package com.tx.txv_provider.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
/**
 * pageHelper实例
 *
 * 文档
 * https://pagehelper.github.io/docs/howtouse/
 * @return
 */
@Configuration
public class pageHelperConfig {



    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        //分页属性
        Properties properties =new Properties();
        //该参数对使用 RowBounds 作为分页参数时有效。 当该参数设置为 true 时，会将 RowBounds 中的 offset 参数当成 pageNum 使用，可以用页码和页面大小两个参数进行分页。
        properties.setProperty("offsetAsPageNum","true");
        //该参数对使用 RowBounds 作为分页参数时有效。 当该参数设置为true时，使用 RowBounds 分页会进行 count 查询。
        properties.setProperty("rowBoundsWithCount","true");
        //当该参数设置为 true 时，pageNum<=0 时会查询第一页， pageNum>pages（超过总数时），会查询最后一页。默认false 时，直接根据参数进行查询。
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
