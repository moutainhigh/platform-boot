package com.plm.platform.module.mp.mq.producer;

import com.plm.platform.framework.mq.core.RedisMQTemplate;
import com.plm.platform.module.mp.mq.message.MpAccountRefreshMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 公众号账号 Producer
 *
 * @author PDM
 */
@Component
public class MpAccountProducer {

    @Resource
    private RedisMQTemplate redisMQTemplate;

    /**
     * 发送 {@link MpAccountRefreshMessage} 消息
     */
    public void sendAccountRefreshMessage() {
        MpAccountRefreshMessage message = new MpAccountRefreshMessage();
        redisMQTemplate.send(message);
    }

}
