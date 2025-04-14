package edu.vojago.backend_healthcheckinsystem.mapper;

import edu.vojago.backend_healthcheckinsystem.pojo.OperationLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationLogMapper {

    @Insert("INSERT INTO `my healthcheck-in app`.operation_logs (admin_id, action_type, target_id, detail, create_time) " +
            "VALUES (#{adminId}, #{actionType}, #{targetId}, #{detail}, #{createTime})")
    void insertOperationLog(OperationLog operationLog);
}