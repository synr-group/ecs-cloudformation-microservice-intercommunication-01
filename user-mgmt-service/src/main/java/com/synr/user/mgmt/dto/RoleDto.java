package com.synr.user.mgmt.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class RoleDto {

	private Long id;

	private String objectID;

	private String name;

	private Set<PermissionDto> permissions = new HashSet<PermissionDto>();

}
