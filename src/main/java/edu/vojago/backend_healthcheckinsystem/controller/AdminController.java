package edu.vojago.backend_healthcheckinsystem.controller;

import edu.vojago.backend_healthcheckinsystem.pojo.Admin;
import edu.vojago.backend_healthcheckinsystem.pojo.Result;
import edu.vojago.backend_healthcheckinsystem.service.AdminService;
import edu.vojago.backend_healthcheckinsystem.service.OperationLogService;
import edu.vojago.backend_healthcheckinsystem.utils.JwtUtil;
import edu.vojago.backend_healthcheckinsystem.utils.MD5Util;
import edu.vojago.backend_healthcheckinsystem.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final OperationLogService operationLogService;

    public AdminController(OperationLogService operationLogService) {
        this.operationLogService = operationLogService;
    }

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public Result registerAdmin(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        Admin admin = adminService.findAdminByUsername(username);
        if (!(admin == null)) {
            return Result.error("用户已存在");
        }
        adminService.registerAdmin(username, password);
        Admin loginAdmin = adminService.findAdminByUsername(username);
        if (loginAdmin == null) {
            return Result.error("注册失败");
        } else {
            return Result.success(loginAdmin);
        }
    }


    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 通过username查询管理员
        Admin loginAdmin = adminService.findAdminByUsername(username);

        // 判断管理员是否存在
        if (loginAdmin == null) {
            return Result.error("管理员不存在");
        }

        // 判断密码是否正确
        if (!loginAdmin.getPassword().equals(MD5Util.encrypt(password))) {
            return Result.error("密码错误");
        }

        // 生成JWT Token
        Map<String, Object> claims = new HashMap<>();
        claims.put("admin_id", loginAdmin.getAdminId());
        claims.put("username", loginAdmin.getUsername());
        String token = JwtUtil.generateToken(claims);


        operationLogService.logOperation(loginAdmin.getAdminId(), "用户登录", loginAdmin.getAdminId(), "用户ID: " + loginAdmin.getAdminId());


        return Result.success(token);
    }

    @GetMapping("/adminInfo")
    public Result<Admin> adminInfo() {
        // 从ThreadLocal中获取当前管理员ID
        Integer adminId = ThreadLocalUtil.getAdminId();
        if (adminId == null) {
            return Result.error("未登录或登录已过期");
        }

        // 通过adminId查询管理员信息
        Admin admin = adminService.findAdminById(adminId);
        if (admin == null) {
            return Result.error("管理员不存在");
        }

        return Result.success(admin);
    }

    @PostMapping("/disableUser")
    public Result disableUser(@RequestParam Integer userId) {
        // 假设从ThreadLocal中获取当前管理员ID
        Integer adminId = 1; // 这里应该是从ThreadLocal中获取的实际管理员ID

        // 执行禁用用户的操作

        // 记录操作日志
        operationLogService.logOperation(adminId, "禁用用户", userId, "用户ID: " + userId);

        return Result.success();
        // 其他操作类似，可以在需要记录日志的地方调用operationLogService.logOperation方法
    }

}