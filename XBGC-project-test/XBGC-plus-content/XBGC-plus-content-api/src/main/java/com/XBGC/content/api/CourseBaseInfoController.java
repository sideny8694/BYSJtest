package com.XBGC.content.api;

import com.XBGC.base.exception.ValidationGroups;
import com.XBGC.base.model.PageParams;
import com.XBGC.base.model.PageResult;
import com.XBGC.content.model.dto.AddCourseDto;
import com.XBGC.content.model.dto.CourseBaseInfoDto;
import com.XBGC.content.model.dto.EditCourseDto;
import com.XBGC.content.model.dto.QueryCourseParamsDto;
import com.XBGC.content.model.po.CourseBase;
import com.XBGC.content.service.CourseBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mr.w
 * @version 1.0
 * @description TODO
 */
@Api(value = "课程信息管理接口",tags = "课程信息管理接口")
@RestController
public class CourseBaseInfoController {

    @Autowired
    CourseBaseInfoService courseBaseInfoService;


    @ApiOperation("课程分页查询接口")
    @PreAuthorize("hasAuthority('xc_teachmanager_course_list')")//指定权限标识符,拥有此权限才可以访问此方法
    @PostMapping("/course/list")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody(required=false) QueryCourseParamsDto queryCourseParamsDto) {

        //当前登录用户
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        //用户所属机构id
        Long companyId = null;
        if(StringUtils.isNotEmpty(user.getCompanyId())){
            companyId = Long.parseLong(user.getCompanyId());
        }


        PageResult<CourseBase> courseBasePageResult = courseBaseInfoService.queryCourseBaseList(companyId,pageParams, queryCourseParamsDto);

        // 添加空参数处理
        if (queryCourseParamsDto == null) {
            queryCourseParamsDto = new QueryCourseParamsDto();
        }

        return courseBasePageResult;

    }

    @ApiOperation("新增课程")
    @PostMapping("/course")
    public CourseBaseInfoDto createCourseBase(@RequestBody @Validated(ValidationGroups.Inster.class) AddCourseDto addCourseDto){

        //获取到用户所属机构的id
        Long companyId = 1232141425L;
//        int i = 1/0;
        CourseBaseInfoDto courseBase = courseBaseInfoService.createCourseBase(companyId, addCourseDto);
        return courseBase;
    }

    @ApiOperation("根据课程id查询接口")
    @GetMapping("/course/{courseId}")
    public CourseBaseInfoDto getCourseBaseById(@PathVariable Long courseId){
        /*CourseBaseInfoDto courseBaseInfo = courseBaseInfoService.getCourseBaseInfo(courseId);*/
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        if (user == null){
            throw new RuntimeException("wei deng lu ");
        }
        System.out.println(user.getUsername());
//        CourseBaseInfoDto courseBaseInfo = courseBaseInfoService.getCourseBaseInfo(courseId);
//        return courseBaseInfo;
        // 添加try-catch块
        try {
            return courseBaseInfoService.getCourseBaseInfo(courseId);
        } catch (Exception e) {
            throw new RuntimeException("课程信息查询失败：" + e.getMessage());
        }

    }


    @ApiOperation("修改课程")
    @PutMapping("/course")
    public CourseBaseInfoDto modifyCourseBase(@RequestBody @Validated(ValidationGroups.Update.class) EditCourseDto editCourseDto){
        //获取到用户所属机构的id
        Long companyId = 1232141425L;
        CourseBaseInfoDto courseBaseInfoDto = courseBaseInfoService.updateCourseBase(companyId, editCourseDto);
        return courseBaseInfoDto;
    }

}
