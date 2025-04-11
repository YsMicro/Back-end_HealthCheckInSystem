package edu.vojago.backend_healthcheckinsystem.mapper;

import edu.vojago.backend_healthcheckinsystem.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO `my healthcheck-in app`.users(username,password,create_time)" +
            "VALUES(#{username},#{password},now())")
    void add(String username, String password);

    @Select("SELECT * FROM `my healthcheck-in app`.users where user_id = #{user_id}")
    User findUserById(Integer user_id);

    @Select("SELECT * FROM `my healthcheck-in app`.users WHERE username = #{username}")
    User findUserByName(String username);

    @Delete("DELETE FROM `my healthcheck-in app`.users WHERE username = #{username}")
    void deleteUserByName(String username);

    @Update("UPDATE `my healthcheck-in app`.users " +
            "SET last_login_time = now() " +
            "WHERE username = #{username}")
    void updateUserLastLoginTime(String username);

}
