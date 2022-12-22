<%@page import="member.dto.MemberDto"%>
<%@page import="member.service.MemberService"%>
<%@page import="member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//<form> 의 요청 방식이 post이면, 반드시 인코딩해야 한다.
	request.setCharacterEncoding("utf-8");
	//<form> 으로 전송된 parameter 값 저장.
	String name = request.getParameter("name");
	//객체 생성.
	MemberDao dao = new MemberDao();
	MemberService ms = new MemberService(dao);
	//Service - DAO 메소드 실행.
	ms.delete_member(name);
	//setAttribute( , ) 를 해야 HTML 과 JS 영역에서 el를 이용해서 Key 값을 사용할 수 있다.
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