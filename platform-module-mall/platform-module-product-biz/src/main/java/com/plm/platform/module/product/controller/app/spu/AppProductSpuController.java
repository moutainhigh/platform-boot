package com.plm.platform.module.product.controller.app.spu;

import com.plm.platform.framework.common.enums.CommonStatusEnum;
import com.plm.platform.framework.common.pojo.CommonResult;
import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.module.product.controller.app.spu.vo.AppProductSpuDetailRespVO;
import com.plm.platform.module.product.controller.app.spu.vo.AppProductSpuPageItemRespVO;
import com.plm.platform.module.product.controller.app.spu.vo.AppProductSpuPageReqVO;
import com.plm.platform.module.product.convert.sku.ProductSkuConvert;
import com.plm.platform.module.product.convert.spu.ProductSpuConvert;
import com.plm.platform.module.product.dal.dataobject.sku.ProductSkuDO;
import com.plm.platform.module.product.dal.dataobject.spu.ProductSpuDO;
import com.plm.platform.module.product.enums.spu.ProductSpuStatusEnum;
import com.plm.platform.module.product.service.property.ProductPropertyValueService;
import com.plm.platform.module.product.service.property.bo.ProductPropertyValueDetailRespBO;
import com.plm.platform.module.product.service.sku.ProductSkuService;
import com.plm.platform.module.product.service.spu.ProductSpuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static com.plm.platform.framework.common.exception.util.ServiceExceptionUtil.exception;
import static com.plm.platform.framework.common.pojo.CommonResult.success;
import static com.plm.platform.module.product.enums.ErrorCodeConstants.SPU_NOT_ENABLE;
import static com.plm.platform.module.product.enums.ErrorCodeConstants.SPU_NOT_EXISTS;

@Tag(name = "用户 APP - 商品 SPU")
@RestController
@RequestMapping("/product/spu")
@Validated
public class AppProductSpuController {

    @Resource
    private ProductSpuService productSpuService;
    @Resource
    private ProductSkuService productSkuService;
    @Resource
    private ProductPropertyValueService productPropertyValueService;

    @GetMapping("/page")
    @Operation(summary = "获得商品 SPU 分页")
    public CommonResult<PageResult<AppProductSpuPageItemRespVO>> getSpuPage(@Valid AppProductSpuPageReqVO pageVO) {
        PageResult<ProductSpuDO> pageResult = productSpuService.getSpuPage(pageVO, ProductSpuStatusEnum.ENABLE.getStatus());
        return success(ProductSpuConvert.INSTANCE.convertPage02(pageResult));
    }

    @GetMapping("/get-detail")
    @Operation(summary = "获得商品 SPU 明细")
    @Parameter(name = "id", description = "编号", required = true)
    public CommonResult<AppProductSpuDetailRespVO> getSpuDetail(@RequestParam("id") Long id) {
        // 获得商品 SPU
        ProductSpuDO spu = productSpuService.getSpu(id);
        if (spu == null) {
            throw exception(SPU_NOT_EXISTS);
        }
        if (!ProductSpuStatusEnum.isEnable(spu.getStatus())) {
            throw exception(SPU_NOT_ENABLE);
        }

        // 查询商品 SKU
        List<ProductSkuDO> skus = productSkuService.getSkuListBySpuIdAndStatus(spu.getId(),
                CommonStatusEnum.ENABLE.getStatus());
        // 查询商品属性
        List<ProductPropertyValueDetailRespBO> propertyValues = productPropertyValueService
                .getPropertyValueDetailList(ProductSkuConvert.INSTANCE.convertPropertyValueIds(skus));
        // 拼接
        return success(ProductSpuConvert.INSTANCE.convert(spu, skus, propertyValues));
    }

}
