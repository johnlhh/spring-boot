package com.smartzhe.service.jifenpay.impl;

import com.gat.common.convention.Pagination;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smartzhe.controller.jifenpay.request.*;
import com.smartzhe.controller.jifenpay.response.ConsumeRecordStatInfoResponse;
import com.smartzhe.dao.jifenpay.ConsumeRecordDao;
import com.smartzhe.jifenpay.entity.ConsumeRecord;
import com.smartzhe.jifenpay.entity.ConsumeRecordCondition;
import com.smartzhe.service.jifenpay.ConsumeRecordService;
import com.smartzhe.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/30
 * Time: 17:39  .
 */
@Service
public class ConsumeRecordServiceImpl implements ConsumeRecordService {


    @Autowired
    private ConsumeRecordDao consumeRecordDao;

    /**
     * 根据id 或者 tradeNo 获取单个消费记录
     *
     * @param consumeRecord
     * @return
     */
    @Override
    public ConsumeRecord getConsumeRecord(ConsumeRecord consumeRecord) {
        return consumeRecordDao.getConsumeRecord(consumeRecord);
    }

    /**
     * feeTradeNo 和 ownerMemberId 获取单个消费记录
     *
     * @param feeTradeNo    服务费交易号
     * @param ownerMemberId 订单所属人会员ID
     * @return
     */
    @Override
    public ConsumeRecord getConsumeRecordByFeeTradeNo(String feeTradeNo, Integer ownerMemberId) {
        return consumeRecordDao.getConsumeRecordByFeeTradeNo(feeTradeNo, ownerMemberId);
    }

    /**
     * 根据企业Id分页获取消费记录列表
     * @param condition
     * @return
     */
    @Override
    public Pagination<ConsumeRecord> getAllByEnterpriseId(ConsumeRecordCondition condition) {
        return getPagination(condition);
    }

    /**
     * 根据ownerMemberId分页获取用户的消费记录列表
     * @param condition
     * @return
     */
    @Override
    public Pagination<ConsumeRecord> getAllByOwnerId(ConsumeRecordCondition condition) {
        return getPagination(condition);
    }

    /**
     * 按搜索条件取消费记录信息
     * @param condition
     * @return
     */
    @Override
    public Pagination<ConsumeRecord> find(ConsumeRecordCondition condition) {
        return getPagination(condition);
    }

    /**
     * 根据条件获取消费汇总信息
     * @param condition
     * @return
     */
    @Override
    public ConsumeRecordStatInfoResponse statInfo(ConsumeRecordCondition condition) {
        return consumeRecordDao.statInfo(condition);
    }


    private Pagination<ConsumeRecord> getPagination(ConsumeRecordCondition condition){
        Pagination pagination = new Pagination();
        if(condition != null){
            //分页处理
            PageHelper.startPage(condition.getPage(), condition.getRowsPerPage());
            PageInfo<ConsumeRecord> pageInfo = new PageInfo<>(consumeRecordDao.getConsumeRecordList(condition));
            pagination.setDataList(pageInfo.getList());
            pagination.setTotalCount((int) pageInfo.getTotal());
        }
        return pagination;
    }

}
