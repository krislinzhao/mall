package cn.krislin.service.impl;

import cn.krislin.entity.AdminPermission;
import cn.krislin.entity.AdminRolePermission;
import cn.krislin.mapper.AdminRolePermissionMapper;
import cn.krislin.service.AdminRolePermissionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author krislin
 * @since 2020-09-01
 */
@Service
public class AdminRolePermissionServiceImpl extends ServiceImpl<AdminRolePermissionMapper, AdminRolePermission> implements AdminRolePermissionService {

    @Resource
    AdminRolePermissionMapper adminRolePermissionMapper;

    @Transactional(rollbackFor = {})
    @Override
    public void savePermissionChange(Integer rid, List<AdminPermission> perms) {
        adminRolePermissionMapper.delete(new QueryWrapper<AdminRolePermission>().eq("rid",rid));
        for (AdminPermission perm:perms){
            AdminRolePermission adminRolePermission = new AdminRolePermission();
            adminRolePermission.setRid(rid);
            adminRolePermission.setPid(perm.getId());
            adminRolePermissionMapper.insert(adminRolePermission);
        }
    }
}
