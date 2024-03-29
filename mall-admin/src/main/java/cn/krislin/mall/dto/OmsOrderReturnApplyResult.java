package cn.krislin.mall.dto;

import cn.krislin.mbg.model.OmsCompanyAddress;
import cn.krislin.mbg.model.OmsOrderReturnApply;
import lombok.Getter;
import lombok.Setter;

/**
 * 申请信息封装
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
    @Getter
    @Setter
    private OmsCompanyAddress companyAddress;
}
