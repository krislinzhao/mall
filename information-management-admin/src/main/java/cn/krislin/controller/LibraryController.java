package cn.krislin.controller;


import cn.krislin.entity.Book;
import cn.krislin.result.Result;
import cn.krislin.result.ResultFactory;
import cn.krislin.service.BookService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author krislin
 * @since 2020-09-01
 */
@RestController
@RequestMapping("/api")
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public Result list(){
        return ResultFactory.buildSuccessResult(bookService.list());
    }

    @PostMapping("/books")
    public Result addOrUpdate(@RequestBody Book book){
        bookService.saveOrUpdate(book);
        return ResultFactory.buildSuccessResult("修改成功");
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.removeById(book.getId());
    }

    @GetMapping("/categories/{cid}/books")
    public Result listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("cid",cid);
            return ResultFactory.buildSuccessResult(bookService.list(queryWrapper));
        } else {
            return list();
        }
    }

    @GetMapping("/search")
    public Result searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return list();
        } else {
            QueryWrapper<Book> queryWrapper = new QueryWrapper();
            queryWrapper.and(wrapper -> wrapper.like("title",keywords).or().like("author",keywords));
            return ResultFactory.buildSuccessResult(bookService.list(queryWrapper));
        }
    }

}
