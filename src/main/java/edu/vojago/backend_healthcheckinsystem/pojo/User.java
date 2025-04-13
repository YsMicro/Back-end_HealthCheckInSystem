package edu.vojago.backend_healthcheckinsystem.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    @NotNull
    private Integer userId;             //用户唯一ID
    private String username;            //用户名
    @JsonIgnore                         //使SpringMVC在将对象转换为JSON时忽略password
    private String password;            //密码
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;            //用户昵称
    private String gender;              //性别
    private String avatarUrl;           //头像路径
    private String phone;               //手机号
    @NotEmpty
    @Email
    private String email;               //邮箱
    private Integer status;             //状态（0-禁用，1-正常）
    private LocalDateTime createTime;   //注册时间
    private LocalDateTime lastLoginTime;//最后登录时间

    public User() {
    }

    public User(Integer userId, String username, String password, String nickname, String avatarUrl, String phone, String email, String gender, Integer status, LocalDateTime createTime, LocalDateTime lastLoginTime) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.avatarUrl = avatarUrl;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.status = status;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
    }
}
