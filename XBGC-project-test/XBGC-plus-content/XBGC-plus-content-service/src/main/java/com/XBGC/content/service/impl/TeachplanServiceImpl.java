package com.XBGC.content.service.impl;


import com.XBGC.base.exception.ContentException;
import com.XBGC.base.exception.XBGCPlusException;
import com.XBGC.content.mapper.TeachplanMapper;
import com.XBGC.content.mapper.TeachplanMediaMapper;
import com.XBGC.content.model.dto.BindTeachplanMediaDto;
import com.XBGC.content.model.dto.SaveTeachplanDto;
import com.XBGC.content.model.dto.TeachplanDto;
import com.XBGC.content.model.po.Teachplan;
import com.XBGC.content.model.po.TeachplanMedia;
import com.XBGC.content.service.TeachplanService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description 课程计划service接口实现类
 */


@Service
public class TeachplanServiceImpl implements TeachplanService {
    @Autowired
    TeachplanMapper teachplanMapper;

    @Autowired
    TeachplanMediaMapper teachplanMediaMapper;


    @Override
    public List<TeachplanDto> findTeachplanTree(long courseId) {
        List<TeachplanDto> teachplanDtos = teachplanMapper.selectTreeNodes(courseId);
        return teachplanDtos ;
    }


    private int getTeachplanCount(Long courseId,Long parentId){
        LambdaQueryWrapper<Teachplan> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper = queryWrapper.eq(Teachplan::getCourseId, courseId).eq(Teachplan::getParentid, parentId);
        Integer count = teachplanMapper.selectCount(queryWrapper);
        return  count+1;
    }


    @Override
    @Transactional
    public void saveTeachplan(SaveTeachplanDto saveTeachplanDto) {
        //通过课程计划id判断是新增和修改
        Long teachplanId = saveTeachplanDto.getId();
        if (teachplanId == null){
            //新增
            Teachplan teachplan = new Teachplan();
            BeanUtils.copyProperties(saveTeachplanDto,teachplan);
            //确定排序字段，找到它的同级节点个数，排序字段就是个数加1
            // 逻辑select count(1) from teachplan where course_id=117 and parentid=268
            Long parentid = saveTeachplanDto.getParentid();
            Long courseId = saveTeachplanDto.getCourseId();
            int teachplanCount = getTeachplanCount(courseId, parentid);
            teachplan.setOrderby(teachplanCount);
            teachplanMapper.insert(teachplan);

        }else {
            //修改
            Teachplan teachplan = teachplanMapper.selectById(teachplanId);
            //将参数复制到teachplan
            BeanUtils.copyProperties(saveTeachplanDto,teachplan);
            teachplanMapper.updateById(teachplan);
        }


    }

    //TODO：删除课程计划
    @Override
    @Transactional
    public void deleteTeachplan(long teachplanId) {
        Teachplan teachplan = teachplanMapper.selectById(teachplanId);
        if (teachplan == null) {
            return;
        }

        // 检查是否为第一级大章节
        if (teachplan.getParentid() == 0) {
            // 检查大章节下是否有小章节
            LambdaQueryWrapper<Teachplan> childQueryWrapper = new LambdaQueryWrapper<>();
            childQueryWrapper.eq(Teachplan::getParentid, teachplanId);
            List<Teachplan> childTeachplans = teachplanMapper.selectList(childQueryWrapper);
            if (!childTeachplans.isEmpty()) {
                throw new ContentException("120409", "课程计划信息还有子级信息，无法操作");
            }
        }

        // 如果是第二级小章节，删除关联的媒体信息
        if (teachplan.getParentid() != 0) {
            teachplanMediaMapper.deleteByTeachplanId(teachplanId);
        }

        // 删除课程计划
        teachplanMapper.deleteById(teachplanId);
    }


    //TODO：课程计划排序
    @Override
    @Transactional
    public void moveTeachplan(String moveType, long teachplanId) {
        Teachplan currentTeachplan = teachplanMapper.selectById(teachplanId);
        if (currentTeachplan == null) {
            throw new ContentException("课程计划不存在");
        }

        Long courseId = currentTeachplan.getCourseId();
        Long parentId = currentTeachplan.getParentid();
        List<Teachplan> siblings = teachplanMapper.selectSiblings(courseId, parentId);

        int currentIndex = -1;
        for (int i = 0; i < siblings.size(); i++) {
            if (siblings.get(i).getId().equals(teachplanId)) {
                currentIndex = i;
                break;
            }
        }

        if (currentIndex == -1) {
            throw new ContentException("未找到当前课程计划的同级节点");
        }

        if ("moveup".equals(moveType)) {
            if (currentIndex > 0) {
                Teachplan prevTeachplan = siblings.get(currentIndex - 1);
                int tempOrder = currentTeachplan.getOrderby();
                currentTeachplan.setOrderby(prevTeachplan.getOrderby());
                prevTeachplan.setOrderby(tempOrder);
                teachplanMapper.updateSort(currentTeachplan.getOrderby(), currentTeachplan.getId());
                teachplanMapper.updateSort(prevTeachplan.getOrderby(), prevTeachplan.getId());
            }
        } else if ("movedown".equals(moveType)) {
            if (currentIndex < siblings.size() - 1) {
                Teachplan nextTeachplan = siblings.get(currentIndex + 1);
                int tempOrder = currentTeachplan.getOrderby();
                currentTeachplan.setOrderby(nextTeachplan.getOrderby());
                nextTeachplan.setOrderby(tempOrder);
                teachplanMapper.updateSort(currentTeachplan.getOrderby(), currentTeachplan.getId());
                teachplanMapper.updateSort(nextTeachplan.getOrderby(), nextTeachplan.getId());
            }
        } else {
            throw new ContentException("无效的移动类型");
        }
    }


    //TODO：教学计划绑定媒资
    @Transactional
    @Override
    public void associationMedia(BindTeachplanMediaDto bindTeachplanMediaDto) {
        //课程计划id
        Long teachplanId = bindTeachplanMediaDto.getTeachplanId();
        Teachplan teachplan = teachplanMapper.selectById(teachplanId);
        if(teachplan == null){
            XBGCPlusException.cast("课程计划不存在");
        }

        //先删除原有记录,根据课程计划id删除它所绑定的媒资
        int delete = teachplanMediaMapper.delete(new LambdaQueryWrapper<TeachplanMedia>().eq(TeachplanMedia::getTeachplanId, bindTeachplanMediaDto.getTeachplanId()));

        //再添加新记录
        TeachplanMedia teachplanMedia = new TeachplanMedia();
        BeanUtils.copyProperties(bindTeachplanMediaDto,teachplanMedia);
        teachplanMedia.setCourseId(teachplan.getCourseId());
        teachplanMedia.setMediaFilename(bindTeachplanMediaDto.getFileName());
        teachplanMediaMapper.insert(teachplanMedia);

    }


}
