package com.plm.platform.module.infra.dal.mysql.db;

import com.plm.platform.framework.mybatis.core.mapper.BaseMapperX;
import com.plm.platform.module.infra.dal.dataobject.db.DataSourceConfigDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据源配置 Mapper
 *
 * @author PDM
 */
@Mapper
public interface DataSourceConfigMapper extends BaseMapperX<DataSourceConfigDO> {
}
