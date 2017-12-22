package com.smartzhe.controller.jifenpay.request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.smartzhe.utils.annotation.ValidatorUtils;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/30
 * Time: 19:11  .
 */
public class BaseRequest implements Serializable {

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":"
                + JSON.toJSONString(this, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.SkipTransientField);
    }


    /**
     * 用于验证型注解的统一验证
     * 针对数据层面的简单检查
     */
    public void validate() {
        ValidatorUtils.validate(this);
    }

}
