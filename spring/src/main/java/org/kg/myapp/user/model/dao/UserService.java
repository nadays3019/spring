package org.kg.myapp.user.model.dao;

import org.kg.myapp.user.model.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bpe;
	
	
	@Override
	public void insertUser(UserVO userVO) {
		userVO.setUserPw(bpe.encode(userVO.getUserPw()));
		userRepository.insertUser(userVO);

	}

	@Override
	public UserVO getUserById(String userId) {
		
		return userRepository.getUserById(userId);
	}

	@Override
	public UserVO getUserByIndex(int userIndex) {
		
		return userRepository.getUserByIndex(userIndex);
	}

	@Override
	public String getPasswordd(String userId) {
		
		return userRepository.getPasswordd(userId);
	}

}
