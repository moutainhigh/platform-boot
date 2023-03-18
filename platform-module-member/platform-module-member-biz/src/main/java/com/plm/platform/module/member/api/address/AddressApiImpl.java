package com.plm.platform.module.member.api.address;

import com.plm.platform.module.member.api.address.dto.AddressRespDTO;
import com.plm.platform.module.member.convert.address.AddressConvert;
import com.plm.platform.module.member.service.address.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * 用户收件地址 API 实现类
 *
 * @author PDM
 */
@Service
@Validated
public class AddressApiImpl implements AddressApi {

    @Resource
    private AddressService addressService;

    @Override
    public AddressRespDTO getAddress(Long id, Long userId) {
        return AddressConvert.INSTANCE.convert02(addressService.getAddress(userId, id));
    }

}
