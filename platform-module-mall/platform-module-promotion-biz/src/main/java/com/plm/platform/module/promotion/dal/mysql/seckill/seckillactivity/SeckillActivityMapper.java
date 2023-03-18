package com.plm.platform.module.promotion.dal.mysql.seckill.seckillactivity;

import cn.hutool.core.util.ObjectUtil;
import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.framework.mybatis.core.mapper.BaseMapperX;
import com.plm.platform.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.plm.platform.module.promotion.controller.admin.seckill.vo.activity.SeckillActivityPageReqVO;
import com.plm.platform.module.promotion.dal.dataobject.seckill.seckillactivity.SeckillActivityDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动 Mapper
 *
 * @author halfninety
 */
@Mapper
public interface SeckillActivityMapper extends BaseMapperX<SeckillActivityDO> {
    default PageResult<SeckillActivityDO> selectPage(SeckillActivityPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SeckillActivityDO>()
                .likeIfPresent(SeckillActivityDO::getName, reqVO.getName())
                .eqIfPresent(SeckillActivityDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(SeckillActivityDO::getCreateTime, reqVO.getCreateTime())
                .apply(ObjectUtil.isNotNull(reqVO.getTimeId()),"FIND_IN_SET(" + reqVO.getTimeId() + ",time_ids) > 0")
                .orderByDesc(SeckillActivityDO::getId));
    }
}
