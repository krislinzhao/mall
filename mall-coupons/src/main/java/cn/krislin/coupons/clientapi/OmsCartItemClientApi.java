package cn.krislin.coupons.clientapi;

import cn.krislin.coupons.clientapi.interceptor.config.FeignConfig;
import cn.krislin.coupons.domain.CartPromotionItem;
import cn.krislincommon.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
* 远程调用订单中心购物车详细客户端
*/
@FeignClient(name = "mall-order",configuration = FeignConfig.class)
public interface OmsCartItemClientApi {

    @RequestMapping(value = "/cart/list/promotion", method = RequestMethod.GET)
    @ResponseBody
    CommonResult<List<CartPromotionItem>> listPromotionByMemberId();

}
