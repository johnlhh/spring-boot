package com.feign;

import com.smartzhe.entity.User;
import com.smartzhe.service.RemoteService;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: luohuahua
 * Date: 2017/9/20
 * Time: 9:31  .
 */
public class RemoteServiceTest {


    @Test
    public void testA(){
        RemoteService service = Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .options(new Request.Options(1000, 3500))
                .retryer(new Retryer.Default(5000, 5000, 3))
                .target(RemoteService.class, "http://127.0.0.1:8080/app");

       /* String result = service.getOwner("John");
        System.out.println(result);

        result = service.getPostOwner("Kent");
        System.out.println(result);*/

        User user = new User();
        user.setName("John");
        user.setId(1);
        User user1 = service.getOwner(user);
        System.out.println(user1.getName());

        String name = service.getOwner("helloworld");
        System.out.println(name);
    }
}
