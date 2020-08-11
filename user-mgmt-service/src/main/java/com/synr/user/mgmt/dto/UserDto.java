package com.synr.user.mgmt.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class UserDto {

	private Long id;
	private String objectID;
	private Set<GroupDto> groups = new HashSet<GroupDto>();
	private String name;
	private String userName;
	private String password;
	private Boolean blockSign;
	private String firstName;
	private String lastName;
	private String jobTitle;
	private String department;
	private String lastUsageLocation;
	private String streetAddress;
	private String state;
	private String country;
	private String physicalDeliveryOfficeName;
	private String city;
	private String postalCode;
	private String officePhone;
	private String mobilePhone;

}
