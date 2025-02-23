package com.XBGC.content.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Mr.w
 * @version 1.0
 * @description TODO
 * @date 2025/2/1/22 14:47
 */
@FeignClient(value = "search",fallbackFactory = SearchServiceClientFallbackFactory.class)
public interface SearchServiceClient {

 @PostMapping("/search/index/course")
 public Boolean add(@RequestBody CourseIndex courseIndex);
}
