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
@Table(name = "consent")
@Getter
@Setter
public class ConsentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String objectID;
	
	@Column(nullable = false, unique = true)
	private String type;
	@Column(nullable = false, unique = true)
	private String name;

	private String description;
}
