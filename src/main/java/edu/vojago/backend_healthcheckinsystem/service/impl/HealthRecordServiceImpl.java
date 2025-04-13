package edu.vojago.backend_healthcheckinsystem.service.impl;

import edu.vojago.backend_healthcheckinsystem.mapper.HealthRecordMapper;
import edu.vojago.backend_healthcheckinsystem.pojo.HealthRecord;
import edu.vojago.backend_healthcheckinsystem.service.HealthRecordService;
import edu.vojago.backend_healthcheckinsystem.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class HealthRecordServiceImpl implements HealthRecordService {

    private final HealthRecordMapper healthRecordMapper;

    public HealthRecordServiceImpl(HealthRecordMapper healthRecordMapper) {
        this.healthRecordMapper = healthRecordMapper;
    }

    @Override
    public void addHealthRecord(HealthRecord healthRecord) {
        healthRecord.setRecordTime(LocalDateTime.now());
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        healthRecord.setUserId(userId);
        healthRecordMapper.addHealthRecord(healthRecord);
    }
}
