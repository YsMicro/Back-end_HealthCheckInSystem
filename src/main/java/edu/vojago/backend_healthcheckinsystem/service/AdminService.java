package edu.vojago.backend_healthcheckinsystem.service;

import edu.vojago.backend_healthcheckinsystem.pojo.Admin;
import jakarta.validation.constraints.Pattern;

public interface AdminService {
    Admin findAdminByUsername(@Pattern(regexp = "^\\S{5,16}$") String username);

    Admin findAdminById(Integer adminId);

    void registerAdmin(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password);
}
