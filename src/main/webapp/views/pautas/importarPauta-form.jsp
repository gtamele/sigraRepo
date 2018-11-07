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
	<c:import url="/views/menu/menu11.jsp" />
	<c:import url="/cabecalho.jsp" /> 	
		
			<fieldset>
				<h4 align="center"> IMPORTAR PAUTA</h4>
				<div>
					<form action=""  modelAttribute="">
						<table width="100%">
							<tr>
								
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2">
									<fieldset>
										<table width="100%">
											<tr>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td width="5%">
													<label>Indique o Caminho do Ficheiro</label>
												</td>
												<td width="30%">
													<input type="file" name="ficheiroDaPauta" style=" width : 459px;">
												</td>
											</tr>
										</table>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2">
									<fieldset>
										<legend>Opera&ccedil;&otilde;es</legend>
										<table width="100%">
											
											<tr align="right">
												<td width="5%">
													<input type="reset" value="Limpar">
													<input type="submit" value="Importar Dados">
													<input type="submit" value="Cancelar">
												</td>
												
											</tr>
										</table>
									</fieldset>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div>
					<fieldset><legend>Log da Opera&ccedil;&atilde;o</legend>
						<table>
							<tr>
								<td width="200px" height="250px">
									<textarea rows="" cols="" style="width : 1414px; height : 239px;"></textarea>
								</td>
							</tr>
							
						</table>
					</fieldset>
					
				</div>
				<div>
					<table>
						<tr>
							<td>&nbsp;</td>
						</tr>
					</table>	
				</div>
				<div>
					<form id="processoBackHomeForm" action="/sigra/processoaction/home" method="get" modelAttribute="processo" >
						<fieldset>
							<table width="100%">
								<tr>
									<td align="right">
										<input type="submit" value="Voltar" style="width : 69px; height : 30px;">
									</td>
								</tr>
							</table>
						</fieldset>
					</form>
				</div>
				
				
			</fieldset>
		
	<c:import url="/rodape.jsp" /> 
</body>
</html>