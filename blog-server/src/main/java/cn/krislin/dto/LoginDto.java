package cn.krislin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Package cn.krislin.dto
 * @ClassName LoginDto
 * @Description 用户登录信息
 * @Date 20/7/15 11:26
 * @Author krislin
 * @Version V1.0
 */
@Data
public class LoginDto implements Serializable {

    @NotBlank(message = "昵称不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

}
