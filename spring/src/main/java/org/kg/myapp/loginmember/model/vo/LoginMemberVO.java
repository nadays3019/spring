package org.kg.myapp.loginmember.model.vo;

/*user_index number primary key,
user_id varchar2(20) unique,
user_password varchar2(255) not null,
user_name varchar2(10) not null,
file_id number,
constraint login_member_file_fk foreign key
(file_id) references files(file_id)*/

public class LoginMemberVO {

	private int userIndex;
	private String userId;
	private String userPw;
	private String userName;
	private int fileId;
	public int getUserIndex() {
		return userIndex;
	}
	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	
	
	
	
}
