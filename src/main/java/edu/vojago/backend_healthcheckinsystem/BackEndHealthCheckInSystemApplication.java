package edu.vojago.backend_healthcheckinsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndHealthCheckInSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackEndHealthCheckInSystemApplication.class, args);
//        ConfigurableApplicationContext context = SpringApplication.run(BackEndHealthCheckInSystemApplication.class, args);
//        System.out.println(context.getBean("dispatcherServlet"));
    }

}
