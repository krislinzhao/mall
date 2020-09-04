package cn.krislin.service.impl;

import cn.krislin.entity.AdminPermission;
import cn.krislin.entity.AdminRolePermission;
import cn.krislin.mapper.AdminPermissionMapper;
import cn.krislin.mapper.AdminRolePermissionMapper;
import cn.krislin.service.AdminPermissionService;
import cn.krislin.service.AdminRolePermissionService;
import cn.krislin.service.AdminRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
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
public class AdminPermissionServiceImpl extends ServiceImpl<AdminPermissionMapper, AdminPermission> implements AdminPermissionService {

    @Autowired
    AdminRoleService adminRoleService;

    @Autowired
    AdminRolePermissionService adminRolePermissionService;

    @Resource
    AdminRolePermissionMapper adminRolePermissionMapper;

    @Resource
    AdminPermissionMapper adminPermissionMapper;

    @Autowired
    AdminPermissionService adminPermissionService;

    @Override
    public Set<String> listPermissionURLsByUser(String username) {
        List<Integer> rids = adminRoleService.listRolesByUser(username)
                .stream().map(x -> x.getId()).collect(Collectors.toList());
        List<Integer> pids = adminRolePermissionMapper.selectList(new QueryWrapper<AdminRolePermission>().eq("rid", rids))
                .stream().map(x -> x.getPid()).collect(Collectors.toList());

        List<AdminPermission> adminPermissions = adminPermissionMapper.selectBatchIds(pids);

        return adminPermissions.stream().map(x -> x.getUrl()).collect(Collectors.toSet());
    }

    @Override
    public boolean needFilter(String requestAPI) {
        List<AdminPermission> ps = adminPermissionService.list();
        for (AdminPermission p:ps){
            if (p.getUrl().equals(requestAPI)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<AdminPermission> listPermsByRoleId(int rid) {
        List<Integer> pids = adminRolePermissionService.list(new QueryWrapper<AdminRolePermission>().eq("rid", rid))
                .stream().map(x -> x.getPid()).collect(Collectors.toList());
        return adminPermissionMapper.selectBatchIds(pids);
    }
}
