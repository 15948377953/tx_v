package com.tx.txv_common.intf;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface TData extends Map , Serializable {
    String getString(String var1);

    double getDouble(String var1);

    boolean getBoolean(String var1);

    int getInt(String var1);

    long getLong(String var1);

    TData getTData(String var1);

    List<TData> getDataList(String var1);


}
