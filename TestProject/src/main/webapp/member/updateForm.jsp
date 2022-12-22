<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h3>회원 수정하기</h3>
	</header>
	<main>
		<div class="container">
			<form action="update.jsp" method="post">
				<label for="name">이름</label>
				<input type="text" name="name" id="name"/>
				<label for="newAddr">새 주소</label>
				<input type="text" name="newAddr" id="newAddr"/>
				<button type="submit">수정하기</button>
			</form>
		</div>
	</main>
</body>
</html>