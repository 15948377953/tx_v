package com.tx.txv_intf.tongxm_v;

import com.tx.txv_common.intf.TData;
import com.tx.txv_common.pojo.PictureBean;
import com.tx.txv_common.pojo.TxPoster;
import com.tx.txv_common.pojo.VideoBean;
import com.tx.txv_common.utils.PageBean;

import java.util.List;
import java.util.Map;

public interface Tx_vAccessIntf {
    public Map init() throws Exception;
    public List<TxPoster> getPostList(TData param);
    public TxPoster getPostById(Map param);
    public byte[] getPostByteById(Map param);
    public VideoBean getVideoById(Map param);
    public byte[] getVideoByteById(Map param);
    public PageBean queryDataByParam(Map param) throws Exception;
    public List<TxPoster> guessUlike(Map param) throws Exception;

}
