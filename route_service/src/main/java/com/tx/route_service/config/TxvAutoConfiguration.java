package com.tx.route_service.config;

import com.tx.txv_common.annotation.Txv;
import com.tx.txv_common.config.SpringDataConfig;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 1.BeanPostProcessor
 * postProcessBeforeInitialization：在对象创建实例并且完成依赖注入之后，init初始化之前自动调用该方法
 * postProcessAfterInitialization：在对象创建实例并且完成依赖注入之后，init初始化之后自动调用该方法
 * BeanName:对象在容器中注册的标识!!!!!!!
 * 方法的返回不能为NULL，否则无法在spring容器中注册
 *
 *
 * 2.SmartInitializingSingleton中只有一个接口afterSingletonsInstantiated()，
 * 其作用是是 在spring容器管理的所有单例对象（非懒加载对象）初始化完成之后调用的回调接口。
 */
@Component
public class TxvAutoConfiguration implements BeanPostProcessor, SmartInitializingSingleton {
    /**
     * 在对象创建实例并且完成依赖注入之后，init初始化之前自动调用该方法
     * @param bean
     * @param BeanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String BeanName) throws BeansException {
        Class<?> aClass = AopProxyUtils.ultimateTargetClass(bean);
        //获取被代理对象的所有方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        if(declaredMethods.length>0){
            for(Method method:declaredMethods){
                //@Txv 注解判断
                setTxvAnnotation(method,aClass);
            }
        }



        return bean;
    }

    /**
     * 在对象创建实例并且完成依赖注入之后，init初始化之后自动调用该方法
     * @param bean
     * @param BeanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String BeanName) throws BeansException {
        return bean;
    }



    /**
     * 在spring容器管理的所有单例对象（非懒加载对象）初始化完成之后调用的回调接口。
     */
    @Override
    public void afterSingletonsInstantiated() {

    }


    public void setTxvAnnotation(Method method,Class<?> aClass){
        Txv annotation = method.getAnnotation(Txv.class);
        if(annotation!=null){
            Map<String,String> annotationMap=new HashMap<>();
            String uri=StringUtils.isEmpty(annotation.name())? method.getName():annotation.name().substring((annotation.name().indexOf("/")+1));
            annotationMap.put("name",uri);
            annotationMap.put("value", StringUtils.isEmpty(annotation.value())?"":annotation.value());
            //注解对应的方法名
            annotationMap.put("method", method.getName());
            SpringDataConfig.getDataMap().put(aClass.getName()+"#"+method.getName(),annotationMap);
        }
    }
}
