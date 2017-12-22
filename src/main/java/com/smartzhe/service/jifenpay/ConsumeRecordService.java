package com.smartzhe.service.jifenpay;

import com.gat.common.convention.Pagination;
import com.smartzhe.controller.jifenpay.request.ConsumeRecordFindRequest;
import com.smartzhe.controller.jifenpay.request.ConsumeRecordGetAllByEnterpriseIdRequest;
import com.smartzhe.controller.jifenpay.request.ConsumeRecordGetAllByOwnerIdRequest;
import com.smartzhe.controller.jifenpay.request.ConsumeRecordStatInfoRequest;
import com.smartzhe.controller.jifenpay.response.ConsumeRecordStatInfoResponse;
import com.smartzhe.jifenpay.entity.ConsumeRecord;
import com.smartzhe.jifenpay.entity.ConsumeRecordCondition;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/30
 * Time: 17:35  .
 */

public interface ConsumeRecordService {

    /**
     * 根据id 或者 tradeNo 获取单个消费记录
     *
     * @param consumeRecord
     * @return
     */
    ConsumeRecord getConsumeRecord(ConsumeRecord consumeRecord);

    /**
     * feeTradeNo 和 ownerMemberId 获取单个消费记录
     *
     * @param feeTradeNo    服务费交易号
     * @param ownerMemberId 订单所属人会员ID
     * @return
     */
    ConsumeRecord getConsumeRecordByFeeTradeNo(String feeTradeNo, Integer ownerMemberId);

    /**
     * 根据企业Id分页获取消费记录列表
     * @param condition
     * @return
     */
    Pagination<ConsumeRecord> getAllByEnterpriseId(ConsumeRecordCondition condition);

    /**
     * 根据ownerMemberId分页获取用户的消费记录列表
     * @param condition
     * @return
     */
    Pagination<ConsumeRecord> getAllByOwnerId(ConsumeRecordCondition condition);

    /**
     * 按搜索条件取消费记录信息
     * @param condition
     * @return
     */
    Pagination<ConsumeRecord> find(ConsumeRecordCondition condition);

    /**
     * 根据条件获取消费汇总信息
     * @param condition
     * @return
     */
    ConsumeRecordStatInfoResponse statInfo(ConsumeRecordCondition condition);
}
