package com.smartzhe.exception;

/**
 * Created by luohuahua on 17/10/8.
 */

/**
 * 业务级异常
 */
public class BizException extends RuntimeException {

    private BizExceptionType bizExceptionType;

    public BizException(){

    }

    public BizException(BizExceptionType type){

        this.bizExceptionType = type;
    }


    public BizExceptionType getBizExceptionType() {
        return bizExceptionType;
    }

    public void setBizExceptionType(BizExceptionType bizExceptionType) {
        this.bizExceptionType = bizExceptionType;
    }
}
