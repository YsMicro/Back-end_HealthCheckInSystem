package edu.vojago.backend_healthcheckinsystem.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Admin {
    private Integer admin_id;           //管理员唯一ID
    private String username;            //登录账号
    private String password;            //密码（加密）
    private String role;                //角色（super-超级管理员）
    private String last_login_ip;       //最后登录IP
    private LocalDateTime created_time; //创建时间

    public Admin() {
    }

    public Admin(Integer admin_id, String username, String password, String role, String last_login_ip, LocalDateTime created_time) {
        this.admin_id = admin_id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.last_login_ip = last_login_ip;
        this.created_time = created_time;
    }
}
