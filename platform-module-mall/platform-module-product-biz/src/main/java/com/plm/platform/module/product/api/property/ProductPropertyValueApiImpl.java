package com.plm.platform.module.product.api.property;

import com.plm.platform.module.product.api.property.dto.ProductPropertyValueDetailRespDTO;
import com.plm.platform.module.product.convert.propertyvalue.ProductPropertyValueConvert;
import com.plm.platform.module.product.service.property.ProductPropertyValueService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 商品属性值 API 实现类
 *
 * @author PDM
 */
@Service
@Validated
public class ProductPropertyValueApiImpl implements ProductPropertyValueApi {

    @Resource
    private ProductPropertyValueService productPropertyValueService;

    @Override
    public List<ProductPropertyValueDetailRespDTO> getPropertyValueDetailList(Collection<Long> ids) {
        return ProductPropertyValueConvert.INSTANCE.convertList02(
                productPropertyValueService.getPropertyValueDetailList(ids));
    }

}
