package com.XBGC.orders.model.dto;

import com.XBGC.orders.model.po.XcPayRecord;
import lombok.Data;
import lombok.ToString;

/**
 * @author Mr.w
 * @version 1.0
 * @description 支付记录dto
 * @date 2025/2/4 11:30
 */
@Data
@ToString
public class PayRecordDto extends XcPayRecord {

    //二维码
    private String qrcode;

}
