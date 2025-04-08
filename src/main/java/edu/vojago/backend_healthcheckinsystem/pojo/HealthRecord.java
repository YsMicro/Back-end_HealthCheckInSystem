package edu.vojago.backend_healthcheckinsystem.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class HealthRecord {
    private Integer record_id;          //记录唯一ID好
    private Integer user_id;            //关联用户ID
    private Double temperature;         //体温（单位：℃）
    private List<String> symptoms;      //症状（JSON数组，如["咳嗽","乏力"]）
    private String remark;              //备注（用户自定义输入）
    private LocalDateTime record_time;  //记录时间
    private Integer syncStatus;         //同步状态（0-未同步，1-已同步）

    public HealthRecord() {
    }

    public HealthRecord(Integer record_id, Integer user_id, Double temperature, List<String> symptoms, String remark, LocalDateTime record_time, Integer syncStatus) {
        this.record_id = record_id;
        this.user_id = user_id;
        this.temperature = temperature;
        this.symptoms = symptoms;
        this.remark = remark;
        this.record_time = record_time;
        this.syncStatus = syncStatus;
    }
}
