/**
 * 
 */
package com.synr.user.mgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.synr.user.mgmt.entity.RoleEntity;

/**
 * The database repository for the {@link RoleEntity} entity
 *
 */
@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

}
