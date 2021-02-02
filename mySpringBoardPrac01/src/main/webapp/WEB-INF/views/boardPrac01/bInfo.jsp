<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bInfo</title>
</head>
<body>

	<div align="center">
		<h1>글을 조회하는 페이지 입니다. </h1>
		<table border="1">
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tr>
				<td>글번호</td>
				<td>${bdto.num }</td>
			</tr>
			<tr>
				<td>글제목</td>
				<td>${bdto.subject }</td>
			</tr>
			<tr>
				<td>글쓴이</td>
				<td>${bdto.writer }</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><fmt:formatDate value="${bdto.regDate }" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${bdto.readCount }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${bdto.email }</td>
			</tr>
			<tr>
				<td>글내용</td>
				<td>${bdto.content }</td>
			</tr>
			<tr align="center">
				<td colspan="2" >
					<button onclick="location.href='boardUpdate?num=${bdto.num}'">수정하기</button>
					<button onclick="location.href='boardDelete?num=${bdto.num}'">삭제하기</button>
					<button onclick="location.href='boardList'">리스트로돌아가기 </button>
				</td>
			</tr>
		</table>
	
	</div>

</body>
</html>