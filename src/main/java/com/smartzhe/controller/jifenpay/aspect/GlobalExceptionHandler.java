package com.smartzhe.controller.jifenpay.aspect;

import com.smartzhe.exception.BizException;
import com.smartzhe.model.ApiResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/10/31
 * Time: 17:37  .
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 业务异常处理
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = {BizException.class})
    @ResponseBody
    public ApiResponse bizExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        return ApiResponse.fail(((BizException) e).getBizExceptionType().getMessage());
    }


    /**
     * 参数异常处理
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseBody
    public ApiResponse illegalArgumentExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        return ApiResponse.fail(e.getMessage());
    }

}
