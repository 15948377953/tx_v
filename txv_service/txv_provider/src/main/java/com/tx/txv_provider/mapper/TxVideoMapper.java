package com.tx.txv_provider.mapper;

import com.tx.txv_common.pojo.PictureBean;
import com.tx.txv_common.pojo.TxVideo;
import com.tx.txv_common.pojo.VideoBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TxVideoMapper {
    TxVideo getVideoByPostId(String postId);
}
