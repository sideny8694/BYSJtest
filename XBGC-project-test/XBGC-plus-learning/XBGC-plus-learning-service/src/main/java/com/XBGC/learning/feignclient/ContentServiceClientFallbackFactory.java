package com.XBGC.learning.feignclient;

import com.XBGC.content.model.po.CoursePublish;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Mr.w
 * @version 1.0
 * @description TODO
 * @date 2025/2/25 9:14
 */
@Slf4j
@Component
public class ContentServiceClientFallbackFactory implements FallbackFactory<ContentServiceClient> {
    @Override
    public ContentServiceClient create(Throwable throwable) {
        return new ContentServiceClient() {

            @Override
            public CoursePublish getCoursepublish(Long courseId) {
                log.error("调用内容管理服务发生熔断:{}", throwable.toString(),throwable);
                return null;
            }
        };
    }
}
