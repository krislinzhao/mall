package club.krislin.blog.controller;

import club.krislin.blog.pojo.Book;
import club.krislin.blog.service.impl.BookServiceImpl;
import club.krislin.blog.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Package club.krislin.blog.controller
 * @ClassName LibraryController
 * @Description TODO
 * @Date 20/7/1 13:15
 * @Author krislin
 * @Version V1.0
 */
@RestController
public class LibraryController {
    @Autowired
    BookServiceImpl bookService;

    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @PostMapping("/api/covers")
    public String coversUpload(MultipartFile file) throws Exception{
        File imageFolder = new File("F:\\Program\\Java\\Practice_Projects\\SpringBoot_Practices\\krislin_blog\\blog\\img");
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
