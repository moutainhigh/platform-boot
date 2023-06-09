package com.plm.platform.framework.mq.core.stream;

import com.plm.platform.framework.mq.core.message.AbstractRedisMessage;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Redis Stream Message 抽象类
 *
 * @author PDM
 */
public abstract class AbstractStreamMessage extends AbstractRedisMessage {

    /**
     * 获得 Redis Stream Key
     *
     * @return Channel
     */
    @JsonIgnore // 避免序列化
    public abstract String getStreamKey();

}
