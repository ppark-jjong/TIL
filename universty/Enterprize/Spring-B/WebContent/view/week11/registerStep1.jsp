<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>
	<h2>약관</h2>
	<p>약관내용</p>
	<form action="step2" method="post">
		<input type="hidden" name="path" value="week11"/> 
		<input type="hidden" name="view" value="registerStep"/> 
		<label>
			<input type="checkbox" name="agree" value="true"/> 약관동의
		</label> 
		<input type="submit" value="다음단계" />
	</form>
</body>
</html>