package club.krislin.blog.service;

import club.krislin.blog.pojo.Category;

import java.util.List;

/**
 * (Category)表服务接口
 *
 * @author krislin
 * @since 2020-07-01 12:37:20
 */
public interface ICategoryService {
    /**
     * 查询所有Category
     * @return
     */
    List<Category> list();

    /**
     * 通过id查询Category
     * @param id
     * @return
     */
    Category get(int id);
}