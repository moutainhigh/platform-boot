package com.plm.platform.module.trade.framework.web.config;

import com.plm.platform.framework.swagger.config.PlatformSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * trade 模块的 web 组件的 Configuration
 *
 * @author PDM
 */
@Configuration(proxyBeanMethods = false)
public class TradeWebConfiguration {

    /**
     * trade 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi tradeGroupedOpenApi() {
        return PlatformSwaggerAutoConfiguration.buildGroupedOpenApi("trade");
    }

}
