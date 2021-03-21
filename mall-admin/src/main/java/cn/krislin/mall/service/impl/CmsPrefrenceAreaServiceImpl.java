package cn.krislin.mall.service.impl;

import cn.krislin.mbg.mapper.CmsPrefrenceAreaMapper;
import cn.krislin.mbg.model.CmsPrefrenceArea;
import cn.krislin.mbg.model.CmsPrefrenceAreaExample;
import cn.krislin.mall.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选Service实现类
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
