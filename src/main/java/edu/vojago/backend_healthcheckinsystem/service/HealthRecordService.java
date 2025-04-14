package edu.vojago.backend_healthcheckinsystem.service;

import edu.vojago.backend_healthcheckinsystem.pojo.HealthRecord;

import java.util.List;

public interface HealthRecordService {

    //添加健康记录
    void addHealthRecord(HealthRecord healthRecord);

    List<HealthRecord> getHealthRecord();
}
