package com.dubbo.example.product.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @NacosValue(value = "${product:123}", autoRefreshed = true)
    private String nacosAddress;

    public String test() {
        testMapper.getAll();
        int[] b= new int[0];
        int value = b[1];
        return String.valueOf(value);
    }

}
