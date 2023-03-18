package com.plm.platform.module.promotion.convert.coupon;

import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.module.promotion.controller.admin.coupon.vo.coupon.CouponPageItemRespVO;
import com.plm.platform.module.promotion.dal.dataobject.coupon.CouponDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 优惠劵 Convert
 *
 * @author PDM
 */
@Mapper
public interface CouponConvert {

    CouponConvert INSTANCE = Mappers.getMapper(CouponConvert.class);

    PageResult<CouponPageItemRespVO> convertPage(PageResult<CouponDO> page);

}
