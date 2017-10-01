package com.smartzhe.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/26
 * Time: 14:16  .
 */
@Data
public class CouponAssignEntity {


    /**
     * 券种号（批量发放时该字段失效，使用batchAssignModel里面的categoryId）
     */
    public Integer couponCategoryId;

    /**
     * 外部发放号
     */
    @NotBlank
    public String outerAssignCode;

    /**
     * 发放对象id
     */
    public Integer personId;

    /**
     * 企业id
     */
    public Integer enterpriseId;

    /**
     * 发放数量
     */
    public Integer qty;

    /**
     * 发放原因
     */
    public String reason;

    /**
     * 发放成功后是否发送通知
     */
    public Integer isNotify;

    /**
     * 备注
     */
    public String remark;

    /**
     * 有效期开始时间
     */
    @JSONField(format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date dateValidStart;

    /**
     * 有效期结束时间
     */
    @JSONField(format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date dateValidEnd;

}
