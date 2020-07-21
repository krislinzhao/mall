package cn.krislin.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Package cn.krislin.shiro
 * @ClassName JwtToken
 * @Description 获取JWT Token
 * @Date 20/7/15 10:19
 * @Author krislin
 * @Version V1.0
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt) {
        token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}