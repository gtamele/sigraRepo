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
		
			<fieldset>
				<h4 align="center"> RELA&Ccedil;&Atilde;O DAS DISCIPLINAS FEITAS</h4>
				<div>
					<form action=""  modelAttribute="processo">
						<table width="100%">
							<tr>
								<td width="50%">
									<div>
										<fieldset>
											<legend>Detalhes Sobre Processo</legend>
											<table>
												<tr>
													<td >
														<label>N&ordm; Processo:</label>
													</td>
													<td>
														<input type="text" name="selfId" id="selfId" style=" width : 350px;" value="${estudante.processo.selfId}" disabled="disabled" >
													</td>
												</tr>
												<tr>
													<td >
														<label>Data Abertura:</label>
													</td>
													<td>
														<input type="text" name="dataCriacao" id="dataCriacao" style=" width : 350px;" value="${estudante.processo.dataCriacao}" disabled="disabled" >
													</td>
												</tr>
												<tr>
													<td >
														<label>Especialidade:</label>
													</td>
													<td>
														<input type="text" name="especialidade" id="especialidade" style=" width : 350px;" value="${estudante.especialidade.designacao}" disabled="disabled" >
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
														<input type="text" name="nome" id="nome" style=" width : 350px;"  value="${estudante.nome}" disabled="disabled" >
													</td>
												</tr>
												<tr>
													<td >
														<label>Apelido:</label>
													</td>
													<td>
														<input type="text" name="apelido" id="apelido" style=" width : 350px;" value="${estudante.apelido}" disabled="disabled" >
													</td>
												</tr>
												<tr>
													<td >
														<label>Doc:</label>
													</td>
													<td>
														<input type="text" name="documento" id="documento" style=" width : 160px;" value="${estudante.documento.tipoDoc.designacao}" disabled="disabled" >
														<label>	N&ordm;:</label>
														<input type="text" name="documento" id="documento" style=" width : 159px;" value="${estudante.documento.numero}" disabled="disabled" >
													</td>
												</tr>
											</table>
										</fieldset>
									</div>
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2">
									<fieldset>
										<table width="100%">
											<tr align="left">
													<th width="25%">DISCIPLINA</th>
													<th width="25%">N&Iacute;VEL</th>
													<th width="25%">ANO</th>
													<th width="25%">NOTA FINAL</th>
											</tr>
											<tr>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td>Matemática I</td>
												<td>I</td>
												<td>2017</td>
												<td>12</td>	
											</tr>
											<tr>
												<td>Português I</td>
												<td>I</td>
												<td>2017</td>
												<td>14</td>	
											</tr>
											<tr>
												<td>Técnicas Lab I</td>
												<td>I</td>
												<td>2017</td>
												<td>11</td>	
											</tr>
											
										</table>
									</fieldset>
								</td>
							</tr>
						</table>
					</form>
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
								<tr align="right">
									<td>
										<input type="submit" value="Imprimir" style="width : 69px; height : 30px;">
										<input type="submit" value="Exportar" style="width : 69px; height : 30px;">
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