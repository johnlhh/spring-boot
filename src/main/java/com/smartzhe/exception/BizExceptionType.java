package com.smartzhe.exception;

/**
 * Created by luohuahua on 17/10/8.
 */
public enum BizExceptionType {


    BIZ_EXCEPTION_CUSTOMER_NOT_UNIQUE_NAME(100030001,"customer's name is already exist");

    private Integer code;

    private String message;

    BizExceptionType(final Integer code,final String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
