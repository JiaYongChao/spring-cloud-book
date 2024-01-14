package com.book.cloud.module.user.controller.admin.user;

import com.book.cloud.framework.common.pojo.CommonResult;
import com.book.cloud.framework.common.pojo.PageResult;
import com.book.cloud.framework.common.util.object.BeanUtils;
import com.book.cloud.framework.operatelog.core.annotations.OperateLog;
import com.book.cloud.module.user.controller.admin.user.vo.*;
import com.book.cloud.module.user.dal.dataobject.BookUserDO;
import com.book.cloud.module.user.service.BookUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import static com.book.cloud.framework.common.pojo.CommonResult.success;

/**
 * @ClassNAME BookUserController
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/14 21:44
 * @Version 1.0
 */
@Tag(name = "管理后台 - 图书用户")
@RestController
@RequestMapping("/book/user")
@Validated
public class BookUserController {


    @Resource
    private BookUserService bookUserService;
    @PutMapping("/update")
    @Operation(summary = "修改图书用户")
    public CommonResult<Boolean> updateBookUser(@Valid @RequestBody BookUserSaveReqVO updateReqVO) {
        bookUserService.updateBookUser(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除图书用户")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<Boolean> deleteNotice(@RequestParam("id") Long id) {
        bookUserService.deleteBookUser(id);
        return success(true);
    }

    @GetMapping("/page")
    @Operation(summary = "获取图书用户列表")
    public CommonResult<PageResult<BookUserRespVO>> getBookUserPage(@Validated BookUserPageReqVO pageReqVO) {
        PageResult<BookUserDO> pageResult = bookUserService.getBookUserPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, BookUserRespVO.class));
    }


    @PostMapping("/loginBook")
    @Operation(summary = "图书用户登录")
    public CommonResult<BookLoginRespVO> bookUserLogin(@RequestBody @Valid BookLoginReqVO reqVO) {
        return success(bookUserService.bookUserLogin(reqVO));
    }

    @PostMapping("/registerUser")
    @Operation(summary = "图书注册")
    public CommonResult<Boolean> registerUser(@RequestBody @Valid BookUserSaveReqVO reqVO){
        bookUserService.registerUser(reqVO);
        return success(true);
    }
}
