package com.redis;


import com.smartzhe.Application;
import com.smartzhe.dao.UserMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
