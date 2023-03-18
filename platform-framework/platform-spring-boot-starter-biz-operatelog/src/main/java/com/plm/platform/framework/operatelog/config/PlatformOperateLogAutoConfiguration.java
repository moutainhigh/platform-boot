package com.plm.platform.framework.operatelog.config;

import com.plm.platform.framework.operatelog.core.aop.OperateLogAspect;
import com.plm.platform.framework.operatelog.core.service.OperateLogFrameworkService;
import com.plm.platform.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import com.plm.platform.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class PlatformOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
