package com.smartzhe.controller;

import com.smartzhe.model.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/22
 * Time: 13:49  .
 */
@RestController
@RequestMapping(value = "/validator")
public class ValidatorController {

    @RequestMapping("/checkName")
    @ResponseBody
    public ApiResponse testCheckName(String name) {

        return ApiResponse.success(name);
    }
}
