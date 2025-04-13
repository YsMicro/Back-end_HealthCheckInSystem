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

    @Update("UPDATE `my healthcheck-in app`.users SET " +
            "nickname = #{nickname}, " +
            "gender = #{gender}, " +
            "`avatar_url` = #{avatarUrl}, " +
            "phone = #{phone}, " +
            "email = #{email} " +
            "WHERE user_id = #{userId}")
    void update(User user);

    @Update("UPDATE `my healthcheck-in app`.users SET " +
            "avatar_url=#{avatarUrl} WHERE " +
            "user_id=#{userId}")
    void updateAvatar(String avatarUrl, Integer userId);

    @Update("UPDATE `my healthcheck-in app`.users SET " +
            "password = #{newPassword} " +
            "WHERE user_id = #{userId}")
    void updatePassword(String newPassword, Integer userId);
}
