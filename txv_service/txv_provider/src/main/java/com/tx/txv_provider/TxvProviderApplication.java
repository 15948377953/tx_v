package com.tx.txv_provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@ImportResource("classpath:dubbo-provider.xml")//dubbo XML方式
@EnableDubboConfiguration//dubbo 注解方式
public class TxvProviderApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TxvProviderApplication.class);
    }

}
