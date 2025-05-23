package edu.vojago.backend_healthcheckinsystem.controller;

import edu.vojago.backend_healthcheckinsystem.pojo.Result;
import edu.vojago.backend_healthcheckinsystem.pojo.User;
import edu.vojago.backend_healthcheckinsystem.service.UserService;
import edu.vojago.backend_healthcheckinsystem.utils.JwtUtil;
import edu.vojago.backend_healthcheckinsystem.utils.MD5Util;
import edu.vojago.backend_healthcheckinsystem.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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

    //删除用户
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


    //用户登录
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {

        //通过username查询用户
        User loginUser = userService.findUserByName(username);

        //判断用户是否存在
        if (loginUser == null) {
            return Result.error("用户不存在");
        }

        //判断密码是否正确
        if (!(loginUser.getPassword().equals(MD5Util.encrypt(password)))) {
            return Result.error("密码错误");
        }
        //密码正确，用户登录

        //更新
        userService.updateUserLastLoginTime(loginUser.getUsername());

        Map<String, Object> claims = new HashMap<>();    //生成token
        claims.put("id", loginUser.getUserId());
        claims.put("username", loginUser.getUsername());
        String token = JwtUtil.generateToken(claims);
        return Result.success(token);
    }

    //获取用户详细信息
    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name = "Authorization") String token*/) {
        //通过username查询用户
//        Map<String, Object> map = JwtUtil.verifyToken(token);
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findUserByName(username);
        return Result.success(user);
    }

    //更新用户数据
    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user) {
        userService.update(user);
        return Result.success(user);
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("/updatePassword")
    public Result updatePassword(@RequestBody Map<String, String> params) {
        //校验数据
        String oldPassword = params.get("oldPassword");
        String newPassword = params.get("newPassword");
        String rePassword = params.get("rePassword");

        if (!StringUtils.hasLength(oldPassword) || !StringUtils.hasLength(newPassword) || !StringUtils.hasLength(rePassword)) {
            return Result.error("缺少密码数据");
        }

        //原密码是否正确
        //调用userService拿到原密码，和oldPassword进行比对
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findUserByName(username);
        if (!loginUser.getPassword().equals(MD5Util.encrypt(oldPassword))) {
            return Result.error("旧密码不正确");
        }
        if (loginUser.getPassword().equals(MD5Util.encrypt(newPassword))) {
            return Result.error("新密码不能和旧密码一致");
        }
        if (!rePassword.equals(newPassword)) {
            return Result.error("两次密码不一致");
        }

        //验证成功，修改密码
        userService.updatePassword(newPassword);
        return Result.success();
    }
}
