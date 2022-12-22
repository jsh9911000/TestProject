<%@page import="member.service.MemberService"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//parameter의 방식이 post이면, 반드시 인코딩을 설정해줘야 한다.
	request.setCharacterEncoding("utf-8"); 
	//필요한 객체들 생성.
	MemberDto dto = new MemberDto();
	MemberDao dao = new MemberDao();
	MemberService ms = new MemberService(dao);
	//<form>으로 전송된 parameter 값을 저장한다. => name 속성과 연결되어 있다.
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	//DTO에 저장.
	dto.setName(name);
	dto.setAddr(addr);
	//Service - DAO를 통해서 요청 처리.
	boolean isInsert = ms.insert_member(dto);
	//.setAttribute( , ) 를 해야 HTML 과 JS 영역에서 el 를 통해서 Key 값을 사용할 수 있다.
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