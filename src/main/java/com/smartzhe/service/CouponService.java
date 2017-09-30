package com.smartzhe.service;

import com.smartzhe.entity.User;
import com.smartzhe.model.ApiResponse;
import feign.*;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/18
 * Time: 15:19  .
 */
public interface CouponService {


    @RequestLine("POST /coupon/query/getCouponList")
    @Body("enterpriseId={enterpriseId}&assignAppId={assignAppId}&personId={personId}&statusList={statusList}")
    ApiResponse getCouponList(@Param("enterpriseId") Integer enterpriseId,
                         @Param("assignAppId") String assignAppId,
                         @Param("personId") Integer personId,
                         @Param("statusList") String statusList);

   /* @Headers({"Content-Type: application/json"})
    @RequestLine("POST /users/list/my")*/

    @Headers({"Content-Type: application/json"})
    @RequestLine("POST /coupon/query/getCouponList")
    ApiResponse getCouponList1(FRequest  request);

    @Data
    class FRequest{

        private Integer enterpriseId;


        private String assignAppId;


        private Set<CouponStatus> statusList;

        private Integer personId;
    }

    static enum CouponStatus{
        UNUSED("未使用","UNUSED",1),
        USED("已使用","USED",2),
        EXPIRED("已过期","EXPIRED",3),
        RECYCLED("已回收","RECYCLED",4);

        private int code;
        private String descZhCn;
        private String descEnUs;

        CouponStatus(String descZhCn, String descEnUs, int code){
            this.descZhCn = descZhCn ;
            this.descEnUs = descEnUs ;
            this.code = code ;
        }
    }

    public static void main(String[] args) {
        CouponService service = Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(CouponService.class, "http://127.0.0.1:8080/");

       /* String result = service.getOwner("John");
        System.out.println(result);

        result = service.getPostOwner("Kent");
        System.out.println(result);*/
        ApiResponse response = service.getCouponList(null,"10000306",226102,"UNUSED,USED");

       /* FRequest request = new FRequest();
        request.setAssignAppId("10000306");
        request.setEnterpriseId(1128);
        request.setPersonId(226102);
        Set set = new HashSet();
        set.add(CouponStatus.UNUSED);
        request.setStatusList(set);
        ApiResponse response = service.getCouponList1(request);*/

        System.out.println(response);
    }

}
