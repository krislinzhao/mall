package cn.krislin.member.dao;


import cn.krislin.member.domain.PortalMemberInfo;

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
