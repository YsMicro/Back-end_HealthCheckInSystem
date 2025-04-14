package edu.vojago.backend_healthcheckinsystem.mapper;

import edu.vojago.backend_healthcheckinsystem.pojo.HealthRecord;
import org.apache.ibatis.annotations.*;

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

    //更新修改健康记录
    @Update("UPDATE `my healthcheck-in app`.health_records SET " +
            "temperature = #{temperature}, " +
            "symptoms = #{symptoms, typeHandler=edu.vojago.backend_healthcheckinsystem.handler.ListToJsonTypeHandler}, " +
            "remark = #{remark}, " +
            "record_time = #{recordTime} " +
            "WHERE record_id = #{recordId}")
    void updateHealthRecord(HealthRecord healthRecord);

    //删除健康记录
    @Delete("DELETE FROM `my healthcheck-in app`.health_records WHERE record_id = #{recordId}")
    void deleteHealthRecord(Integer recordId);
}
