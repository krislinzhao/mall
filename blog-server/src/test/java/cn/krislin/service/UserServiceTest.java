package cn.krislin.service;

import cn.krislin.dto.LoginDto;
import cn.krislin.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Package cn.krislin.service
 * @ClassName UserServiceTest
 * @Description TODO
 * @Date 20/7/15 13:34
 * @Author krislin
 * @Version V1.0
 */
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void testGetOne() {
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername("krislin");
        loginDto.setPassword("111111");
        User user = userService.getOne(new QueryWrapper<User>().eq("username", "krislin"));
        System.out.println(user);
    }
}
