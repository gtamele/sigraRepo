<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
</head>
<body>
	<form:form>
	<h1>Teste Spring......!</h1>

	<h2>${allTipoPagamentos}</h2>
	
	<p><%= request.getAttribute("msg") %></p>
	
	<p><%= request.getAttribute("msg1") %></p>
	
	<p><%= request.getAttribute("msg2") %></p>
	
	<p><%= request.getAttribute("msg3") %></p>
	
	<p><%= request.getAttribute("msg4") %></p>
	<p>${msg3}</p>
	</form:form>

</body>
</html>