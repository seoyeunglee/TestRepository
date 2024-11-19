<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetail.jsp</title>
</head>
<body>
게시글 상세 보기<br />
번호: ${dto.boardNum }<br />
글쓴이: ${dto.boardWriter }<br />
제목: ${dto.boardSubject }<br />
내용: ${dto.boardContent }<br />
<a href="boardModify.miso?boardNum=${dto.boardNum }">수정</a>
<a href="boardDelete.miso?boardNum=${dto.boardNum }">삭제</a>
</body>
</html>