<%@page import="member.service.MemberService"%>
<%@page import="member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String newAddr = request.getParameter("newAddr");
	
	MemberDao dao = new MemberDao();
	MemberService ms = new MemberService(dao);
	
	boolean isUpdate = ms.update_member(name,newAddr);
	
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
	alert(`${name}님의 주소가 변경되었습니다.`);
	location.href = "select.jsp";
</script>
</body>
</html>