<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.service.MemberService"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MemberDto dto = new MemberDto();
	MemberDao dao = new MemberDao();
	MemberService ms = new MemberService(dao);
	
	List<MemberDto> list = new ArrayList<>();
	list = ms.select_All();
	
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h3>멤버 조회하기</h3>
	</header>
	<main>
		<div class="container">
			<c:choose>
				<c:when test="${list.size() == 0 }">
					<p>회원이 없습니다.</p>				
				</c:when>
				<c:otherwise>
					<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>주소</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tmp" items="${list }">
						<tr>
							<td>${tmp.num }</td>
							<td>${tmp.name }</td>
							<td>${tmp.addr }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
				</c:otherwise>
			</c:choose>
		</div>
		<button type="button" onclick="goHome()">홈으로</button>
	</main>
<script>
	function goHome(){
		location.href = "../index.jsp";
	};
</script>
</body>
</html>