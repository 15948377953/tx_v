package com.tx.txv_provider.service.tongxm_v;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.tx.txv_common.pojo.PictureBean;
import com.tx.txv_common.pojo.VideoBean;
import com.tx.txv_common.utils.PageBean;
import com.tx.txv_intf.tongxm_v.Tx_vAccessIntf;
import com.tx.txv_provider.mapper.TxvMapper;
import com.tx.txv_common.utils.Base64Util;
import com.tx.txv_provider.utils.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//dubbo 注解
@Service
//spring 注解
@org.springframework.stereotype.Service
public class Tx_vAccessService implements Tx_vAccessIntf {

    private static final Logger logger = LoggerFactory.getLogger(Tx_vAccessService.class);


    @Autowired
    private TxvMapper txvMapper;

    /**
     * 首页初始化所需图片数据
     * @param param
     * @return
     */
    @Override
    public Map init() {
        logger.info("------");
        Map returnMap=new HashMap();
        //查询轮播图
        Map initMap=new HashMap();
        initMap.put("picType","1");
        List<PictureBean> carouseList = this.getPictureList(initMap);
        //查询热门视频
        initMap.put("picType","2");
        List<PictureBean> hotVideoList = this.getPictureList(initMap);
        //查询热门小说
        initMap.put("picType","3");
        List<PictureBean> hotTextList = this.getPictureList(initMap);
        returnMap.put("carouseList",carouseList);
        returnMap.put("hotVideoList",hotVideoList);
        returnMap.put("hotTextList",hotTextList);
        return returnMap;
    }

    /**
     * 根据图片类型查询图片列表
     * @param param
     * @return
     */
    public List<PictureBean> getPictureList(Map param) {
        logger.info("[Tx_vAccessService]- search pictureList");
        List<PictureBean> carouseList = txvMapper.getCarouseList(param);
        return carouseList;
    }


    @Override
    public PictureBean getPictureById(Map param) {
        return txvMapper.getPictureById(param);
    }

    @Override
    public byte[] getPictureByteById(Map param) {
        PictureBean picBean = getPictureById(param);
        byte[] bytes = Base64Util.stringBase64ToByte(picBean.getPicData());

        return bytes;
    }

    @Override
    public VideoBean getVideoById(Map param) {
        return txvMapper.getVideoById(param);
    }

    @Override
    public byte[] getVideoByteById(Map param) {
        VideoBean videoById = getVideoById(param);
        byte[] bytes = Base64Util.stringBase64ToByte(videoById.getVideoData());
        return bytes;
    }



    @Override
    public PageBean getAll(Map param) {
        Integer pageNum=0;
        Integer pageSize=3;
        if(param.get("pageNum")!=null){
            pageNum = new Integer(param.get("pageNum").toString());
        }
        if(param.get("pageSize")!=null){
            pageSize = new Integer(param.get("pageSize").toString());
        }
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        List all = txvMapper.getAll(param);
        PageBean pageBean = new PageBean(pageNum, pageSize,all.size());
        pageBean.setItems(all);
        return pageBean;
    }


}
