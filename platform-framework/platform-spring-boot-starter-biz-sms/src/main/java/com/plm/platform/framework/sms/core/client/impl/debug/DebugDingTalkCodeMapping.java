package com.plm.platform.framework.sms.core.client.impl.debug;

import com.plm.platform.framework.common.exception.ErrorCode;
import com.plm.platform.framework.common.exception.enums.GlobalErrorCodeConstants;
import com.plm.platform.framework.sms.core.client.SmsCodeMapping;
import com.plm.platform.framework.sms.core.enums.SmsFrameworkErrorCodeConstants;

import java.util.Objects;

/**
 * 钉钉的 SmsCodeMapping 实现类
 *
 * @author PDM
 */
public class DebugDingTalkCodeMapping implements SmsCodeMapping {

    @Override
    public ErrorCode apply(String apiCode) {
        return Objects.equals(apiCode, "0") ? GlobalErrorCodeConstants.SUCCESS : SmsFrameworkErrorCodeConstants.SMS_UNKNOWN;
    }

}
