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

/**
 * springboot 集成dubbo
 * 1 :添加依赖
 *         <dependency>
 *             <groupId>com.alibaba.spring.boot</groupId>
 *             <artifactId>dubbo-spring-boot-starter</artifactId>
 *             <version>2.0.0</version>
 *         </dependency>
 *         <!--zookeeper依赖 -->
 *         <dependency>
 *             <groupId>org.apache.zookeeper</groupId>
 *             <artifactId>zookeeper</artifactId>
 *             <version>3.4.8</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>com.101tec</groupId>
 *             <artifactId>zkclient</artifactId>
 *             <version>0.10</version>
 *         </dependency>
 *
 *      2：启动类加上引用dubbo 配置文件（@ImportResource 相当于将文件作为spring中的applicationContext.xml 一部分）
 *
 *
 */
@SpringBootApplication()
@ImportResource("classpath:dubbo-consumer.xml")
public class RouteServiceApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RouteServiceApplication.class);
    }


}
