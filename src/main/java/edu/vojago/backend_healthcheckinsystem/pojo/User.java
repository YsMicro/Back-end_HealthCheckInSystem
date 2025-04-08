package edu.vojago.backend_healthcheckinsystem.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer user_id;            //用户唯一ID
    private String username;            //用户名
    private String password;            //密码（BCrypt加密存储）
    private String nickname;            //用户昵称
    private String gender;              //性别
    private String avatar_url;          //头像路径
    private String phone;               //手机号
    private String email;               //邮箱
    private Integer status;             //状态（0-禁用，1-正常）
    private LocalDateTime createTime;   //注册时间
    private LocalDateTime lastLoginTime;//最后登录时间

    public User() {
    }

    public User(Integer user_id, String username, String password, String nickname, String avatar_url, String phone, String email, String gender, Integer status, LocalDateTime createTime, LocalDateTime lastLoginTime) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.avatar_url = avatar_url;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.status = status;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
    }
}
