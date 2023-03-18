package com.plm.platform.framework.file.config;

import com.plm.platform.framework.file.core.client.FileClientFactory;
import com.plm.platform.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 文件配置类
 *
 * @author PDM
 */
@AutoConfiguration
public class PlatformFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
