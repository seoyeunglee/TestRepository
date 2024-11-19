<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberModify.jsp</title>
</head>
<body>
회원수정페이지입니다<br />
<form action="memberModify.mem" method="post">
회원번호 : <input type = "text" name="memberNum" value="${dto.memberNum }"/><br />
이름 : <input type="text" name="memberName" value="${dto.memberName }"/><br />
아이디 : <input type="text" name="memberId" value="${dto.memberId }"/><br />
주소 : <input type="text" name="memberAddr" value="${dto.memberAddr }"/><br />
상세주소 : <input type="text" name="memberAddrDetail" value="${dto.memberAddrDetail }"/><br />
우편번호 : <input type="text" name="memberpost" value="${dto.memberpost }"/><br />
연락처1 : <input type="text" name="memberPhone1" value="${dto.memberPhone1 }"/><br />
연락처2 : <input type="text" name="memberPhone2" value="${dto.memberPhone2 }"/><br />
성별 : <input type="radio" name="gender" value="M"
		<c:if test="${dto.gender == 'M'}">checked</c:if> />남자
		<input type="radio" name="gender" value="F"
		<c:if test="${dto.gender == 'F'}">checked</c:if> />여자 <br />
등록일 : <input type="text" name="memberRegist" value="${dto.memberRegist }"/><br />
생년월일 : <input type="text" name="memberBirth" value="${dto.memberBirth }"/><br />
이메일 : <input type="text" name="memberEmail" value="${dto.memberEmail }"/><br />
<input type="submit" value="회원수정완료"/>
<input type="button" value="회원목록" onclick="javascript:location.href='memberList.mem'">
</form>
</body>
</html>