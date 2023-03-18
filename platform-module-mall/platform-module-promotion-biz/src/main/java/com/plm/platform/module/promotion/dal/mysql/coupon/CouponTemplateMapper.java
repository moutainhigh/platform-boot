package com.plm.platform.module.promotion.dal.mysql.coupon;

import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.framework.mybatis.core.mapper.BaseMapperX;
import com.plm.platform.framework.mybatis.core.query.LambdaQueryWrapperX;
import com.plm.platform.module.promotion.controller.admin.coupon.vo.template.CouponTemplatePageReqVO;
import com.plm.platform.module.promotion.dal.dataobject.coupon.CouponTemplateDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 优惠劵模板 Mapper
 *
 * @author PDM
 */
@Mapper
public interface CouponTemplateMapper extends BaseMapperX<CouponTemplateDO> {

    default PageResult<CouponTemplateDO> selectPage(CouponTemplatePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CouponTemplateDO>()
                .likeIfPresent(CouponTemplateDO::getName, reqVO.getName())
                .eqIfPresent(CouponTemplateDO::getStatus, reqVO.getStatus())
                .eqIfPresent(CouponTemplateDO::getDiscountType, reqVO.getDiscountType())
                .betweenIfPresent(CouponTemplateDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CouponTemplateDO::getId));
    }

    void updateTakeCount(@Param("id") Long id, @Param("incrCount") Integer incrCount);

}
