package com.synr.user.mgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String platformId;

	@Column(nullable = false)
	// [displayName] Required
	private String name;

	@Column(nullable = false, unique = true)
	// [userPrincipalName] Required
	private String userName;
	// [passwordProfile] Required
	@Column(nullable = false)
	private String password;
	// [accountEnabled] Required
	private Boolean blockSign;

	// [givenName]
	private String firstName;
	// [surname]
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
