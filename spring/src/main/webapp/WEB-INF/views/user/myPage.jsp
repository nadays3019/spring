<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	
	<img src='<c:url value="/img/${user.fileId}"/>' width="100" class="img-thumbnail"><br>
	
	
	<h1>안녕하세요 ${user.userName}</h1>
	
</body>
</html>