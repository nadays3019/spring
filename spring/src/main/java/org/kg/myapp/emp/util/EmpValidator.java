package org.kg.myapp.emp.util;

import org.kg.myapp.emp.model.vo.EmpVO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmpValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return EmpVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EmpVO emp =(EmpVO)target;
		if(emp.getEmployeeId() <= 206) {
			errors.rejectValue("employeeId", "emp.employeeId","사원번호는 206 이상이여야합니다!");
		}
		
	}

	
	
}
