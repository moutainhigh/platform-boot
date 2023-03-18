package com.plm.platform.module.report.dal.mysql.goview;

import com.plm.platform.framework.common.pojo.PageParam;
import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.framework.mybatis.core.mapper.BaseMapperX;
import com.plm.platform.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.plm.platform.module.report.dal.dataobject.goview.GoViewProjectDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoViewProjectMapper extends BaseMapperX<GoViewProjectDO> {

    default PageResult<GoViewProjectDO> selectPage(PageParam reqVO, Long userId) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GoViewProjectDO>()
                .eq(GoViewProjectDO::getCreator, userId)
                .orderByDesc(GoViewProjectDO::getId));
    }

}
