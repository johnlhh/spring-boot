package com.smartzhe.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.smartzhe.entity.User;
import com.smartzhe.entity.UserExample;
import com.smartzhe.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by luohuahua on 17/9/3.
 */
@RestController
@RequestMapping("/swagger")
public class SwaggerController {
    @Autowired
    private IUserService userService;

    private static final String TAGS = "用户API";

    @ApiOperation(value = "获取用户列表", notes = "分页获取用户列表信息", tags = {TAGS})
    @RequestMapping(value = "/users/list", method = RequestMethod.GET)
    public PageInfo getUserList(@RequestParam(required = true) Integer toPage,
                                @RequestParam(defaultValue = "10") Integer pageSize) {

        PageHelper.startPage(toPage, pageSize);
        UserExample example = new UserExample();
        PageInfo<User> pageInfo = new PageInfo<User>(userService.querUsers(example));
        return pageInfo;
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户", tags = {TAGS})
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public String postUser(@RequestBody User user) {

        System.out.println(user.getBirthDate());
        return "success";
    }


    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true)
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return new User();
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value="/user/{id}/", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody User user) {

        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        return "success";
    }


}
