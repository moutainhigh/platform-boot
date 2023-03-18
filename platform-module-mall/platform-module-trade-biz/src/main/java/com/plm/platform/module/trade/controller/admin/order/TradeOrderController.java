package com.plm.platform.module.trade.controller.admin.order;

import cn.hutool.core.collection.CollUtil;
import com.plm.platform.framework.common.pojo.CommonResult;
import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.module.member.api.user.MemberUserApi;
import com.plm.platform.module.member.api.user.dto.MemberUserRespDTO;
import com.plm.platform.module.product.api.property.ProductPropertyValueApi;
import com.plm.platform.module.product.api.property.dto.ProductPropertyValueDetailRespDTO;
import com.plm.platform.module.trade.controller.admin.order.vo.TradeOrderDeliveryReqVO;
import com.plm.platform.module.trade.controller.admin.order.vo.TradeOrderDetailRespVO;
import com.plm.platform.module.trade.controller.admin.order.vo.TradeOrderPageItemRespVO;
import com.plm.platform.module.trade.controller.admin.order.vo.TradeOrderPageReqVO;
import com.plm.platform.module.trade.convert.order.TradeOrderConvert;
import com.plm.platform.module.trade.dal.dataobject.order.TradeOrderDO;
import com.plm.platform.module.trade.dal.dataobject.order.TradeOrderItemDO;
import com.plm.platform.module.trade.service.order.TradeOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.plm.platform.framework.common.pojo.CommonResult.success;
import static com.plm.platform.framework.common.util.collection.CollectionUtils.convertSet;
import static com.plm.platform.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

@Tag(name = "管理后台 - 交易订单")
@RestController
@RequestMapping("/trade/order")
@Validated
@Slf4j
public class TradeOrderController {

    @Resource
    private TradeOrderService tradeOrderService;

    @Resource
    private ProductPropertyValueApi productPropertyValueApi;
    @Resource
    private MemberUserApi memberUserApi;

    @GetMapping("/page")
    @Operation(summary = "获得交易订单分页")
    @PreAuthorize("@ss.hasPermission('trade:order:query')")
    public CommonResult<PageResult<TradeOrderPageItemRespVO>> getOrderPage(TradeOrderPageReqVO reqVO) {
        // 查询订单
        PageResult<TradeOrderDO> pageResult = tradeOrderService.getOrderPage(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(PageResult.empty());
        }
        // 查询订单项
        List<TradeOrderItemDO> orderItems = tradeOrderService.getOrderItemListByOrderId(
                convertSet(pageResult.getList(), TradeOrderDO::getId));
        // 查询商品属性
        List<ProductPropertyValueDetailRespDTO> propertyValueDetails = productPropertyValueApi
                .getPropertyValueDetailList(TradeOrderConvert.INSTANCE.convertPropertyValueIds(orderItems));
        // 最终组合
        return success(TradeOrderConvert.INSTANCE.convertPage(pageResult, orderItems, propertyValueDetails));
    }

    @GetMapping("/get-detail")
    @Operation(summary = "获得交易订单详情")
    @Parameter(name = "id", description = "订单编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('trade:order:query')")
    public CommonResult<TradeOrderDetailRespVO> getOrderDetail(@RequestParam("id") Long id) {
        // 查询订单
        TradeOrderDO order = tradeOrderService.getOrder(id);
        // 查询订单项
        List<TradeOrderItemDO> orderItems = tradeOrderService.getOrderItemListByOrderId(id);
        // 查询商品属性
        List<ProductPropertyValueDetailRespDTO> propertyValueDetails = productPropertyValueApi
                .getPropertyValueDetailList(TradeOrderConvert.INSTANCE.convertPropertyValueIds(orderItems));
        // 查询会员
        MemberUserRespDTO user = memberUserApi.getUser(order.getUserId());
        // 最终组合
        return success(TradeOrderConvert.INSTANCE.convert(order, orderItems, propertyValueDetails, user));
    }

    @PostMapping("/delivery")
    @Operation(summary = "发货订单")
    @PreAuthorize("@ss.hasPermission('trade:order:delivery')")
    public CommonResult<Boolean> deliveryOrder(@RequestBody TradeOrderDeliveryReqVO deliveryReqVO) {
        tradeOrderService.deliveryOrder(getLoginUserId(), deliveryReqVO);
        return success(true);
    }

}
