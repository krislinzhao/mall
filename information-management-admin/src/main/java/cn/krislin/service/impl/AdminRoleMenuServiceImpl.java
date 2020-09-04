package cn.krislin.service.impl;

import cn.krislin.entity.AdminRoleMenu;
import cn.krislin.mapper.AdminRoleMenuMapper;
import cn.krislin.service.AdminRoleMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author krislin
 * @since 2020-09-01
 */
@Service
public class AdminRoleMenuServiceImpl extends ServiceImpl<AdminRoleMenuMapper, AdminRoleMenu> implements AdminRoleMenuService {

    @Resource
    AdminRoleMenuMapper adminRoleMenuMapper;

    @Override
    public void updateRoleMenu(int rid, Map<String, List<Integer>> menusIds) {
        adminRoleMenuMapper.delete(new QueryWrapper<AdminRoleMenu>().eq("rid",rid));
        for (Integer menusId:menusIds.get("menusIds")){
            AdminRoleMenu adminRoleMenu = new AdminRoleMenu();
            adminRoleMenu.setMid(menusId);
            adminRoleMenu.setRid(rid);
            adminRoleMenuMapper.insert(adminRoleMenu);
        }
    }
}
