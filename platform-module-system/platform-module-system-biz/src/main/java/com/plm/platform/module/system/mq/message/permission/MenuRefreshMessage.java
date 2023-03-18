package com.plm.platform.module.system.mq.message.permission;

import com.plm.platform.framework.mq.core.pubsub.AbstractChannelMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单数据刷新 Message
 *
 * @author PDM
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "system.menu.refresh";
    }

}
