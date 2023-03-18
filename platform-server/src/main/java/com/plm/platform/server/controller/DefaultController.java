package com.plm.platform.server.controller;

import com.plm.platform.framework.common.pojo.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.plm.platform.framework.common.exception.enums.GlobalErrorCodeConstants.NOT_IMPLEMENTED;

/**
 * 默认 Controller，解决部分 module 未开启时的 404 提示。
 * 例如说，/bpm/** 路径，工作流
 *
 * @author PDM
 */
@RestController
public class DefaultController {

    @RequestMapping("/admin-api/bpm/**")
    public CommonResult<Boolean> bpm404() {
        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
                "[工作流模块 platform-module-bpm - 已禁用][参考 https://doc.example.com/bpm/ 开启]");
    }

    @RequestMapping("/admin-api/mp/**")
    public CommonResult<Boolean> mp404() {
        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
                "[微信公众号 platform-module-mp - 已禁用][参考 https://doc.example.com/mp/build/ 开启]");
    }

    @RequestMapping(value = {"/admin-api/product/**", // 商品中心
            "/admin-api/trade/**", // 交易中心
            "/admin-api/promotion/**"})  // 营销中心
    public CommonResult<Boolean> mall404() {
        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
                "[商城系统 platform-module-mall - 已禁用][参考 https://doc.example.com/mall/build/ 开启]");
    }

    @RequestMapping(value = {"/admin-api/report/**"})
    public CommonResult<Boolean> report404() {
        return CommonResult.error(NOT_IMPLEMENTED.getCode(),
                "[报表模块 platform-module-report - 已禁用][参考 https://doc.example.com/report/ 开启]");
    }

}
