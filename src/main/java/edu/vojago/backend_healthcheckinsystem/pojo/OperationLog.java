package edu.vojago.backend_healthcheckinsystem.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OperationLog {
    private Integer logId;             //日志唯一ID
    private Integer adminId;           //操作管理员ID
    private String actionType;         //操作类型（如"禁用用户"）
    private Integer targetId;          //操作目标ID（如"用户ID"）
    private String detail;              //操作详情（JSON格式）
    private LocalDateTime createTime;  //操作时间

    public OperationLog() {
    }

    public OperationLog(Integer logId, Integer adminId, String actionType, Integer targetId, String detail, LocalDateTime createTime) {
        this.logId = logId;
        this.adminId = adminId;
        this.actionType = actionType;
        this.targetId = targetId;
        this.detail = detail;
        this.createTime = createTime;
    }
}
