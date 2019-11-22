package com.tx.route_service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/**
 *  项目部署在外部tomcat(不使用springboot内嵌tomcat)
 *  1：pom 中 将《spring-boot-starter-tomcat》依赖作用域改为provided
 *  2：启动类 继承 SpringBootServletInitializer 并重写SpringApplicationBuilder方法即可
 */
@SpringBootApplication()
@ImportResource("classpath:dubbo-consumer.xml")
public class RouteServiceApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RouteServiceApplication.class);
    }


}
