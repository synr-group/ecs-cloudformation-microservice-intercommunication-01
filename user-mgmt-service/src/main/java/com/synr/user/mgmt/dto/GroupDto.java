package com.synr.user.mgmt.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class GroupDto {

	private Long id;
	private String objectID;
	private String type;
	private String name;

	private String description;

	private Set<UserDto> users = new HashSet<UserDto>();
	private Set<RoleDto> roles = new HashSet<RoleDto>();
	private Set<ConsentDto> consents = new HashSet<ConsentDto>();

}
