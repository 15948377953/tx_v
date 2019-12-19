package com.tx.txv_common.utils;


public class TxResponse{
    private Integer respCode;
    private String respDesc;
    private Object respData;
    public TxResponse(){};


    public static TxResponse success(){
        TxResponse tp=new TxResponse();
        tp.setRespCode(200);
        return tp;
    }

    public static TxResponse success(Object src){
        TxResponse tp=new TxResponse();
        tp.setRespCode(200);
        tp.setRespData(src);
        return tp;
    }



    public static TxResponse error(){
        TxResponse tp=new TxResponse();
        tp.setRespCode(400);
        tp.setRespDesc("请求返回错误！");
        return tp;
    }

    public static TxResponse error(String desc){
        TxResponse tp=new TxResponse();
        tp.setRespCode(400);
        tp.setRespDesc(desc);
        return tp;
    }


    public Integer getRespCode() {
        return respCode;
    }

    public void setRespCode(Integer respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public Object getRespData() {
        return respData;
    }

    public void setRespData(Object respData) {
        this.respData = respData;
    }



}