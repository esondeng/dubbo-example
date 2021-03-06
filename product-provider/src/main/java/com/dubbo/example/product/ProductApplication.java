package com.dubbo.example.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.dubbo.example.product.spring.ProductConfig;

/**
 * @author dengxiaolin
 * @since 2020/12/25
 */
@Configuration
@SpringBootApplication
@Import({
        ProductConfig.class
})
@MapperScan("com.dubbo.example.product.mapper")
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
