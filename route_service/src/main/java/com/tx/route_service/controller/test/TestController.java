package com.tx.route_service.controller.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tx.route_service.base.BaseController;
import com.tx.txv_common.utils.DataMap;
import com.tx.txv_intf.test.DubboAnnotation;
import com.tx.txv_intf.test.testInTF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class TestController extends BaseController {
    @Value("${testName}")
    private String name;

//    @Autowired
//    private testInTF testInTF;

    @Reference
    private DubboAnnotation dubboAnnotationTest;


    @RequestMapping("/")
    public String dubboAnnotationTest(){
        return dubboAnnotationTest.dubboAnnotationTest();
    }


//    @RequestMapping("/")
//    public String test(){
//        String testdubbo = testInTF.testdubbo();
//        DataMap data=new DataMap();
//        return testdubbo;
//    }


//    @RequestMapping("/redisTest")
//    public String redisTest(){
//        Object redisTest = testInTF.redisTest("redisTest");
//        return redisTest.toString();
//    }




    public static void main(String args[]){

    }





}
