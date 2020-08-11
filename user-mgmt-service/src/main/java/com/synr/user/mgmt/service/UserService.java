package com.synr.user.mgmt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.synr.user.mgmt.common.Utils;
import com.synr.user.mgmt.converter.UserDtoConverter;
import com.synr.user.mgmt.dto.UserDto;
import com.synr.user.mgmt.entity.UserEntity;
import com.synr.user.mgmt.repository.UserRepository;

@Service

@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private UserDtoConverter userDtoConverter;

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

	/**
	 * Retrieves an entity by its objectID.
	 *
	 * @param objectID must not be {@literal null}.
	 * @return the entity {@link UserDto} with the given objectID or
	 *         {@link ResponseStatusException} if none found.
	 * @throws ResponseStatusException if {@literal objectID} is Not found
	 */
	public UserDto findByObjectID(String objectID) {

		Optional<UserEntity> user = userRepository.findByObjectID(objectID);
		if (user.isPresent()) {
			return userDtoConverter.convertEntityToPojo(user.get());
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "USER NOT FOUND !!!");
	}

	/**
	 * Retrieves an entity by its userName and password.
	 *
	 * @param userName must not be {@literal null}.
	 * @param password must not be {@literal null}.
	 * @return the entity {@link UserDto} with the given userName or password
	 *         {@link ResponseStatusException} if none found.
	 * @throws ResponseStatusException if {@literal apiUserName} is Not found
	 */
	public UserDto findByUserNameAndPassword(String userName, String password) {

		Optional<UserEntity> user = userRepository.findByUserNameAndPassword(userName, password);
		if (user.isPresent()) {
			return userDtoConverter.convertEntityToPojo(user.get());
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "USER NOT FOUND !!!");
	}

	/**
	 * Saves a given entity {@link UserDto}. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 *
	 * @param UserDto must not be {@literal null}.
	 * @return the saved entity {@link UserDto}; will never be {@literal null}.
	 * @throws ResponseStatusException in case the given {@literal entity} is
	 *                                 {@literal null}.
	 */
	public UserDto save(UserDto userDto) {
		UserEntity userEntity = userDtoConverter.convertPojoToEntity(userDto);
		userEntity.setObjectID(Utils.createObjectIdentifier());
		UserEntity result;
		try {
			result = userRepository.save(userEntity);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, e.getMessage());
		}

		return userDtoConverter.convertEntityToPojo(result);
	}

	/**
	 * Updates a given entity {@link UserDto}. Use the returned instance for further
	 * operations as the save operation might have changed the entity instance
	 * completely.
	 * 
	 * @param UserDto must not be {@literal null}.
	 * @return the updated entity {@link UserDto}; will never be {@literal null}.
	 * @throws ResponseStatusException in case the given {@literal entity} is
	 *                                 {@literal null}.
	 */
	public UserDto update(UserDto userDto) {
		UserEntity userEntityFromRequest = userDtoConverter.convertPojoToEntity(userDto);
		Optional<UserEntity> userEntityFromDB = userRepository.findByUserName(userDto.getUserName());
		if (userEntityFromDB.isPresent()) {
			userEntityFromRequest.setId(userEntityFromDB.get().getId());
			userEntityFromRequest.setObjectID(userEntityFromDB.get().getObjectID());
			return userDtoConverter.convertEntityToPojo(userRepository.save(userEntityFromRequest));
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with UserObjecyID Not Found!!!");
	}

}
