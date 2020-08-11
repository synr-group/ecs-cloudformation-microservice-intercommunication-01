package com.synr.user.mgmt.dto;

import lombok.Data;

@Data
public class ConsentDto {
	private Long id;
	private String objectID;
	private String type;
	private String name;

	private String description;
}
