package edu.vojago.backend_healthcheckinsystem.service.impl;

import edu.vojago.backend_healthcheckinsystem.mapper.UserMapper;
import edu.vojago.backend_healthcheckinsystem.pojo.User;
import edu.vojago.backend_healthcheckinsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(Integer user_id) {
        return userMapper.findUserById(user_id);
    }

    @Override
    public User findUserByName(String user_name) {
        return userMapper.findUserByName(user_name);
    }
}
