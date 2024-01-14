package com.book.cloud.module.user.framework.rpc.config;

import com.book.cloud.module.system.api.oauth2.OAuth2TokenApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassNAME RpcConfiguration
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/14 22:49
 * @Version 1.0
 */
@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {OAuth2TokenApi.class})
public class RpcConfiguration {
}
