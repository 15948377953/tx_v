package com.tx.txv_provider.service.common;

import com.tx.txv_common.pojo.TxKeyvalue;
import com.tx.txv_common.pojo.TxKeyvalueExample;
import com.tx.txv_intf.common.TableServiceIntf;
import com.tx.txv_provider.mapper.TxKeyvalueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class TableService implements TableServiceIntf {
    @Autowired
    TxKeyvalueMapper txKeyvalueMapper;
    @Override
    public TxKeyvalue getKeyValue(String key) {
        TxKeyvalueExample example=new TxKeyvalueExample();
        example.createCriteria().andKeyEqualTo(key);
        List<TxKeyvalue> txKeyvalues = txKeyvalueMapper.selectByExample(example);
        if(txKeyvalues.size()>0){
            TxKeyvalue txKeyvalue = txKeyvalues.get(0);
            return txKeyvalue;
        }
        return null;
    }
}
