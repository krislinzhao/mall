package cn.krislin.service;

import cn.krislin.entity.AdminPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author krislin
 * @since 2020-09-01
 */
public interface AdminPermissionService extends IService<AdminPermission> {
    /**
     * 根据当前用户获取所有权限的方法
     * @param username
     * @return
     */
    Set<String> listPermissionURLsByUser(String username);

    /**
     * 判断是否需要过滤
     * @param requestAPI
     * @return
     */
    boolean needFilter(String requestAPI);

    /**
     * 根据角色id获取所有权限
     * @param rid
     * @return
     */
    List<AdminPermission> listPermsByRoleId(int rid);
}
