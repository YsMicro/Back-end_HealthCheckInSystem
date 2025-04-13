package edu.vojago.backend_healthcheckinsystem.mapper;

import edu.vojago.backend_healthcheckinsystem.pojo.HealthRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HealthRecordMapper {

    @Insert("INSERT INTO `my healthcheck-in app`.health_records" +
            "(user_id, temperature, symptoms, remark, record_time) VALUES" +
            "(#{userId}, #{temperature}, #{symptoms, typeHandler=edu.vojago.backend_healthcheckinsystem.handler.ListToJsonTypeHandler}, #{remark}, #{recordTime})")
    void addHealthRecord(HealthRecord healthRecord);
}
