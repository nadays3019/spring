package org.kg.myapp.loginmember.model.dao;

import org.kg.myapp.loginmember.model.vo.LoginMemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginMemberService implements ILoginMemberService {

	@Autowired
	ILoginMemberRepository loginMemberRepository;
	
	@Override
	public void insertId(LoginMemberVO loginMembervo) {
		loginMemberRepository.insertId(loginMembervo);

	}

}
