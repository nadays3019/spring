package org.kg.myapp.loginmember.model.dao;

import org.kg.myapp.loginmember.model.vo.LoginMemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginMemberRepository implements ILoginMemberRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertId(LoginMemberVO loginMembervo) {
		String sql ="insert into login_member value(login_member_seq.nextVal,?,?,?,?)";
		jdbcTemplate.update(sql, loginMembervo.getUserId(),loginMembervo.getUserPw(),loginMembervo.getUserName()
				,loginMembervo.getFileId());
	}

}
