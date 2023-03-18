package com.plm.platform.module.infra.framework.web.config;

import com.plm.platform.framework.swagger.config.PlatformSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * infra 模块的 web 组件的 Configuration
 *
 * @author PDM
 */
@Configuration(proxyBeanMethods = false)
public class InfraWebConfiguration {

    /**
     * infra 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi infraGroupedOpenApi() {
        return PlatformSwaggerAutoConfiguration.buildGroupedOpenApi("infra");
    }

}
