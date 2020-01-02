package com.tx.txv_provider.service.tongxm_v;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.tx.txv_common.impl.TDataMap;
import com.tx.txv_common.intf.TData;
import com.tx.txv_common.pojo.*;
import com.tx.txv_common.utils.GenerateSearchExample;
import com.tx.txv_common.utils.PageBean;
import com.tx.txv_intf.tongxm_v.Tx_vAccessIntf;
import com.tx.txv_provider.mapper.TxPosterMapper;
import com.tx.txv_provider.mapper.TxVideoMapper;
import com.tx.txv_provider.mapper.TxvMapper;
import com.tx.txv_common.utils.Base64Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.*;

//dubbo 注解
@Service
//spring 注解
@org.springframework.stereotype.Service
public class Tx_vAccessService implements Tx_vAccessIntf {

    private static final Logger logger = LoggerFactory.getLogger(Tx_vAccessService.class);


    @Autowired
    private TxvMapper txvMapper;

    @Autowired
    private TxPosterMapper txPosterMapper;

    @Autowired
    private TxVideoMapper txVideoMapper;
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
        TData initMap=new TDataMap();
        initMap.put("picType","1");
        List<TxPoster> carouseList = this.getPostList(initMap);
        //查询热门视频
        initMap.put("picType","2");
        List<TxPoster> hotVideoList = this.getPostList(initMap);
        //查询热门小说
        initMap.put("picType","3");
        List<TxPoster> hotTextList = this.getPostList(initMap);
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
    public List<TxPoster> getPostList(TData param) {
        logger.info("[Tx_vAccessService]- search PostListList");
        String picType = param.getString("picType");
        TxPosterExample example=new TxPosterExample();
        example.createCriteria().andPostTypeEqualTo(picType);
        List<TxPoster> searchList = txPosterMapper.selectByExample(example);
        return searchList;
    }


    @Override
    public TxPoster getPostById(Map param) {
        TxPosterExample example=new TxPosterExample();
        String picId=param.get("picId").toString();
        return  txPosterMapper.selectByPrimaryKey(picId);
    }

    @Override
    public byte[] getPostByteById(Map param) {
        TxPoster postBean = getPostById(param);
        byte[] bytes = Base64Util.stringBase64ToByte(postBean.getPostData());
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
        String keyWord= StringUtils.isEmpty(param.get("keyWord"))?"":param.get("keyWord").toString();
        Integer currentPage=null;
        Integer pageSize=null;
        if(param.get("currentPage")!=null){
            currentPage = new Integer(param.get("currentPage").toString());
        }
        if(param.get("pageSize")!=null){
            pageSize = new Integer(param.get("pageSize").toString());
        }
        //根据关键字生成TxPosterExample类
        TxPosterExample example = GenerateSearchExample.generateTxPosterExample(keyWord);
        if(currentPage==null||pageSize==null){
            //非分页查询
            PageBean pageBean = new PageBean();
            List<TxPoster> txPosters = txPosterMapper.selectByExample(example);
            pageBean.setItems(txPosters);
            return pageBean;
        }
        //分页查询，开启分页
        PageHelper.startPage(currentPage,pageSize);
        List<TxPoster> txPosters = txPosterMapper.selectByExample(example);
        int totalNum = txPosterMapper.countByExample(example);
        //封装分页对象并返回
        PageBean pageBean = new PageBean(currentPage,pageSize,totalNum);
        pageBean.setItems(txPosters);
        return pageBean;
    }

    /**
     * 猜你喜欢 随机获取5名随机观众
     * @param param
     * @return
     */
    @Override
    public List<TxPoster> guessUlike(Map param) throws Exception {
        TxPosterExample example=new TxPosterExample();
        List<TxPoster> allList = txPosterMapper.selectByExample(example);
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

    /**
     * 查询视频信息
     * @param param
     * @return
     */
    @Override
    public TxVideo getVideoByPostId(JSONObject param) {
        String postId = param.getString("postId");
        if(StringUtils.isEmpty(postId)){
            return null;
        }
        TxVideo videoByPostId = txVideoMapper.getVideoByPostId(postId);
        return videoByPostId;
    }


}
