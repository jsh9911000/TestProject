<%@page import="member.dto.MemberDto"%>
<%@page import="member.service.MemberService"%>
<%@page import="member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	
	MemberDao dao = new MemberDao();
	MemberService ms = new MemberService(dao);
	
	ms.delete_member(name);
	
	request.setAttribute("name", name);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script>
	alert(`${name}님이 삭제되었습니다.`);
	location.href = "../index.jsp";
</script>
</body>
</html>