package cn.krislin.order.feignapi.pms;

import cn.krislin.order.domain.CartPromotionItem;
import cn.krislincommon.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
* 订单服务用于调用商品服务锁定库存
*/
@FeignClient(value = "mall-product",path = "/stock")
public interface PmsProductStockFeignApi {


    @RequestMapping("/lockStock")
    CommonResult lockStock(@RequestBody List<CartPromotionItem> cartPromotionItemList);
}
