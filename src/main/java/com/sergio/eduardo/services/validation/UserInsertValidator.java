package com.sergio.eduardo.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.sergio.eduardo.dto.UserInsertDTO;
import com.sergio.eduardo.entities.User;
import com.sergio.eduardo.repositories.UserRepository;
import com.sergio.eduardo.services.exceptions.FieldMessage;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {

	
	@Autowired
	private UserRepository repository; 
	
	@Override
	public void initialize(UserInsertValid ann) {
	}

	@Override
	public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>(); 

		User user = repository.findByEmail(dto.getEmail());
		if(user != null) {
			list.add(new FieldMessage("email", "Este email já existe... Inserir outro.")); 
		}
				
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
