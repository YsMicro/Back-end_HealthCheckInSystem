package edu.vojago.backend_healthcheckinsystem.controller;

import edu.vojago.backend_healthcheckinsystem.pojo.Result;
import edu.vojago.backend_healthcheckinsystem.pojo.User;
import edu.vojago.backend_healthcheckinsystem.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //查询
    //通过ID查询用户
    @RequestMapping("/findUserById")
    public User findUserById(Integer user_id) {
        return userService.findUserById(user_id);
    }

    //通过username查询用户
    @RequestMapping("/findUserByName")
    public User findUserByName(String username) {
        return userService.findUserByName(username);
    }

    //注册用户
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        //查询用户
        User u = userService.findUserByName(username);
        if (u == null) {
            //若无结果，则注册
            userService.registerUser(username, password);
            if (findUserByName(username) == null) {
                return Result.error("注册失败");
            }
            return Result.success();
        } else {  //已存在同名用户
            return Result.error("用户名已注册");
        }
    }

    @PostMapping("/DeleteUserByName")
    public Result DeleteUserByName(String username) {
        userService.findUserByName(username);
        if (findUserByName(username) == null) {
            return Result.error("不存在此用户！");
        } else {
            userService.deleteUserByName(username);

        }
        if (findUserByName(username) == null) {
            return Result.success("用户已删除");
        }
        return Result.error("删除失败");
    }
}
