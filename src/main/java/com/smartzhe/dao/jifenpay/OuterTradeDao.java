package com.smartzhe.dao.jifenpay;

import com.smartzhe.core.datasource.dynic.TargetDataSource;
import com.smartzhe.jifenpay.entity.OuterTrade;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/30
 * Time: 18:35  .
 */
@Repository
public class OuterTradeDao extends BaseDao {

    /**
     * 根据appId 和 外部交易号 查询 外部交易记录
     * @param appId  应用场景ID
     * @param outerTradeNo  外部交易号
     * @return
     */
    @TargetDataSource(name = "slave")
    public OuterTrade getOuterTradeByAppIdAndOuterTradeNo(String appId,String outerTradeNo){
        Map<String,Object> params = new HashMap<>(2);
        params.put("appId",appId);
        params.put("outerTradeNo",outerTradeNo);
        return this.sqlSessionTemplate.selectOne("com.smartzhe.jifenpay.dao.OuterTradeMapper.getOuterTradeByAppIdAndOuterTradeNo",params);
    }
}
