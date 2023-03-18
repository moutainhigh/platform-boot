package com.plm.platform.module.product.convert.brand;

import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.module.product.controller.admin.brand.vo.ProductBrandCreateReqVO;
import com.plm.platform.module.product.controller.admin.brand.vo.ProductBrandRespVO;
import com.plm.platform.module.product.controller.admin.brand.vo.ProductBrandUpdateReqVO;
import com.plm.platform.module.product.dal.dataobject.brand.ProductBrandDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 品牌 Convert
 *
 * @author PDM
 */
@Mapper
public interface ProductBrandConvert {

    ProductBrandConvert INSTANCE = Mappers.getMapper(ProductBrandConvert.class);

    ProductBrandDO convert(ProductBrandCreateReqVO bean);

    ProductBrandDO convert(ProductBrandUpdateReqVO bean);

    ProductBrandRespVO convert(ProductBrandDO bean);

    List<ProductBrandRespVO> convertList(List<ProductBrandDO> list);

    PageResult<ProductBrandRespVO> convertPage(PageResult<ProductBrandDO> page);

}
