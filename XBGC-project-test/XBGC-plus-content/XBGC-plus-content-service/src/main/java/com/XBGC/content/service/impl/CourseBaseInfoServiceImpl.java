package com.XBGC.content.service.impl;

import com.XBGC.base.exception.XBGCPlusException;
import com.XBGC.base.model.PageParams;
import com.XBGC.base.model.PageResult;
import com.XBGC.content.mapper.*;
import com.XBGC.content.model.dto.AddCourseDto;
import com.XBGC.content.model.dto.CourseBaseInfoDto;
import com.XBGC.content.model.dto.EditCourseDto;
import com.XBGC.content.model.dto.QueryCourseParamsDto;
import com.XBGC.content.model.po.*;
import com.XBGC.content.service.CourseBaseInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.PublicKey;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @description 课程信息管理业务接口实现类
 * @author Mr.w
 * @date
 * @version 1.0
 */
@Slf4j
@Service
public class CourseBaseInfoServiceImpl  implements CourseBaseInfoService {


    @Autowired
    private CourseBaseMapper courseBaseMapper;


    @Autowired
    private CourseTeacherMapper courseTeacherMapper;

    @Autowired
    private TeachplanMapper teachplanMapper;

    @Autowired
    private CourseMarketMapper courseMarketMapper;

    @Autowired
    private CourseCategoryMapper courseCategoryMapper;

    @Override
    public PageResult<CourseBase> queryCourseBaseList(Long companyId,PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto) {


        //构建查询条件对象
        LambdaQueryWrapper<CourseBase> queryWrapper = new LambdaQueryWrapper<>();
        //构建查询条件，根据课程名称查询
        queryWrapper.like(StringUtils.isNotEmpty(queryCourseParamsDto.getCourseName()),CourseBase::getName,queryCourseParamsDto.getCourseName());
        //构建查询条件，根据课程审核状态查询
        queryWrapper.eq(StringUtils.isNotEmpty(queryCourseParamsDto.getAuditStatus()),CourseBase::getAuditStatus,queryCourseParamsDto.getAuditStatus());
//构建查询条件，根据课程发布状态查询
//todo:根据课程发布状态查询

        // 构建查询条件，根据课程审核状态查询
        queryWrapper.eq(StringUtils.isNotEmpty(queryCourseParamsDto.getAuditStatus()),CourseBase::getAuditStatus,queryCourseParamsDto.getAuditStatus());

// 构建查询条件，根据课程发布状态查询
        queryWrapper.eq(StringUtils.isNotEmpty(queryCourseParamsDto.getPublishStatus()), CourseBase::getStatus, queryCourseParamsDto.getPublishStatus());



        //分页对象
        Page<CourseBase> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        // 查询数据内容获得结果
        Page<CourseBase> pageResult = courseBaseMapper.selectPage(page, queryWrapper);
        // 获取数据列表
        List<CourseBase> list = pageResult.getRecords();
        // 获取数据总数
        long total = pageResult.getTotal();
        // 构建结果集
        PageResult<CourseBase> courseBasePageResult = new PageResult<>(list, total, pageParams.getPageNo(), pageParams.getPageSize());
        return courseBasePageResult;


    }


