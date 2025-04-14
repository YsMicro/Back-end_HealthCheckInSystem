package edu.vojago.backend_healthcheckinsystem.service;

public interface OperationLogService {
    void logOperation(Integer adminId, String actionType, Integer targetId, String detail);

}
