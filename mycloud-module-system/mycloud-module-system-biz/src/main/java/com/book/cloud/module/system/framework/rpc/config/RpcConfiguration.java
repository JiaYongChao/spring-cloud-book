package com.book.cloud.module.system.framework.rpc.config;

import com.book.cloud.module.infra.api.file.FileApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {FileApi.class})
public class RpcConfiguration {
}
