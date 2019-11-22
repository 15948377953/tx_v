package com.tx.txv_provider.service;

import com.tx.txv_common.factory.TSingletonFactory;
import com.tx.txv_intf.test.testInTF;
import com.tx.txv_provider.utils.RedisAccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestService implements testInTF {
    @Autowired
    RedisAccess redisAccess;

    @Override
    public String testdubbo() {
        return "dubbo test success";
    }

    @Override
    public Object redisTest(String key) {
        return redisAccess.get(key);

    }



}
