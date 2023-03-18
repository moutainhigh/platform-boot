package com.plm.platform.module.promotion.convert.coupon;

import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.module.promotion.controller.admin.coupon.vo.template.CouponTemplateCreateReqVO;
import com.plm.platform.module.promotion.controller.admin.coupon.vo.template.CouponTemplateRespVO;
import com.plm.platform.module.promotion.controller.admin.coupon.vo.template.CouponTemplateUpdateReqVO;
import com.plm.platform.module.promotion.dal.dataobject.coupon.CouponTemplateDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 优惠劵模板 Convert
 *
 * @author PDM
 */
@Mapper
public interface CouponTemplateConvert {

    CouponTemplateConvert INSTANCE = Mappers.getMapper(CouponTemplateConvert.class);

    CouponTemplateDO convert(CouponTemplateCreateReqVO bean);

    CouponTemplateDO convert(CouponTemplateUpdateReqVO bean);

    CouponTemplateRespVO convert(CouponTemplateDO bean);

    PageResult<CouponTemplateRespVO> convertPage(PageResult<CouponTemplateDO> page);

}
