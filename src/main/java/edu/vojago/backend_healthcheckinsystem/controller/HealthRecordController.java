package edu.vojago.backend_healthcheckinsystem.controller;

import edu.vojago.backend_healthcheckinsystem.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthRecord")
public class HealthRecordController {

    @GetMapping("/getHealthRecord")
    public Result<String> getHealthRecord() {
        return Result.success("获取到打卡记录");
    }

}
