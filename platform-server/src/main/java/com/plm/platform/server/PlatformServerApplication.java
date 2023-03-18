package com.plm.platform.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目的启动类
 *
 * 如果你碰到启动的问题，请认真阅读 https://doc.example.com/quick-start/ 文章
 * 如果你碰到启动的问题，请认真阅读 https://doc.example.com/quick-start/ 文章
 * 如果你碰到启动的问题，请认真阅读 https://doc.example.com/quick-start/ 文章
 *
 * @author PDM
 */
@SuppressWarnings("SpringComponentScan") // 忽略 IDEA 无法识别 ${platform.info.base-package}
@SpringBootApplication(scanBasePackages = {"${platform.info.base-package}.server", "${platform.info.base-package}.module"})
public class PlatformServerApplication {

    public static void main(String[] args) {
        // 如果你碰到启动的问题，请认真阅读 https://doc.example.com/quick-start/ 文章
        // 如果你碰到启动的问题，请认真阅读 https://doc.example.com/quick-start/ 文章
        // 如果你碰到启动的问题，请认真阅读 https://doc.example.com/quick-start/ 文章

        SpringApplication.run(PlatformServerApplication.class, args);
//        new SpringApplicationBuilder(PlatformServerApplication.class)
//                .applicationStartup(new BufferingApplicationStartup(20480))
//                .run(args);

        // 如果你碰到启动的问题，请认真阅读 https://doc.example.com/quick-start/ 文章
        // 如果你碰到启动的问题，请认真阅读 https://doc.example.com/quick-start/ 文章
        // 如果你碰到启动的问题，请认真阅读 https://doc.example.com/quick-start/ 文章
    }

}
