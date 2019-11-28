package com.tx.txv_provider.service.tongxm_v;

import com.alibaba.dubbo.config.annotation.Service;
import com.tx.txv_common.pojo.CarouseBean;
import com.tx.txv_intf.tongxm_v.Tx_vAccessIntf;
import com.tx.txv_provider.mapper.TxvMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@org.springframework.stereotype.Service
@Slf4j
public class Tx_vAccessService implements Tx_vAccessIntf {
    @Autowired
    private TxvMapper txvMapper;
    public List<CarouseBean> getCarouseList(Map param) {
        log.info("[Tx_vAccessService]- search carouseList");
        return txvMapper.getCarouseList(param);
    }


}
