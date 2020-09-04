package cn.krislin.service;

import cn.krislin.entity.AdminRole;
import cn.krislin.entity.AdminUserRole;
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
public interface AdminUserRoleService extends IService<AdminUserRole> {
    /**
     * 通过uid查询所有
     * @param uid
     * @return
     */
    List<AdminUserRole> listAllByUid(int uid);

    /**
     * 保存角色用户变化
     * @param uid
     * @param roles
     */
    void saveRoleChange(Integer uid, List<AdminRole> roles);
}
