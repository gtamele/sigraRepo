<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>

 

<link type="text/css" href="resources/css/jquery-ui-1.10.1.custom.css" rel="stylesheet"> 
 
<script type="text/javascript" src="resources/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.10.1.custom.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">

body{	background-color: #D8D8D8;
		font: normal 14px Arial;
				 
	}


h3 {
    text-shadow: 0 1px 0 rgba(255, 255, 255, .7), 0px 2px 0 rgba(0, 0, 0, .5);
    text-transform: uppercase;
    text-align: center;
    color: #666;
    margin: 0 0 30px 0;
    letter-spacing: 1px;
    font: normal 19px/1 Verdana, Helvetica;
    position: relative;
}

form input {

  margin-left: 20px;
  padding: 5px 20px;
  font-size: 1em;
  border-radius: 5px;
 
  border: 2px solid #6E6E6E;
}




</style>	
	
	
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

	<form id="loginForm" action="/sigra/home" method="post" modelAttribute="login" >
		<div align="center">
		<!-- <fieldset> -->	
				<table width="400px" border="0">
					
					<tr>
						<td colspan="2" align="center" valign="middle">
							<p> 
								<font color="red">	${msg} </font>
							</p>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center" valign="middle">
							<h3> Login do Utilizador</h3>
						</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;&nbsp;</td>
					</tr>
				
					<tr>
						<td width="5%" align="center">
							<label><b>Utilizador:</b></label>
						</td>
						<td width="30%">
							<input type="text" name="user" id="user" placeholder="utilizador" value="${login.user}" >
						</td>	
					</tr>
					<tr>
						<td align="center">
							<label><b>Password:</b></label>
						</td>
						<td>
							<input type="passWord" name="senha" id="senha" placeholder="password" value="${login.senha}" >
						</td>	
					</tr>
					<tr></tr>
					
					<tr>
						<td>&nbsp;</td>
						<td align="left" valign="middle">
						  <!-- <input type="button" name="enntrar" value="Entrar" onclick="login(${login.user})"> -->
						  	<input type="submit" name="enntrar" value="Entrar" >	
							
							<input type="reset" name="limpar" value="Limpar">
						</td>
					</tr>
					<tr>
						<td width="400px" height="500px"></td>
					</tr>
				</table>
		<!-- </fieldset> -->	
		</div>
	</form>
	<c:import url="/rodape.jsp"/> 
</body>
</html>