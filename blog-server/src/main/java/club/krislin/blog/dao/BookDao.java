package club.krislin.blog.dao;

import club.krislin.blog.pojo.Book;
import club.krislin.blog.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Book)表数据库访问层
 *
 * @author krislin
 * @since 2020-07-01 12:37:08
 */
@Mapper
public interface BookDao {

    /**
     * 通过分类查找
     * @param category 分类
     * @return
     */
    List<Book> findAllByCategory(Category category);

    /**
     * 通过title和author模糊查询
     * @param keyword1 title
     * @param keyword2 author
     * @return
     */
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Book queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Book> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param book 实例对象
     * @return 对象列表
     */
    List<Book> queryAll(Book book);

    /**
     * 新增数据
     *
     * @param book 实例对象
     * @return 影响行数
     */
    int insert(Book book);

    /**
     * 修改数据
     *
     * @param book 实例对象
     * @return 影响行数
     */
    int update(Book book);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}