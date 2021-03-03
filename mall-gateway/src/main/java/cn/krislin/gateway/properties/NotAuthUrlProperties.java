package cn.krislin.gateway.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashSet;


/**
* 网关跳过认证的配置类
*/
@Data
@ConfigurationProperties("krislin.gateway")
public class NotAuthUrlProperties {

    private LinkedHashSet<String> shouldSkipUrls;
}
