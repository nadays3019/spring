<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Error !</h1>
	<p>애플리케이션 오류발생. 관리자에게 문의하시려면 nadays3019@naver.com 또는
	010-0000-0000으로 연락주세요</p>
	<!--  Failed URL : ${url}
	Exception : ${exception.message}
	<c:forEach items = "${exception.stackTrace}" var = "ste" > ${ste} </c:forEach>
	-->
</body>
</html>