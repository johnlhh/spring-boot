package com.smartzhe.dao.jifenpay;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/30
 * Time: 18:28  .
 */
import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;

public abstract class BaseDao {

    /**
     * 读取数据源
     */
    @Resource
    protected SqlSessionTemplate sqlSessionTemplate;
}
