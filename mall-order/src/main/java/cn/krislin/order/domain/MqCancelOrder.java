package cn.krislin.order.domain;

import lombok.Data;

/**
* mq取消订单封装对象
*/
@Data
public class MqCancelOrder {

    private Long orderId;

    private Long memberId;
}
