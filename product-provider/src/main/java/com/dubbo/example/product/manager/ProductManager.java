package com.dubbo.example.product.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.dubbo.example.product.mapper.TestMapper;
import com.eson.common.core.exception.BusinessException;

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

    @NacosValue(value = "${product:123}", autoRefreshed = true)
    private String nacosAddress;

    public String test() {
        return transactionTemplate.execute((status) -> testMapper.getById(1).getName());
    }

}
