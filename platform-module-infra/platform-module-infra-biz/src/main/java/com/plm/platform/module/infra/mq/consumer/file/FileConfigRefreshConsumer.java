package com.plm.platform.module.infra.mq.consumer.file;

import com.plm.platform.framework.mq.core.pubsub.AbstractChannelMessageListener;
import com.plm.platform.module.infra.mq.message.file.FileConfigRefreshMessage;
import com.plm.platform.module.infra.service.file.FileConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 针对 {@link FileConfigRefreshMessage} 的消费者
 *
 * @author PDM
 */
@Component
@Slf4j
public class FileConfigRefreshConsumer extends AbstractChannelMessageListener<FileConfigRefreshMessage> {

    @Resource
    private FileConfigService fileConfigService;

    @Override
    public void onMessage(FileConfigRefreshMessage message) {
        log.info("[onMessage][收到 FileConfig 刷新消息]");
        fileConfigService.initLocalCache();
    }

}
