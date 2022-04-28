<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한줄 게시판 리스트</title>
</head>
<body>
	<h2>한줄 게시판 글목록</h2><hr>
	<table width="600" cellpadding="0" cellspacing="0" border="1">
		<tr align="center" bgcolor="pink">
			<td><b>번호</b></td>
			<td><b>작성자</b></td>
			<td><b>내용</b></td>
			<td><b>삭제</b></td>
		</tr>
		<c:forEach items="${list }" var="dto">
		<tr align="center">
			<td>${dto.mid }</td>
			<td>${dto.mwriter }</td>
			<td align="left"><a href="view?mid=${dto.mid }">${dto.mcontent }</a></td>
			<td><a href="delete?mid=${dto.mid }">X</a></td>
		</tr>	
		</c:forEach>
		<tr>
			<td colspan="4" align="right">
				<a href="writeForm">글쓰기</a>
			</td>
		</tr>
	</table>
</body>
</html>