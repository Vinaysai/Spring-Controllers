package com.nt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.StudentCommand;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(StudentCommand.class);
	}

	@Override
	public void validate(Object cmd, Errors errors) {
		StudentCommand command=null;
		//typecasting
		command=(StudentCommand)cmd;
		//form validations
				if(command.getSno()<=0)
					errors.rejectValue("sno", "sno.invalid");
				if(command.getSname()=="")
					errors.rejectValue("sname", "sname.required");
				if(command.getSadd()=="")
					errors.rejectValue("sadd", "sadd.required");
				

		
	}

}
