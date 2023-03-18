package com.plm.platform.framework.sms.core.client;

import com.plm.platform.framework.common.exception.ErrorCode;
import com.plm.platform.framework.sms.core.enums.SmsFrameworkErrorCodeConstants;

import java.util.function.Function;

/**
 * 将 API 的错误码，转换为通用的错误码
 *
 * @see SmsCommonResult
 * @see SmsFrameworkErrorCodeConstants
 *
 * @author PDM
 */
public interface SmsCodeMapping extends Function<String, ErrorCode> {
}
