package edu.vojago.backend_healthcheckinsystem.controller;

import edu.vojago.backend_healthcheckinsystem.pojo.HealthRecord;
import edu.vojago.backend_healthcheckinsystem.pojo.Result;
import edu.vojago.backend_healthcheckinsystem.service.HealthRecordService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/healthRecord")
public class HealthRecordController {

    private final HealthRecordService healthRecordService;

    public HealthRecordController(HealthRecordService healthRecordService) {
        this.healthRecordService = healthRecordService;
    }

    @GetMapping
    public Result<List<HealthRecord>> getHealthRecord() {
        List<HealthRecord> hr = healthRecordService.getHealthRecord();
        return Result.success(hr);
    }

    @PostMapping
    public Result addHealthRecord(@RequestBody @Validated HealthRecord healthRecord) {
        healthRecordService.addHealthRecord(healthRecord);
        return Result.success();
    }

}
