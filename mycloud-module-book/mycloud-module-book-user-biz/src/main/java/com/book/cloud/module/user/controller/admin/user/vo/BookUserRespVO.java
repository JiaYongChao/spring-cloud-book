package com.book.cloud.module.user.controller.admin.user.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.book.cloud.framework.common.validation.Mobile;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @ClassNAME BookUserRespVO
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/14 21:45
 * @Version 1.0
 */
@Schema(description = "管理后台 - 图书用户信息 Response VO")
@Data
public class BookUserRespVO {

    //用户id
    @Schema(description = "用户id编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @NotNull(message = "用户id不能为空")
    private Long userId;
    //用户名
    @Schema(description = "用户名", requiredMode = Schema.RequiredMode.REQUIRED, example = "username")
    @NotBlank(message = "用户名不能为空")
    @Size(max = 50, message = "用户名不能超过50个字符")
    private String userName;
    //用户密码
    @Schema(description = "用户密码", requiredMode = Schema.RequiredMode.REQUIRED, example = "Admin@q121")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String password;
    //用户昵称
    @Schema(description = "用户昵称", requiredMode = Schema.RequiredMode.REQUIRED, example = "小博主")
    @NotBlank(message = "用户昵称不能为空")
    private String userNickname;
    //用户联系方式
    @Schema(description = "用户联系方式", requiredMode = Schema.RequiredMode.REQUIRED, example = "13008797889")
    @Mobile
    private String  userPhone;
    //用户性别
    @Schema(description = "用户性别，参见 SexEnum 枚举类", example = "1")
    private Integer userSex;
    //用户年龄
    @Schema(description = "用户年龄", requiredMode = Schema.RequiredMode.REQUIRED, example = "22")
    private Integer userAge;
    //用户地址
    @Schema(description = "用户地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "北京市")
    private String userAddress;
}
