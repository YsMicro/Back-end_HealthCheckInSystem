package edu.vojago.backend_healthcheckinsystem.service.impl;

import edu.vojago.backend_healthcheckinsystem.mapper.UserMapper;
import edu.vojago.backend_healthcheckinsystem.pojo.User;
import edu.vojago.backend_healthcheckinsystem.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;


    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findUserById(Integer user_id) {
        return userMapper.findUserById(user_id);
    }

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public void registerUser(String username, String password) {
        //对密码进行加密处理
//        String hashedPassword = password;
        userMapper.add(username, password);
    }

    @Override
    public void deleteUserByName(String username) {
        userMapper.deleteUserByName(username);
    }
}
