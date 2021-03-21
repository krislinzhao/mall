package cn.krislin.search.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan({"cn.krislin.search.mapper","cn.krislin.search..dao"})
public class MyBatisConfig {
}
