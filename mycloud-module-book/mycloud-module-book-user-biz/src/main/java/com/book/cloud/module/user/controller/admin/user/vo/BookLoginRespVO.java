package com.book.cloud.module.user.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassNAME BookLoginRespVO
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/14 22:01
 * @Version 1.0
 */
@Schema(description = "管理后台 - 图书用户登录 Response VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookLoginRespVO {
    @Schema(description = "用户编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    private Long userId;

    @Schema(description = "访问令牌", requiredMode = Schema.RequiredMode.REQUIRED, example = "happy")
    private String accessToken;

    @Schema(description = "刷新令牌", requiredMode = Schema.RequiredMode.REQUIRED, example = "nice")
    private String refreshToken;

    @Schema(description = "过期时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime expiresTime;
}
