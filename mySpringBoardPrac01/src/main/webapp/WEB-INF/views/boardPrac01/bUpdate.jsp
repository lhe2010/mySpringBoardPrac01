<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bUdate</title>
</head>
<body>
	<div align="center" style="padding-top: 100px">
		<form action="boardUpdate" method="post" >
			<div  align="center">
				<h2>게시글 수정하기</h2>
				<br>
			</div>
			<table border="1" style="width:550px;" >
				<tr>
					<td>작성자</td>
					<td>${bdto.writer}</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><fmt:formatDate value="${bdto.regDate}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" value="${bdto.subject}" size="70"/></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" name="password" size="70"/></td>
				</tr>
				<tr>
					<td>글내용</td>
					<td><textarea rows="10" cols="60" name="content">${bdto.content}</textarea></td>
				</tr>
				<tr align="center">
					<td colspan="4">
						<input type="hidden" name="num" value="${bdto.num }" /> 
						<input type="submit" value="글수정" />
						<input type="button" onclick="location.href='boardList'" value="전체글보기" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>