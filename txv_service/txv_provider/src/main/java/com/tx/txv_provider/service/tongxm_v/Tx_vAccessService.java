package com.tx.txv_provider.service.tongxm_v;

import com.alibaba.dubbo.config.annotation.Service;
import com.tx.txv_common.pojo.PictureBean;
import com.tx.txv_common.pojo.VideoBean;
import com.tx.txv_intf.tongxm_v.Tx_vAccessIntf;
import com.tx.txv_provider.mapper.TxvMapper;
import com.tx.txv_common.utils.Base64Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
@org.springframework.stereotype.Service
@Slf4j
public class Tx_vAccessService implements Tx_vAccessIntf {
    @Autowired
    private TxvMapper txvMapper;
    public List<PictureBean> getCarouseList(Map param) {
        log.info("[Tx_vAccessService]- search carouseList");
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


}
