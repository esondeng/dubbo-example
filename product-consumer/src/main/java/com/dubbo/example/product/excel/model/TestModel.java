package com.dubbo.example.product.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.eson.common.excel.model.BaseRowModel;

import lombok.Getter;
import lombok.Setter;

/**
 * @author dengxiaolin
 * @since 2021/01/21
 */
@Getter
@Setter
public class TestModel extends BaseRowModel {
    @ExcelProperty("ID")
    private String id;

    @ExcelProperty("名字")
    private String name;
}
