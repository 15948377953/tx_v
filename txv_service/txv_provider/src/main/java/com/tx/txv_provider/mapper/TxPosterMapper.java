package com.tx.txv_provider.mapper;

import com.tx.txv_common.pojo.TxPoster;
import com.tx.txv_common.pojo.TxPosterExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TxPosterMapper {
    int countByExample(TxPosterExample example);

    int deleteByExample(TxPosterExample example);

    int deleteByPrimaryKey(String postId);

    int insert(TxPoster record);

    int insertSelective(TxPoster record);

    List<TxPoster> selectByExampleWithBLOBs(TxPosterExample example);

    List<TxPoster> selectByExample(TxPosterExample example);

    TxPoster selectByPrimaryKey(String postId);

    int updateByExampleSelective(@Param("record") TxPoster record, @Param("example") TxPosterExample example);

    int updateByExampleWithBLOBs(@Param("record") TxPoster record, @Param("example") TxPosterExample example);

    int updateByExample(@Param("record") TxPoster record, @Param("example") TxPosterExample example);

    int updateByPrimaryKeySelective(TxPoster record);

    int updateByPrimaryKeyWithBLOBs(TxPoster record);

    int updateByPrimaryKey(TxPoster record);
}