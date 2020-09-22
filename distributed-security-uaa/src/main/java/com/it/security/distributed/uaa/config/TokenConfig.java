package com.it.security.distributed.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : TODO
 * @Create on : 2020/9/21 20:09
 **/
@Configuration
public class TokenConfig {
    //令牌存储策略 普通令牌
    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }
}
