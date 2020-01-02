package com.tx.txv_provider.mapper;

import com.tx.txv_common.pojo.TxKeyvalue;
import com.tx.txv_common.pojo.TxKeyvalueExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TxKeyvalueMapper {
    int countByExample(TxKeyvalueExample example);

    int deleteByExample(TxKeyvalueExample example);


    int insert(TxKeyvalue record);

    int insertSelective(TxKeyvalue record);

    List<TxKeyvalue> selectByExample(TxKeyvalueExample example);


    int updateByExampleSelective(@Param("record") TxKeyvalue record, @Param("example") TxKeyvalueExample example);

    int updateByExample(@Param("record") TxKeyvalue record, @Param("example") TxKeyvalueExample example);

    int updateByPrimaryKeySelective(TxKeyvalue record);

    int updateByPrimaryKey(TxKeyvalue record);
}