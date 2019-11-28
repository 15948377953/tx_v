package com.tx.txv_provider.mapper;

import com.tx.txv_common.pojo.CarouseBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TxvMapper {

    public List<CarouseBean> getCarouseList(Map param);

}
