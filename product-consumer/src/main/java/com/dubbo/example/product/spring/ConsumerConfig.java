package com.dubbo.example.product.spring;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.eson.common.web.spring.CommonWebMvcConfig;
import com.trace.web.spring.TraceWebMvcConfig;


/**
 * @author dengxiaolin
 * @since 2020/12/25
 */
@Configuration
@EnableDubbo
@ComponentScan({"com.dubbo.example.product"})
@Import({CommonWebMvcConfig.class})
public class ConsumerConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
