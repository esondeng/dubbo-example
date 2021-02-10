package com.dubbo.example.product;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.dubbo.example.product.spring.ProductConfig;

/**
 * @author dengxiaolin
 * @since 2020/12/28
 */
@SpringJUnitConfig(
        classes = {
                ProductConfig.class
        })
@TestPropertySource(
        locations = {
                "classpath:application.properties"
        })
@SpringBootTest
@ActiveProfiles("test")
public class BaseTest {
}
