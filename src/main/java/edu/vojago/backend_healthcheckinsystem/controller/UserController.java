package edu.vojago.backend_healthcheckinsystem.controller;

import edu.vojago.backend_healthcheckinsystem.pojo.User;
import edu.vojago.backend_healthcheckinsystem.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/findUserById")
    public User findUserById(Integer user_id) {
        return userService.findUserById(user_id);
    }

    @RequestMapping("/findUserByName")
    public User findUserByName(String user_name) {
        return userService.findUserByName(user_name);
    }
}
