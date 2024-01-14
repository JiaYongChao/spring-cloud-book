package com.book.cloud.module.user.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @ClassNAME BookLoginReqVO
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/14 22:02
 * @Version 1.0
 */
@Schema(description = "管理后台 - 图书系统账号密码登录 Request VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookLoginReqVO {

    @Schema(description = "账号", requiredMode = Schema.RequiredMode.REQUIRED, example = "mycloudyuanma")
    @NotEmpty(message = "登录账号不能为空")
    private String username;

    @Schema(description = "密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "buzhidao")
    @NotEmpty(message = "密码不能为空")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String password;

}
