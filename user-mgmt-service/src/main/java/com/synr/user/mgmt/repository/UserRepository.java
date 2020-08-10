/**
 * 
 */
package com.synr.user.mgmt.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.synr.user.mgmt.entity.UserEntity;

/**
 * The database repository for the {@link UserEntity} entity
 *
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	Optional<UserEntity> findByUserName(String userName);

}