    @Transactional
    @Override  //增删改 都要实现
    public CourseBaseInfoDto createCourseBase(Long companyId, AddCourseDto dto) {
    /*    //参数合法性校验    在controller配置自动校验后 可保留可去掉
        if (StringUtils.isBlank(dto.getName())) {
            throw new RuntimeException("课程名称为空");
        }

        if (StringUtils.isBlank(dto.getMt())) {
            throw new RuntimeException("课程分类为空");
        }

        if (StringUtils.isBlank(dto.getSt())) {
            throw new RuntimeException("课程分类为空");
        }

        if (StringUtils.isBlank(dto.getGrade())) {
            throw new RuntimeException("课程等级为空");
        }

        if (StringUtils.isBlank(dto.getTeachmode())) {
            throw new RuntimeException("教育模式为空");
        }

        if (StringUtils.isBlank(dto.getUsers())) {
            throw new RuntimeException("适应人群为空");
        }

        if (StringUtils.isBlank(dto.getCharge())) {
            throw new RuntimeException("收费规则为空");
        }*/
        //、、、、、、、、、向课程基本信息表course_base写入数据、、、、、、、、、、
        //向课程基本信息表course_base写入数据
        CourseBase courseBaseNew = new CourseBase();
        //将传入的页面的参数放到courseBaseNew对象
//        courseBaseNew.setName(dto.getName());
//        courseBaseNew.setDescription(dto.getDescription());
        //上边的从原始对象中get拿数据向新对象set，比较复杂  //将填写的课程信息赋值给新增对象
        BeanUtils.copyProperties(dto,courseBaseNew);//只要属性名称一致就可以拷贝
        //设置审核状态
        courseBaseNew.setAuditStatus("202002");
        //设置发布状态
        courseBaseNew.setStatus("203001");
        /*//机构id
        courseBaseNew.setCompanyId(companyId);
        //添加时间
        courseBaseNew.setCreateDate(LocalDateTime.now());*/
        //插入课程基本信息表
        int insert = courseBaseMapper.insert(courseBaseNew);
        if (insert <= 0) {
            throw new RuntimeException("新增课程基本信息失败");
        }
        //向课程营销表保存课程营销信息 //todo:向课程营销表保存课程营销信息
        //向课程营销系courese_market写入数据
        CourseMarket courseMarketNew = new CourseMarket();
        //将页面输入的数据拷贝到courseMarketNew
        BeanUtils.copyProperties(dto,courseMarketNew);
        //课程的id
        Long courseId = courseBaseNew.getId();
        courseMarketNew.setId(courseId);
        //保存营销信息
        saveCourseMarket(courseMarketNew);
        //从数据库查询课程的详细信息，包括两部分
        CourseBaseInfoDto courseBaseInfo = getCourseBaseInfo(courseId);

        return courseBaseInfo;
    }


    //todo:查询课程基本信息及营销信息并返回
    //查询课程信息
    public CourseBaseInfoDto getCourseBaseInfo(Long courseId){
        //从课程基本信息表查询
        CourseBase courseBase = courseBaseMapper.selectById(courseId);
        if(courseBase == null){
            return null;
        }
        //从课程营销表查询
        CourseMarket courseMarket = courseMarketMapper.selectById(courseId);

        //组装在一起
        CourseBaseInfoDto courseBaseInfoDto = new CourseBaseInfoDto();
        BeanUtils.copyProperties(courseBase,courseBaseInfoDto);
        if(courseMarket != null){
            BeanUtils.copyProperties(courseMarket,courseBaseInfoDto);
        }
        //通过courseCategory查询分类名称
        CourseCategory courseCategoryBySt = courseCategoryMapper.selectById(courseBase.getSt());
        courseBaseInfoDto.setStName(courseCategoryBySt.getName());
        CourseCategory courseCategoryByMt = courseCategoryMapper.selectById(courseBase.getMt());
        courseBaseInfoDto.setMtName(courseCategoryByMt.getName());

        return courseBaseInfoDto;
    }

