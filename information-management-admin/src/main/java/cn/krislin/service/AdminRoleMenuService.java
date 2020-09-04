package cn.krislin.service;

import cn.krislin.entity.AdminRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author krislin
 * @since 2020-09-01
 */
public interface AdminRoleMenuService extends IService<AdminRoleMenu> {
    /**
     * 更新角色的菜单列表
     * @param rid
     * @param menusIds
     */
    void updateRoleMenu(int rid, Map<String, List<Integer>> menusIds);
}
