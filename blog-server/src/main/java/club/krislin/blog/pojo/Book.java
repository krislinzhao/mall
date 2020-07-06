package club.krislin.blog.pojo;

import java.io.Serializable;

/**
 * (Book)实体类
 *
 * @author krislin
 * @since 2020-07-01 12:37:08
 */
public class Book implements Serializable {
    private static final long serialVersionUID = -53481345807649416L;
    
    private Integer id;
    
    private String cover;
    
    private String title;
    
    private String author;
    
    private String date;
    
    private String press;
    
    private String abs;
    
    private Integer cid;

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", press='" + press + '\'' +
                ", abs='" + abs + '\'' +
                ", cid=" + cid +
                ", category=" + category +
                '}';
    }
}