    @Override
    public CourseBaseInfoDto updateCourseBase(Long companyId, EditCourseDto editCourseDto){
        //拿到课程ID
        Long courseId = editCourseDto.getId();
        //查询课程信息
        CourseBase courseBase = courseBaseMapper.selectById(courseId);
        if (courseBase == null){
            XBGCPlusException.cast("课程不存在");
        }
        //数据合法性校验
        //根据具体业务逻辑校验
        //本机构只能修改本机构课程
        if(!companyId.equals(courseBase.getCompanyId())){
            XBGCPlusException.cast("本机构只能修改本机构课程");
        }

        //封装数据
        BeanUtils.copyProperties(editCourseDto,courseBase);//页面查出的数据拷贝到数据库中数据去
        //修改时间
        courseBase.setChangeDate(LocalDateTime.now());

        //更新数据
         int i = courseBaseMapper.updateById(courseBase);
         if (i<0){
             XBGCPlusException.cast("修改课程失败");
         }

 // todo://更新营销信息
        // 获取课程营销信息
        CourseMarket courseMarket = courseMarketMapper.selectById(courseId);
        if (courseMarket == null) {
            // 如果课程营销信息不存在，则创建新的营销信息
            courseMarket = new CourseMarket();
            courseMarket.setId(courseId);
            BeanUtils.copyProperties(editCourseDto, courseMarket);
            // 保存新的课程营销信息
            int insertResult = saveCourseMarket(courseMarket);
            if (insertResult <= 0) {
                XBGCPlusException.cast("保存课程营销信息失败");
            }
        } else {
            // 如果课程营销信息已存在，则更新营销信息
            BeanUtils.copyProperties(editCourseDto, courseMarket);
            courseMarket.setId(courseId);
            // 更新课程营销信息
            int updateResult = courseMarketMapper.updateById(courseMarket);
            if (updateResult <= 0) {
                XBGCPlusException.cast("更新课程营销信息失败");
            }
        }

         //查询课程信息
        CourseBaseInfoDto courseBaseInfo = getCourseBaseInfo(courseId);
        return courseBaseInfo;
    }


    //单独创建一个方法保存营销信息，逻辑是，存在则更新，不存在则添加
    private int saveCourseMarket(CourseMarket courseMarketNew) {
        //参数合法性校验
        String charge = courseMarketNew.getCharge();
        if (StringUtils.isBlank(charge)) {
            throw new RuntimeException("收费规则没有选择");
        }
        //如果课程收费，价格没有填写也需要抛出异常
        if (charge.equals("201001")) {
            if (courseMarketNew.getPrice() == null || courseMarketNew.getPrice().floatValue() <= 0) {
                throw new RuntimeException("课程为收费价格不能为空且必须大于0");
            }
        }
        //从数据库查询营销信息，存在则更新，不存在则添加
        Long id = courseMarketNew.getId();//拿到主键并查询
        CourseMarket courseMarket = courseMarketMapper.selectById(id);
        if (courseMarket == null) {
            //插入数据库
           return courseMarketMapper.insert(courseMarketNew);
        } else {
            //将courseMarketNew拷贝到courseMarket
            BeanUtils.copyProperties(courseMarketNew,courseMarket);
            courseMarket.setId(courseMarketNew.getId());//为了防止前面是空数据覆盖后面 需要重新设置ID
            //更新
            return  courseMarketMapper.updateById(courseMarket);
        }
    }


    //刪除课程接口
    @Override
    public void delectCourse(Long companyId, Long courseId) {
        CourseBase courseBase = courseBaseMapper.selectById(courseId);
        if (courseBase == null) {
            XBGCPlusException.cast("课程不存在");
        }
        if (!companyId.equals(courseBase.getCompanyId())) {
            XBGCPlusException.cast("只允许删除本机构的课程");
        }
        // 检查课程审核状态是否为未提交
        if (!"未提交".equals(courseBase.getAuditStatus())) {
            XBGCPlusException.cast("只有审核状态为未提交的课程才能删除");
        }
        // 删除课程教师信息
        LambdaQueryWrapper<CourseTeacher> teacherLambdaQueryWrapper = new LambdaQueryWrapper<>();
        teacherLambdaQueryWrapper.eq(CourseTeacher::getCourseId, courseId);
        courseTeacherMapper.delete(teacherLambdaQueryWrapper);
        // 删除课程计划
        LambdaQueryWrapper<Teachplan> teachplanLambdaQueryWrapper = new LambdaQueryWrapper<>();
        teachplanLambdaQueryWrapper.eq(Teachplan::getCourseId, courseId);
        teachplanMapper.delete(teachplanLambdaQueryWrapper);
        // 删除营销信息
        courseMarketMapper.deleteById(courseId);
        // 删除课程基本信息
        courseBaseMapper.deleteById(courseId);
    }
}




