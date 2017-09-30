package com.smartzhe.service;

import com.smartzhe.entity.User;
import com.smartzhe.model.SingleAssignRequest;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/18
 * Time: 18:10  .
 */
public interface RemoteService {

    @RequestLine("GET /users/list?name={name}")
    String getOwner(@Param(value = "name") String name);


    @RequestLine("POST /users/list?")
    @Body("name={name}")
    String getPostOwner(@Param(value = "name") String name);

    @Headers({"Content-Type: application/json"})
    @RequestLine("POST /users/list/my")
    User getOwner(User user);


    @Headers({"Content-Type: application/json"})
    @RequestLine("POST /validator/map")
    Map<String,SingleAssignRequest> map();

    @Headers({"Content-Type: application/json"})
    @RequestLine("POST /validator/list")
    List<SingleAssignRequest> list();
}


