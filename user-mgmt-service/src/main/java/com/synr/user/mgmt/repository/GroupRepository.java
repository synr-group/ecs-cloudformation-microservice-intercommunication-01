/**
 * 
 */
package com.synr.user.mgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.synr.user.mgmt.entity.GroupEntity;

/**
 * The database repository for the {@link GroupEntity} entity
 *
 */
@Repository
public interface GroupRepository extends CrudRepository<GroupEntity, Long> {

}
