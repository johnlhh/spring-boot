package com.smartzhe.controller.jifenpay.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/31
 * Time: 11:11  .
 */
@Data
public class ConsumeRecordFindRequest extends PageRequest {


    /**
     * 起始ID, 即 ConsumeRecord.id > idStart
     */
    private Integer idStart;
    /**
     * ID大于, 即 ConsumeRecord.id > idGT
     */
    private Integer idGT;
    /**
     * ID小于, 即 ConsumeRecord.id < idLT
     */
    private Integer idLT;
    /**
     * 订单所属人会员ID
     */
    private Integer ownerMemberId;
    /**
     * 订单付款人会员ID
     */
    private Integer payerMemberId;

    /**
     * 隔开的订单付款人会员ID串
     */
    private String payerMemberIdStr;
    /**
     * 隔开的订单所属人会员ID串
     */
    private String ownerMemberIds;
    /**
     * 隔开的资产类型串
     */
    private String assetCodeIn;
    /**
     * 订单收款人会员ID
     */
    private String payeeMemberId;
    /**
     * 订单付款人账户ID
     */
    private Integer payerAccountId;
    /**
     * 企业ID
     */
    private Integer enterpriseId;
    /**
     * 0-8	下单应用ID
     */
    private String appId;
    /**
     * 0-8	实际下单应用ID
     */
    private String sourceAppId;

    /**
     * 订单付款人会员类型. 1:员工, 2:商家, 3:企业
     */
    private Integer payerMemberType;
    /**
     * 订单收款人会员类型. 1:员工, 2:商家, 3:企业
     */
    private Integer payeeMemberType;
    /**
     * 0-16	支付系统交易号
     */
    private String tradeNo;
    /**
     * 0-40 外部订单编号, 用于关联支付系统与下单应用的数据
     */
    private String outerTradeNo;
    /**
     * 创建时间晚于(包含), 传日期值. 参数值举例: "2017-08-01"
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timeCreatedStart;
    /**
     * 创建时间早于(包含), 传日期值. 参数值举例: "2017-08-01"
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timeCreatedEnd;
    /**
     * 创建时间晚于(包含). 参数值举例: "2017-08-01 00:00:00"
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeCreatedFrom;
    /**
     * 创建时间早于(包含). 参数值举例: "2017-08-01 23:59:59"
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeCreatedTo;
    /**
     * pointAmt >= pointAmtStart
     */
    private BigDecimal pointAmtStart;
    /**
     * pointAmt <= pointAmtEnd
     */
    private BigDecimal pointAmtEnd;

    /**
     * 支付帐户类型. 1:积分账户, 2:现金账户, 3:预支付账户
     */
    private Integer payType;
    /**
     * 是否包含服务费记录. 1:是, 2:否
     */
    private Integer containFeeTrade;

    /**
     * 备注
     */
    private String remarkLike;

}
