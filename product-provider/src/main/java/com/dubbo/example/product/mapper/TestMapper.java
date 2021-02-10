package com.dubbo.example.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.dubbo.example.product.domain.Test;


@Mapper
public interface TestMapper {
    List<Test> getAll();

    Test getById(Integer id);

    int update(Test record);

    int updateSelective(Test record);

    int deleteById(Integer id);

    int insert(Test record);

    int batchInsert(@Param("items") List<Test> items);
}