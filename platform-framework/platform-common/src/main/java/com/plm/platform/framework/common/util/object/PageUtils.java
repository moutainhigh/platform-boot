package com.plm.platform.framework.common.util.object;

import com.plm.platform.framework.common.pojo.PageParam;

/**
 * {@link com.plm.platform.framework.common.pojo.PageParam} 工具类
 *
 * @author PDM
 */
public class PageUtils {

    public static int getStart(PageParam pageParam) {
        return (pageParam.getPageNo() - 1) * pageParam.getPageSize();
    }

}
