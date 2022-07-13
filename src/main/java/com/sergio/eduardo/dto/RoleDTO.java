package com.sergio.eduardo.dto;

import java.io.Serializable;

import com.sergio.eduardo.entities.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String authority;

	public RoleDTO() {
	}

	public RoleDTO(Long id, String authority) {
		super();
		this.id = id;
		this.authority = authority;
	}

	public RoleDTO(Role role) {
		super();
		id = role.getId();
		authority = role.getAuthority();
	}
	
}
