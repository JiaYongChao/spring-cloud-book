package com.book.cloud.framework.apilog.core.service;

import cn.hutool.core.bean.BeanUtil;
import com.book.cloud.framework.common.pojo.CommonResult;
import com.book.cloud.module.infra.api.logger.ApiAccessLogApi;
import com.book.cloud.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

/**
 * API 访问日志 Framework Service 实现类
 *
 * 基于 {@link ApiAccessLogApi} 远程服务，记录访问日志
 *
 * @author JiaYongChao
 */
@RequiredArgsConstructor
public class ApiAccessLogFrameworkServiceImpl implements ApiAccessLogFrameworkService {

    private final ApiAccessLogApi apiAccessLogApi;

    @Override
    @Async
    public void createApiAccessLog(ApiAccessLog apiAccessLog) {
        ApiAccessLogCreateReqDTO reqDTO = BeanUtil.copyProperties(apiAccessLog, ApiAccessLogCreateReqDTO.class);
        apiAccessLogApi.createApiAccessLog(reqDTO).checkError();
    }

}