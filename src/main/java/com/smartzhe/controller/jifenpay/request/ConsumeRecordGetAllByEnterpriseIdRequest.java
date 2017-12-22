package com.smartzhe.controller.jifenpay.request;

import com.smartzhe.utils.annotation.CheckInteger;
import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/30
 * Time: 19:11  .
 */
@Data
public class ConsumeRecordGetAllByEnterpriseIdRequest extends PageRequest {

    /**
     * 企业ID
     */
    @CheckInteger
    private Integer enterpriseId;

    /**
     * 起始ID, 即ConsumeRecord.id > idStart
     */
    private Integer idStart;

    /**
     * 下单应用ID
     */
    private String appId;

    /**
     * 实际下单应用ID
     */
    private String sourceAppId;

    /**
     * 2017-08-01 00:00:00
     */
    private Date timeCreatedStart;

    /**
     * 2017-08-01 23:59:59
     */
    private Date timeCreatedEnd;

}
