package com.XBGC.auth.controller;

import com.XBGC.ucenter.model.po.XcUser;
//import com.XBGC.ucenter.service.WxAuthService;
import com.XBGC.ucenter.service.WxAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * @author Mr.w
 * @version 1.0
 * @description TODO
 * @date 2025/2/1/24 15:13
 */
@Slf4j
@Controller
public class WxLoginController {

    @Autowired
    WxAuthService wxAuthService;

    @RequestMapping("/wxLogin")
    public String wxLogin(String code, String state) throws IOException {
        log.debug("微信扫码回调,code:{},state:{}", code, state);
        //远程调用微信请令牌，拿到令牌查询用户信息，将用户信息写入本项目数据库
        XcUser xcUser1 = wxAuthService.wxAuth(code);

        XcUser xcUser = new XcUser();
        //硬編碼
        xcUser.setUsername("test");

        if (xcUser == null) {
            return "redirect:http://www.51xbgc.cn/error.html";
        }
        String username = xcUser.getUsername();
        return "redirect:http://www.51xbgc.cn/sign.html?username=" + username + "&authType=wx";
    }
}
