package com.smartzhe.controller.jifenpay.response;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/31
 * Time: 11:43  .
 */
@Data
public class ConsumeRecordStatInfoResponse {

    /**
     * 消费记录总条数
     */
    private Integer totalCnt;
    /**
     * 消费记录总资产金额
     */
    private BigDecimal totalAssetAmt;
    /**
     * 消费记录总积分金额
     */
    private BigDecimal totalPointAmt;
    /**
     * 消费记录总退款资产金额
     */
    private BigDecimal totalRefundAssetAmt;
    /**
     * 消费记录总退款积分金额
     */
    private BigDecimal totalRefundPointAmt;
    /**
     * 消费记录总的使用多少积分
     */
    private BigDecimal totalUsePoint;
    /**
     * 消费记录总	的使用多少现金
     */
    private BigDecimal totalUseCash;
}
