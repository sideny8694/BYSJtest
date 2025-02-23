package com.XBGC.learning.feignclient;

import com.XBGC.content.model.po.CoursePublish;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Mr.w
 * @version 1.0
 * @description 内容管理远程接口
 * @date 2025/2/25 9:13
 */
@FeignClient(value = "content-api",fallbackFactory = ContentServiceClientFallbackFactory.class)
public interface ContentServiceClient {

    //查询已经发布的课程
    @ResponseBody
    @GetMapping("/content/r/coursepublish/{courseId}")
    public CoursePublish getCoursepublish(@PathVariable("courseId") Long courseId);

}
