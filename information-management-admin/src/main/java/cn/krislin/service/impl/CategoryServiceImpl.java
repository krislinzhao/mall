package cn.krislin.service.impl;

import cn.krislin.entity.Category;
import cn.krislin.mapper.CategoryMapper;
import cn.krislin.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author krislin
 * @since 2020-09-01
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
