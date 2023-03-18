package com.plm.platform.module.bpm.convert.oa;

import com.plm.platform.module.bpm.controller.admin.oa.vo.BpmOALeaveCreateReqVO;
import com.plm.platform.module.bpm.controller.admin.oa.vo.BpmOALeaveRespVO;
import com.plm.platform.module.bpm.dal.dataobject.oa.BpmOALeaveDO;
import com.plm.platform.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 请假申请 Convert
 *
 * @author PDM
 */
@Mapper
public interface BpmOALeaveConvert {

    BpmOALeaveConvert INSTANCE = Mappers.getMapper(BpmOALeaveConvert.class);

    BpmOALeaveDO convert(BpmOALeaveCreateReqVO bean);

    BpmOALeaveRespVO convert(BpmOALeaveDO bean);

    List<BpmOALeaveRespVO> convertList(List<BpmOALeaveDO> list);

    PageResult<BpmOALeaveRespVO> convertPage(PageResult<BpmOALeaveDO> page);

}
