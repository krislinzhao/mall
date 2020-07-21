package cn.krislin.utils;

import cn.krislin.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

/**
 * @Package cn.krislin.utils
 * @ClassName ShiroUtils
 * @Description Shiro工具类
 * @Date 20/7/16 14:59
 * @Author krislin
 * @Version V1.0
 */
public class ShiroUtils {

    /**
     * 获取当前登录用户的信息
     *
     * @return
     */
    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}