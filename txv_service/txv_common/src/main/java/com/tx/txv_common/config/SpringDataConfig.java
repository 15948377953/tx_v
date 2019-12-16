package com.tx.txv_common.config;

import java.util.HashMap;
import java.util.Map;

public class SpringDataConfig {
    private static Map<String,Map<String,String>>dataMap=new HashMap<>();

    public static Map getDataMap(){
        return dataMap;
    }
}
