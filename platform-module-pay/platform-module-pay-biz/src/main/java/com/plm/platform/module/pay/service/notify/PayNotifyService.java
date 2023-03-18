package com.plm.platform.module.pay.service.notify;

import com.plm.platform.module.pay.service.notify.dto.PayNotifyTaskCreateReqDTO;

import javax.validation.Valid;

/**
 * 支付通知 Service 接口
 *
 * @author PDM
 */
public interface PayNotifyService {

    /**
     * 创建支付通知任务
     *
     * @param reqDTO 任务信息
     */
    void createPayNotifyTask(@Valid PayNotifyTaskCreateReqDTO reqDTO);

    /**
     * 执行支付通知
     *
     * 注意，该方法提供给定时任务调用。目前是 platform-server 进行调用
     * @return 通知数量
     */
    int executeNotify() throws InterruptedException;

}
