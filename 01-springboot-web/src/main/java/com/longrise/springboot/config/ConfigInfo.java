package com.longrise.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName:ConfigInfo
 * Package:com.longrise.springboot.config
 * Description:
 *
 * @Date:2018/12/11 21:23
 * @Author:Tanger@longrise.com
 */

@Component
@ConfigurationProperties(prefix = "boot")
public class ConfigInfo {
    private String name;

    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
