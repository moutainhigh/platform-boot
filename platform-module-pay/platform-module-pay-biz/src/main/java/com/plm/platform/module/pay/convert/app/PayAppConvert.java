package com.plm.platform.module.pay.convert.app;

import java.util.*;

import com.plm.platform.framework.common.pojo.PageResult;

import com.plm.platform.module.pay.controller.admin.merchant.vo.app.*;
import com.plm.platform.module.pay.dal.dataobject.merchant.PayAppDO;
import com.plm.platform.module.pay.dal.dataobject.merchant.PayMerchantDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 支付应用信息 Convert
 *
 * @author PDM
 */
@Mapper
public interface PayAppConvert {

    PayAppConvert INSTANCE = Mappers.getMapper(PayAppConvert.class);

    PayAppPageItemRespVO pageConvert (PayAppDO bean);

    PayAppPageItemRespVO.PayMerchant convert(PayMerchantDO bean);

    PayAppDO convert(PayAppCreateReqVO bean);

    PayAppDO convert(PayAppUpdateReqVO bean);

    PayAppRespVO convert(PayAppDO bean);

    List<PayAppRespVO> convertList(List<PayAppDO> list);

    PageResult<PayAppRespVO> convertPage(PageResult<PayAppDO> page);

    List<PayAppExcelVO> convertList02(List<PayAppDO> list);

}
