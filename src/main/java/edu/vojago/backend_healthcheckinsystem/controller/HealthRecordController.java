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
        return Result.success("获取所有打卡记录！");
    }
//    public Result<String> getHealthRecord(@RequestHeader(name = "Authorization") String token, HttpServletResponse response) {
//        try {
//            Map<String, Object> claims = JwtUtil.verifyToken(token);
//            return Result.success("获取到打卡记录");
//        } catch (Exception e) {
//            response.setStatus(401);
//            return Result.error("未登录");
//        }
//    }
}
