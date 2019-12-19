package com.tx.txv_common.utils;

import com.tx.txv_common.pojo.BaseExample;
import com.tx.txv_common.pojo.TxPosterExample;
import org.springframework.util.StringUtils;

/**
 *
 */
public class GenerateSearchExample {


    /**
     * 根据关键字生成TxPosterExample类
     * @param keyWord
     * @return
     */
    public static TxPosterExample generateTxPosterExample(String keyWord){
        TxPosterExample example=new TxPosterExample();
        if(!StringUtils.isEmpty(keyWord)){
            keyWord="%"+keyWord+"%";
            example.createCriteria().andPostNameLike(keyWord);
            example.or(example.createCriteria().andPostDescLike(keyWord));
        }
        return example;

    }
}
