package com.plm.platform.framework.websocket.config;

import com.plm.platform.framework.websocket.core.UserHandshakeInterceptor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.HandshakeInterceptor;

@EnableConfigurationProperties(WebSocketProperties.class)
public class WebSocketHandlerConfig {
    @Bean
    public HandshakeInterceptor handshakeInterceptor() {
        return new UserHandshakeInterceptor();
    }
}
