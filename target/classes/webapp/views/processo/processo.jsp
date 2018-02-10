<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@	taglib tagdir="/WEB-INF/tags" prefix="sb" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<!--    <link type="text/css" href="resources/css/estilos01.css" rel="stylesheet" /> -->
		<link href="<c:url value="/resources/css/sigraStyle.css" />" rel="stylesheet"> 
		<link type="text/css" href="resources/css/jquery-ui-1.10.1.custom.css" rel="stylesheet"> 
		 
		<script type="text/javascript" src="resources/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui-1.10.1.custom.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:import url="/cabecalho.jsp" /> 	
		<form action="">
			<fieldset>
				<table width="100%">
					<tr>
						<td width="50%">
							<div>
								<fieldset>
									<legend>Processo</legend>
									<table>
										<tr>
											<td >
												<label>N&ordm; Processo:</label>
											</td>
											<td>
												<input type="text" style=" width : 350px;">
											</td>
										</tr>
										<tr>
											<td >
												<label>Data Abertura:</label>
											</td>
											<td>
												<input type="text" style=" width : 350px;">
											</td>
										</tr>
										<tr>
											<td >
												<label>Especialidade:</label>
											</td>
											<td>
												<input type="text" style=" width : 350px;">
											</td>
										</tr>
									</table>
								</fieldset>
							</div>
						</td>
						<td width="50%">
							<div>
								<fieldset>
									<table>
										<tr>
											<td >
												<label>Nome:</label>
											</td>
											<td>
												<input type="text" style=" width : 350px;">
											</td>
										</tr>
										<tr>
											<td >
												<label>Apelido:</label>
											</td>
											<td>
												<input type="text" style=" width : 350px;">
											</td>
										</tr>
										<tr>
											<td >
												<label>Doc N&ordm;:</label>
											</td>
											<td>
												<input type="text" style=" width : 350px;">
											</td>
										</tr>
									</table>
								</fieldset>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<fieldset>
								<legend>Opera&ccedil;&otilde;es</legend>
								<table width="100%">
									<tr>
										<td align="right">
											<input type="button" name="matricula" id="matricula" value="Matricula">
											<input type="button" name="matricula" id="matricula" value="Matricula">
										</td>
									</tr>
								</table>
							</fieldset>
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	<c:import url="/rodape.jsp" /> 
</body>
</html>