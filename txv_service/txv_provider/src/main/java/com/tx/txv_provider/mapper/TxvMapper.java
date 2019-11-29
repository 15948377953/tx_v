package com.tx.txv_provider.mapper;

import com.tx.txv_common.pojo.PictureBean;
import com.tx.txv_common.pojo.VideoBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TxvMapper {

    public List<PictureBean> getCarouseList(Map param);
    public PictureBean getPictureById(Map param);
    public VideoBean getVideoById(Map param);

}
