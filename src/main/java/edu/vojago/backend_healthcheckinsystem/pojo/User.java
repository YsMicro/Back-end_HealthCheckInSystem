package edu.vojago.backend_healthcheckinsystem.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private int user_id;
    private String user_name;
    private String user_password;
    private String display_name;

    public User() {
    }

    public User(int user_id, String user_name, String user_password, String display_name) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.display_name = display_name;
    }

}
