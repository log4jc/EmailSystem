package com.jwebcoder.emailsystem.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 14/10/2017.
 */

@Component
@ConfigurationProperties(prefix = "CustomProps")
public class CustomProperty {

    private final Logger logger = LoggerFactory.getLogger(CustomProperty.class);

    private Map<String,String>  druidConfig;
    private String visitorInfoPageSize;

    public Map<String, String> getDruidConfig() {
        return druidConfig;
    }

    public void setDruidConfig(Map<String, String> druidConfig) {
        this.druidConfig = druidConfig;
    }

    public String getVisitorInfoPageSize() {
        return visitorInfoPageSize;
    }

    public void setVisitorInfoPageSize(String visitorInfoPageSize) {
        this.visitorInfoPageSize = visitorInfoPageSize;
    }

}
