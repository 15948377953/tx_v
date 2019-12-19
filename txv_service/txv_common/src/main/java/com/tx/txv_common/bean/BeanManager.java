package com.tx.txv_common.bean;

import java.util.HashMap;
import java.util.Map;

public class BeanManager {
    private static Map beanMap=new HashMap<>();




    public static Map getBeanMap(){
        return BeanManager.beanMap;
    }

    public static  <Type> Type getBean(Class clas) throws IllegalAccessException, InstantiationException {
        if(BeanManager.beanMap.containsKey(clas.getName())){
            return (Type) BeanManager.getBeanMap().get(clas.getName());
        }
        return(Type)clas.newInstance();
    }
}
