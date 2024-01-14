package com.book.cloud.framework.file.config;

import com.book.cloud.framework.file.core.client.FileClientFactory;
import com.book.cloud.framework.file.core.client.FileClientFactoryImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 文件配置类
 *
 * @author JiaYongChao
 */
@AutoConfiguration
public class MycloudFileAutoConfiguration {

    @Bean
    public FileClientFactory fileClientFactory() {
        return new FileClientFactoryImpl();
    }

}
