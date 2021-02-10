package com.dubbo.example.product.service;


import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.dubbo.example.product.manager.ProductManager;

/**
 * @author dengxiaolin
 * @since 2020/12/25
 */
@DubboService
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductManager productManager;

    @Override
    public String sayHello() {
        String test = productManager.test();
        return test;
    }
}
