package com.dubbo.example.product.spring;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySources;
import com.trace.collect.spring.TraceCollectAutoConfig;


/**
 * @author dengxiaolin
 * @since 2020/12/25
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.dubbo.example.product.service")
@ComponentScan({"com.dubbo.example.product"})
@EnableNacosConfig
@Import({TraceCollectAutoConfig.class,
        JdbcConfig.class,
        MybatisConfig.class})
@NacosPropertySources({
        @NacosPropertySource(dataId = "dubbo-provider-demo.properties", groupId = "dubbo-provider-group", autoRefreshed = true)
})
@PropertySource(value = "classpath:config/${spring.profiles.active:dev}/nacos.properties")
@PropertySource(value = "classpath:config/${spring.profiles.active:dev}/datasource.properties")
public class ProductConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
