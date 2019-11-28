package com.tx.route_service.controller.tongxm_v;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tx.txv_intf.tongxm_v.Tx_vAccessIntf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("txv")
public class Tx_vController {

    @Reference
    private Tx_vAccessIntf tx_vAccess;



    @RequestMapping("carouselList")
    public List getcCarouselList(){
        Map param =new HashMap();
        param.put("picType","1");
        return tx_vAccess.getCarouseList(param);
    }

}
