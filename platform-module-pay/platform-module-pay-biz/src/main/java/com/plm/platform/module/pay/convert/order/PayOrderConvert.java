package com.plm.platform.module.pay.convert.order;

import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.framework.pay.core.client.dto.order.PayOrderUnifiedReqDTO;
import com.plm.platform.framework.pay.core.client.dto.order.PayOrderUnifiedRespDTO;
import com.plm.platform.module.pay.api.order.dto.PayOrderCreateReqDTO;
import com.plm.platform.module.pay.api.order.dto.PayOrderRespDTO;
import com.plm.platform.module.pay.controller.admin.order.vo.*;
import com.plm.platform.module.pay.controller.app.order.vo.AppPayOrderSubmitReqVO;
import com.plm.platform.module.pay.controller.app.order.vo.AppPayOrderSubmitRespVO;
import com.plm.platform.module.pay.dal.dataobject.order.PayOrderDO;
import com.plm.platform.module.pay.dal.dataobject.order.PayOrderExtensionDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 支付订单 Convert
 *
 * @author aquan
 */
@Mapper
public interface PayOrderConvert {

    PayOrderConvert INSTANCE = Mappers.getMapper(PayOrderConvert.class);

    PayOrderRespVO convert(PayOrderDO bean);

    PayOrderRespDTO convert2(PayOrderDO order);

    PayOrderDetailsRespVO orderDetailConvert(PayOrderDO bean);

    PayOrderDetailsRespVO.PayOrderExtension orderDetailExtensionConvert(PayOrderExtensionDO bean);

    List<PayOrderRespVO> convertList(List<PayOrderDO> list);

    PageResult<PayOrderRespVO> convertPage(PageResult<PayOrderDO> page);

    List<PayOrderExcelVO> convertList02(List<PayOrderDO> list);

    /**
     * 订单 DO 转自定义分页对象
     *
     * @param bean 订单DO
     * @return 分页对象
     */
    PayOrderPageItemRespVO pageConvertItemPage(PayOrderDO bean);

    // TODO 测试：优化下 convert 逻辑
    default PayOrderExcelVO excelConvert(PayOrderDO bean) {
        if (bean == null) {
            return null;
        }

        PayOrderExcelVO payOrderExcelVO = new PayOrderExcelVO();

        payOrderExcelVO.setId(bean.getId());
        payOrderExcelVO.setSubject(bean.getSubject());
        payOrderExcelVO.setMerchantOrderId(bean.getMerchantOrderId());
        payOrderExcelVO.setChannelOrderNo(bean.getChannelOrderNo());
        payOrderExcelVO.setStatus(bean.getStatus());
        payOrderExcelVO.setNotifyStatus(bean.getNotifyStatus());
        payOrderExcelVO.setNotifyUrl(bean.getNotifyUrl());
        payOrderExcelVO.setCreateTime(bean.getCreateTime());
        payOrderExcelVO.setSuccessTime(bean.getSuccessTime());
        payOrderExcelVO.setExpireTime(bean.getExpireTime());
        payOrderExcelVO.setNotifyTime(bean.getNotifyTime());
        payOrderExcelVO.setUserIp(bean.getUserIp());
        payOrderExcelVO.setRefundStatus(bean.getRefundStatus());
        payOrderExcelVO.setRefundTimes(bean.getRefundTimes());
        payOrderExcelVO.setBody(bean.getBody());

        BigDecimal multiple = new BigDecimal(100);

        payOrderExcelVO.setAmount(BigDecimal.valueOf(bean.getAmount())
                .divide(multiple, 2, RoundingMode.HALF_UP).toString());

        payOrderExcelVO.setChannelFeeAmount(BigDecimal.valueOf(bean.getChannelFeeAmount())
                .divide(multiple, 2, RoundingMode.HALF_UP).toString());
        payOrderExcelVO.setChannelFeeRate(java.math.BigDecimal.valueOf(bean.getChannelFeeRate())
                .multiply(multiple).toString());
        payOrderExcelVO.setRefundAmount(BigDecimal.valueOf(bean.getRefundAmount())
                .divide(multiple, 2, RoundingMode.HALF_UP).toString());

        return payOrderExcelVO;
    }

    PayOrderDO convert(PayOrderCreateReqDTO bean);

    @Mapping(target = "id", ignore = true)
    PayOrderExtensionDO convert(PayOrderSubmitReqVO bean, String userIp);

    PayOrderUnifiedReqDTO convert2(PayOrderSubmitReqVO reqVO);

    PayOrderSubmitRespVO convert(PayOrderUnifiedRespDTO bean);

    AppPayOrderSubmitRespVO convert3(PayOrderSubmitRespVO bean);

}
