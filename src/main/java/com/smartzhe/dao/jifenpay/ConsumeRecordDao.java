package com.smartzhe.dao.jifenpay;

import com.smartzhe.controller.jifenpay.response.ConsumeRecordStatInfoResponse;
import com.smartzhe.core.datasource.dynic.TargetDataSource;
import com.smartzhe.jifenpay.entity.ConsumeRecord;
import com.smartzhe.jifenpay.entity.ConsumeRecordCondition;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/30
 * Time: 18:29  .
 */
@Repository
public class ConsumeRecordDao extends BaseDao {



    /**
     * 获取单个消费记录
     *
     * @param consumeRecord
     * @return
     */
    @TargetDataSource(name = "slave")
    public ConsumeRecord getConsumeRecord(ConsumeRecord consumeRecord) {

        return this.sqlSessionTemplate.selectOne("com.smartzhe.jifenpay.dao.ConsumeRecordMapper.getConsumeRecord", consumeRecord);
    }

    /**
     * feeTradeNo 和 ownerMemberId 获取单个消费记录
     * @param feeTradeNo 服务费交易号
     * @param ownerMemberId 订单所属人会员ID
     * @return
     */
    @TargetDataSource(name = "slave")
    public ConsumeRecord getConsumeRecordByFeeTradeNo(String feeTradeNo, Integer ownerMemberId) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("feeTradeNo", feeTradeNo);
        params.put("ownerMemberId", ownerMemberId);
        return this.sqlSessionTemplate.selectOne("com.smartzhe.jifenpay.dao.ConsumeRecordMapper.getConsumeRecordByFeeTradeNoAndOwnerMemberId", params);
    }


    /**
     * 根据条件获取多条消费记录
     * @param condition
     * @return
     */
    @TargetDataSource(name = "slave")
    public List<ConsumeRecord> getConsumeRecordList(ConsumeRecordCondition condition){
        return this.sqlSessionTemplate.selectList("com.smartzhe.jifenpay.dao.ConsumeRecordMapper.getConsumeRecordList",condition);
    }

    /**
     * 根据条件获取消费汇总信息
     * @param condition
     * @return
     */
    @TargetDataSource(name = "slave")
    public ConsumeRecordStatInfoResponse statInfo(ConsumeRecordCondition condition){
        return this.sqlSessionTemplate.selectOne("com.smartzhe.jifenpay.dao.ConsumeRecordMapper.consumeRecordStatInfo",condition);
    }
}
