package cn.krislin.mall.service.impl;

import cn.krislin.mbg.mapper.OmsCompanyAddressMapper;
import cn.krislin.mbg.model.OmsCompanyAddress;
import cn.krislin.mbg.model.OmsCompanyAddressExample;
import cn.krislin.mall.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
