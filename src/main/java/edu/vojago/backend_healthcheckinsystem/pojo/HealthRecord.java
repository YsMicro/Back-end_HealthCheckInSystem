package edu.vojago.backend_healthcheckinsystem.pojo;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthRecord {
    private Integer recordId;          //记录唯一ID好
    private Integer userId;            //关联用户ID
    @NotNull
    @DecimalMin(value = "30.0", message = "体温不能低于30.0")
    @DecimalMax(value = "50.0", message = "体温不能高于50.0")
    private Double temperature;         //体温（单位：℃）
    private List<String> symptoms;      //症状（JSON数组，如["咳嗽","乏力"]）
    private String remark;              //备注（用户自定义输入）
    private LocalDateTime recordTime;  //记录时间
    private Integer syncStatus;         //同步状态（0-未同步，1-已同步）
}
