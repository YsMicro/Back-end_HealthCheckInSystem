package edu.vojago.backend_healthcheckinsystem.service;

import edu.vojago.backend_healthcheckinsystem.pojo.OperationLog;
import edu.vojago.backend_healthcheckinsystem.pojo.PageBean;

public interface OperationLogService {
    void logOperation(Integer adminId, String actionType, Integer targetId, String detail);

    //分页查询
    PageBean<OperationLog> listOperationLogs(Integer pageNum, Integer pageSize, Integer logId, Integer adminId, String actionType);
}
