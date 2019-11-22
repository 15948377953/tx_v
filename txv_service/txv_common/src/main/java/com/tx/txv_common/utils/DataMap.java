package com.tx.txv_common.utils;

import java.util.HashMap;

public class DataMap extends HashMap {


    public String getString(String key){
        return super.get(key).toString();
    }
}
