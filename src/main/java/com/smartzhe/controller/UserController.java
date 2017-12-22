package com.smartzhe.controller;

/**
 * Created by luohuahua on 17/6/16.
 */

import com.smartzhe.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在/users下，可去除
public class UserController {
/*
    @RequestMapping("/add")
    @ResponseBody
    String home(HttpServletRequest request,
                HttpServletResponse response,
                @RequestBody String name) {

        System.out.println(name);
        return name;
    }

    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    @ResponseBody
    public String list(@RequestParam String name) throws InterruptedException {
        return name.toUpperCase();
    }

    @RequestMapping(value = "/list/my", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    @ResponseBody
    public User mylist(@RequestBody User user) throws InterruptedException {
        return user;
    }*/




   /* @Autowired
    private IUserService userService;

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value="list", method= RequestMethod.GET)
    public List<User> getUserList() {

        UserExample example = new UserExample();
        System.out.println("hello world12");
        return userService.querUsers(example);
    }*/

   /* @RequestMapping("/home")
    @ResponseBody
    Map home() {

        Map map = new HashMap();
        map.put("name", "john");
        map.put("age", 25);


        return map;
    }

    @RequestMapping("/index")
    @ResponseBody
   void index(HttpServletRequest request) {

        request.getParameter("");
        System.out.println("index");
    }


    @RequestMapping("/user")
    @ResponseBody
    User user() {
        User user = new User();
        user.setId(151);
        user = userService.
        (user);
        return user;
    }

    @TargetDataSource(name = "ds1")
    @RequestMapping("/user/ds1")
    @ResponseBody
    User user1() {

        User user = new User();
        user.setId(151);
        user = userService.queryUser(user);
        return user;
    }

    @TargetDataSource(name = "ds2")
    @RequestMapping("/user/ds2")
    @ResponseBody
    User user2() {

        User user = new User();
        user.setId(151);
        user = userService.queryUser(user);
        return user;
    }


    @RequestMapping("/user/query")
    @ResponseBody
    List<User> queryUsers() {


        UserExample example = new UserExample();
        return userService.querUsers(example);
    }

    @RequestMapping("/user/queryPage")
    @ResponseBody
    PageInfo queryUsersByPage() {
        PageHelper.startPage(1, 10);
        UserExample example = new UserExample();
        example.createCriteria().andIdIsNotNull().andPasswdIsNotNull();

        System.out.println(userService + "==ssdsf====2323===hellowo");
        List<User> list = userService.querUsers(example);
        PageInfo<User> p = new PageInfo<User>(list);
        return p;
    }

    @RequestMapping("/user/add")
    @ResponseBody
    public User addUser() throws Exception {

        User user = new User();
        user.setName("helloworld");

        userService.addUser(user);
        return user;
    }*/


}
