package com.smartzhe.controller.jifenpay.request;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/30
 * Time: 17:22  .
 */
@Data
public class ConsumeRecordGetRequst extends BaseRequest {

    /**
     * 消费记录ID
     */
    private Integer id;

    /**
     * 交易号
     */
    private String tradeNo;

    /**
     * 外部交易号
     */
    private String outerTradeNo;

}
