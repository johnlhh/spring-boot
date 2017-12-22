package com.smartzhe.service.impl;

import com.smartzhe.dao.UserMapper;
import com.smartzhe.entity.User;
import com.smartzhe.entity.UserExample;
import com.smartzhe.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by luohuahua on 17/8/5.
 */
@Service
public class UserServiceImpl implements IUserService {

   /* @Autowired
    //private UserMapper userMapper;

    @Override
    public void addUser(User user) {

    }

    @Override
    public int deleteUser(User user) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public User queryUser(User user) {
        return userMapper.selectByPrimaryKey(user.getId());
    }

    @Override
    public List<User> querUsers(UserExample example) {

        return userMapper.selectByExample(example);
    }*/
}
