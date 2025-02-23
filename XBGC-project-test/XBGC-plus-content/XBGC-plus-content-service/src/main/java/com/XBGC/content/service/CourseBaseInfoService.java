package com.XBGC.content.service;


/*
 * @description 课程基本信息管理业务接口
 * @author Mr.w
 * @date
 * @version 1.0
*/

import com.XBGC.content.model.dto.AddCourseDto;
import com.XBGC.content.model.dto.CourseBaseInfoDto;
import com.XBGC.content.model.dto.EditCourseDto;
import com.XBGC.content.model.dto.QueryCourseParamsDto;
import com.XBGC.content.model.po.CourseBase;
import com.XBGC.base.model.PageParams;
import com.XBGC.base.model.PageResult;
import com.XBGC.base.model.PageParams;

public interface CourseBaseInfoService {
    /*
     * @description 课程查询接口
     * @param pageParams 分页参数
     * @param queryCourseParamsDto 条件条件
     * @return com.XBGC.base.model.PageResult<com.XBGC.content.model.po.CourseBase>
     * @author Mr.w
     * @date 
     */
    PageResult<CourseBase> queryCourseBaseList(Long companyId, PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto);

    /*
     * @description 新增课程
     * @param companyID  提供课程方ID
     * @param addCourseDto 课程信息
     * @return 课程添加成功详情信息
     */
    public CourseBaseInfoDto createCourseBase(Long companyId, AddCourseDto addCourseDto);

    /*
     * @description 根据课程ID查询课程信息
     * @param courseId  课程ID
     * @param
     * @return  课程详情信息
     */
    public CourseBaseInfoDto getCourseBaseInfo(Long courseId);

    /**
     * @description 修改课程信息
     * @param companyId  机构id
     * @author Mr.w
     */
    public CourseBaseInfoDto updateCourseBase(Long companyId, EditCourseDto editCourseDto);


    //刪除課程接口
    void delectCourse(Long companyId, Long courseId);
}
