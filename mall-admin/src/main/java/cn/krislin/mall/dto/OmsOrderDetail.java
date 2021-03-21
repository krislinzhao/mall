package cn.krislin.mall.dto;

import cn.krislin.mbg.model.OmsOrder;
import cn.krislin.mbg.model.OmsOrderItem;
import cn.krislin.mbg.model.OmsOrderOperateHistory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    private List<OmsOrderOperateHistory> historyList;
}
