package com.longrise.springboot.config;

import com.longrise.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName:WebConfig
 * Package:com.longrise.springboot.config
 * Description:
 *
 * @Date:2018/12/22 9:10
 * @Author:Tanger@longrise.com
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
    //拦截器的配置类

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //定义登录拦截器
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(loginInterceptor);
        //拦截路径
        String[] addPath ={"/boot/**"};
        interceptorRegistration.addPathPatterns(addPath);
        //不拦截的路径
        String[] excludePath = {"/boot/hello","/boot/index"};
        interceptorRegistration.excludePathPatterns(excludePath);

        //定义权限拦截器
        //.....


    }
}
