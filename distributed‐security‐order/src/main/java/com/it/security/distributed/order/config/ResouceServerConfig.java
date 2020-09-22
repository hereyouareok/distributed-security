package com.it.security.distributed.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : TODO
 * @Create on : 2020/9/22 14:24
 **/
@EnableResourceServer
@Configuration
public class ResouceServerConfig extends ResourceServerConfigurerAdapter {
    public static final String RESOURCE_ID = "res1";

    @Autowired
    TokenStore tokenStore;


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        //资源id
        resources.resourceId(RESOURCE_ID)
                //.tokenServices(tokenService())//验证令牌的服务
                .tokenStore(tokenStore)
                .stateless(true);
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").access("#oauth2.hasScope('ROLE_ADMIN')")
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
