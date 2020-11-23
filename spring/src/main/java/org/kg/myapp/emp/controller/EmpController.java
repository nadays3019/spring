package org.kg.myapp.emp.controller;

import org.kg.myapp.emp.model.dao.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/emp")
public class EmpController {

	
	@Autowired
	IEmpService empService;
	
	
	@GetMapping(value="/")
	public String empMain() {
		return "emp/home";
	}
	
	@GetMapping(value="/count")
	public String empCount(@RequestParam(value="deptId", required=false, defaultValue="0") int deptId, Model model) {
		
		if(deptId ==0) {
			model.addAttribute("count",empService.getEmpCount());
		}else {
			model.addAttribute("count",empService.getEmpCount(deptId));
		}
		return "emp/count";
	}
	
}
