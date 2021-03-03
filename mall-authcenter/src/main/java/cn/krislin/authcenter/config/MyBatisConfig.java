package cn.krislin.authcenter.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"cn.krislin.mall.mapper","cn.krislin.portal.dao"})
public class MyBatisConfig {
}
