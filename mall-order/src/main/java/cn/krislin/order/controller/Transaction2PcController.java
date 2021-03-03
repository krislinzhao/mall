package cn.krislin.order.controller;

import cn.krislin.order.service.impl.Transaction2PcServiceImpl;
import cn.krislincommon.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：杨过
 * @date ：Created in 2020/3/19
 * @version: V1.0
 * @slogan: 天下风云出我辈，一入代码岁月催
 * @description:
 **/
@RestController
public class Transaction2PcController {
    @Autowired
    private Transaction2PcServiceImpl service;

    @GetMapping("/sharding/2pc_transaction")
    public CommonResult insertIn2Pc(){
        //TransactionTypeHolder.set(TransactionType.XA);
        return service.insertOrder();
    }

    @GetMapping("/sharding/select")
    public CommonResult select(@RequestHeader("memberId") Long memberId){
        return service.selectOrder(memberId);
    }
}
