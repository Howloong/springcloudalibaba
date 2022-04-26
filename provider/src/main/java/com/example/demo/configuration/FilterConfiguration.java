package com.example.demo.configuration;
import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setFilter(new CommonFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY, "false");
        registration.setName("sentinelFilter");
        return registration;
    }
}
