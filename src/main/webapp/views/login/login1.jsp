<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>

 
<link href="<c:url value="/resources/css/styleLogin.css" />" rel="stylesheet"> 
<link type="text/css" href="resources/css/jquery-ui-1.10.1.custom.css" rel="stylesheet"> 
 
<script type="text/javascript" src="resources/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.10.1.custom.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	
	
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">


 /**
	function login(user){


		alert("Logar....!");
	//	if(!validar())
	//		return;

		$.post("/sigra/login/getin",{'user':user});

	} **/

	$(document).ready(function() {
	    $("#loginForm").submit(function(e) {
	        if(!validar()) {
	            e.preventDefault();
	        }
	    });             
	});

	function validar(){
	
		if (document.getElementById('user').value == ''){
			alert("O campo 'Utilizador' deve ser preenchido");
			return false;
		}
		if (document.getElementById('senha').value == ''){
			alert("O campo 'Password' deve ser preenchido");
			return false;
		}							 
		
		return true;
	}


</script>

</head>
<body>

	<form id="login">
		
			<table width="100%" border="0" align="left">
		    <h1>Log In</h1>
		    <fieldset id="inputs" >
		        <input id="username" type="text" placeholder="Username" autofocus required>   
		        <input id="password" type="password" placeholder="Password" required>
		    </fieldset>
		    <fieldset id="actions" >
		        <input type="submit" id="submit" value="Entrar" style=" width : 92px;" align="left">  
		        <input type="reset" name="limpar" value="Limpar" style=" width : 92px;" align="left">
		    </fieldset>
		    </table>
	   
	</form>
<!-- 	<c:import url="/rodape.jsp"/>  -->
</body>
</html>