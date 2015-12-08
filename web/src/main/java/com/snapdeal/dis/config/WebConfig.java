package com.snapdeal.dis.config;


import com.snapdeal.base.spring.http.converter.SDServiceHttpMessageConverter;
import com.snapdeal.base.startup.config.AppEnvironmentContext;
import com.snapdeal.base.utils.HttpClientPropertiesUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by kanuj on 20/11/15.
 */

@EnableWebMvc //mvc:annotation-driven
@Configuration
@ComponentScan(basePackages = { "com.snapdeal.dis","com.snapdeal.base.transport.serialization.service","com.snapdeal.base.utils","com.snapdeal.base.spring.http.converter"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean(name = "appEnvironmentContext")
    public AppEnvironmentContext getEnvironmentContext() {
        AppEnvironmentContext context = new AppEnvironmentContext("dis-api");
        return context;
    }

    @Bean
    public HttpMessageConverter<?> getConverter() {
        return new SDServiceHttpMessageConverter();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(getConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
    }

    @Bean(name = "httpclientProperties")
    public HttpClientPropertiesUtil getProperties() {
        HttpClientPropertiesUtil client = new HttpClientPropertiesUtil();
        Resource res = new ClassPathResource("/soa-config/httpclient.properties");
        client.setLocation(res);
        return client;
    }

}
