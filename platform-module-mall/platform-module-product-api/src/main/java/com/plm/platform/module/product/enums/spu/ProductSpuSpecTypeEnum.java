package com.plm.platform.module.product.enums.spu;

import com.plm.platform.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 商品 SPU 规格类型
 *
 * @author PDM
 */
@Getter
@AllArgsConstructor
public enum ProductSpuSpecTypeEnum implements IntArrayValuable {

    RECYCLE(1, "统一规格"),
    DISABLE(2, "多规格");

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(ProductSpuSpecTypeEnum::getType).toArray();

    /**
     * 规格类型
     */
    private final Integer type;
    /**
     * 规格名称
     */
    private final String name;

    @Override
    public int[] array() {
        return ARRAYS;
    }

}
