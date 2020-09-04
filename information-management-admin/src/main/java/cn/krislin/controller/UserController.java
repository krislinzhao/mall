package cn.krislin.controller;


import cn.krislin.entity.User;
import cn.krislin.result.Result;
import cn.krislin.result.ResultFactory;
import cn.krislin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author krislin
 * @since 2020-07-15
 */
@RestController
@RequestMapping("/api/admin")
public class UserController {

    @Autowired
    UserService userService;


    /**
     * 列出所有用户
     *
     * @return
     */
    @GetMapping("/user")
    public Result listUser() {
        return ResultFactory.buildSuccessResult(userService.list());
    }


    /**
     * 修改用户信息
     *
     * @param requestUser
     * @return
     */
    @PutMapping("/user")
    public Result editUser(@RequestBody User requestUser) {
        userService.editUser(requestUser);
        return ResultFactory.buildSuccessResult("修改成功");
    }

    /**
     * 更新用户状态
     *
     * @param requestUser
     * @return
     */
    @PutMapping("/user/status")
    public Result updateUserStatus(@RequestBody User requestUser) {
        userService.updateUserStatus(requestUser);
        return ResultFactory.buildSuccessResult("更新用户状态成功");
    }

    /**
     * 重置密码
     *
     * @param requestUser
     * @return
     */
    @PutMapping("/user/password")
    public Result restPassword(@RequestBody User requestUser) {
        userService.restPassword(requestUser);
        return ResultFactory.buildSuccessResult("重置密码成功");
    }

}
