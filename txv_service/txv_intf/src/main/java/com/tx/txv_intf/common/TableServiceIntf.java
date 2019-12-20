package com.tx.txv_intf.common;

import com.tx.txv_common.pojo.TxKeyvalue;

public interface TableServiceIntf {
    public TxKeyvalue getKeyValue(String key);
}
