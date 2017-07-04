package com.thoughtworks.petstore.web.service.account;

import com.thoughtworks.petstore.web.service.account.dto.UserPo;
import com.thoughtworks.petstore.web.service.account.dto.UserWithIdPo;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFeignClientFallback implements UserServiceFeignClient {

	@Override
	public UserWithIdPo getUser(Long userId) {
		return null;
	}

	@Override
	public UserWithIdPo updateUser(UserPo userPo) {
		return null;
	}

	@Override
	public UserWithIdPo createUser(UserPo userPo) {
		return null;
	}

    @Override
    public UserWithIdPo matchUserCredential(String name, String pass) {
        return null;
    }

}
