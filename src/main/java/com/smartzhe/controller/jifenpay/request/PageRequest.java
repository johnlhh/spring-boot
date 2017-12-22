package com.smartzhe.controller.jifenpay.request;

import com.smartzhe.jifenpay.entity.enums.SorModeEnum;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/30
 * Time: 19:08  .
 */
@Data
public class PageRequest extends BaseRequest{

    /**
     * 每页大小
     */
    private Integer rowsPerPage;

    /**
     * 第几页
     */
    private Integer page;

    /**
     * 排序方式
     */
    private SorModeEnum sorModeEnum = SorModeEnum.ID_ASC;

}
