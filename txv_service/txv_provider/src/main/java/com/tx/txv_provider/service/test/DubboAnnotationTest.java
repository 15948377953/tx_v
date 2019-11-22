package com.tx.txv_provider.service.test;

import com.alibaba.dubbo.config.annotation.Service;
import com.tx.txv_intf.test.DubboAnnotation;
@org.springframework.stereotype.Service //这是springframework下的注解，用于在spring容器中注册实例
@Service//非常重要！！！！！！！！！！这是dubbo 包下的注解，用于在注册中心注册服务
public class DubboAnnotationTest implements DubboAnnotation {

    @Override
    public String dubboAnnotationTest() {
        return "dubboAnnotationTest success!!!!";
    }
}
