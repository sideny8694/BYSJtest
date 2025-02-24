package com.XBGC.content.service;

import com.XBGC.content.model.po.CourseTeacher;

import java.util.List;
/*
*
* <p>
 * 课程-教师关系表 服务类* </p>
        */
public interface CourseTeacherService {
    //查询教师信息
    List<CourseTeacher> getCourseTeacherList(Long courseId);

    //修改或添加
    CourseTeacher saveCourseTeacher(CourseTeacher courseTeacher);

    //删除教师信息
    void deleteCourseTeacher(Long courseId, Long teacherId);


    //刪除课程接口
    void delectCourse(Long companyId, Long courseId);

}
