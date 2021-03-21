package cn.krislin.api.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
* 会员中心 Feign 配置类
*/
public class UmsMemberFeignConfig {

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }

}
