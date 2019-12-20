package com.tx.route_service.controller.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.tx.route_service.base.BaseController;
import com.tx.txv_common.annotation.Txv;
import com.tx.txv_common.utils.DataMap;
import com.tx.txv_intf.test.DubboAnnotation;
import com.tx.txv_intf.test.testInTF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Slf4j
@RestController
public class TestController extends BaseController {
    @Value("${testName}")
    private String name;

//    @Autowired
//    private testInTF testInTF;

    @Reference
    private DubboAnnotation dubboAnnotationTest;


    @Txv()
    public String testTxv(JSONObject paramJSON){
        String name = paramJSON.getString("name");
        String age = paramJSON.getString("age");
        System.out.println(name+"-----"+age);
        String result = dubboAnnotationTest.dubboAnnotationTest();
        return result;
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



}
