package cn.krislin.coupons.clientapi;


import cn.krislin.coupons.clientapi.interceptor.config.FeignConfig;
import cn.krislin.mbg.model.UmsMember;
import cn.krislincommon.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* Feign远程调用用户服务接口
*/
@FeignClient(name = "mall-member", configuration = FeignConfig.class)
public interface UmsMemberClientApi {

    @RequestMapping(value = "/getCurrentMember", method = RequestMethod.GET)
    @ResponseBody
    CommonResult<UmsMember> getCurrentMember();
}
