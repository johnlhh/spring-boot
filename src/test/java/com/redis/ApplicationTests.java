package com.redis;


import com.smartzhe.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luohuahua on 17/8/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

    public static void main(String[] args) {
        System.out.println("sdfs");

        List<String> list = new ArrayList<>();


    }


/*
    @Autowired
    private UserMapper userMapper;






    @Test
    public void test1() throws Exception {

        User user = userMapper.selectByPrimaryKey(151);
        System.out.println(user);
    }*/


   /* @Test
    public void test2() throws Exception {
        template.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", template.opsForValue().get("aaa"));
    }*/
}
