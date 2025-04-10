package edu.vojago.backend_healthcheckinsystem.config;

import edu.vojago.backend_healthcheckinsystem.interceptors.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LoginInterceptor loginInterceptor;

    public WebConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //除登录接口及注册接口以外，拦截所有接口
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/register", "/user/login");
    }
}
