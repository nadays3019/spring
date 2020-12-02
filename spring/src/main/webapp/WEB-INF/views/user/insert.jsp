<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>

	<h1>회원 가입</h1>
	<form action="insertdata" method="post" enctype="multipart/form-data">
	
	<table border="1">
	
	<tr>
	<td># 아이디 :</td> 
	<td>
	<input type ="text" name ="userId"/><br>
	</td>
	</tr>
	<tr>
	<td># 패스워드 :</td> 
	<td>
	<input type ="password" name ="userPw"/><br>
	</td>
	</tr>
	<tr>
	<td># 이름 :</td> 
	<td>
	<input type ="text" name ="userName"/><br>
	</td>
	</tr>
	<tr>
	<td># 프로필 사진 : </td> 
	<td>
	<input type ="file" name ="file"/><br>
	<font size="1">사진 크기는 5mb를 넘을 수 없습니다.</font>
	</td>
	</tr>
	<tr>
	<td colspan="2">
	<input type="submit" name="저장"> <input type="reset" name="취소">
	</td>
	</tr>
	</table>
	</form>
</body>
</html>