package com.smartzhe.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartzhe.model.CouponAssignEntity;
import com.smartzhe.model.SingleAssignRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/26
 * Time: 11:22  .
 */

public class JSONDeserial {

    public static final ObjectMapper mapper = new ObjectMapper();

    public static void test() throws JsonProcessingException {
        CouponAssignEntity entity = new CouponAssignEntity();
        entity.setCouponCategoryId(1);
        entity.setOuterAssignCode("sdfsfds");

        JSONObject jsonObject = JSONObject.parseObject(mapper.writeValueAsString(entity), JSONObject.class);
        SingleAssignRequest request = mapper.convertValue(jsonObject, SingleAssignRequest.class);
        System.out.println(mapper.writeValueAsString(request));

        
    }

    public static void main(String[] args) throws JsonProcessingException {

        JSONDeserial.test();
        /*Map<String, CouponAssignEntity> map = new HashMap<>();
        CouponAssignEntity entity = new CouponAssignEntity();
        entity.setCouponCategoryId(1);
        entity.setOuterAssignCode("sdfsfds");
        map.put("hell", entity);
        System.out.println(map);

        String json = mapper.writeValueAsString(map);
        System.out.println(json);


        Map<String, CouponAssignEntity> obj = JSONObject.parseObject(json, Map.class);
        System.out.println(obj);*/


    }

}


