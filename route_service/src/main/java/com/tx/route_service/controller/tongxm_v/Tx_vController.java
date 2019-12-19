package com.tx.route_service.controller.tongxm_v;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tx.txv_common.utils.PageBean;
import com.tx.txv_common.utils.TxResponse;
import com.tx.txv_intf.tongxm_v.Tx_vAccessIntf;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Swagger
 * http://127.0.0.1:8330/route_service/swagger-ui.html
 */
@Slf4j
@RestController
@RequestMapping("txv")
@Api("开森一刻接口功能")
public class Tx_vController {

    //dubbo注解@Reference
    @Reference(timeout = 60000)
    private Tx_vAccessIntf tx_vAccess;


    /**
     * 猜你喜欢（分页查询）
     * @return
     */
    @ApiOperation("猜你喜欢")
    @RequestMapping(value="guessUlike",method = RequestMethod.POST)
    @ApiImplicitParam(name ="param",value = "查询参数 currentPage，pageSize" )
    public List guessUlike(@RequestParam Map param) throws Exception {
        return tx_vAccess.guessUlike(param);
    }
    /**
     * 页面初始化
     * @return
     */
    @ApiOperation("页面初始化-查询轮播图/查询热门视频/查询热门小说")
    @RequestMapping(value="init",method = RequestMethod.POST)
    public Map init() throws Exception {
        return tx_vAccess.init();
    }

    /**
     * 查询轮播图
     * @return
     */
    @ApiOperation("查询轮播图,图片表类型为1")
    @RequestMapping(value="carouselList",method = RequestMethod.POST)
    public List getcCarouselList(){
        Map param =new HashMap();
        param.put("picType","1");
        return tx_vAccess.getPictureList(param);
    }

    /**
     *
     * @param param
     * @return
     */
    @ApiOperation("条件查询-支持分页")
    @RequestMapping(value = "queryByParam",method = RequestMethod.POST)
    @ApiImplicitParam(name = "param",value = "查询参数对象,currentPage:当前页码,pageSize:每页展示数",dataType = "Map")
    public Object queryDataByParam(@RequestParam Map param) throws Exception {
        PageBean all = tx_vAccess.queryDataByParam(param);
        TxResponse.success(all);
        return all;
    }


    /**
     *
     * @return
     * http://127.0.0.1:8330/route_service/txv/searchPicById?picId=5
     *
     */
    @ApiOperation("根据图片Id返回输出流")
    @RequestMapping(value = "/searchPicById")
    @ApiImplicitParam(name = "param",value = "查询参数对象",dataType = "Map")
    public Object searchPicById(@RequestParam Map param, HttpServletResponse response){
        String picId = param.get("picId").toString();
        Map sparam =new HashMap();
        sparam.put("picId",picId);
        byte[] pictureByte = tx_vAccess.getPictureByteById(sparam);
        ServletOutputStream outputStream=null;
        try {
            outputStream= response.getOutputStream();
            if(pictureByte!=null&&pictureByte.length>0){
                outputStream.write(pictureByte);
            }
            outputStream.flush();
        }catch (Exception e){

        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }



    /**
     *
     * @return
     * http://127.0.0.1:8330/route_service/txv/searchVideoById?videoId=1
     * 将视频文件转为base64 再返回，会导致前端无法快进视频，因此该方法暂时屏蔽
     *
     */
    @ApiIgnore
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
