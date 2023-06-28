<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>
	<h2>회원 정보 입력</h2>
	<form:form action="step3" modelAttribute="registerRequest">
		<form:hidden path="path" value="week11" />
		<form:hidden path="view" value="registerStep" />
		<p>
			<label>이메일 : <br> <form:input path="email" />
			</label>
		</p>
		<p>
			<label>이름 : <br> <form:input path="name" /></label>
		</p>
		<p>
			<label>비밀번호 : <br> <form:input path="password" /></label>
		</p>
		<p>
			<label>비밀번호 확인 : <br> <form:input path="confirmPassword" /></label>
		</p>
		<input type="submit" value="가입 완료" />
	</form:form>
</body>
</html>