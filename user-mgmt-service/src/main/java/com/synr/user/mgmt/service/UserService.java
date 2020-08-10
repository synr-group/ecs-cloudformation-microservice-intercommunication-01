package com.synr.user.mgmt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.synr.user.mgmt.entity.UserEntity;
import com.synr.user.mgmt.repository.UserRepository;

@Service

@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Delete an entity {@link UserEntity} by its userName.
	 *
	 * @param userName must not be {@literal null}.
	 * @throws ResponseStatusException if {@literal userName} is Not found
	 */
	public void delete(String userName) {
		Optional<UserEntity> user = userRepository.findByUserName(userName);
		if (user.isPresent())
			userRepository.delete(user.get());
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "USER NOT FOUND!!!");
	}

}
