package com.plm.platform.module.product.controller.admin.property;

import com.plm.platform.framework.common.pojo.CommonResult;
import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.module.product.controller.admin.property.vo.value.ProductPropertyValueCreateReqVO;
import com.plm.platform.module.product.controller.admin.property.vo.value.ProductPropertyValuePageReqVO;
import com.plm.platform.module.product.controller.admin.property.vo.value.ProductPropertyValueRespVO;
import com.plm.platform.module.product.controller.admin.property.vo.value.ProductPropertyValueUpdateReqVO;
import com.plm.platform.module.product.convert.propertyvalue.ProductPropertyValueConvert;
import com.plm.platform.module.product.service.property.ProductPropertyValueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.plm.platform.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - 商品属性值")
@RestController
@RequestMapping("/product/property/value")
@Validated
public class ProductPropertyValueController {

    @Resource
    private ProductPropertyValueService productPropertyValueService;

    @PostMapping("/create")
    @Operation(summary = "创建属性值")
    @PreAuthorize("@ss.hasPermission('product:property:create')")
    public CommonResult<Long> createProperty(@Valid @RequestBody ProductPropertyValueCreateReqVO createReqVO) {
        return success(productPropertyValueService.createPropertyValue(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新属性值")
    @PreAuthorize("@ss.hasPermission('product:property:update')")
    public CommonResult<Boolean> updateProperty(@Valid @RequestBody ProductPropertyValueUpdateReqVO updateReqVO) {
        productPropertyValueService.updatePropertyValue(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除属性值")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('product:property:delete')")
    public CommonResult<Boolean> deleteProperty(@RequestParam("id") Long id) {
        productPropertyValueService.deletePropertyValue(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得属性值")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('product:property:query')")
    public CommonResult<ProductPropertyValueRespVO> getProperty(@RequestParam("id") Long id) {
        return success(ProductPropertyValueConvert.INSTANCE.convert(productPropertyValueService.getPropertyValue(id)));
    }

    @GetMapping("/page")
    @Operation(summary = "获得属性值分页")
    @PreAuthorize("@ss.hasPermission('product:property:query')")
    public CommonResult<PageResult<ProductPropertyValueRespVO>> getPropertyValuePage(@Valid ProductPropertyValuePageReqVO pageVO) {
        return success(ProductPropertyValueConvert.INSTANCE.convertPage(productPropertyValueService.getPropertyValuePage(pageVO)));
    }
}
