package com.smartzhe.model;

import com.gat.common.convention.Pagination;
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
    private int totalRows;
    private boolean success;
    private String errorMsg;
    private T result;


    public static <T> ApiResponse success(T result) {
        ApiResponse response = new ApiResponse();
        response.setCode(0);
        response.setErrorMsg("");
        response.setResult(result);
        response.setSuccess(true);
        return response;
    }

    public static ApiResponse success(Pagination pagination) {
        ApiResponse response = new ApiResponse();
        response.setCode(0);
        response.setErrorMsg("");
        response.setResult(pagination.getDataList());
        response.setSuccess(true);
        response.setTotalRows(pagination.getTotalCount());
        return response;
    }

    public static ApiResponse fail() {
        ApiResponse response = new ApiResponse();
        response.setCode(-1);
        response.setErrorMsg("");
        response.setResult(null);
        response.setSuccess(false);
        return response;
    }

    public static ApiResponse fail(String message) {
        ApiResponse response = new ApiResponse();
        response.setCode(-1);
        response.setErrorMsg(message);
        response.setResult(null);
        response.setSuccess(false);
        return response;
    }

}