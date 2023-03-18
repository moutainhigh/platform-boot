package com.plm.platform.module.bpm.framework.web.config;

import com.plm.platform.framework.swagger.config.PlatformSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * bpm 模块的 web 组件的 Configuration
 *
 * @author PDM
 */
@Configuration(proxyBeanMethods = false)
public class BpmWebConfiguration {

    /**
     * bpm 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi bpmGroupedOpenApi() {
        return PlatformSwaggerAutoConfiguration.buildGroupedOpenApi("bpm");
    }

}
