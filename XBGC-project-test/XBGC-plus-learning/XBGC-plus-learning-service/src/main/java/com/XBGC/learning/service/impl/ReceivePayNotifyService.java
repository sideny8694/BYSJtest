package com.XBGC.learning.service.impl;

import com.alibaba.fastjson.JSON;
import com.XBGC.base.exception.XBGCPlusException;
import com.XBGC.learning.config.PayNotifyConfig;
import com.XBGC.learning.service.MyCourseTablesService;
import com.XBGC.messagesdk.model.po.MqMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr.w
 * @version 1.0
 * @description 接收消息通知处理类
 * @date 2025/2/1/26 16:42
 */
@Slf4j
@Service
public class ReceivePayNotifyService {

    @Autowired
    MyCourseTablesService myCourseTablesService;


    @RabbitListener(queues = PayNotifyConfig.PAYNOTIFY_QUEUE)
    public void receive(Message message) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //解析出消息
        byte[] body = message.getBody();
        String jsonString = new String(body);
        //转成对象
        MqMessage mqMessage = JSON.parseObject(jsonString, MqMessage.class);
        //解析消息的内容
        //选课id
        String chooseCourseId = mqMessage.getBusinessKey1();
        //订单类型
        String orderType = mqMessage.getBusinessKey2();
        //学习中心服务只要购买课程类的支付订单的结果
        if (orderType.equals("60201")) {
            //根据消息内容，更新选课记录、向我的课程表插入记录
            boolean b = myCourseTablesService.saveChooseCourseSuccess(chooseCourseId);
            if (!b) {
                XBGCPlusException.cast("保证选课记录状态失败");
            }


        }


    }


}
