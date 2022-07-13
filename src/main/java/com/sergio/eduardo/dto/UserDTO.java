package com.sergio.eduardo.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.sergio.eduardo.entities.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NonNull
	@Size(min = 3, max = 10, message = "Deve ter entre 3 e 10 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String firstName;
	@NonNull
	@Size(min = 3, max = 10, message = "Deve ter entre 3 e 10 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String lastName;	
	@NotBlank(message = "Email não pode ser vazio")
	@Email(message = "Favor entrar um email válido")
	private String email;

	@Setter(AccessLevel.NONE)
	Set<RoleDTO> roles = new HashSet<>();

	public UserDTO() {
	}

	public UserDTO(Long id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public UserDTO(User entity) {
		this.id = entity.getId();
		this.firstName = entity.getFirstName();
		this.lastName = entity.getLastName();
		this.email = entity.getEmail();
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}
	
}
