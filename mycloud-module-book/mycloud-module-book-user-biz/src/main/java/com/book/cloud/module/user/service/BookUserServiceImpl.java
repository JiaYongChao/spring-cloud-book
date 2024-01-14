package com.book.cloud.module.user.service;

import com.book.cloud.framework.common.enums.UserTypeEnum;
import com.book.cloud.framework.common.pojo.CommonResult;
import com.book.cloud.framework.common.pojo.PageResult;
import com.book.cloud.framework.common.util.object.BeanUtils;
import com.book.cloud.module.system.api.oauth2.OAuth2TokenApi;
import com.book.cloud.module.system.api.oauth2.dto.OAuth2AccessTokenCreateReqDTO;
import com.book.cloud.module.system.api.oauth2.dto.OAuth2AccessTokenRespDTO;
import com.book.cloud.module.system.enums.logger.LoginLogTypeEnum;
import com.book.cloud.module.system.enums.logger.LoginResultEnum;
import com.book.cloud.module.system.enums.oauth2.OAuth2ClientConstants;
import com.book.cloud.module.user.controller.admin.user.vo.BookLoginReqVO;
import com.book.cloud.module.user.controller.admin.user.vo.BookLoginRespVO;
import com.book.cloud.module.user.controller.admin.user.vo.BookUserPageReqVO;
import com.book.cloud.module.user.controller.admin.user.vo.BookUserSaveReqVO;
import com.book.cloud.module.user.dal.dataobject.BookUserDO;
import com.book.cloud.module.user.dal.mysql.BookUserMapper;
import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.book.cloud.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.book.cloud.module.system.enums.ErrorCodeConstants.*;
import static com.book.cloud.module.system.enums.ErrorCodeConstants.AUTH_LOGIN_BAD_CREDENTIALS;

/**
 * @ClassNAME BookUserServiceImpl
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/14 21:59
 * @Version 1.0
 */
@Service
@Slf4j
public class BookUserServiceImpl implements  BookUserService{

    @Resource
    private BookUserMapper bookUserMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private OAuth2TokenApi oAuth2TokenApi;

    @Override
    public PageResult<BookUserDO> getBookUserPage(BookUserPageReqVO pageReqVO) {
        return bookUserMapper.selectPage(pageReqVO);
    }

    @Override
    public void updateBookUser(BookUserSaveReqVO updateReqVO) {
        // 校验是否存在
        validateNoticeExists(updateReqVO.getUserId());
        // 更新图书用户
        BookUserDO updateObj = BeanUtils.toBean(updateReqVO, BookUserDO.class);
        bookUserMapper.updateById(updateObj);
    }

    @Override
    public void deleteBookUser(Long userId) {
        // 校验是否存在
        validateNoticeExists(userId);
        // 删除图书用户
        bookUserMapper.deleteById(userId);
    }

    @Override
    public boolean registerUser(BookUserSaveReqVO reqVO) {
        // 校验是否存在
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("user_name",reqVO.getUserName());
        List<BookUserDO> bookUserList = bookUserMapper.selectByMap(queryMap);
        if (bookUserList != null && bookUserList.size()>0) {
            throw exception(BOOK_USER_EXISTS);
        }
        BookUserDO  bookUser = BeanUtils.toBean(reqVO, BookUserDO.class);
        bookUser.setPassword(encodePassword(reqVO.getPassword())); // 加密密码
        bookUserMapper.insert(bookUser);
        return true;
    }

    @Override
    public BookLoginRespVO bookUserLogin(BookLoginReqVO reqVO) {
        // 校验账号是否存在
        BookUserDO user = getUserByUsername(reqVO.getUsername());
        if (user == null) {
            throw exception(AUTH_LOGIN_BAD_CREDENTIALS);
        }
        if (!isPasswordMatch(reqVO.getPassword(), user.getPassword())) {
            throw exception(AUTH_LOGIN_BAD_CREDENTIALS);
        }
        // 创建登录Token 令牌
        OAuth2AccessTokenCreateReqDTO oAuth2AccessTokenCreateReqDTO = new OAuth2AccessTokenCreateReqDTO();
        oAuth2AccessTokenCreateReqDTO.setUserType(getUserType().getValue());
        oAuth2AccessTokenCreateReqDTO.setUserId(user.getUserId());
        oAuth2AccessTokenCreateReqDTO.setScopes(null);
        oAuth2AccessTokenCreateReqDTO.setClientId("default");
        CommonResult<OAuth2AccessTokenRespDTO> accessTokenRespDTOCommonResult =  oAuth2TokenApi.createAccessToken(oAuth2AccessTokenCreateReqDTO);
        OAuth2AccessTokenRespDTO accessTokenDO = accessTokenRespDTOCommonResult.getData();
        BookLoginRespVO BookLoginRespVO = BeanUtils.toBean(accessTokenDO, BookLoginRespVO.class);
        return BookLoginRespVO;
    }

    @VisibleForTesting
    public void validateNoticeExists(Long userID) {
        if (userID == null) {
            return;
        }
        BookUserDO notice = bookUserMapper.selectById(userID);
        if (notice == null) {
            throw exception(NOTICE_NOT_FOUND);
        }
    }

    @Override
    public BookUserDO getUserByUsername(String username) {
        return bookUserMapper.selectByUsername(username);
    }

    @Override
    public boolean isPasswordMatch(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 对密码进行加密
     *
     * @param password 密码
     * @return 加密后的密码
     */
    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    private UserTypeEnum getUserType() {
        return UserTypeEnum.MEMBER;
    }

}
