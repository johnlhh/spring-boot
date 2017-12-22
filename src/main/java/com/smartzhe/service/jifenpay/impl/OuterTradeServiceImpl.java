package com.smartzhe.service.jifenpay.impl;

import com.smartzhe.dao.jifenpay.OuterTradeDao;
import com.smartzhe.jifenpay.entity.OuterTrade;
import com.smartzhe.service.jifenpay.OuterTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/30
 * Time: 18:00  .
 */
@Service
public class OuterTradeServiceImpl implements OuterTradeService {

    @Autowired
    private OuterTradeDao outerTradeDao;

    /**
     * 根据appId 和 外部交易号 查询 外部交易记录
     *
     * @param appId        应用场景ID
     * @param outerTradeNo 外部交易号
     * @return
     */
    @Override
    public OuterTrade getOuterTradeByAppIdAndOuterTradeNo(String appId, String outerTradeNo) {
        return outerTradeDao.getOuterTradeByAppIdAndOuterTradeNo(appId, outerTradeNo);
    }
}
