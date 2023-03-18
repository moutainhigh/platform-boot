package com.plm.platform.module.product.framework.web.config;

import com.plm.platform.framework.swagger.config.PlatformSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * product 模块的 web 组件的 Configuration
 *
 * @author PDM
 */
@Configuration(proxyBeanMethods = false)
public class ProductWebConfiguration {

    /**
     * product 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi productGroupedOpenApi() {
        return PlatformSwaggerAutoConfiguration.buildGroupedOpenApi("product");
    }

}
