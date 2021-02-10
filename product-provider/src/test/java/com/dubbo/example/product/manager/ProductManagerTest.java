package com.dubbo.example.product.manager;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dubbo.example.product.BaseTest;

/**
 * @author dengxiaolin
 * @since 2020/12/28
 */
public class ProductManagerTest extends BaseTest {

    @Autowired
    private ProductManager productManager;

    @Test
    void test() {
        String test = productManager.test();
        System.out.println(test);
    }
}
