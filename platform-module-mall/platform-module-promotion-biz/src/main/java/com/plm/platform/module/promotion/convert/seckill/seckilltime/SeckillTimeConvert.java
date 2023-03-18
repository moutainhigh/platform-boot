package com.plm.platform.module.promotion.convert.seckill.seckilltime;

import java.util.*;

import com.plm.platform.framework.common.pojo.PageResult;

import com.plm.platform.module.promotion.controller.admin.seckill.vo.time.SeckillTimeCreateReqVO;
import com.plm.platform.module.promotion.controller.admin.seckill.vo.time.SeckillTimeRespVO;
import com.plm.platform.module.promotion.controller.admin.seckill.vo.time.SeckillTimeUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.plm.platform.module.promotion.dal.dataobject.seckill.seckilltime.SeckillTimeDO;

/**
 * 秒杀时段 Convert
 *
 * @author PDM
 */
@Mapper
public interface SeckillTimeConvert {

    SeckillTimeConvert INSTANCE = Mappers.getMapper(SeckillTimeConvert.class);

    SeckillTimeDO convert(SeckillTimeCreateReqVO bean);

    SeckillTimeDO convert(SeckillTimeUpdateReqVO bean);

    SeckillTimeRespVO convert(SeckillTimeDO bean);

    List<SeckillTimeRespVO> convertList(List<SeckillTimeDO> list);

    PageResult<SeckillTimeRespVO> convertPage(PageResult<SeckillTimeDO> page);

}
