package edu.vojago.backend_healthcheckinsystem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.vojago.backend_healthcheckinsystem.mapper.HealthRecordMapper;
import edu.vojago.backend_healthcheckinsystem.mapper.UserMapper;
import edu.vojago.backend_healthcheckinsystem.pojo.HealthRecord;
import edu.vojago.backend_healthcheckinsystem.pojo.PageBean;
import edu.vojago.backend_healthcheckinsystem.service.HealthRecordService;
import edu.vojago.backend_healthcheckinsystem.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class HealthRecordServiceImpl implements HealthRecordService {
    @Override
    public PageBean<HealthRecord> listHealthRecords(Integer pageNum, Integer pageSize) {
        //创建PageBean对象
        PageBean<HealthRecord> pb = new PageBean<>();
        //开启分页查询
        PageHelper.startPage(pageNum, pageSize);
        //调用Mapper
        /*Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        operationLogMapper.listOperationLogs(userId,logId,adminId);*/   // 在Service方法中添加：
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<HealthRecord> ol = healthRecordMapper.listHealthRecords(userId/*logId, adminId, actionType*/);
        Page<HealthRecord> p = (Page<HealthRecord>) ol;
        //填充数据到PageBean对象
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    private final HealthRecordMapper healthRecordMapper;
    private final UserMapper userMapper;

    public HealthRecordServiceImpl(HealthRecordMapper healthRecordMapper, UserMapper userMapper) {
        this.healthRecordMapper = healthRecordMapper;
        this.userMapper = userMapper;
    }

    @Override
    public List<HealthRecord> getHealthRecord() {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        return healthRecordMapper.getHealthRecord(userId);
    }

    @Override
    public void addHealthRecord(HealthRecord healthRecord) {
        healthRecord.setRecordTime(LocalDateTime.now());
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        healthRecord.setUserId(userId);
        healthRecordMapper.addHealthRecord(healthRecord);
    }

    @Override
    public void updateHealthRecord(HealthRecord healthRecord) {
        healthRecord.setRecordTime(LocalDateTime.now());
        healthRecordMapper.updateHealthRecord(healthRecord);
    }

    @Override
    public void deleteHealthRecord(HealthRecord healthRecord) {
        Integer recordId = healthRecord.getRecordId();
        healthRecordMapper.deleteHealthRecord(recordId);
    }
}
