package cn.krislin.order.domain;

import cn.krislin.mbg.model.OmsOrder;
import cn.krislin.mbg.model.OmsOrderItem;
import lombok.Data;

import java.util.Date;

@Data
public class OrderMessage {

    private OmsOrder order;

    private OmsOrderItem orderItem;

    //秒杀活动记录ID
    private Long flashPromotionRelationId;

    //限购数量
    private Integer flashPromotionLimit;
    /*
     * 秒杀活动结束日期
     */
    private Date flashPromotionEndDate;
}
