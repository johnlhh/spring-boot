package com.smartzhe.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/18
 * Time: 15:32  .
 */
@Data
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;
    private T data;


    public static <T> ApiResponse success(T data){
        ApiResponse response = new ApiResponse();
        response.setCode(0);
        response.setMsg("success");
        response.setData(data);
        return response;
    }
}