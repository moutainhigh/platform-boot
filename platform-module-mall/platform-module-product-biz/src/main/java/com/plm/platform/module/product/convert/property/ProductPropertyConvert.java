package com.plm.platform.module.product.convert.property;

import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.framework.common.util.collection.CollectionUtils;
import com.plm.platform.module.product.controller.admin.property.vo.property.ProductPropertyAndValueRespVO;
import com.plm.platform.module.product.controller.admin.property.vo.property.ProductPropertyCreateReqVO;
import com.plm.platform.module.product.controller.admin.property.vo.property.ProductPropertyRespVO;
import com.plm.platform.module.product.controller.admin.property.vo.property.ProductPropertyUpdateReqVO;
import com.plm.platform.module.product.dal.dataobject.property.ProductPropertyDO;
import com.plm.platform.module.product.dal.dataobject.property.ProductPropertyValueDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

/**
 * 属性项 Convert
 *
 * @author PDM
 */
@Mapper
public interface ProductPropertyConvert {

    ProductPropertyConvert INSTANCE = Mappers.getMapper(ProductPropertyConvert.class);

    ProductPropertyDO convert(ProductPropertyCreateReqVO bean);

    ProductPropertyDO convert(ProductPropertyUpdateReqVO bean);

    ProductPropertyRespVO convert(ProductPropertyDO bean);

    List<ProductPropertyRespVO> convertList(List<ProductPropertyDO> list);

    PageResult<ProductPropertyRespVO> convertPage(PageResult<ProductPropertyDO> page);

    default List<ProductPropertyAndValueRespVO> convertList(List<ProductPropertyDO> keys, List<ProductPropertyValueDO> values) {
        Map<Long, List<ProductPropertyValueDO>> valueMap = CollectionUtils.convertMultiMap(values, ProductPropertyValueDO::getPropertyId);
        return CollectionUtils.convertList(keys, key -> {
            ProductPropertyAndValueRespVO respVO = convert02(key);
            respVO.setValues(convertList02(valueMap.get(key.getId())));
            return respVO;
        });
    }
    ProductPropertyAndValueRespVO convert02(ProductPropertyDO bean);
    List<ProductPropertyAndValueRespVO.Value> convertList02(List<ProductPropertyValueDO> list);

}
