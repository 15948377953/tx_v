package com.tx.txv_intf.tongxm_v;

import com.tx.txv_common.pojo.PictureBean;
import com.tx.txv_common.pojo.VideoBean;
import com.tx.txv_common.utils.PageBean;

import java.util.List;
import java.util.Map;

public interface Tx_vAccessIntf {
    public Map init();
    public List<PictureBean> getPictureList(Map param);
    public PictureBean getPictureById(Map param);
    public byte[] getPictureByteById(Map param);
    public VideoBean getVideoById(Map param);
    public byte[] getVideoByteById(Map param);
    public PageBean getAll(Map param);

}
