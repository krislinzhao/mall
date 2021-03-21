package cn.krislin.portal.service;

import cn.krislincommon.api.CommonResult;
import cn.krislin.mbg.model.PmsComment;
import cn.krislin.mbg.model.PmsCommentReplay;
import org.springframework.transaction.annotation.Transactional;

/**
 * 网站商品评论service
 **/
public interface PortalProductCommentService {
    /**
     * 获取评论列表
     * @param productId
     * @param pageNum
     * @param pageSize
     * @return
     */
    CommonResult getCommentList(Long productId, Integer pageNum, Integer pageSize);

    /**
     * 用户评价
     * @param pmsComment
     * @return
     */
    @Transactional
    Integer insertProductComment(PmsComment pmsComment);

    /**
     * 用户评价回复
     * @param replay
     * @return
     */
    @Transactional
    Integer insertCommentReply(PmsCommentReplay replay);

}
