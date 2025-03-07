package com.XBGC.learning.service;

import com.XBGC.base.model.PageResult;
import com.XBGC.learning.model.dto.MyCourseTableParams;
import com.XBGC.learning.model.dto.XcChooseCourseDto;
import com.XBGC.learning.model.dto.XcCourseTablesDto;
import com.XBGC.learning.model.po.XcCourseTables;

/**
 * @author Mr.w
 * @version 1.0
 * @description 选课相关的接口
 * @date 2025/2/1/25 12:00
 */
public interface MyCourseTablesService {

    /**
     * @description 添加选课
     * @param userId 用户id
     * @param courseId 课程id
     * @return com.XBGC.learning.model.dto.XcChooseCourseDto
     * @author Mr.w
     * @date 2025/2/24 17:33
     */
    public XcChooseCourseDto addChooseCourse(String userId, Long courseId);

    /**
     * @description 判断学习资格
     * @param userId
     * @param courseId
     * @return XcCourseTablesDto 学习资格状态 [{"code":"702001","desc":"正常学习"},{"code":"702002","desc":"没有选课或选课后没有支付"},{"code":"702003","desc":"已过期需要申请续期或重新支付"}]
     * @author Mr.w
     * @date 2025/2/3 7:37
     */
    public XcCourseTablesDto getLearningStatus(String userId, Long courseId);

    /**
     * 保存选课成功状态
     * @param chooseCourseId
     * @return
     */
    public boolean saveChooseCourseSuccess(String chooseCourseId);

    /**
     * @description 我的课程表
     * @param params
     * @return com.XBGC.base.model.PageResult<com.XBGC.learning.model.po.XcCourseTables>
     * @author Mr.w
     * @date 2025/2/27 9:24
     */
    public PageResult<XcCourseTables> mycoursetables(MyCourseTableParams params);

}
