package com.XBGC.content;

import com.XBGC.content.config.MultipartSupportConfig;
import com.XBGC.content.feignclient.MediaServiceClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Mr.w
 * @version 1.0
 * @description 测试远程调用媒资服务
 * @date 2025/2/1/22 10:30
 */
@SpringBootTest
public class FeignUploadTest {

    @Autowired
    MediaServiceClient mediaServiceClient;

    @Test
    public void test() throws IOException {

        //将file转成MultipartFile
        File file = new File("D:\\develop\\upload\\117.html");
        MultipartFile multipartFile = MultipartSupportConfig.getMultipartFile(file);
        //远程调用得到返回值
        String upload = mediaServiceClient.upload(multipartFile, "course/117.html");
        if(upload==null){
            System.out.println("走了降级逻辑");
        }
    }
}
