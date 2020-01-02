package com.tx.route_service.config;

import com.alibaba.fastjson.JSONObject;
import com.tx.route_service.utils.ApplicationContextUtil;
import com.tx.txv_common.Constant;
import com.tx.txv_common.config.SpringDataConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
@Slf4j
public class TxvServlet extends HttpServlet{
    // http://127.0.0.1:8330/route_service/Txv/txvAnno

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JSONObject json=new JSONObject();
        Map<String, String[]> parameterMap = req.getParameterMap();
        if(parameterMap!=null&&parameterMap.size()>0) {
            for (Map.Entry entry : parameterMap.entrySet()) {
                String[] value = (String[]) entry.getValue();
                json.put(entry.getKey().toString(), value[0]);
            }
        }

        this.matchMethod(this.matchUri(req),json,resp);

    }

    //重写post方法
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String requestParam = req.getParameter("requestParam");
        JSONObject json=new JSONObject();
        if(!StringUtils.isEmpty(requestParam)&&!"undefined".equals(requestParam)){
            json.putAll(JSONObject.parseObject(requestParam));
        }
        Map<String, String[]> parameterMap = req.getParameterMap();
        if(parameterMap!=null&&parameterMap.size()>0){
            for(Map.Entry entry:parameterMap.entrySet()){
                String[] value =(String[]) entry.getValue();
                json.put(entry.getKey().toString(),value[0]);
            }

        }
        this.matchMethod(this.matchUri(req),json,resp);
    }



    public String matchUri(HttpServletRequest req){
        String requestURI = req.getRequestURI();
        int index = requestURI.indexOf("Txv");
        String uri =index==-1?"": requestURI.substring(index + 4);
        return uri;
    }

    public void matchMethod(String uri,JSONObject json,HttpServletResponse resp){
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
                this.invokeLocal(className, method,json,resp);

            }

        }
    }

    public void invokeLocal(String className,String method,JSONObject param,HttpServletResponse resp){
        try {
            Class<?> aClass = Class.forName(className);
            //从容器中获取实例
            Method declaredMethod = aClass.getDeclaredMethod(method, JSONObject.class);
            Object bean = ApplicationContextUtil.getApplicationContext().getBean(aClass);
            Object[] invokeParam=new Object[]{param};
            Object result = declaredMethod.invoke(bean, invokeParam);
            if(!StringUtils.isEmpty(String.valueOf(result))&& Constant.RESPONSE_END.equals(String.valueOf(result))){
                //如果请求函数已经完成了响应则不再走响应数据后续流程
                return;
            }
            log.info("response result:"+result);
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/json; charset=utf-8");
            resp.setHeader("Access-Control-Allow-Origin", "*");
            PrintWriter writer = resp.getWriter();
            writer.write(JSONObject.toJSONString(result));
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e1) {
            log.error("error-{}",e1);
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
