package com.XBGC.content.service;


import com.XBGC.base.exception.ContentException;
import com.XBGC.content.model.dto.BindTeachplanMediaDto;
import com.XBGC.content.model.dto.SaveTeachplanDto;
import com.XBGC.content.model.dto.TeachplanDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description 课程基本信息管理业务接口
 * @author Mr.w
 */

public interface TeachplanService {
    /**
     * 根据课程id查询课程计划
     * @param courseId 课程计划
     * @return
     */
    public List<TeachplanDto> findTeachplanTree(long courseId);

    /**
     * 新增/修改/保存课程计划
     * @param saveTeachplanDto
     */
    public void saveTeachplan(SaveTeachplanDto saveTeachplanDto);


    //TODO：删除课程计划
   public void deleteTeachplan(long teachplanId);

    /**
     * TODO:课程计划上下移动
     * @param moveType 移动类型，movedown或moveup
     * @param teachplanId 课程计划id
     */
    @Transactional
    void moveTeachplan(String moveType, long teachplanId);


    /**
     * @description 教学计划绑定媒资
     * @param bindTeachplanMediaDto
     * @return com.XBGC.content.model.po.TeachplanMedia
     * @author Mr.w
     */
    public void associationMedia(BindTeachplanMediaDto bindTeachplanMediaDto);

}




