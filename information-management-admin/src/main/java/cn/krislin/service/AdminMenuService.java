package cn.krislin.service;

import cn.krislin.entity.AdminMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author krislin
 * @since 2020-09-01
 */
public interface AdminMenuService extends IService<AdminMenu> {
    /**
     * 根据当前用户列出他拥有的菜单列表
     * @return
     */
    List<AdminMenu> getMenusByCurrentUser();

    /**
     * 根据角色id列出他拥有的菜单列表
     * @param rid
     * @return
     */
    List<AdminMenu> getMenusByRoleId(Integer rid);
}
