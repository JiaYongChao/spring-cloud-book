package com.book.cloud.module.infra.dal.mysql.db;

import com.book.cloud.framework.mybatis.core.mapper.BaseMapperX;
import com.book.cloud.module.infra.dal.dataobject.db.DataSourceConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源配置 Mapper
 *
 * @author JiaYongChao
 */
@Mapper
public interface DataSourceConfigMapper extends BaseMapperX<DataSourceConfigDO> {
}
