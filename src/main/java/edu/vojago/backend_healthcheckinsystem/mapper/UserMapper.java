package edu.vojago.backend_healthcheckinsystem.mapper;

import edu.vojago.backend_healthcheckinsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from `my healthcheck-in app`.users where user_id = #{user_id}")
    User findUserById(Integer user_id);

    @Select("SELECT * FROM `my healthcheck-in app`.users WHERE user_name = #{user_name}")
    User findUserByName(String user_name);

}
