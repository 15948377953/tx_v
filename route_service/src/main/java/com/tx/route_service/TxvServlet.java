package com.tx.route_service;

import com.alibaba.fastjson.JSONObject;
import com.tx.txv_common.config.SpringDataConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
@Slf4j
public class TxvServlet extends HttpServlet{
    // http://127.0.0.1:8330/route_service/Txv/txvAnno

    //重写post方法
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        int index = requestURI.indexOf("Txv");
        String uri =index==-1?"": requestURI.substring(index + 4);
        //获取请求参数
        String requestParam = req.getParameter("requestParam");
        Map<String, String[]> parameterMap = req.getParameterMap();
        JSONObject json=new JSONObject();
        if(!StringUtils.isEmpty(requestParam)){
            json.putAll(JSONObject.parseObject(requestParam));
        }


        Map<String,Map<String,String>> dataMap = SpringDataConfig.getDataMap();
        if(dataMap==null){
            log.error("{} request Method is not found",uri);
            return;
        }
        for(Map.Entry entry:dataMap.entrySet()){
            String key = entry.getKey().toString();
            String[] split = key.split("#");
            String className=split[0];
            String method=split[1];
            Map annotationMap =(Map)entry.getValue();
            if(!StringUtils.isEmpty(uri)&&!StringUtils.isEmpty(annotationMap.get("name"))&&
                    annotationMap.get("name").toString().equals(uri)){
                this.invokeLocal(className, method,json);

            }

        }


    }



    public void invokeLocal(String className,String method,JSONObject param){
        try {
            Class<?> aClass = Class.forName(className);
            //从容器中获取实例
            Method declaredMethod = aClass.getDeclaredMethod(method, JSONObject.class);
            Object o = aClass.newInstance();
            Object[] invokeParam=new Object[]{param};
            declaredMethod.invoke(o,invokeParam);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
