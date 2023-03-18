package com.plm.platform.framework.sms.config;

import com.plm.platform.framework.sms.core.client.SmsClientFactory;
import com.plm.platform.framework.sms.core.client.impl.SmsClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 短信配置类
 *
 * @author PDM
 */
@AutoConfiguration
public class PlatformSmsAutoConfiguration {

    @Bean
    public SmsClientFactory smsClientFactory() {
        return new SmsClientFactoryImpl();
    }

}
