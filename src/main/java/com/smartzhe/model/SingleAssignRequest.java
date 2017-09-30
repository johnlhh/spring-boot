package com.smartzhe.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/26
 * Time: 14:51  .
 */

@Data
public class SingleAssignRequest implements Serializable {

    /**
     * 券种id
     */
    private Integer couponCategoryId;

    /**
     * 外部发放号
     */
    private String outerAssignCode;

    /**
     * 发放对象id
     */
    private Integer personId;

    /**
     * 企业id
     */
    private Integer enterpriseId;

    /**
     * 发放数量
     */
    private Integer qty;

    /**
     * 发放原因
     */
    private String reason;

    /**
     * 发放成功后是否发送通知
     */
    private Integer isNotify;

    /**
     * 备注
     */
    private String remark;

    /**
     * 有效期开始时间
     */
    private String dateValidStart;

    /**
     * 有效期结束时间
     */
    private String dateValidEnd;
}
