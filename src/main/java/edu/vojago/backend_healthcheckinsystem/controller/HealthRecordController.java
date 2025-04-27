package edu.vojago.backend_healthcheckinsystem.controller;

import edu.vojago.backend_healthcheckinsystem.pojo.HealthRecord;
import edu.vojago.backend_healthcheckinsystem.pojo.PageBean;
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

    // 分页查询健康记录
    @GetMapping("/list")
    public Result<PageBean<HealthRecord>> listHealthRecords(
            Integer pageNum,
            Integer pageSize,
            @RequestParam() Integer userId/*,
//            @RequestParam(required = false) Integer adminId
            @RequestParam(required = false) Integer logId,
            @RequestParam(required = false) String actionType*/

    ) {
        PageBean<HealthRecord> pb = healthRecordService.listHealthRecords(pageNum, pageSize/*, logId, adminId, actionType*/);
        return Result.success(pb);
    }


    @PostMapping
    public Result addHealthRecord(@RequestBody @Validated(HealthRecord.Add.class) HealthRecord healthRecord) {
        healthRecordService.addHealthRecord(healthRecord);
        return Result.success();
    }

    @PutMapping
    public Result updateHealthRecord(@RequestBody @Validated(HealthRecord.Update.class) HealthRecord healthRecord) {
        healthRecordService.updateHealthRecord(healthRecord);
        return Result.success();
    }

    @DeleteMapping
    public Result deleteHealthRecord(@RequestBody HealthRecord healthRecord) {
        healthRecordService.deleteHealthRecord(healthRecord);
        return Result.success();
    }
}
