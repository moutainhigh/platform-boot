package com.plm.platform.framework.pay.config;

import com.plm.platform.framework.pay.core.client.PayClientFactory;
import com.plm.platform.framework.pay.core.client.impl.PayClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 支付配置类
 *
 * @author PDM
 */
@AutoConfiguration
@EnableConfigurationProperties(PayProperties.class)
public class PlatformPayAutoConfiguration {

    @Bean
    public PayClientFactory payClientFactory() {
        return new PayClientFactoryImpl();
    }

}
