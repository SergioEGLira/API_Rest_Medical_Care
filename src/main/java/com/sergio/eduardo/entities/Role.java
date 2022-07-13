package com.sergio.eduardo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity 
@Table(name = "tb_role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String authority;
	
	public Role() {
	}

	public Role(Long id, String authority) {
		super();
		this.id = id;
		this.authority = authority;
	}
	
}
