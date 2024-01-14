package com.book.cloud.module.user.service;

import com.book.cloud.framework.common.pojo.PageResult;
import com.book.cloud.module.user.controller.admin.user.vo.BookLoginReqVO;
import com.book.cloud.module.user.controller.admin.user.vo.BookLoginRespVO;
import com.book.cloud.module.user.controller.admin.user.vo.BookUserPageReqVO;
import com.book.cloud.module.user.controller.admin.user.vo.BookUserSaveReqVO;
import com.book.cloud.module.user.dal.dataobject.BookUserDO;

/**
 * @ClassNAME BookUserService
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/14 21:59
 * @Version 1.0
 */
public interface BookUserService {

    /**
     * @description: 图书用户分页查询
     * @author: JiaYongChao
     * @date: 2024/1/14 22:06
     * @param: [pageReqVO]
     * @return: com.book.cloud.framework.common.pojo.PageResult<com.book.cloud.module.user.dal.dataobject.BookUserDO>
     **/
    PageResult<BookUserDO> getBookUserPage(BookUserPageReqVO pageReqVO);

    /**
     * @description: 更新图书用户
     * @author: JiaYongChao
     * @date: 2024/1/14 22:06
     * @param: [updateReqVO]
     * @return: void
     **/
    void updateBookUser(BookUserSaveReqVO updateReqVO);

    /**
     * @description: 删除图书用户
     * @author: JiaYongChao
     * @date: 2024/1/14 22:06
     * @param: [userId]
     * @return: void
     **/
    void deleteBookUser(Long userId);

    /**
     * @description: 注册图书用户
     * @author: JiaYongChao
     * @date: 2024/1/14 22:07
     * @param: [reqVO]
     * @return: void
     **/
    boolean registerUser(BookUserSaveReqVO reqVO);

    /**
     * @description: 图书用户登录
     * @author: JiaYongChao
     * @date: 2024/1/14 22:07
     * @param: [reqVO]
     * @return: boolean
     **/
    BookLoginRespVO bookUserLogin(BookLoginReqVO reqVO);

    /**
     * @description: 根据用户名查询
     * @author: JiaYongChao
     * @date: 2024/1/14 22:22
     * @param: [username]
     * @return: com.book.cloud.module.user.dal.dataobject.BookUserDO
     **/
    BookUserDO getUserByUsername(String username);

    /**
     * 判断密码是否匹配
     *
     * @param rawPassword 未加密的密码
     * @param encodedPassword 加密后的密码
     * @return 是否匹配
     */
    boolean isPasswordMatch(String rawPassword, String encodedPassword);
}
