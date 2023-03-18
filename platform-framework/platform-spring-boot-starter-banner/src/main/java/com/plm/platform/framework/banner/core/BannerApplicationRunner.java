package com.plm.platform.framework.banner.core;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.util.ClassUtils;

import java.util.concurrent.TimeUnit;

/**
 * 项目启动成功后，提供文档相关的地址
 *
 * @author PDM
 */
@Slf4j
public class BannerApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ThreadUtil.execute(() -> {
            ThreadUtil.sleep(1, TimeUnit.SECONDS); // 延迟 1 秒，保证输出到结尾
            log.info("\n----------------------------------------------------------\n\t" +
                            "项目启动成功！\n\t" +
                            "----------------------------------------------------------"
            );

            // 数据报表
            if (isNotPresent("com.plm.platform.module.report.framework.security.config.SecurityConfiguration")) {
                System.out.println("[报表模块 platform-module-report - 已禁用]");
            }
            // 工作流
            if (isNotPresent("com.plm.platform.framework.flowable.config.PlatformFlowableConfiguration")) {
                System.out.println("[工作流模块 platform-module-bpm - 已禁用]");
            }
            // 微信公众号
            if (isNotPresent("com.plm.platform.module.mp.framework.mp.config.MpConfiguration")) {
                System.out.println("[微信公众号 platform-module-mp - 已禁用]");
            }
            // 商城
            if (isNotPresent("com.plm.platform.module.trade.framework.web.config.TradeWebConfiguration")) {
                System.out.println("[商城系统 platform-module-mall - 已禁用]");
            }
        });
    }

    private static boolean isNotPresent(String className) {
        return !ClassUtils.isPresent(className, ClassUtils.getDefaultClassLoader());
    }

}
