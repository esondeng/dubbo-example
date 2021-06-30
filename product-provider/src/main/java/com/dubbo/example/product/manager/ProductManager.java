package com.dubbo.example.product.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import com.dubbo.example.product.mapper.TestMapper;

/**
 * @author dengxiaolin
 * @since 2020/12/25
 */
@Component
public class ProductManager {
    @Autowired
    private TestMapper testMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Value("${product:123}")
    private String nacosAddress;

    public String test() {
        return transactionTemplate.execute((status) -> testMapper.getById(2).getName());
    }

}
