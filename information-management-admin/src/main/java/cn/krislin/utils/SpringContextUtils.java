package cn.krislin.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Package cn.krislin.utils
 * @ClassName SpringContextUtils
 * @Description TODO
 * @Date 2020/9/2 17:44
 * @Author krislin
 * @Version V1.0
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringContextUtils.context = context;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
