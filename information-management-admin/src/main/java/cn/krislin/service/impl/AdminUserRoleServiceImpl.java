package cn.krislin.service.impl;

import cn.krislin.entity.AdminRole;
import cn.krislin.entity.AdminUserRole;
import cn.krislin.mapper.AdminUserRoleMapper;
import cn.krislin.service.AdminUserRoleService;
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
public class AdminUserRoleServiceImpl extends ServiceImpl<AdminUserRoleMapper, AdminUserRole> implements AdminUserRoleService {

    @Resource
    AdminUserRoleMapper adminUserRoleMapper;


    @Override
    public List<AdminUserRole> listAllByUid(int uid) {
        return adminUserRoleMapper.selectList(new QueryWrapper<AdminUserRole>().eq("uid",uid));
    }

    @Transactional(rollbackFor = {})
    @Override
    public void saveRoleChange(Integer uid, List<AdminRole> roles) {
        adminUserRoleMapper.delete(new QueryWrapper<AdminUserRole>().eq("uid",uid));
        for (AdminRole role:roles){
            AdminUserRole adminUserRole = new AdminUserRole();
            adminUserRole.setUid(uid);
            adminUserRole.setRid(role.getId());
            adminUserRoleMapper.insert(adminUserRole);
        }
    }
}
