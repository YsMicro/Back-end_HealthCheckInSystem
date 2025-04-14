package edu.vojago.backend_healthcheckinsystem.controller;

import edu.vojago.backend_healthcheckinsystem.pojo.Result;
import edu.vojago.backend_healthcheckinsystem.service.OperationLogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final OperationLogService operationLogService;

    public AdminController(OperationLogService operationLogService) {
        this.operationLogService = operationLogService;
    }

    @PostMapping("/disableUser")
    public Result disableUser(@RequestParam Integer userId) {
        // 假设从ThreadLocal中获取当前管理员ID
        Integer adminId = 1; // 这里应该是从ThreadLocal中获取的实际管理员ID

        // 执行禁用用户的操作

        // 记录操作日志
        operationLogService.logOperation(adminId, "禁用用户", userId, "用户ID: " + userId);

        return Result.success();
    }

    // 其他操作类似，可以在需要记录日志的地方调用operationLogService.logOperation方法
}