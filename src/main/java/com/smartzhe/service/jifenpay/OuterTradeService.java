package com.smartzhe.service.jifenpay;

import com.smartzhe.jifenpay.entity.OuterTrade;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/30
 * Time: 17:57  .
 */
public interface OuterTradeService {


    /**
     * 根据appId 和 外部交易号 查询 外部交易记录
     * @param appId  应用场景ID
     * @param outerTradeNo  外部交易号
     * @return
     */
    OuterTrade  getOuterTradeByAppIdAndOuterTradeNo(String appId,String outerTradeNo);
}
