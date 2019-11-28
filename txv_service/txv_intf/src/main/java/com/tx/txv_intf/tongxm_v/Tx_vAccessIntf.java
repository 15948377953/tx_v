package com.tx.txv_intf.tongxm_v;

import com.tx.txv_common.pojo.CarouseBean;

import java.util.List;
import java.util.Map;

public interface Tx_vAccessIntf {
    public List<CarouseBean> getCarouseList(Map param);

}
