package edu.vojago.backend_healthcheckinsystem.service;

import edu.vojago.backend_healthcheckinsystem.pojo.HealthRecord;

public interface HealthRecordService {

    //添加健康记录
    void addHealthRecord(HealthRecord healthRecord);
}
