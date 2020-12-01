package org.kg.myapp.loginmember.controller;

import org.kg.myapp.loginmember.model.dao.ILoginMemberService;
import org.kg.myapp.loginmember.model.vo.LoginMemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginMemberController {

	@Autowired
	ILoginMemberService loginMemberService;
	
	@PostMapping(value ="/loginmember/insert")
	public String insertId(LoginMemberVO membervo ,Model model) {
		model.addAttribute("insertId");
		
		return "redirect:/loginmemeber/insert";
	}
	
}
