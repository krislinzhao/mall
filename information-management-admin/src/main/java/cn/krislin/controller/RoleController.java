package cn.krislin.controller;


import cn.krislin.entity.AdminRole;
import cn.krislin.result.Result;
import cn.krislin.result.ResultFactory;
import cn.krislin.service.AdminPermissionService;
import cn.krislin.service.AdminRoleMenuService;
import cn.krislin.service.AdminRolePermissionService;
import cn.krislin.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author krislin
 * @since 2020-09-01
 */
@RestController
@RequestMapping("/api/admin")
public class RoleController {
    @Autowired
    AdminRolePermissionService adminRolePermissionService;

    @Autowired
    AdminRoleService adminRoleService;

    @Autowired
    AdminPermissionService adminPermissionService;

    @Autowired
    AdminRoleMenuService adminRoleMenuService;

    /**
     * 列出所有角色
     * @return
     */
    @GetMapping("/role")
    public Result listRoles(){
        return ResultFactory.buildSuccessResult(adminRoleService.listWithPermsAndMenus());
    }

    /**
     * 修改角色
     * @param adminRole
     * @return
     */
    @PutMapping("/role")
    public Result editRole(@RequestBody AdminRole adminRole){
        adminRoleService.addOrUpdateRole(adminRole);
        return ResultFactory.buildSuccessResult("修改角色信息成功");
    }

    /**
     * 添加角色
     * @param adminRole
     * @return
     */
    @PostMapping("/role")
    public Result addRole(@RequestBody AdminRole adminRole){
        adminRoleService.addOrUpdateRole(adminRole);
        return ResultFactory.buildSuccessResult("添加角色成功");
    }

    /**
     * 查询当前角色的权限
     * @return
     */
    @GetMapping("/role/perm")
    public Result listPerms(){
        return ResultFactory.buildSuccessResult(adminPermissionService.list());
    }

    /**
     * 更新角色可以访问的菜单
     * @return
     */
    @PutMapping("/role/menu")
    public Result updateRoleMenu(@RequestBody Integer rid, @RequestBody Map<String, List<Integer>> menusIds) {
        adminRoleMenuService.updateRoleMenu(rid,menusIds);
        return ResultFactory.buildSuccessResult("更新成功");
    }

    /**
     * 更新角色状态
     * @param adminRole
     * @return
     */
    @PutMapping("/role/status")
    public Result updateRoleStatus(@RequestBody AdminRole adminRole){
        AdminRole role = adminRoleService.updateRoleStatus(adminRole);
        String message = "用户:"+role.getNameZh()+"状态更新成功";
        return ResultFactory.buildSuccessResult(message);
    }
}
