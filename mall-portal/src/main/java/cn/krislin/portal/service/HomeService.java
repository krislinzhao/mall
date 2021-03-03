package cn.krislin.portal.service;

import cn.krislin.mbg.model.CmsSubject;
import cn.krislin.mbg.model.PmsProduct;
import cn.krislin.mbg.model.PmsProductCategory;
import cn.krislin.portal.domain.HomeContentResult;

import java.util.List;

/**
 * 首页内容管理Service
 * Created by tuling on 2019/1/28.
 */
public interface HomeService {

    /**
     * 获取首页内容
     */
    HomeContentResult content();

    /**
     * 首页商品推荐
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);

    /**
     * 获取商品分类
     * @param parentId 0:获取一级分类；其他：获取指定二级分类
     */
    List<PmsProductCategory> getProductCateList(Long parentId);

    /**
     * 根据专题分类分页获取专题
     * @param cateId 专题分类id
     */
    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);
}
