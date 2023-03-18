package com.plm.platform.module.member.convert.address;

import com.plm.platform.framework.common.pojo.PageResult;
import com.plm.platform.module.member.api.address.dto.AddressRespDTO;
import com.plm.platform.module.member.controller.app.address.vo.AppAddressCreateReqVO;
import com.plm.platform.module.member.controller.app.address.vo.AppAddressRespVO;
import com.plm.platform.module.member.controller.app.address.vo.AppAddressUpdateReqVO;
import com.plm.platform.module.member.dal.dataobject.address.AddressDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户收件地址 Convert
 *
 * @author PDM
 */
@Mapper
public interface AddressConvert {

    AddressConvert INSTANCE = Mappers.getMapper(AddressConvert.class);

    AddressDO convert(AppAddressCreateReqVO bean);

    AddressDO convert(AppAddressUpdateReqVO bean);

    AppAddressRespVO convert(AddressDO bean);

    List<AppAddressRespVO> convertList(List<AddressDO> list);

    PageResult<AppAddressRespVO> convertPage(PageResult<AddressDO> page);

    AddressRespDTO convert02(AddressDO bean);

}
