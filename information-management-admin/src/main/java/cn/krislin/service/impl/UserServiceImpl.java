package cn.krislin.service.impl;

import cn.krislin.entity.AdminRole;
import cn.krislin.entity.User;
import cn.krislin.mapper.UserMapper;
import cn.krislin.service.AdminRoleService;
import cn.krislin.service.AdminUserRoleService;
import cn.krislin.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author krislin
 * @since 2020-07-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    UserMapper userMapper;

    @Autowired
    AdminRoleService adminRoleService;

    @Autowired
    AdminUserRoleService adminUserRoleService;


    @Override
    public int register(User user) {
        String username = user.getUsername();
        String name = user.getName();
        String phone = user.getPhone();
        String email = user.getEmail();
        String password = user.getPassword();

        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        phone = HtmlUtils.htmlEscape(phone);
        user.setPhone(phone);
        email = HtmlUtils.htmlEscape(email);
        user.setEmail(email);
        user.setEnabled(true);

        if (username.equals("") || password.equals("")) {
            return 0;
        }

        boolean exist = isExist(username);

        if (exist) {
            return 2;
        }

        // 默认生成 16 位盐
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();

        user.setSalt(salt);
        user.setPassword(encodedPassword);
        System.out.println(user);

        userMapper.insert(user);

        return 1;
    }

    @Override
    public void editUser(User requestUser) {
        userMapper.updateById(requestUser);
        adminUserRoleService.saveRoleChange(requestUser.getId(), requestUser.getRoles());
    }

    public boolean isExist(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        System.out.println(username);
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        return null != user;
    }

    @Override
    public List<User> list() {
        List<User> users = userMapper.selectList(new QueryWrapper<>());
        List<AdminRole> roles;
        for (User user : users) {
            roles = adminRoleService.listRolesByUser(user.getUsername());
            user.setRoles(roles);
        }
        return users;
    }

    @Override
    public void updateUserStatus(User requestUser) {
        userMapper.updateById(requestUser);
    }

    @Override
    public User restPassword(User requestUser) {
        User userInDB = userMapper.selectById(requestUser.getId());
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodedPassword = new SimpleHash("md5", 123, salt, times).toString();
        userInDB.setPassword(encodedPassword);
        userMapper.insert(userInDB);
        return userInDB;
    }
}
