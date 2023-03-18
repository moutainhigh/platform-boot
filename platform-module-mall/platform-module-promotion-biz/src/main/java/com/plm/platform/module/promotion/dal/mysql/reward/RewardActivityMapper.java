package com.plm.platform.module.promotion.dal.mysql.reward;

import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.framework.mybatis.core.mapper.BaseMapperX;
import com.plm.platform.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.plm.platform.module.promotion.controller.admin.reward.vo.RewardActivityPageReqVO;
import com.plm.platform.module.promotion.dal.dataobject.reward.RewardActivityDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * 满减送活动 Mapper
 *
 * @author PDM
 */
@Mapper
public interface RewardActivityMapper extends BaseMapperX<RewardActivityDO> {

    default PageResult<RewardActivityDO> selectPage(RewardActivityPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RewardActivityDO>()
                .likeIfPresent(RewardActivityDO::getName, reqVO.getName())
                .eqIfPresent(RewardActivityDO::getStatus, reqVO.getStatus())
                .orderByDesc(RewardActivityDO::getId));
    }

    default List<RewardActivityDO> selectListByStatus(Collection<Integer> statuses) {
        return selectList(RewardActivityDO::getStatus, statuses);
    }

    default List<RewardActivityDO> selectListByProductScopeAndStatus(Integer productScope, Integer status) {
        return selectList(new LambdaQueryWrapperX<RewardActivityDO>()
                .eq(RewardActivityDO::getProductScope, productScope)
                .eq(RewardActivityDO::getStatus, status));
    }

}
