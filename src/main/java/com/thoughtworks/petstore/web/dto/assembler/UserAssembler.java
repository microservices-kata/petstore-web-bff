package com.thoughtworks.petstore.web.dto.assembler;

import com.thoughtworks.petstore.web.dto.enums.Gender;
import com.thoughtworks.petstore.web.dto.vo.request.UserReq;
import com.thoughtworks.petstore.web.dto.vo.response.UserRes;
import com.thoughtworks.petstore.web.service.account.dto.UserPo;
import com.thoughtworks.petstore.web.service.account.dto.UserWithIdPo;
import org.springframework.stereotype.Component;

@Component
public class UserAssembler {

    public UserPo userReq2UserPo(UserReq userReq) {
        return new UserPo(userReq.getName(), userReq.getPassword(),
                userReq.getGender(), userReq.getEmail(), userReq.getPhone());
    }

    public UserRes userWithIdPo2UserRes(UserWithIdPo userWithIdPo) {
        return new UserRes(userWithIdPo.getUserId().toString(),
                userWithIdPo.getName(), Gender.valueOf(userWithIdPo.getGender()),
                userWithIdPo.getEmail(), userWithIdPo.getPhone());
    }
}