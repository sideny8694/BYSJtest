package com.XBGC.learning;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.XBGC.content.model.po.CoursePublish;
import com.XBGC.learning.feignclient.ContentServiceClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * @author Mr.w
 * @version 1.0
 * @description TODO
 * @date 2025/2/1/22 20:14
 */
@SpringBootTest
public class FeignClientTest {

    @Autowired
    ContentServiceClient contentServiceClient;


    @Test
    public void testContentServiceClient() {
        CoursePublish coursepublish = contentServiceClient.getCoursepublish(120L);
        Assertions.assertNotNull(coursepublish);
    }
}