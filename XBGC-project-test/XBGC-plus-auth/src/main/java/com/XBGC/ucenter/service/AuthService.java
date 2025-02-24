package com.XBGC.ucenter.service;

import com.XBGC.ucenter.model.dto.AuthParamsDto;
import com.XBGC.ucenter.model.dto.XcUserExt;

/**
 * @author Mr.w
 * @version 1.0
 * @description 统一的认证接口
 * @date 2025/2/1/24 11:55
 */
public interface AuthService {

 /**
  * @description 认证方法
  * @param authParamsDto 认证参数
  * @return com.XBGC.ucenter.model.po.XcUser 用户信息
  * @author Mr.w
  */
 XcUserExt execute(AuthParamsDto authParamsDto);

}
