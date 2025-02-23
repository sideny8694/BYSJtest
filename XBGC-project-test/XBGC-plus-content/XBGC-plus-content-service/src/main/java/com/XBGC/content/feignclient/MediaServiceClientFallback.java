package com.XBGC.content.feignclient;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Mr.w
 * @version 1.0
 * @description TODO  使用此方法无法拿到熔断异常信息
 * @date 2025/2/1/22 11:06
 */
public class MediaServiceClientFallback implements MediaServiceClient{
 @Override
 public String upload(MultipartFile filedata, String objectName) throws IOException {

  return null;
 }
}
