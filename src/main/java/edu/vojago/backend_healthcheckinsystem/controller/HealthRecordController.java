package edu.vojago.backend_healthcheckinsystem.controller;

import edu.vojago.backend_healthcheckinsystem.pojo.Result;
import edu.vojago.backend_healthcheckinsystem.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/healthRecord")
public class HealthRecordController {

    @GetMapping("/getHealthRecord")
    public Result<String> getHealthRecord(@RequestHeader(name = "Authorization") String token, HttpServletResponse response) {
        try {
            Map<String, Object> claims = JwtUtil.verifyToken(token);
            return Result.success("获取到打卡记录");
        } catch (Exception e) {
            response.setStatus(401);
            return Result.error("未登录");
        }
    }
}
