package cn.krislin.controller;

import cn.krislin.entity.User;
import cn.krislin.result.Result;
import cn.krislin.result.ResultFactory;
import cn.krislin.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Package cn.krislin.controller
 * @ClassName AccountController
 * @Description TODO
 * @Date 20/7/15 11:24
 * @Author krislin
 * @Version V1.0
 */
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    UserService userService;

    /**
     * 登录
     *
     * @param requestUser
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody User requestUser) {
        String userName = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            User user = userService.getOne(new QueryWrapper<User>().eq("username", userName));
            if (!user.getEnabled()) {
                return ResultFactory.buildFailResult("该用户已被禁用");
            }
            return ResultFactory.buildSuccessResult(userName);
        } catch (IncorrectCredentialsException e) {
            return ResultFactory.buildFailResult("账户密码错误");
        } catch (UnknownAccountException e) {
            return ResultFactory.buildFailResult("账号不存在");
        }
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @CrossOrigin
    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody User user) {
        int status = userService.register(user);
        switch (status) {
            case 0:
                return ResultFactory.buildFailResult("用户名和密码不能为空");
            case 1:
                return ResultFactory.buildSuccessResult("注册成功");
            case 2:
                return ResultFactory.buildFailResult("用户已存在");
        }
        return ResultFactory.buildFailResult("未知错误");
    }


    /**
     * 注销
     * <p>
     * 登录后才能访问该接口
     *
     * @return
     */
    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return ResultFactory.buildSuccessResult("注销成功");
    }

    /**
     * 身份认证成功
     *
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/authentication")
    public String authentication() {
        return "身份认证成功";
    }
}
