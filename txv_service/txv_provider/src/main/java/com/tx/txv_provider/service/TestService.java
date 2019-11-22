package com.tx.txv_provider.service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.tx.txv_intf.test.testInTF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestService implements testInTF {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Override
    public String testdubbo() {
        return "dubbo test success";
    }

    @Override
    public Object redisTest(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }



}
