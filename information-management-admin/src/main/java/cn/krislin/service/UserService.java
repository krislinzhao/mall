package cn.krislin.service;

import cn.krislin.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author krislin
 * @since 2020-07-15
 */
public interface UserService extends IService<User> {
    /**
     * 注册
     *
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 修改用户
     *
     * @param requestUser
     */
    void editUser(User requestUser);

    /**
     * 更新用户状态
     *
     * @param requestUser
     */
    void updateUserStatus(User requestUser);

    /**
     * 重置密码
     *
     * @param requestUser
     * @return
     */
    User restPassword(User requestUser);
}
