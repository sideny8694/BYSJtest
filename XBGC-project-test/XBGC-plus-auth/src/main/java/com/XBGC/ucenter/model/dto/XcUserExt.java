package com.XBGC.ucenter.model.dto;

import com.XBGC.ucenter.model.po.XcUser;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 用户扩展信息
 * @author Mr.M
 * @version 1.0
 */
@Data
public class XcUserExt extends XcUser {
    //用户权限
    List<String> permissions = new ArrayList<>();
}
