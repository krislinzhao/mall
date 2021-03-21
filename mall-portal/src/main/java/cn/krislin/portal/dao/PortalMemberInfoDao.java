package cn.krislin.portal.dao;

import cn.krislin.portal.domain.PortalMemberInfo;

/**
 * 会员信息获取
 **/
public interface PortalMemberInfoDao {
    /**
     * 查询会员信息
     * @param memberId
     * @return
     */
    PortalMemberInfo getMemberInfo(Long memberId);
}
