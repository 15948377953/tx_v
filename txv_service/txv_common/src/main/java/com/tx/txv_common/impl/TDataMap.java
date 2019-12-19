package com.tx.txv_common.impl;

import com.tx.txv_common.intf.TData;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

public class TDataMap extends HashMap implements TData {

    @Override
    public String getString(String var1) {
        return super.containsKey("var1")?null: super.get(var1).toString();
    }

    @Override
    public double getDouble(String var1) {
        return  super.containsKey("var1")?null: Double.valueOf(this.getString(var1));
    }

    @Override
    public boolean getBoolean(String var1) {
        return super.containsKey("var1")?null:Boolean.parseBoolean(this.getString(var1));
    }

    @Override
    public int getInt(String var1) {
        return super.containsKey("var1")?null:Integer.parseInt(this.getString(var1));
    }

    @Override
    public long getLong(String var1) {
        return super.containsKey("var1")?null:Long.parseLong(this.getString(var1));
    }

    @Override
    public TData getTData(String var1) {
        return super.containsKey("var1")?null:(TData)super.get(var1);
    }

    @Override
    public List<TData> getDataList(String var1) {
        return super.containsKey("var1")?null:(List)super.get(var1);
    }


}
