package cn.krislin.portal.component.trade.alipay.service;

import com.alipay.api.response.MonitorHeartbeatSynResponse;
import cn.krislin.portal.component.trade.alipay.model.builder.AlipayHeartbeatSynRequestBuilder;

/**
 * Created by liuyangkly on 15/10/22.
 */
public interface AlipayMonitorService {

    // 交易保障接口 https://openhome.alipay.com/platform/document.htm#mobileApp-barcodePay-API-heartBeat

    // 可以提供给系统商/pos厂商使用
    public MonitorHeartbeatSynResponse heartbeatSyn(AlipayHeartbeatSynRequestBuilder builder);
}
