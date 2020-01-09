package com.tx.txv_common.utils;



import lombok.extern.slf4j.Slf4j;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import java.io.*;

@Slf4j
public class Base64Util {

    public static void main(String args[]){
        File file =new File("G:\\testVideo.mp4");
        String s = base64EncodetoString(file);
    }

    /**
     * 文件对象转为Base64编码
     * @param file
     * @return
     */
    public static String base64EncodetoString(File file)  {
        String ret="";
        InputStream stream=null;
        byte[] by =null;
        try {
            stream= new FileInputStream(file);
            by=new byte[stream.available()];
            stream.read(by);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(by!=null){
            Encoder be = Base64.getEncoder();
            ret = be.encodeToString(by);

        }
        return ret;

    }

    /**
     *
     * @param base64Vlaue
     * @return
     */
    public static  byte[] stringBase64ToByte(String base64Vlaue){
        String value = null;
        Decoder decoder =Base64.getDecoder();
        byte[] bytes=null;
        try {
            value = new String(base64Vlaue.getBytes(), "UTF-8");
            bytes= decoder.decode(value);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
        }

        return bytes;

    }


    /**
     * base64 生成图片
     * @param base64Value
     * @param imgFilePath
     * @return
     */
    public static boolean GenerateImage(String base64Value, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
        if (base64Value == null) // 图像数据为空
            return false;
        Decoder decoder = Base64.getDecoder();
        OutputStream out =null;
        try {
            // Base64解码
            byte[] bytes = decoder.decode(base64Value);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            out= new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();

            return true;
        } catch (Exception e) {
            return false;
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
