package com.smartzhe.controller;

import com.smartzhe.model.ApiResponse;
import com.smartzhe.model.CouponAssignEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/22
 * Time: 13:49  .
 */
@RestController
@RequestMapping(value = "/validator")
public class ValidatorController {

    /*@RequestMapping("/checkName")
    @ResponseBody
    public ApiResponse testCheckName(String name) {

        return ApiResponse.success(name);
    }

    @RequestMapping("/map")
    @ResponseBody
    public Map<String, CouponAssignEntity> testMap() {
        Map<String, CouponAssignEntity> map = new HashMap<>();
        CouponAssignEntity entity = new CouponAssignEntity();
        entity.setCouponCategoryId(1);
        entity.setOuterAssignCode("sdfsfds");
        map.put("hell", entity);
        return map;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<CouponAssignEntity> testList() {
        CouponAssignEntity entity = new CouponAssignEntity();
        entity.setCouponCategoryId(1);
        entity.setOuterAssignCode("sdfsfds");
        List<CouponAssignEntity> list = new ArrayList<>();
        list.add(entity);
        return list;
    }

    @RequestMapping("/entity")
    @ResponseBody
    public CouponAssignEntity testEntity() {

        CouponAssignEntity entity = new CouponAssignEntity();
        entity.setCouponCategoryId(1);
        entity.setOuterAssignCode("sdfsfds");

        return entity;
    }*/


}
