package com.smartzhe.controller.jifenpay.request;

import com.smartzhe.dao.jifenpay.BaseDao;
import com.smartzhe.utils.annotation.CheckInteger;
import com.smartzhe.utils.annotation.CheckString;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/30
 * Time: 18:52  .
 */
@Data
public class ConsumeRecordGetByFeeTradeNoRequst extends BaseRequest{

    /**
     * 订单所属人会员ID
     */
    @CheckInteger
    private Integer ownerMemberId;

    /**
     * 服务费交易号
     */
    @CheckString(maxLength = 16)
    private String feeTradeNo;

}
