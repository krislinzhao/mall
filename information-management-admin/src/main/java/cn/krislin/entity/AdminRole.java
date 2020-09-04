package cn.krislin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author krislin
 * @since 2020-09-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdminRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String nameZh;

    private Boolean enabled;

    /**
     * 角色拥有的权限
     */
    @TableField(exist = false)
    private List<AdminPermission> perms;

    /**
     * 角色可以访问的菜单
     */
    @TableField(exist = false)
    private List<AdminMenu> menus;

}
