package com.plm.platform.module.system.mq.producer.permission;

import com.plm.platform.module.system.mq.message.permission.RoleRefreshMessage;
import com.plm.platform.framework.mq.core.RedisMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Role 角色相关消息的 Producer
 *
 * @author PDM
 */
@Component
public class RoleProducer {

    @Resource
    private RedisMQTemplate redisMQTemplate;

    /**
     * 发送 {@link RoleRefreshMessage} 消息
     */
    public void sendRoleRefreshMessage() {
        RoleRefreshMessage message = new RoleRefreshMessage();
        redisMQTemplate.send(message);
    }

}
