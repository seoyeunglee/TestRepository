<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findId.jsp</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn1").click(function(){
		var userName = $("#userName").val();
		$(opener.document).find("#userName").val(userName);
		var userEmail = $("#userEmail").val();
		$(opener.document).find("#userEmail").val(userEmail);
	});
});
</head>
<body>
<form action="idFind.help" method="get">
<table border=1 width=300 align="center">
	<tr><td>이름</td>
		<td><input type="text" name="userName" value="${userName }"/></td></tr>
	<tr><td>이메일</td>
		<td><input type="email" name="userEmail" value="${userEmail }" />
			<input type="submit" id="btn1" value="다음" /></td></tr>
		
</table>
</form>
</body>
</html>