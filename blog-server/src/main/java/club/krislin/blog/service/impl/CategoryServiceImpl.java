package club.krislin.blog.service.impl;

import club.krislin.blog.dao.CategoryDao;
import club.krislin.blog.pojo.Category;
import club.krislin.blog.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Category)表服务实现类
 *
 * @author krislin
 * @since 2020-07-01 12:37:20
 */
@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
    @Resource
    private CategoryDao categoryDao;

    @Override
    public List<Category> list() {
        Category category = new Category();
        return categoryDao.queryAll(category);
    }

    @Override
    public Category get(int id) {
        return categoryDao.queryById(id);
    }
}