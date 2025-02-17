package com.XBGC.content.service;


import com.XBGC.content.model.dto.SaveTeachplanDto;
import com.XBGC.content.model.dto.TeachplanDto;

import java.util.List;

/**
 * @description 课程基本信息管理业务接口
 * @author Mr.w
 */

public interface TeachplanService {
    public List<TeachplanDto> findTeachplanTree(long courseId);


    /**
     * @description 保存课程计划
     * @param teachplanDto  课程计划信息
     */
    public void saveTeachplan(SaveTeachplanDto teachplanDto);

}


