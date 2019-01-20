package com.longrise.springboot.config;

import com.longrise.springboot.servlet.HeServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:ServletConfig
 * Package:com.longrise.springboot.config
 * Description:
 *
 * @Date:2018/12/22 10:44
 * @Author:Tanger@longrise.com springboot没有xml,@Configuration相当于一个spring的xml配置文件，如：applicationContext.xml
 */
@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean heServletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new HeServlet(), "/heServlet");
        return registration;
    }
}
