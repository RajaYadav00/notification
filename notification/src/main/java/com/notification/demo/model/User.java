package com.notification.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
@Entity
@Getter
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull(message = "name of should not be null")
	private String name;
	@NotNull(message = "Id should not be null")
	private String email;
}