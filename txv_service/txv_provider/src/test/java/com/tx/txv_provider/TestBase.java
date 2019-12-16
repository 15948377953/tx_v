package com.tx.txv_provider;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.tx.txv_common.pojo.PictureBean;
import com.tx.txv_common.utils.PageBean;
import com.tx.txv_provider.mapper.TxvMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestBase {

    @Autowired
    private TxvMapper txvMapper;


    @Test
    public void test1(){
        Integer pageNum=3;
        Integer pageSize=4;
        Map param =new HashMap();
        PageHelper.startPage(pageNum,pageSize);
        List<PictureBean> all = txvMapper.getAll(param);
        PageBean pageBean = new PageBean(pageNum, pageSize,all.size());
        log.error(all.size()+"");
    }


    @Test
    public void test2(){
        String p="{\"name\":\"tong\",\"age\":\"23\"}";
        JSONObject ob1=new JSONObject();
        ob1.put("name","tong");
        ob1.put("age","23");
        JSONObject ob2=new JSONObject();
        ob2.put("name","wei");
        ob2.put("age","24");
        System.out.println(JSONObject.toJSONString(ob1));
    }





}
