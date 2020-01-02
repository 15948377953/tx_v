package com.tx.route_service.config;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tx.txv_common.annotation.KeyValue;
import com.tx.txv_common.annotation.Txv;
import com.tx.txv_common.config.SpringDataConfig;
import com.tx.txv_common.pojo.TxKeyvalue;
import com.tx.txv_common.utils.CommonUtils;
import com.tx.txv_intf.common.TableServiceIntf;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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
public class AnnotationAutoConfiguration implements BeanPostProcessor, SmartInitializingSingleton {

    /**
     * 在对象创建实例并且完成依赖注入之后，init初始化之前自动调用该方法
     * @param bean
     * @param BeanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String BeanName) throws BeansException {
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
        Class<?> aClass = AopProxyUtils.ultimateTargetClass(bean);
        //@Txv 注解判断
        setTxvAnnotation(aClass);
        //@KeyValue 注解判断
//        setKeyValue(aClass,bean);
        return bean;
    }



    /**
     * 在spring容器管理的所有单例对象（非懒加载对象）初始化完成之后调用的回调接口。
     */
    @Override
    public void afterSingletonsInstantiated() {

    }


    public void setKeyValue(Class<?> aClass,Object bean) {
        //Constant在common模块！！！！！
        Field[] declaredFields = aClass.getDeclaredFields();
        for(Field field:declaredFields){
            KeyValue annotation = field.getAnnotation(KeyValue.class);
            if(annotation!=null){
                String keyName=field.getName();
                if(!StringUtils.isEmpty(annotation.key())){
                    keyName=annotation.key();
                }
                //查询tx_keyVlue表
//                TxKeyvalue keyValue = tableServiceIntf.getKeyValue(keyName);
                String value="";
//                if(keyValue!=null){
//                    value=keyValue.getValue();
//                }
                boolean isStatic = Modifier.isStatic(field.getModifiers());
                if(isStatic){
                    //TODO
                    try {
                        field.set(bean,value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                //反射赋值
                String methodName ="set"+ CommonUtils.toUpperCaseFirstOne(field.getName());
                Method declaredMethod = null;
                try {
                    declaredMethod = aClass.getDeclaredMethod(methodName,String.class);
                    declaredMethod.invoke(bean,value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }

        }



    }

    public void setTxvAnnotation(Class<?> aClass){
        //获取被代理对象的所有方法
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for(Method method:declaredMethods){
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
}
