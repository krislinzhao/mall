package cn.krislin.controller;


import cn.krislin.common.Result;
import cn.krislin.entity.User;
import cn.krislin.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //登录权限验证:即登录之后才可以访问该接口
    @RequiresAuthentication
    @GetMapping("/index")
    public Object index(){
        User user = userService.getById(1L);
        return Result.success(user);
    }

    @GetMapping("/error")
    public Object error(){
        return Result.error("操作失败");
    }


    @PostMapping("/save")
    public Result save(@Validated @RequestBody User user){
        return Result.success(user);

    }

}
