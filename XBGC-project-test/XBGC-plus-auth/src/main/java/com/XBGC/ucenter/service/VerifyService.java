package com.XBGC.ucenter.service;

import com.XBGC.ucenter.model.dto.FindPswDto;
import com.XBGC.ucenter.model.dto.RegisterDto;

public interface VerifyService {

    // 发送验证码
    void findPassword(FindPswDto findPswDto);


    // 注册
    void register(RegisterDto registerDto);
}