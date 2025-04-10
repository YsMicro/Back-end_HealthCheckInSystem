package edu.vojago.backend_healthcheckinsystem.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String Hello() {
        return "Hello World!";
    }

    @RequestMapping("/hello/{message}")
    public String Hello(@PathVariable String message) {
        return "Hello " + message + "!";
    }
}
