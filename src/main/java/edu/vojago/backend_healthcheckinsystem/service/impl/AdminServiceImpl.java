package edu.vojago.backend_healthcheckinsystem.service.impl;

import edu.vojago.backend_healthcheckinsystem.mapper.AdminMapper;
import edu.vojago.backend_healthcheckinsystem.pojo.Admin;
import edu.vojago.backend_healthcheckinsystem.service.AdminService;
import edu.vojago.backend_healthcheckinsystem.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findAdminByUsername(String username) {
        return adminMapper.findAdminByUsername(username);
    }

    @Override
    public Admin findAdminById(Integer adminId) {
        return adminMapper.findAdminById(adminId);
    }

    @Override
    public void registerAdmin(String username, String password) {
        String encryptPassword = MD5Util.encrypt(password);
        adminMapper.add(username, encryptPassword);
    }
}
