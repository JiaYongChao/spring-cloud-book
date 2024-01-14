package com.book.cloud.module.book.lend.dal.mysql;

import com.book.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.book.cloud.module.book.lend.dal.dataobject.BookLendRecordsDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassNAME BookLendRecordsMapper
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/13 21:13
 * @Version 1.0
 */
@Mapper
public interface BookLendRecordsMapper extends BaseMapperX<BookLendRecordsDO> {
}
