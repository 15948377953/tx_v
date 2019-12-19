package com.tx.txv_provider;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.tx.txv_common.pojo.PictureBean;
import com.tx.txv_common.utils.PageBean;
import com.tx.txv_intf.tongxm_v.Tx_vAccessIntf;
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

    @Autowired()
    private Tx_vAccessIntf tx_vAccess;

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
    public void test2() throws Exception {
        Map param=new HashMap();
        param.put("keyWord","菜");
        param.put("currentPage","1");
        param.put("pageSize","2");
        PageBean all = tx_vAccess.queryDataByParam(param);
    }





}
