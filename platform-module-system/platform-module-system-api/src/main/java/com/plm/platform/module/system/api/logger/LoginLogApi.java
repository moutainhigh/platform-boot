package com.plm.platform.module.system.api.logger;

import com.plm.platform.module.system.api.logger.dto.LoginLogCreateReqDTO;

import javax.validation.Valid;

/**
 * 登录日志的 API 接口
 *
 * @author PDM
 */
public interface LoginLogApi {

    /**
     * 创建登录日志
     *
     * @param reqDTO 日志信息
     */
    void createLoginLog(@Valid LoginLogCreateReqDTO reqDTO);

}
