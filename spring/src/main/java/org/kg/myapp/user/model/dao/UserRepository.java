package org.kg.myapp.user.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.kg.myapp.user.model.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<UserVO> userMapper = new RowMapper<UserVO>() {
		
		@Override
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO user = new UserVO();
			user.setUserIndex(rs.getInt(1));
			user.setUserId(rs.getString(2));
			user.setUserPw(rs.getString(3));
			user.setUserName(rs.getString(4));
			user.setFileId(rs.getInt(5));
			return user;
		}
	};
	
	@Override
	public void insertUser(UserVO userVO) {
		String sql ="insert into login_member values(login_member_seq.nextval,?,?,?,?)";
		jdbcTemplate.update(sql,userVO.getUserId(),userVO.getUserPw(),userVO.getUserName(),userVO.getFileId());

	}

	@Override
	public UserVO getUserById(String userId) {
		String sql = "select * from login_member where user_id=?";
		
		return jdbcTemplate.queryForObject(sql, userMapper,userId);
	}

	@Override
	public UserVO getUserByIndex(int userIndex) {
		String sql ="select * from login_member where user_index=?";
		return jdbcTemplate.queryForObject(sql, userMapper,userIndex);
	}

}
