package com.dubbo.example.product.spring;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


/**
 * @author dengxiaolin
 * @since 2020/12/25
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.dubbo.example.product.service")
@ComponentScan({"com.dubbo.example.product"})
@PropertySource(value = "classpath:config/${spring.profiles.active:dev}/nacos.properties")
@PropertySource(value = "classpath:config/${spring.profiles.active:dev}/datasource.properties")
public class ProductConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
