package com.tx.route_service;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.tx.route_service.config.TxvServlet;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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
 *      注解模式：
 *      1 启动类添加 @EnableDubboConfiguration 注解
 *      2 服务消费方用@Reference注解 引用接口
 *      3 服务提供方用@Service(dubbo包下service注解，用于暴露服务于注册中心) 再用service(springframework下的注解)在容器中注册对象
 *
 *
 */
@SpringBootApplication()
//@ImportResource("classpath:dubbo-consumer.xml")
@EnableDubboConfiguration//dubbo 注解方式
public class RouteServiceApplication extends SpringBootServletInitializer {
    public static ApplicationContext context;
    private final String EXPOSE_HEADER = "DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Content-Range,Range,Token";


    /**
     * 重写configure方法,实现springboot工程以外部tomcat形式启动
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        SpringApplicationBuilder sources = builder.sources(RouteServiceApplication.class);
        return sources;
    }


    /**
     * 注册servlet 请求映射
     * @return
     */
//    @Bean
//    protected ServletRegistrationBean registrationBean(){
//        return new ServletRegistrationBean(new TxvServlet(),"/Txv/*");
//
//    }

    /**
     * 创建跨域配置项
     * @return
     */
    private CorsConfiguration buildCorsConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addExposedHeader(EXPOSE_HEADER);
        return corsConfiguration;
    }

    /**
     * 跨域是实例
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildCorsConfig());
        return new CorsFilter(source);
    }


}
