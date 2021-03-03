package cn.krislin.member.domain;

import cn.krislin.mbg.model.UmsMember;
import cn.krislin.mbg.model.UmsMemberLevel;
import lombok.Data;

@Data
public class PortalMemberInfo extends UmsMember {
    private UmsMemberLevel umsMemberLevel;
}
