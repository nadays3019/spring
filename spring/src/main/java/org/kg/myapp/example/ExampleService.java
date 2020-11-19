package org.kg.myapp.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

	@Autowired
	ExampleRepository exampleRepository;
	
	public String example() {
		return exampleRepository.example();
		
	}
}
