package cn.krislin.service.impl;

import cn.krislin.entity.AdminMenu;
import cn.krislin.entity.AdminRoleMenu;
import cn.krislin.entity.AdminUserRole;
import cn.krislin.entity.User;
import cn.krislin.mapper.AdminMenuMapper;
import cn.krislin.service.AdminMenuService;
import cn.krislin.service.AdminRoleMenuService;
import cn.krislin.service.AdminUserRoleService;
import cn.krislin.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class AdminMenuServiceImpl extends ServiceImpl<AdminMenuMapper, AdminMenu> implements AdminMenuService {

    @Autowired
    UserService userService;

    @Autowired
    AdminUserRoleService adminUserRoleService;

    @Autowired
    AdminRoleMenuService adminRoleMenuService;

    @Autowired
    AdminMenuService adminMenuService;

    @Override
    public List<AdminMenu> getMenusByCurrentUser() {
        //从数据库获取当前对象
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        System.out.println("user="+user);

        //获取当前用户对应的所有角色的id列表
        List<Integer> rids = adminUserRoleService.list(new QueryWrapper<AdminUserRole>().eq("uid", user.getId()))
                .stream().map(x -> x.getRid()).collect(Collectors.toList());
        System.out.println("rids="+rids);

        //查询出这些角色所对应的菜单项
        List<Integer> menuIds = adminRoleMenuService.list(new QueryWrapper<AdminRoleMenu>().in("rid", rids))
                .stream().map(x -> x.getMid()).distinct().collect(Collectors.toList());
        System.out.println("menuIds="+menuIds);
        List<AdminMenu> menus = adminMenuService.listByIds(menuIds).stream().distinct().collect(Collectors.toList());
        System.out.println("menus="+menus);

        //处理菜单项的结构
        handleMenus(menus);
        return menus;
    }

    @Override
    public List<AdminMenu> getMenusByRoleId(Integer rid) {
        List<Integer> menuIds = adminRoleMenuService.list(new QueryWrapper<AdminRoleMenu>().eq("rid",rid))
                .stream().map(x -> x.getMid()).distinct().collect(Collectors.toList());
        List<AdminMenu> menus = adminMenuService.listByIds(menuIds).stream().collect(Collectors.toList());
        handleMenus(menus);
        return menus;
    }

    /**
     * 把查询出来的菜单数据列表整合成具有层级关系的菜单树
     * @param menus
     */
    public void handleMenus(List<AdminMenu> menus) {
        menus.forEach(m -> {
            List<AdminMenu> children = getAllByParentId(m.getId());
            m.setChildren(children);
        });

        menus.removeIf(m -> m.getParentId() != 0);
        System.out.println(menus);
    }

    public List<AdminMenu> getAllByParentId(int parentId){
        return adminMenuService.list(new QueryWrapper<AdminMenu>().eq("parent_id",parentId));
    }
}
