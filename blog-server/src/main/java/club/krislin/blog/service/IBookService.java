package club.krislin.blog.service;

import club.krislin.blog.pojo.Book;

import java.util.List;

/**
 * (Book)表服务接口
 *
 * @author krislin
 * @since 2020-07-01 12:37:08
 */
public interface IBookService {
    /**
     * 查询所有Book
     * @return
     */
    List<Book> list();

    /**
     * 增加或更新Book
     * @param book
     */
    void addOrUpdate(Book book);

    /**
     * 通过id删除
     * @param id
     */
    void deleteById(int id);

    /**
     * 通过Category查询所有
     * @param cid
     * @return
     */
    List<Book> listByCategory(int cid);
}