<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>��ǰ ���</h1>
	<form action="/shopping" method="post" modelAttribute="orderCommand">
		<c:forEach var="item" items="${items}" varStatus="status">
			<p>
				<label>1. �𵨸� : <input type="text" name="orderCommand.itemName" value = "${item.itemName}" ></label>
			</p>

			<ul>
				<li>������ :  <input type="text" name="orderCommand.age" value = "${item.maker}"></li>
				<li>�� �� : ${item.price}</li>
				<li>�� �� : <input type="checkbox" value="�ֹ�����">: 
					<input type="text" name="orderCommand.num">
			</ul>
			<input type="submit" value="�ֹ��ϱ�">
		</c:forEach>
	</form>
</body>
</html>