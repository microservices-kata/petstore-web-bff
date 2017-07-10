package com.thoughtworks.petstore.web.service.account;

import com.thoughtworks.petstore.web.dto.enums.Gender;
import com.thoughtworks.petstore.web.exception.NoResponseException;
import com.thoughtworks.petstore.web.service.account.dto.UserPo;
import com.thoughtworks.petstore.web.service.account.dto.UserWithIdPo;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFeignClientFallback implements UserServiceFeignClient {

	@Override
	public UserWithIdPo getUser(Long userId) {
		return new UserWithIdPo(0L, "N/A", "Unknown", "N/A", "N/A");
	}

	@Override
	public UserWithIdPo updateUser(UserPo userPo) {
		throw new NoResponseException(500, "account service error when updating account");
	}

	@Override
	public UserWithIdPo createUser(UserPo userPo) {
		throw new NoResponseException(500, "account service error when creating account");
	}

    @Override
    public UserWithIdPo matchUserCredential(String name, String pass) {
		throw new NoResponseException(500, "account service error when matching account");
    }

}
