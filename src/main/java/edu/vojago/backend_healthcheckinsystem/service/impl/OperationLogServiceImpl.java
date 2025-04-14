package edu.vojago.backend_healthcheckinsystem.service.impl;

import edu.vojago.backend_healthcheckinsystem.mapper.OperationLogMapper;
import edu.vojago.backend_healthcheckinsystem.pojo.OperationLog;
import edu.vojago.backend_healthcheckinsystem.service.OperationLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OperationLogServiceImpl implements OperationLogService {

    private final OperationLogMapper operationLogMapper;

    public OperationLogServiceImpl(OperationLogMapper operationLogMapper) {
        this.operationLogMapper = operationLogMapper;
    }

    public void logOperation(Integer adminId, String actionType, Integer targetId, String detail) {
        OperationLog operationLog = new OperationLog();
        operationLog.setAdminId(adminId);
        operationLog.setActionType(actionType);
        operationLog.setTargetId(targetId);
        operationLog.setDetail(detail);
        operationLog.setCreateTime(LocalDateTime.now());

        operationLogMapper.insertOperationLog(operationLog);
    }
}