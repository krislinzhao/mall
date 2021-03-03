package cn.krislin.member.service;

import cn.krislin.member.domain.PortalMemberInfo;

public interface UmsMemberCenterService {

    /**
     * 查询会员信息
     * @param memberId
     * @return
     */
    PortalMemberInfo getMemberInfo(Long memberId);
}
