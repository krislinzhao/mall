package club.krislin.blog.service.impl;

import club.krislin.blog.dao.BookDao;
import club.krislin.blog.pojo.Book;
import club.krislin.blog.pojo.Category;
import club.krislin.blog.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Book)表服务实现类
 *
 * @author krislin
 * @since 2020-07-01 12:37:08
 */
@Service("bookService")
public class BookServiceImpl implements IBookService {
    @Resource
    private BookDao bookDao;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Override
    public List<Book> list() {
        Book book = new Book();
        return bookDao.queryAll(book);
    }

    @Override
    public void addOrUpdate(Book book) {
        List<Book> list = bookDao.queryAll(book);
        if (list == null){
            bookDao.insert(book);
        }else {
            bookDao.update(book);
        }
    }

    @Override
    public void deleteById(int id) {
        bookDao.deleteById(id);
    }

    @Override
    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDao.findAllByCategory(category);
    }
}