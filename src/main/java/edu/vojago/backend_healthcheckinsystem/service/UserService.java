package edu.vojago.backend_healthcheckinsystem.service;

import edu.vojago.backend_healthcheckinsystem.pojo.User;

public interface UserService {
    User findUserById(Integer user_id);

    User findUserByName(String user_name);
}
