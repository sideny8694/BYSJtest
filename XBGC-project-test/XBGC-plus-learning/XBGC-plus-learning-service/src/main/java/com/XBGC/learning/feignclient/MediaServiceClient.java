package com.XBGC.learning.feignclient;

import com.XBGC.base.model.RestResponse;
import com.XBGC.content.model.po.CoursePublish;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description TODO
 * @author Mr.w
 * @date 2025/2/27 9:04
 * @version 1.0
 */
 @FeignClient(value = "media-api",fallbackFactory = MediaServiceClientFallbackFactory.class)
 @RequestMapping("/media")
 public interface MediaServiceClient {

  @GetMapping("/open/preview/{mediaId}")
  public RestResponse<String> getPlayUrlByMediaId(@PathVariable("mediaId") String mediaId);

 @GetMapping("/open/content/course/whole/{courseId}")
  public CoursePublish getCoursepublish(@PathVariable("courseId") Long courseId);

 }
