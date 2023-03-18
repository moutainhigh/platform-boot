package com.plm.platform.module.member.convert.social;

import com.plm.platform.module.member.controller.app.social.vo.AppSocialUserBindReqVO;
import com.plm.platform.module.member.controller.app.social.vo.AppSocialUserUnbindReqVO;
import com.plm.platform.module.system.api.social.dto.SocialUserBindReqDTO;
import com.plm.platform.module.system.api.social.dto.SocialUserUnbindReqDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SocialUserConvert {

    SocialUserConvert INSTANCE = Mappers.getMapper(SocialUserConvert.class);

    SocialUserBindReqDTO convert(Long userId, Integer userType, AppSocialUserBindReqVO reqVO);

    SocialUserUnbindReqDTO convert(Long userId, Integer userType, AppSocialUserUnbindReqVO reqVO);

}
