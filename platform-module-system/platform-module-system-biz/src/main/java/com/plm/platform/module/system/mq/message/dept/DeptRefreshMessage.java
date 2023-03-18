package com.plm.platform.module.system.mq.message.dept;

import com.plm.platform.framework.mq.core.pubsub.AbstractChannelMessage;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 部门数据刷新 Message
 *
 * @author PDM
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptRefreshMessage extends AbstractChannelMessage {

    @Override
    public String getChannel() {
        return "system.dept.refresh";
    }

}
