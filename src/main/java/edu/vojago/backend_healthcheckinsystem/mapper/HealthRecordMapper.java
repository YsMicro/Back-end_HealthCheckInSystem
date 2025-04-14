package edu.vojago.backend_healthcheckinsystem.mapper;

import edu.vojago.backend_healthcheckinsystem.pojo.HealthRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HealthRecordMapper {

    @Insert("INSERT INTO `my healthcheck-in app`.health_records" +
            "(user_id, temperature, symptoms, remark, record_time) VALUES" +
            "(#{userId}, #{temperature}, #{symptoms, typeHandler=edu.vojago.backend_healthcheckinsystem.handler.ListToJsonTypeHandler}, #{remark}, #{recordTime})")
    void addHealthRecord(HealthRecord healthRecord);

    //查询当前用户的所有健康记录
    @Select("SELECT * FROM `my healthcheck-in app`.health_records WHERE user_id=#{userId}")
    List<HealthRecord> getHealthRecord(Integer userId);
}
