package com.plm.platform.module.bpm.convert.definition;

import com.plm.platform.module.bpm.controller.admin.definition.vo.form.BpmFormCreateReqVO;
import com.plm.platform.module.bpm.controller.admin.definition.vo.form.BpmFormRespVO;
import com.plm.platform.module.bpm.controller.admin.definition.vo.form.BpmFormSimpleRespVO;
import com.plm.platform.module.bpm.controller.admin.definition.vo.form.BpmFormUpdateReqVO;
import com.plm.platform.module.bpm.dal.dataobject.definition.BpmFormDO;
import com.plm.platform.framework.common.pojo.PageResult;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 动态表单 Convert
 *
 * @author PDM
 */
@Mapper
public interface BpmFormConvert {

    BpmFormConvert INSTANCE = Mappers.getMapper(BpmFormConvert.class);

    BpmFormDO convert(BpmFormCreateReqVO bean);

    BpmFormDO convert(BpmFormUpdateReqVO bean);

    BpmFormRespVO convert(BpmFormDO bean);

    List<BpmFormSimpleRespVO> convertList2(List<BpmFormDO> list);

    PageResult<BpmFormRespVO> convertPage(PageResult<BpmFormDO> page);

}
