package cn.krislin.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Package cn.krislin.config
 * @ClassName MyBatisPlusConfig
 * @Description 开启mapper接口扫描，添加分页插件
 * 通过@mapperScan注解指定要变成实现类的接口所在的包，
 * 然后包下面的所有接口在编译之后都会生成相应的实现类
 * @Date 20/7/15 8:12
 * @Author krislin
 * @Version V1.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan("cn.krislin.mapper")
public class MyBatisPlusConfig {
    /**
     * PaginationInterceptor是一个分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
