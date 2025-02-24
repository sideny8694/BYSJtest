package com.XBGC.content.service.impl;

import com.XBGC.base.exception.XBGCPlusException;
import com.XBGC.content.mapper.CourseBaseMapper;
import com.XBGC.content.mapper.CourseMarketMapper;
import com.XBGC.content.mapper.CourseTeacherMapper;
import com.XBGC.content.mapper.TeachplanMapper;
import com.XBGC.content.model.po.CourseBase;
import com.XBGC.content.model.po.CourseTeacher;
import com.XBGC.content.model.po.Teachplan;
import com.XBGC.content.service.CourseTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 课程-教师关系表 服务实现类
 * </p>
 *
 * @author itcast
 */
@Slf4j
@Service
public class CourseTeacherServiceImpl extends ServiceImpl<CourseTeacherMapper, CourseTeacher> implements CourseTeacherService {

    @Autowired
    private CourseTeacherMapper courseTeacherMapper;

    @Autowired
    private CourseBaseMapper courseBaseMapper;

    @Autowired
    private TeachplanMapper teachplanMapper;

    @Autowired
    private CourseMarketMapper courseMarketMapper;


    // 课程教师信息查询
    @Override
    public List<CourseTeacher> getCourseTeacherList(Long courseId) {
        // SELECT * FROM course_teacher WHERE course_id = 117
        LambdaQueryWrapper<CourseTeacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CourseTeacher::getCourseId, courseId);
        List<CourseTeacher> courseTeachers = courseTeacherMapper.selectList(queryWrapper);
        return courseTeachers;
    }


    // 课程教师信息新增和修改
    @Transactional
    @Override
    public CourseTeacher saveCourseTeacher(CourseTeacher courseTeacher) {
        Long id = courseTeacher.getId();
        if (id == null) {
            // id为null，新增教师
            CourseTeacher teacher = new CourseTeacher();
            BeanUtils.copyProperties(courseTeacher, teacher);
            teacher.setCreateDate(LocalDateTime.now());
            int flag = courseTeacherMapper.insert(teacher);
            if (flag <= 0)
                XBGCPlusException.cast("新增失败");
            return getCourseTeacher(teacher);
        } else {
            // id不为null，修改教师
            CourseTeacher teacher = courseTeacherMapper.selectById(id);
            BeanUtils.copyProperties(courseTeacher, teacher);
            int flag = courseTeacherMapper.updateById(teacher);
            if (flag <= 0)
                XBGCPlusException.cast("修改失败");
            return getCourseTeacher(teacher);
        }
    }


    // 课程教师信息删除
    @Override
    public void deleteCourseTeacher(Long courseId, Long teacherId) {
        LambdaQueryWrapper<CourseTeacher> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CourseTeacher::getId, teacherId);
        queryWrapper.eq(CourseTeacher::getCourseId, courseId);
        int flag = courseTeacherMapper.delete(queryWrapper);
        if (flag < 0)
            XBGCPlusException.cast("删除失败");
    }


    // 课程教师信息查询
    public CourseTeacher getCourseTeacher(CourseTeacher courseTeacher) {
        return courseTeacherMapper.selectById(courseTeacher.getId());
    }



    // 课程删除
    @Transactional
    @Override
    public void delectCourse(Long companyId, Long courseId) {
        CourseBase courseBase = courseBaseMapper.selectById(courseId);
        if (!companyId.equals(courseBase.getCompanyId()))
            XBGCPlusException.cast("只允许删除本机构的课程");
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
