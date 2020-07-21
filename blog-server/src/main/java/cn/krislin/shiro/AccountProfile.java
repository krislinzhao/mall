package cn.krislin.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * @Package cn.krislin.shiro
 * @ClassName AccountProfile
 * @Description 封装用户可公开的信息
 * @Date 20/7/15 10:58
 * @Author krislin
 * @Version V1.0
 */
@Data
public class AccountProfile implements Serializable {

    private Long id;

    private String username;

    private String avatar;

    private String email;

}


