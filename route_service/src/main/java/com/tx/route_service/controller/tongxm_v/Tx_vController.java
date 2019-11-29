package com.tx.route_service.controller.tongxm_v;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tx.txv_common.pojo.PictureBean;
import com.tx.txv_intf.tongxm_v.Tx_vAccessIntf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("txv")
public class Tx_vController {

    @Reference(timeout = 60000)
    private Tx_vAccessIntf tx_vAccess;


    /**
     * 查询轮播图
     * @return
     */
    @RequestMapping("carouselList")
    public List getcCarouselList(){
        Map param =new HashMap();
        param.put("picType","1");
        return tx_vAccess.getCarouseList(param);
    }



    /**
     *
     * @return
     * http://127.0.0.1:8330/route_service/txv/searchPicById?picId=5
     *
     */
    @RequestMapping("/searchPicById")
    public Object searchPicById(@RequestParam Map param, HttpServletResponse response){
        String picId = param.get("picId").toString();
        Map sparam =new HashMap();
        sparam.put("picId",picId);
        byte[] pictureByte = tx_vAccess.getPictureByteById(sparam);
        ServletOutputStream outputStream=null;
        try {
            outputStream= response.getOutputStream();
            outputStream.write(pictureByte);
        }catch (Exception e){

        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    /**
     *
     * @return
     * http://127.0.0.1:8330/route_service/txv/searchVideoById?videoId=1
     * 将视频文件转为base64 再返回，会导致前端无法快进视频
     *
     */
    @RequestMapping("/searchVideoById")
    public Object searchVideoById(@RequestParam Map param, HttpServletResponse response){
        String videoId = param.get("videoId").toString();
        Map sparam =new HashMap();
        sparam.put("videoId",videoId);
        byte[] vdeByte = tx_vAccess.getVideoByteById(sparam);
        ServletOutputStream outputStream=null;
        try {
//            response.setHeader("Content-Type", "video/mpeg4");
            outputStream= response.getOutputStream();
            outputStream.write(vdeByte);
        }catch (Exception e){

        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
