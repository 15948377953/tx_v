package com.tx.txv_provider.mapper;

import com.tx.txv_common.pojo.TxPic;
import com.tx.txv_common.pojo.TxPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TxPicMapper {
    int countByExample(TxPicExample example);

    int deleteByExample(TxPicExample example);

    int deleteByPrimaryKey(String picId);

    int insert(TxPic record);

    int insertSelective(TxPic record);

    List<TxPic> selectByExampleWithBLOBs(TxPicExample example);

    List<TxPic> selectByExample(TxPicExample example);

    TxPic selectByPrimaryKey(String picId);

    int updateByExampleSelective(@Param("record") TxPic record, @Param("example") TxPicExample example);

    int updateByExampleWithBLOBs(@Param("record") TxPic record, @Param("example") TxPicExample example);

    int updateByExample(@Param("record") TxPic record, @Param("example") TxPicExample example);

    int updateByPrimaryKeySelective(TxPic record);

    int updateByPrimaryKeyWithBLOBs(TxPic record);

    int updateByPrimaryKey(TxPic record);
}