package cn.krislin.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created on 2019/4/8.
 */
@Configuration
@MapperScan({"com.macro.api.mapper","com.macro.api.search.dao"})
public class MyBatisConfig {
}
