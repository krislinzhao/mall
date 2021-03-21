package cn.krislin.portal.domain;

import cn.krislin.mbg.model.UmsMember;
import cn.krislin.mbg.model.UmsMemberLevel;
import lombok.Data;

/**
 * 网站会员信息
 **/
@Data
public class PortalMemberInfo extends UmsMember {
    private UmsMemberLevel umsMemberLevel;
}
