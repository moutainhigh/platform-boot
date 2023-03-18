package com.plm.platform.module.promotion.service.discount;

import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.module.promotion.controller.admin.discount.vo.DiscountActivityCreateReqVO;
import com.plm.platform.module.promotion.controller.admin.discount.vo.DiscountActivityPageReqVO;
import com.plm.platform.module.promotion.controller.admin.discount.vo.DiscountActivityUpdateReqVO;
import com.plm.platform.module.promotion.dal.dataobject.discount.DiscountActivityDO;
import com.plm.platform.module.promotion.dal.dataobject.discount.DiscountProductDO;
import com.plm.platform.module.promotion.service.discount.bo.DiscountProductDetailBO;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 限时折扣 Service 接口
 *
 * @author PDM
 */
public interface DiscountActivityService {

    /**
     * 基于指定 SKU 编号数组，获得匹配的限时折扣商品
     *
     * 注意，匹配的条件，仅仅是日期符合，并且处于开启状态
     *
     * @param skuIds SKU 编号数组
     * @return 匹配的限时折扣商品
     */
    Map<Long, DiscountProductDetailBO> getMatchDiscountProducts(Collection<Long> skuIds);

    /**
     * 创建限时折扣活动
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createDiscountActivity(@Valid DiscountActivityCreateReqVO createReqVO);

    /**
     * 更新限时折扣活动
     *
     * @param updateReqVO 更新信息
     */
    void updateDiscountActivity(@Valid DiscountActivityUpdateReqVO updateReqVO);

    /**
     * 关闭限时折扣活动
     *
     * @param id 编号
     */
    void closeRewardActivity(Long id);

    /**
     * 删除限时折扣活动
     *
     * @param id 编号
     */
    void deleteDiscountActivity(Long id);

    /**
     * 获得限时折扣活动
     *
     * @param id 编号
     * @return 限时折扣活动
     */
    DiscountActivityDO getDiscountActivity(Long id);

    /**
     * 获得限时折扣活动分页
     *
     * @param pageReqVO 分页查询
     * @return 限时折扣活动分页
     */
    PageResult<DiscountActivityDO> getDiscountActivityPage(DiscountActivityPageReqVO pageReqVO);

    /**
     * 获得活动编号，对应对应的商品列表
     *
     * @param activityId 活动编号
     * @return 活动的商品列表
     */
    List<DiscountProductDO> getDiscountProductsByActivityId(Long activityId);

}