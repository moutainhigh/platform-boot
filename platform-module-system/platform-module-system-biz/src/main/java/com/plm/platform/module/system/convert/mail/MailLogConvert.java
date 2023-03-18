package com.plm.platform.module.system.convert.mail;

import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.module.system.controller.admin.mail.vo.log.MailLogRespVO;
import com.plm.platform.module.system.dal.dataobject.mail.MailLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MailLogConvert {

    MailLogConvert INSTANCE = Mappers.getMapper(MailLogConvert.class);

    PageResult<MailLogRespVO> convertPage(PageResult<MailLogDO> pageResult);

    MailLogRespVO convert(MailLogDO bean);

}
