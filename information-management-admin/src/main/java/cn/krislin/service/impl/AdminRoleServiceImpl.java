package cn.krislin.service.impl;

import cn.krislin.entity.AdminMenu;
import cn.krislin.entity.AdminPermission;
import cn.krislin.entity.AdminRole;
import cn.krislin.entity.User;
import cn.krislin.mapper.AdminRoleMapper;
import cn.krislin.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author krislin
 * @since 2020-09-01
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {

    @Autowired
    UserService userService;

    @Autowired
    AdminUserRoleService adminUserRoleService;

    @Resource
    AdminRoleMapper adminRoleMapper;

    @Autowired
    AdminRolePermissionService adminRolePermissionService;

    @Autowired
    AdminMenuService adminMenuService;

    @Autowired
    AdminPermissionService adminPermissionService;

    @Override
    public List<AdminRole> listRolesByUser(String username) {
        int userId = userService.getOne(new QueryWrapper<User>().eq("username", username)).getId();
        List<Integer> rids = adminUserRoleService.listAllByUid(userId)
                .stream().map(x -> x.getRid()).collect(Collectors.toList());
        return adminRoleMapper.selectBatchIds(rids);
    }

    @Override
    public void addOrUpdateRole(AdminRole adminRole) {
        AdminRole role = adminRoleMapper.selectById(adminRole.getId());
        if (role == null){
            adminRoleMapper.insert(adminRole);
        }else {
            adminRoleMapper.updateById(adminRole);
        }
        adminRolePermissionService.savePermissionChange(adminRole.getId(),adminRole.getPerms());
    }

    @Override
    public AdminRole updateRoleStatus(AdminRole role) {
        AdminRole roleInDB = adminRoleMapper.selectById(role.getId());
        roleInDB.setEnabled(role.getEnabled());
        adminRoleMapper.updateById(roleInDB);
        return roleInDB;
    }

    @Override
    public List<AdminRole> listWithPermsAndMenus() {
        List<AdminRole> roles = adminRoleMapper.selectList(new QueryWrapper<>());
        List<AdminMenu> menus;
        List<AdminPermission> perms;
        for (AdminRole role:roles){
            menus = adminMenuService.getMenusByRoleId(role.getId());
            perms = adminPermissionService.listPermsByRoleId(role.getId());
            role.setMenus(menus);
            role.setPerms(perms);
        }
        return roles;
    }
}
