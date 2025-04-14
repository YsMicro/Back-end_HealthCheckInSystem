package edu.vojago.backend_healthcheckinsystem.mapper;

import edu.vojago.backend_healthcheckinsystem.pojo.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {

    @Select("SELECT * FROM `my healthcheck-in app`.admins WHERE username=#{username}")
    Admin findAdminByUsername(String username);

    @Select("SELECT * FROM `my healthcheck-in app`.admins WHERE admin_id = #{adminId}")
    Admin findAdminById(Integer adminId);

    @Insert("INSERT INTO `my healthcheck-in app`.admins(username, password, create_time) " +
            "VALUES(#{username},#{password},now()) ")
    void add(String username, String password);
}
