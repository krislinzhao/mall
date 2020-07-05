package club.krislin.blog.pojo;

import java.io.Serializable;

/**
 * (Category)实体类
 *
 * @author krislin
 * @since 2020-07-01 12:37:20
 */
public class Category implements Serializable {
    private static final long serialVersionUID = 329332512013001684L;
    
    private Integer id;
    
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}