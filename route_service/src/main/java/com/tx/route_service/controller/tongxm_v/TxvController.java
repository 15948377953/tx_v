package com.tx.route_service.controller.tongxm_v;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.tx.txv_common.Constant;
import com.tx.txv_common.annotation.KeyValue;
import com.tx.txv_common.annotation.Txv;
import com.tx.txv_common.impl.TDataMap;
import com.tx.txv_common.intf.TData;
import com.tx.txv_common.utils.PageBean;
import com.tx.txv_common.utils.TxResponse;
import com.tx.txv_intf.tongxm_v.Tx_vAccessIntf;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@Api("开森一刻接口功能")
public class TxvController {


    //dubbo注解@Reference
    @Reference(timeout = 60000)
    private Tx_vAccessIntf tx_vAccess;



    /**
     * 猜你喜欢（分页查询）
     * @return
     */
    @ApiOperation("猜你喜欢")
    @Txv()
    @ApiImplicitParam(name ="param",value = "查询参数 currentPage，pageSize" )
    public List guessUlike(JSONObject param) throws Exception {
        return tx_vAccess.guessUlike(param);
    }
    /**
     * 页面初始化
     * @return
     */
    @ApiOperation("页面初始化-查询轮播图/查询热门视频/查询热门小说")
    @Txv()
    public Map init(JSONObject param) throws Exception {
        return tx_vAccess.init();
    }

    /**
     * 查询轮播图
     * @return
     */
    @ApiOperation("查询轮播图,图片表类型为1")
    @Txv()
    public List carouselList(JSONObject paramObj){
        TData param =new TDataMap();
        param.put("picType","1");
        return tx_vAccess.getPostList(param);
    }

    /**
     *
     * @param param
     * @return
     */
    @ApiOperation("条件查询-支持分页")
//    @RequestMapping(value = "queryDataByParam",method = RequestMethod.POST)
    @Txv()
    @ApiImplicitParam(name = "param",value = "查询参数对象,currentPage:当前页码,pageSize:每页展示数",dataType = "Map")
    public Object queryDataByParam(JSONObject param) throws Exception {
        PageBean all = tx_vAccess.queryDataByParam(param);
        return TxResponse.success(all);
    }


    /**
     *
     * @return
     * http://127.0.0.1:8330/route_service/txv/searchPicById?picId=5
     *
     */
    @ApiOperation("根据图片Id返回输出流")
    @Txv()
    @ApiImplicitParam(name = "param",value = "查询参数对象",dataType = "Map")
    public Object searchPicById(JSONObject param){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        String picId = param.get("picId").toString();
        Map sparam =new HashMap();
        sparam.put("picId",picId);
        byte[] pictureByte = tx_vAccess.getPostByteById(sparam);
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
        return Constant.RESPONSE_END;
    }



}
