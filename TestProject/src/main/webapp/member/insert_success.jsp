<%@page import="member.service.MemberService"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8"); //post 방식이니까.
	MemberDto dto = new MemberDto();
	MemberDao dao = new MemberDao();
	MemberService ms = new MemberService(dao);
	
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	
	dto.setName(name);
	dto.setAddr(addr);
	
	boolean isInsert = ms.insert_member(dto);
	
	request.setAttribute("name", name);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${name }님 가입 축하드립니다.</h3>
	<button type="button" id="homeBtn">홈으로</button>
<script>
	alert(`${name}님이 가입되었습니다.`);
	homeBtn.addEventListener("click", () => {
		location.href = "../index.jsp";
	});
</script>
</body>
</html>