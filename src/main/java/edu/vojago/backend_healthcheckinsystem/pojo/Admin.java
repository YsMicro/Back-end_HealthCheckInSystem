package edu.vojago.backend_healthcheckinsystem.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Admin {
    private Integer adminId;           //管理员唯一ID
    private String username;            //登录账号
    @JsonIgnore
    private String password;            //密码（加密）
    private String role;                //角色（super-超级管理员）
    private String lastLoginIp;       //最后登录IP
    private LocalDateTime createTime; //创建时间

    public Admin() {
    }

    public Admin(Integer adminId, String username, String password, String role, String lastLoginIp, LocalDateTime createTime) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.lastLoginIp = lastLoginIp;
        this.createTime = createTime;
    }
}
