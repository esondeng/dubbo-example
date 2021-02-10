package com.dubbo.example.product.spring;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.dubbo.trace.web.spring.TraceWebAutoConfig;
import com.trace.collect.spring.TraceCollectAutoConfig;


/**
 * @author dengxiaolin
 * @since 2020/12/25
 */
@Configuration
@EnableDubbo
@ComponentScan({"com.dubbo.example.product"})
@Import({WebMvcConfig.class,
        TraceCollectAutoConfig.class,
        TraceWebAutoConfig.class
})
public class ConsumerConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
