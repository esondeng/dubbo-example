package com.dubbo.example.product.controller;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletResponse;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dubbo.example.product.service.ProductService;
import com.eson.common.core.exception.BusinessException;
import com.eson.common.web.WebResponse;


/**
 * @author dengxiaolin
 * @since 2020/12/25
 */
@RestController
@RequestMapping("/dubbo/")
public class ProductController {

    @DubboReference(timeout = 3000)
    private ProductService productService;

    @Autowired
    private Test test;

    private ThreadPoolExecutor uploadExecutor = new ThreadPoolExecutor(
            1,
            1,
            1,
            TimeUnit.MINUTES,
            new SynchronousQueue<>(),
            new ThreadFactory() {
                private AtomicInteger atomicInteger = new AtomicInteger(1);

                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "thread-test-" + atomicInteger.getAndIncrement());
                }
            },
            new ThreadPoolExecutor.CallerRunsPolicy());


    @RequestMapping("/test")
    public WebResponse<String> test(HttpServletResponse response) {
//        List<TestModel> testModelList1 = new ArrayList<>();
//        TestModel testModel = new TestModel();
//        testModel.setId("1");
//        testModel.setName("test1");
//        testModelList1.add(testModel);
//
//        TestModel testMode_1 = new TestModel();
//        testMode_1.setId("1");
//        testMode_1.setName("test2");
//        testModelList1.add(testMode_1);
//
//        List<TestModel2> testModelList2 = new ArrayList<>();
//        TestModel2 testModel2 = new TestModel2();
//        testModel2.setId("1");
//        testModel2.setAge("12");
//        Map<String, String> dynamic = new HashMap<>();
//        dynamic.put("动态属性", "dynamic");
//        testModel2.setDynamicPropertyMap(dynamic);
//        testModelList2.add(testModel2);
//
//
//        WriteSheetParam<TestModel> sheetWriteParam = new WriteSheetParam<>(
//                "sheet1",
//                Arrays.asList("ID", "名字"),
//                testModelList1);
//        sheetWriteParam.setWriteHandlers(Arrays.asList(new OnceAbsoluteMergeStrategy(1, 2, 0, 0)));
//
//        WriteSheetParam<TestModel2> sheetWriteParam2 = new WriteSheetParam<>();
//        sheetWriteParam2.setSheetName("sheet2");
//        sheetWriteParam2.setDataList(testModelList2);
//        sheetWriteParam2.setHeadList(Arrays.asList("ID", "年龄", "动态属性"));
//
//        List<WriteSheetParam<? extends BaseRowModel>> sheetWriteParams = new ArrayList<>();
//        sheetWriteParams.add(sheetWriteParam);
//        sheetWriteParams.add(sheetWriteParam2);
//
//        ExcelUtils.write(response, sheetWriteParams, "测试");

        test.test();
        return WebResponse.success(productService.sayHello());

    }

}
