package com.smartzhe.jifenpay.entity.enums;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/30
 * Time: 19:02  .
 */
public enum SorModeEnum {

    ID_DESC("id desc"),
    ID_ASC("id asc"),
    STATUS_ASC_ID_ASC("status asc, id asc"),
    INVOICE_MODE_DESC_ID_ASC("invoiceIssueMode asc, id asc");

    private String value;

    SorModeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
