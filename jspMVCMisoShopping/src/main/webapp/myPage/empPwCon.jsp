<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empPwCon.jsp</title>
</head>
<body>
<ul>
	<li><a href="<c:url value='/' />">홈</a></li>
	<li><a href="empMyPage.my">직원 내정보 보기</a></li>
	<li><a href="empUpdate.my">직원 정보 수정</a></li>
	<li><a href="empPwModify.my">비밀번호변경</a></li>
	<li><a href="employeeDrop.my">회원탈퇴</a></li>
	</ul>
<form action="empMyPwModify.my" method="post">
		비밀번호 확인 : <input type="password" name="empPw" required="required" />
		<div style="color:red">${errPw }</div>
					<input type="submit" value="확인" />
	</form>

</body>
</html>