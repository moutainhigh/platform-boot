package com.plm.platform.framework.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文档地址
 *
 * @author PDM
 */
@Getter
@AllArgsConstructor
public enum DocumentEnum {

    REDIS_INSTALL("https://doc.example.com", "Redis 安装文档"),
    TENANT("https://doc.example.com", "SaaS 多租户文档");

    private final String url;
    private final String memo;

}
