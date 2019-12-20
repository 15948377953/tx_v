package com.tx.txv_common;

import com.tx.txv_common.annotation.KeyValue;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Constant {
    @KeyValue()
    public  static String  RESPONSE_END="RESPONSE_END";
}
