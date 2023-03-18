package com.plm.platform.module.pay.enums.order;

import com.plm.platform.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付订单的通知状态枚举
 *
 * @author PDM
 */
@Getter
@AllArgsConstructor
public enum PayOrderNotifyStatusEnum implements IntArrayValuable {

    NO(0, "未通知"),
    SUCCESS(10, "通知成功"),
    FAILURE(20, "通知失败")
    ;

    private final Integer status;
    private final String name;

    @Override
    public int[] array() {
        return new int[0];
    }

}