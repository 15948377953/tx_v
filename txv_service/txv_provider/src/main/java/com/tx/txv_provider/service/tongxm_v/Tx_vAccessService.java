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

import java.util.*;

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
    public Map init() throws Exception {
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
        //猜你喜欢
        initMap.remove("picType");
        //设置分页参数
        initMap.put("currentPage","1");
        initMap.put("pageSize","5");
        PageBean pageBean = this.queryDataByParam(initMap);
        returnMap.put("carouseList",carouseList);
        returnMap.put("hotVideoList",hotVideoList);
        returnMap.put("hotTextList",hotTextList);
        returnMap.put("guessLike",pageBean.getItems());
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
    public PageBean queryDataByParam(Map param) throws Exception {
        Integer currentPage=null;
        Integer pageSize=null;
        if(param.get("currentPage")!=null){
            currentPage = new Integer(param.get("currentPage").toString());
        }
        if(param.get("pageSize")!=null){
            pageSize = new Integer(param.get("pageSize").toString());
        }
        if(currentPage==null||pageSize==null){
            throw new Exception("缺少分页查询参数");
        }
        //开启分页
        PageHelper.startPage(currentPage,pageSize);
        List all = txvMapper.getAll(param);
        PageBean pageBean = new PageBean(currentPage, pageSize,all.size());
        pageBean.setItems(all);
        return pageBean;
    }

    /**
     * 猜你喜欢 随机获取5名随机观众
     * @param param
     * @return
     */
    @Override
    public List<PictureBean> guessUlike(Map param) throws Exception {
        List allList = txvMapper.getAll(param);
        List result=new ArrayList();
        int size = allList.size()-1;
        Set indexSet=new HashSet();
        for(int i=0;i<size;i++){
            int index = new Random().nextInt(size);
            if(!indexSet.contains(index)){
                result.add(allList.get(index));
                indexSet.add(index);
                if(indexSet.size()==5){
                    break;
                }
            }
        }
        return result;
    }



}
