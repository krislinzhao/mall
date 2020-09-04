package cn.krislin.service;

import cn.krislin.entity.AdminPermission;
import cn.krislin.entity.AdminRolePermission;
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
public interface AdminRolePermissionService extends IService<AdminRolePermission> {

    /**
     * 更改权限
     * @param rid
     * @param perms
     */
    void savePermissionChange(Integer rid, List<AdminPermission> perms);
}
