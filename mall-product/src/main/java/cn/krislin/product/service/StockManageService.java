package cn.krislin.product.service;


import cn.krislincommon.api.CommonResult;
import cn.krislin.product.domain.CartPromotionItem;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 库存管理
 **/
public interface StockManageService {

    /**
     * 添加库存
     * @param productId
     * @param skuId
     * @param quanlity
     * @param miaosha
     * @return
     */
    Integer incrStock(Long productId, Long skuId, Integer quanlity, Integer miaosha, Long flashPromotionRelationId);

    /**
     * 减库存
     * @param productId
     * @param skuId
     * @param quanlity
     * @param miaosha
     * @return
     */
    Integer descStock(@RequestParam Long productId, Long skuId, Integer quanlity, Integer miaosha, Long flashPromotionRelationId);

    /**
     * 查询库存
     * @param productId
     * @param flashPromotionRelationId
     * @return
     */
    CommonResult<Integer> selectStock(Long productId, Long flashPromotionRelationId);

    /**
     * 方法实现说明:锁定库存
     * @author:smlz
     * @param
     * @return:
     * @exception:
     * @date:2020/3/16 19:36
     */
    CommonResult lockStock(List<CartPromotionItem> cartPromotionItemList);
}
