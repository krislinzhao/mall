package cn.krislin.mall.dao;

import cn.krislin.mall.dto.OmsOrderDeliveryParam;
import cn.krislin.mall.dto.OmsOrderDetail;
import cn.krislin.mall.dto.OmsOrderQueryParam;
import cn.krislin.mbg.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 * Created on 2018/10/12.
 */
public interface OmsOrderDao {
    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}
