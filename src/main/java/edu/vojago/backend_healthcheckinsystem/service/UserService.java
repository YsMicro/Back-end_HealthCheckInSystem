package edu.vojago.backend_healthcheckinsystem.service;

import edu.vojago.backend_healthcheckinsystem.pojo.User;

public interface UserService {
    User findUserById(Integer user_id);

    User findUserByName(String username);
    //新增用户
    void registerUser(String username, String password);

    void deleteUserByName(String username);

    void updateUserLastLoginTime(String username);

    //更新
    void update(User user);

    //更新用户头像
    void updateAvatar(String avatarUrl);

    //更新用户密码
    void updatePassword(String newPassword);
}
