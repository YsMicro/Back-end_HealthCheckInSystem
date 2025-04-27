package edu.vojago.backend_healthcheckinsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.vojago.backend_healthcheckinsystem.mapper.OperationLogMapper;
import edu.vojago.backend_healthcheckinsystem.pojo.OperationLog;
import edu.vojago.backend_healthcheckinsystem.pojo.PageBean;
import edu.vojago.backend_healthcheckinsystem.service.OperationLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OperationLogServiceImpl implements OperationLogService {

    private final OperationLogMapper operationLogMapper;

    public OperationLogServiceImpl(OperationLogMapper operationLogMapper) {
        this.operationLogMapper = operationLogMapper;
    }

    @Override
    public void logOperation(Integer adminId, String actionType, Integer targetId, String detail) {
        OperationLog operationLog = new OperationLog();
        operationLog.setAdminId(adminId);
        operationLog.setActionType(actionType);
        operationLog.setTargetId(targetId);
        operationLog.setDetail(detail);
        operationLog.setCreateTime(LocalDateTime.now());

        operationLogMapper.insertOperationLog(operationLog);
    }

    @Override
    public PageBean<OperationLog> listOperationLogs(Integer pageNum, Integer pageSize, Integer logId, Integer adminId, String actionType) {
        //创建PageBean对象
        PageBean<OperationLog> pb = new PageBean<>();
        //开启分页查询
        PageHelper.startPage(pageNum, pageSize);
        //调用Mapper
        /*Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        operationLogMapper.listOperationLogs(userId,logId,adminId);*/
        List<OperationLog> ol = operationLogMapper.listOperationLogs(logId, adminId, actionType);
        Page<OperationLog> p = (Page<OperationLog>) ol;
        //填充数据到PageBean对象
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}