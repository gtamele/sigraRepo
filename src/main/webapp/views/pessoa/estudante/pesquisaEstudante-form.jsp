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

		<link href="<c:url value="/resources/css/sigraStyle.css" />" rel="stylesheet"> 
		<link type="text/css" href="/sigra/resources/css/jquery-ui-1.10.1.custom.css" rel="stylesheet"> 
		 
		<script type="text/javascript" src="/sigra/resources/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="/sigra/resources/js/jquery-ui-1.10.1.custom.js"></script>

<title>Insert title here</title>

	 

	<script type="text/javascript">
	
	
		   $(document).ready(function() {
	           $("#tipoPedidoForm").submit(function(e) {
	               if(!validar()) {
	                   e.preventDefault();
	               }
	           });             
	       });
	
		function validar(){
	
			if (document.getElementById('designacao').value == ''){
				alert("O campo 'Designacao' deve ser preenchido");
				return false;
			}
			if (document.getElementById('descricao').value == ''){
				alert("O campo 'Descricao' deve ser preenchido");
				return false;
			}							 
			
			return true;
		}
		

		function setFakeId(){
	
			if(document.getElementById('apelido').value !="" || document.getElementById('nome').value !="") {
				
				document.getElementById('selfId').value =0;
			}
			
	
		}
	
	
	</script>	

</head>
<body>
	<c:import url="/views/menu/menu11.jsp" /> 
	<c:import url="/cabecalho.jsp" /> 	
	<fieldset>
		<h4 align="center">PESQUISA DE ESTUDANTE</h4>
		<div>
			<form id="pesquisaEstudanteForm" action="/sigra/pesquisaestudanteaction/pesquisaestudante" method="post" modelAttribute="estudante" >
			
		
			
			<table width="100%">	
				<tr>
					<td align="center" colspan="3"> 
						<font color="red"> 
							${statusMsg} 
						</font>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>
						<fieldset>
							<table width="100%">
								<tr>
									<td width="5%">	
										<label>N&ordm; de Estudante:</label>
									</td>
									<td width="85%">			
										<input type="number" id="selfId" name="selfId" style=" width : 530px;" value="${estudante.selfId}" >
									</td>
								</tr>
								
								<tr>
									<td width="8%">
										<label> Nome:</label>
									</td>
									<td width="85%">			
										<input type="text" id="nome" name="nome" style=" width : 530px;" value="${estudante.nome}" >
									</td>
								</tr>
								<tr>
									<td width="5%">
										<label> Apelido:</label>
									</td>
									<td width="85%">			
										<input type="text" id="apelido" name="apelido" style=" width : 530px;" value="${estudante.apelido}" >
									</td>
									
								</tr>
								
							</table>
						</fieldset>
					</td>
				</tr>
				<tr>
					<td align="right"> 
							<fieldset>
								<table width="100%">
									<tr>
										<td align="right">
											<input type="submit" name="action" value="Pesquisar" onclick="setFakeId();" >
											<input type="reset" value="Limpar" > 
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
			<table width="100%">
				<tr>
					<td>
						<fieldset>
							<table width="100%">
								<tr>
									<td>
										<fieldset>
												<legend>Resultado da Pesquisa</legend>
											<table width="100%">
												<tr align="left">
													<th width="5%" >EDITAR</th>	
													<th width="30%">NOME</th>
													<th width="20%">APELIDO</th>
													<th width="20%">DOCUMENTO</th>
													<th width="25%">N&ordm; DOCUMENTO</th>
												</tr>
													<c:forEach items="${estudantesFromPesquisa}" var="selectedEstudante" >
													<tr>
														<td height="20" valign="middle">
															<a href="/sigra/pesquisaestudanteaction/selectedEstudante?selfId=${selectedEstudante.selfId}" >
														       <img src="<c:url value="/imagens/edit_big.gif" />" width="22px" height="22px" title="Clica aqui para Detalhar!"/>
																 <!--  <img src="comuns/images/edit_big.gif" width="22px" height="22px" title="Clica aqui para Detalhar!" /> -->  
															</a>
														</td>
														<td>${selectedEstudante.nome}</td>
														<td>${selectedEstudante.apelido}</td>	
														<td>${selectedEstudante.documento.tipoDoc.designacao}</td>	
														<td>${selectedEstudante.documento.numero}</td>
													</tr>
												</c:forEach>
											</table>
									
										</fieldset>
									</td>
								</tr>
								
								<tr>
									<td>
										<table>
											<tr>
												<td width="200px" height="200px"></td>
											</tr>
										</table>
									</td>
								</tr>
								
							</table>
						</fieldset>
					</td>
				</tr>
			</table>
		</div>
		<div>
			<form id="pesquisaEstudanteBackHomeForm" action="/sigra/pesquisaestudanteaction/home" method="get" modelAttribute="estudante" >
				<table width="100%">
					<tr>
						<td align="right">
							<input type="submit" value="Voltar" style="width : 69px; height : 30px;">
						</td>
					</tr>
				</table>
			</form>
		</div>
		
	</fieldset>
	<c:import url="/rodape.jsp" /> 
</body>
</html>