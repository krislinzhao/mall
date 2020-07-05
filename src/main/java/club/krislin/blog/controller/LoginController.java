package club.krislin.blog.controller;

import club.krislin.blog.pojo.User;
import club.krislin.blog.result.Result;
import club.krislin.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

/**
 * @Package club.krislin.blog.controller
 * @ClassName LoginController
 * @Description TODO
 * @Date 20/6/22 17:02
 * @Author krislin
 * @Version V1.0
 */
@Controller
public class LoginController {

    @Autowired
    IUserService userService;


    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession httpSession){

        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.getByUsernameAndPassword(username,requestUser.getPassword());
        //System.out.println(user);

        if (null == user){
            return new Result(400);
        }else {
            httpSession.setAttribute("user",user);
            return new Result(200);
        }
    }
}
