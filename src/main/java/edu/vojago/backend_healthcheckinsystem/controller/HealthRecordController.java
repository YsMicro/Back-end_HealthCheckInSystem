package edu.vojago.backend_healthcheckinsystem.controller;

import edu.vojago.backend_healthcheckinsystem.pojo.HealthRecord;
import edu.vojago.backend_healthcheckinsystem.pojo.Result;
import edu.vojago.backend_healthcheckinsystem.service.HealthRecordService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/healthRecord")
public class HealthRecordController {

    private final HealthRecordService healthRecordService;

    public HealthRecordController(HealthRecordService healthRecordService) {
        this.healthRecordService = healthRecordService;
    }

    @GetMapping("/getHealthRecord")
    public Result<String> getHealthRecord() {
        return Result.success("获取所有打卡记录！");
    }

    @PostMapping
    public Result addHealthRecord(@RequestBody @Validated HealthRecord healthRecord) {
        healthRecordService.addHealthRecord(healthRecord);
        return Result.success();
    }

}
