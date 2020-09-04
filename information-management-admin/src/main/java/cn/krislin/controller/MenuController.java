package cn.krislin.controller;


import cn.krislin.result.Result;
import cn.krislin.result.ResultFactory;
import cn.krislin.service.AdminMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author krislin
 * @since 2020-09-01
 */
@RestController
@RequestMapping("/api")
public class MenuController {
    @Autowired
    AdminMenuService adminMenuService;

    /**
     * 当前用户可以访问的菜单
     * @retrn
     */
    @GetMapping("/menu")
    public Result menu() {

        return ResultFactory.buildSuccessResult(adminMenuService.getMenusByCurrentUser());
    }

    /**
     * 角色可以访问的菜单
     * @return
     */
    @GetMapping("/role/menu")
    public Result listAllMenus() {
        return ResultFactory.buildSuccessResult(adminMenuService.getMenusByRoleId(1));
    }
}
