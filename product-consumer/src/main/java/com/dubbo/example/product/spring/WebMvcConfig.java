package com.dubbo.example.product.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.dubbo.trace.web.filter.TraceFilter;
import com.dubbo.trace.web.handler.TraceAppExceptionHandler;

/**
 * @author dengxiaolin
 * @since 2021/01/05
 */
@Configuration
public class WebMvcConfig {

    @Bean
    public FilterRegistrationBean<TraceFilter> traceFilter() {
        TraceFilter filter = new TraceFilter();
        FilterRegistrationBean<TraceFilter> registration = new FilterRegistrationBean<>(filter);
        registration.addUrlPatterns("/*");
        registration.setName("traceFilter");

        Map<String, String> params = new HashMap<>(16);
        registration.setInitParameters(params);

        registration.setOrder(1);
        return registration;
    }

    @Bean
    public TraceAppExceptionHandler appExceptionHandler() {
        return new TraceAppExceptionHandler();
    }

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");

        // resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
        resolver.setResolveLazily(true);
        // Set the maximum allowed size (in bytes) before uploads are written to disk.
        resolver.setMaxInMemorySize(40960);
        // 上传文件大小 60M 60*1024*1024
        resolver.setMaxUploadSize(60 * 1024 * 1024);
        return resolver;
    }
}
