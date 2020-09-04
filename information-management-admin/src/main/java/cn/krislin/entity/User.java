package cn.krislin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * (User)表实体类
 *
 * @author krislin
 * @since 2020-09-01 09:28:43
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

    @TableId(type = IdType.INPUT)
    private Integer id;

    private String username;

    private String password;

    private String salt;

    private String name;

    private String phone;

    private String email;

    private Boolean enabled;

    /**
     * 用户拥有的角色
     */
    @TableField(exist = false)
    private List<AdminRole> roles;

}