package com.plm.platform.module.bpm.dal.mysql.oa;

import com.plm.platform.module.bpm.controller.admin.oa.vo.BpmOALeavePageReqVO;
import com.plm.platform.module.bpm.dal.dataobject.oa.BpmOALeaveDO;
import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.framework.mybatis.core.mapper.BaseMapperX;
import com.plm.platform.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 请假申请 Mapper
 *
 * @author jason
 * @author PDM
 */
@Mapper
public interface BpmOALeaveMapper extends BaseMapperX<BpmOALeaveDO> {

    default PageResult<BpmOALeaveDO> selectPage(Long userId, BpmOALeavePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BpmOALeaveDO>()
                .eqIfPresent(BpmOALeaveDO::getUserId, userId)
                .eqIfPresent(BpmOALeaveDO::getResult, reqVO.getResult())
                .eqIfPresent(BpmOALeaveDO::getType, reqVO.getType())
                .likeIfPresent(BpmOALeaveDO::getReason, reqVO.getReason())
                .betweenIfPresent(BpmOALeaveDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(BpmOALeaveDO::getId));
    }

}
