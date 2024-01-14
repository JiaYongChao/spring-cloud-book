package com.book.cloud.framework.operatelog.config;

import com.book.cloud.framework.operatelog.core.aop.OperateLogAspect;
import com.book.cloud.framework.operatelog.core.service.OperateLogFrameworkService;
import com.book.cloud.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import com.book.cloud.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class MycloudOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
