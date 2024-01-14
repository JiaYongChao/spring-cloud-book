package com.book.cloud.module.user.dal.mysql;

import com.book.cloud.framework.common.pojo.PageResult;
import com.book.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.book.cloud.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.book.cloud.module.user.controller.admin.user.vo.BookUserPageReqVO;
import com.book.cloud.module.user.dal.dataobject.BookUserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassNAME BookUserMapper
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/14 21:36
 * @Version 1.0
 */
@Mapper
public interface BookUserMapper extends BaseMapperX<BookUserDO> {
    BookUserDO selectByUsername(String username);

    default PageResult<BookUserDO> selectPage(BookUserPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BookUserDO>()
                .likeIfPresent(BookUserDO::getUserName, reqVO.getUserName())
                .likeIfPresent(BookUserDO::getUserPhone, reqVO.getUserPhone())
                .orderByDesc(BookUserDO::getUserId));
    }
}
