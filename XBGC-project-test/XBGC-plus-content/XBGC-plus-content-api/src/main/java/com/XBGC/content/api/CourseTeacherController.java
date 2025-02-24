package com.XBGC.content.api;

import com.XBGC.content.model.po.CourseTeacher;
import com.XBGC.content.service.CourseBaseInfoService;
import com.XBGC.content.service.CourseTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程-教师关系表 前端控制器
 * </p>
 *
 * @author itcast
 */
@Slf4j
@RestController
@RequestMapping("courseTeacher")
@Controller("apiCourseTeacherController")
@Api(value = "课程教师管理接口", tags = "课程教师管理接口")
public class CourseTeacherController {

    @Autowired
    private CourseTeacherService courseTeacherService;

    @Autowired
    private CourseBaseInfoService courseBaseInfoService;

    @ApiOperation("查询教师信息接口")
    @GetMapping("/list/{courseId}")
    public List<CourseTeacher> getCourseTeacherList(@PathVariable Long courseId) {
        return courseTeacherService.getCourseTeacherList(courseId);
    }

    @ApiOperation("添加教师信息接口")
    @PostMapping
    public CourseTeacher addCourseTeacher(@RequestBody CourseTeacher courseTeacher) {
        return courseTeacherService.saveCourseTeacher(courseTeacher);
    }

    @ApiOperation("修改教师信息接口")
    @PutMapping
    public CourseTeacher updateCourseTeacher(@RequestBody CourseTeacher courseTeacher) {
        return courseTeacherService.saveCourseTeacher(courseTeacher);
    }

    @ApiOperation("删除教师信息接口")
    @DeleteMapping("/course/{courseId}/{teacherId}")
    public ResponseEntity<Void> deleteCourseTeacher(@PathVariable Long courseId, @PathVariable Long teacherId) {
        courseTeacherService.deleteCourseTeacher(courseId, teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation("删除课程")
    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
        Long companyId = 1232141425L;
        courseBaseInfoService.delectCourse(companyId, courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
