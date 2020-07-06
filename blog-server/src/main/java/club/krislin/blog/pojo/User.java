package club.krislin.blog.pojo;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author krislin
 * @since 2020-06-26 20:33:13
 */
public class User implements Serializable {
    private static final long serialVersionUID = -17182121131759279L;
    
    private Integer id;
    
    private String username;
    
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}