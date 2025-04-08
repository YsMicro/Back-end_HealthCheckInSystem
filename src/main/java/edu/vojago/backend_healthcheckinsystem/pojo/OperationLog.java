package edu.vojago.backend_healthcheckinsystem.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OperationLog {
    private Integer log_id;             //日志唯一ID
    private Integer admin_id;           //操作管理员ID
    private String action_type;         //操作类型（如"禁用用户"）
    private Integer target_id;          //操作目标ID（如"用户ID"）
    private String detail;              //操作详情（JSON格式）
    private LocalDateTime create_time;  //操作时间

    public OperationLog() {
    }

    public OperationLog(Integer log_id, Integer admin_id, String action_type, Integer target_id, String detail, LocalDateTime create_time) {
        this.log_id = log_id;
        this.admin_id = admin_id;
        this.action_type = action_type;
        this.target_id = target_id;
        this.detail = detail;
        this.create_time = create_time;
    }
}
