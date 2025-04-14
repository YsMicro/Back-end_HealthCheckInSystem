package edu.vojago.backend_healthcheckinsystem.service;

import edu.vojago.backend_healthcheckinsystem.pojo.HealthRecord;

import java.util.List;

public interface HealthRecordService {

    //添加健康记录
    void addHealthRecord(HealthRecord healthRecord);

    //获取健康记录
    List<HealthRecord> getHealthRecord();

    //更新健康记录
    void updateHealthRecord(HealthRecord healthRecord);

    void deleteHealthRecord(HealthRecord healthRecord);
}
