package cn.krislin.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"cn.krislin.mall.mapper","cn.krislin.mall.dao"})
public class MyBatisConfig {
}
