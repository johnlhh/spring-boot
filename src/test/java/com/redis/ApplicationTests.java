package com.redis;


import com.smartzhe.Application;
import com.smartzhe.dao.UserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luohuahua on 17/8/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {


    @Autowired
    private UserMapper userMapper;


  /*  @Autowired
    private StringRedisTemplate template;

    @Test
    public void test1() throws Exception {

        User user = userMapper.selectByPrimaryKey(151);
        System.out.println(user);
    }


    @Test
    public void test2() throws Exception {
        template.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", template.opsForValue().get("aaa"));
    }*/

    private void test() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(Collections.EMPTY_LIST.add(1));
        System.out.println();
        System.out.println();
        Map<String, String> map = new HashMap<>();

    }
}
