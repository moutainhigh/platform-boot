package com.plm.platform.module.pay.api.order;

import com.plm.platform.module.pay.api.order.dto.PayOrderCreateReqDTO;
import com.plm.platform.module.pay.api.order.dto.PayOrderRespDTO;
import com.plm.platform.module.pay.convert.order.PayOrderConvert;
import com.plm.platform.module.pay.dal.dataobject.order.PayOrderDO;
import com.plm.platform.module.pay.service.order.PayOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 支付单 API 实现类
 *
 * @author PDM
 */
@Service
public class PayOrderApiImpl implements PayOrderApi {

    @Resource
    private PayOrderService payOrderService;

    @Override
    public Long createOrder(PayOrderCreateReqDTO reqDTO) {
        return payOrderService.createPayOrder(reqDTO);
    }

    @Override
    public PayOrderRespDTO getOrder(Long id) {
        PayOrderDO order = payOrderService.getOrder(id);
        return PayOrderConvert.INSTANCE.convert2(order);
    }

}
