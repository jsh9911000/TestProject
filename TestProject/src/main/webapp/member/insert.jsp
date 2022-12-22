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
		<h3>맴버 추가하기</h3>
	</header>
	<main>
		<div class="container">
			<form action="insert_success.jsp" method="post">
				<label for="name">이름</label>
				<input type="text" name="name" id="name"/>
				<label for="addr">주소</label>
				<input type="text" name="addr" id="addr"/>
				<button type="submit">추가하기</button>
			</form>
		</div>
	</main>
</body>
</html>