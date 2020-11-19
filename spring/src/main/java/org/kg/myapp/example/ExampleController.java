package org.kg.myapp.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ExampleController {

	@Autowired
	ExampleService exampleService;
	
	public void runExample() {
		System.out.println(exampleService.example());
	}
	
}
