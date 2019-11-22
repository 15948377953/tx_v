package com.tx.txv_common.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 单例工厂
 * 本质还是从一个缓存中获取同一个，如果缓存中没有，则创建一个实例
 * 下次再获取的时候，直接从缓存中获取
 */
public class TSingletonFactory {
    //单例缓存
    private static Map instanceCache=new HashMap();
    //对象锁
    private static Object lock =new Object();

    /**
     *获取单例对象方法
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T>T getInstance(Class<T> tClass){
        T retObj =null;
        if(instanceCache.containsKey(tClass.getName())){
            //缓存中存在该class 实例对象，则直接返回
            return (T) instanceCache.get(tClass.getName());
        }
            synchronized (lock){
                retObj =buildInstance(tClass);
                //将创建的实例放入缓存中
                instanceCache.put(tClass.getName(),retObj);
            }

        return retObj;
    }


    /**
     * 创建实例对象
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T>T buildInstance(Class<T> tClass){
        T t=null;
        Method method=null;
        try {
            //class 中是否含有获取单例方法
            method = tClass.getDeclaredMethod("getInstance");
            t = (T) method.invoke(t);
        }  catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
        }catch (NoSuchMethodException e) {
            //没有获取单例的方法
            try {
                t = tClass.newInstance();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        return  t;
    }

}
