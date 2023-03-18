package com.plm.platform.module.pay.convert.demo;

import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.module.pay.controller.admin.demo.vo.PayDemoOrderCreateReqVO;
import com.plm.platform.module.pay.controller.admin.demo.vo.PayDemoOrderRespVO;
import com.plm.platform.module.pay.dal.dataobject.demo.PayDemoOrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 示例订单 Convert
 *
 * @author PDM
 */
@Mapper
public interface PayDemoOrderConvert {

    PayDemoOrderConvert INSTANCE = Mappers.getMapper(PayDemoOrderConvert.class);

    PayDemoOrderDO convert(PayDemoOrderCreateReqVO bean);

    PayDemoOrderRespVO convert(PayDemoOrderDO bean);

    PageResult<PayDemoOrderRespVO> convertPage(PageResult<PayDemoOrderDO> page);

}
