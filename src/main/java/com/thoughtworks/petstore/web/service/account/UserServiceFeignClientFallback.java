package com.thoughtworks.petstore.web.service.account;

import com.thoughtworks.petstore.web.service.account.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFeignClientFallback implements UserServiceFeignClient {

	@Override
	public User getUser(Long userId) {
		return null;
	}

	@Override
	public User updateUser(User user) {
		return null;
	}

	@Override
	public User createUser(User user) {
		return null;
	}
}
