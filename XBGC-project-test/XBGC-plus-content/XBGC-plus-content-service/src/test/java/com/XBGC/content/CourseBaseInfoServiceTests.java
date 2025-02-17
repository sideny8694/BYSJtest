package com.XBGC.content;


import com.XBGC.base.model.PageParams;
import com.XBGC.base.model.PageResult;
import com.XBGC.content.model.dto.QueryCourseParamsDto;
import com.XBGC.content.model.po.CourseBase;
import com.XBGC.content.service.CourseBaseInfoService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CourseBaseInfoServiceTests {

    @Autowired
    CourseBaseInfoService courseBaseInfoService;

    @Test
    public void testCourseBaseInfoService(){

        //查询条件
        QueryCourseParamsDto courseParamsDto = new QueryCourseParamsDto();
        courseParamsDto.setCourseName("java");//课程名称查询条件;
        courseParamsDto.setAuditStatus("202004");//课程审核状态
        courseParamsDto.setPublishStatus("203001");//课程发布状态
        //分页参数
        PageParams pageParams = new PageParams();
        pageParams.setPageNo(1L);//页码
        pageParams.setPageSize(2L);//每页记录数

        PageResult<CourseBase> courseBasePageResult = courseBaseInfoService.queryCourseBaseList(pageParams,courseParamsDto);
        System.out.println(courseBasePageResult);


    }

}
