package com.book.cloud.module.user.controller.admin.user.vo;

import com.book.cloud.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static com.book.cloud.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
 * @ClassNAME BookUserPageReqVO
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/14 21:45
 * @Version 1.0
 */
@Schema(description = "管理后台 - 图书用户分页 Request VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BookUserPageReqVO extends PageParam {

    @Schema(description = "用户账号，模糊匹配", example = "mycloud")
    private String userName;

    @Schema(description = "手机号码，模糊匹配", example = "130090090900")
    private String userPhone;

}
