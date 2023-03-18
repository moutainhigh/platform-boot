package com.plm.platform.module.system.mq.message.permission;

import com.plm.platform.framework.mq.core.pubsub.AbstractChannelMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户与角色的数据刷新 Message
 *
 * @author PDM
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserRoleRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "system.user-role.refresh";
    }

}
