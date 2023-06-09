package com.plm.platform.module.pay.service.refund;

import com.plm.platform.framework.pay.core.client.dto.notify.PayNotifyReqDTO;
import com.plm.platform.framework.pay.core.client.dto.notify.PayRefundNotifyRespDTO;
import com.plm.platform.module.pay.api.refund.dto.PayRefundCreateReqDTO;
import com.plm.platform.module.pay.controller.admin.refund.vo.PayRefundExportReqVO;
import com.plm.platform.module.pay.controller.admin.refund.vo.PayRefundPageReqVO;
import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.module.pay.dal.dataobject.refund.PayRefundDO;

import java.util.List;

/**
 * 退款订单 Service 接口
 *
 * @author aquan
 */
public interface PayRefundService {

    /**
     * 获得退款订单
     *
     * @param id 编号
     * @return 退款订单
     */
    PayRefundDO getRefund(Long id);

    /**
     * 获得退款订单分页
     *
     * @param pageReqVO 分页查询
     * @return 退款订单分页
     */
    PageResult<PayRefundDO> getRefundPage(PayRefundPageReqVO pageReqVO);

    /**
     * 获得退款订单列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 退款订单列表
     */
    List<PayRefundDO> getRefundList(PayRefundExportReqVO exportReqVO);

    /**
     * 创建退款申请
     *
     * @param reqDTO 退款申请信息
     * @return 退款单号
     */
    Long createPayRefund(PayRefundCreateReqDTO reqDTO);

    /**
     * 渠道的退款通知
     *
     * @param channelId  渠道编号
     * @param notify     通知
     * @param rawNotify  通知数据
     */
    void notifyPayRefund(Long channelId, PayRefundNotifyRespDTO notify, PayNotifyReqDTO rawNotify);

}
