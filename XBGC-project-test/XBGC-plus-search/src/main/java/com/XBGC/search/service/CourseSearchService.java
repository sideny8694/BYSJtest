package com.XBGC.search.service;

import com.XBGC.base.model.PageParams;
import com.XBGC.base.model.PageResult;
import com.XBGC.search.dto.SearchCourseParamDto;
import com.XBGC.search.dto.SearchPageResultDto;
import com.XBGC.search.po.CourseIndex;

/**
 * @description 课程搜索service
 * @author Mr.w
 * @date 2025/2/24 22:40
 * @version 1.0
 */
public interface CourseSearchService {


    /**
     * @description 搜索课程列表
     * @param pageParams 分页参数
     * @param searchCourseParamDto 搜索条件
     * @return com.XBGC.base.model.PageResult<com.XBGC.search.po.CourseIndex> 课程列表
     * @author Mr.w
     * @date 2025/2/24 22:45
    */
    SearchPageResultDto<CourseIndex> queryCoursePubIndex(PageParams pageParams, SearchCourseParamDto searchCourseParamDto);

 }
