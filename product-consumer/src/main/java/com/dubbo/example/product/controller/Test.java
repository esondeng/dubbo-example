package com.dubbo.example.product.controller;

import org.springframework.stereotype.Component;

import com.trace.core.annotation.Tracing;

import lombok.extern.slf4j.Slf4j;


/**
 * @author dengxiaolin
 * @since 2021/01/08
 */
@Component
@Tracing
@Slf4j
public class Test {

    public String test() {
        log.info("test");
        return "1";
    }
}
