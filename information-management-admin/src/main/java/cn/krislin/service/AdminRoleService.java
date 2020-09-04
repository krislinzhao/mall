package cn.krislin.service;

import cn.krislin.entity.AdminRole;
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
public interface AdminRoleService extends IService<AdminRole> {
    /**
     * 通过User查找Roles
     * @param username
     * @return
     */
    List<AdminRole> listRolesByUser(String username);

    /**
     * 增加或修改角色
     * @param adminRole
     */
    void addOrUpdateRole(AdminRole adminRole);

    /**
     * 更新角色状态
     * @param role
     * @return
     */
    AdminRole updateRoleStatus(AdminRole role);

    /**
     * 查找出带有Permission和Menus的Role
     * @return
     */
    List<AdminRole> listWithPermsAndMenus();
}
