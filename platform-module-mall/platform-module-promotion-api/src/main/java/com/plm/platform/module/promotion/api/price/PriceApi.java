package com.plm.platform.module.promotion.api.price;

import com.plm.platform.module.promotion.api.price.dto.PriceCalculateReqDTO;
import com.plm.platform.module.promotion.api.price.dto.PriceCalculateRespDTO;

/**
 * 价格 API 接口
 *
 * @author PDM
 */
public interface PriceApi {

    /**
     * 计算商品的价格
     *
     * @param calculateReqDTO 价格请求
     * @return 价格相应
     */
    PriceCalculateRespDTO calculatePrice(PriceCalculateReqDTO calculateReqDTO);

}
