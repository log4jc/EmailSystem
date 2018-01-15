package com.jwebcoder.emailsystem.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.ServletRequestListener;

/**
 * Created by Jason on 14/10/2017.
 */

@Configuration
public class CoreConfiguration extends WebMvcConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(CoreConfiguration.class);

    @Autowired
    private CustomProperty customProperty;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(groceryCoreInterceptor);
        super.addInterceptors(registry);
    }

    @Bean
    public ServletRequestListener createServletRequestListener() {
        return new RequestContextListener();
    }

    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new DruidStatViewServlet(), "/druid/*");
        servletRegistrationBean.setInitParameters(customProperty.getDruidConfig());
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean getFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new DruidStatFilter());
        filterRegistrationBean.setName("druidWebStatFilter");
        filterRegistrationBean.addUrlPatterns(customProperty.getDruidConfig().get("filterUrlPatterns"));
        filterRegistrationBean.addInitParameter("exclusions", customProperty.getDruidConfig().get("filterInitParameter"));
        return filterRegistrationBean;
    }

}
