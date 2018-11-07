<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@	taglib tagdir="/WEB-INF/tags" prefix="sb" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
		<link href="<c:url value="/resources/css/sigraStyle.css" />" rel="stylesheet"> 
		<link type="text/css" href="/sigra/resources/css/jquery-ui-1.10.1.custom.css" rel="stylesheet"> 
		 
		<script type="text/javascript" src="/sigra/resources/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="/sigra/resources/js/jquery-ui-1.10.1.custom.js"></script>
		
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
<title>Insert title here</title>

<style type="text/css">

.hidden{

	visibility: collapse;
}

</style>
  	
<script type="text/javascript">


	function isTrabSelector(){
		
		var radioIsTrabList = document.getElementsByName('radioIsTrab');
		 
		var trabSim = document.getElementById('trabSim').checked;
		var trabNao  = document.getElementById('trabNao').checked;
		
		var i;

		for(i=0; i<radioIsTrabList.length; i++){
			
			if(radioIsTrabList[i].checked){
				document.getElementById('trabalhador').value = radioIsTrabList[i].value;
				
				console.log("Trab é "+document.getElementById('trabalhador').value);
				
				break;
			}
		}
		
	}

	function showTrab(){

		$('#isTrab').removeClass('hidden')

	}

	function hideTrab(){

		$('#isTrab').addClass('hidden')

	}


</script>

</head>
<body>
	<c:import url="/cabecalho.jsp" /> 
	
	<fieldset>
		<h4 align="center"> CADASTRO DE ESTUDANTE</h4>
			<div>
				<form id="estudanteForm" action="/sigra/estudanteaction/save" method="post" modelAttribute="estudante" >
				
					<input type="hidden" name="trabalhador" id="trabalhador" value=""/>
					
					<table width="100%">
						<tr>
							<td align="center" colspan="3"> 
								<font color="blue"> 
									${statusMsg} 
								</font>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
						<td>
							<c:set var="disabled" value="${currStepEstudante == 'VISUALIZAR' ? 'disabled' : ''}" />	
							<fieldset>
								<legend>Dados do Estudante</legend>
								<table width="100%">
									<tr>
										<td>
											<c:if test="${estudante.selfId!=null && estudante.selfId>0}">
												<input type="hidden" name="selfId" value="${tipopedido.selfId}"/>
											</c:if>
										</td>
									</tr>
									<tr  >
										<td width="5%">
											<label>Nome:</label>
										</td>
										<td width="35%" align="left"> 
											<input name="nome" id="nome" style="width: 350px"" value="${estudante.pessoa.nome}"  disabled="disabled" >
											<a href="/sigra/estudanteaction/criarpessoa" >
										       <img src="<c:url value="/imagens/criarIcon2.png" />" width="25px" height="22px" title="Clica aqui se o estudante ainda não foi criado Sistema!"/>
											</a>
											<a href="/sigra/estudanteaction/pesquisarpessoa" >
										       <img src="<c:url value="/imagens/pesquisarIcon1.png" />" width="22px" height="22px" title="Clica aqui se os dados do Estudante já existirem no Sistema !"/>
											</a>
											
										</td>
										<td  width="5%" align="left">
											<label>Apelido:</label>
										</td>
										<td width="35%">
											<input type="text" name="apelido" id="apelido" style="width: 350px" value="${estudante.pessoa.apelido}" disabled="disabled" >
										</td>
									</tr>
									
									<tr>
										<td width="5%">
											<label>Trabalhador:</label>
										</td>
										<td width="35%" align="left" >
											<input type ="radio" name="radioIsTrab"  id="trabSim" value = true  ${estudante.trabalhador==true? 'checked' : ''} onclick="showTrab();"  > <label>Sim </label>
											<input type ="radio" name="radioIsTrab"  id="trabNao"  value = false onclick="hideTrab();" > <label>N&atilde;o </label> 
										</td>
										
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr id="isTrab">
										<td colspan="4">
												<span id="refresh_1_04"> 
												<c:if test="${estudante.trabalhador=='true'}">
													<fieldset >
														<table width="100%">
															<tr>
																<td width="5%"> 
																	<label>Local Trab:</label>
																</td>
																<td width="35%">
																	<input type ="text" name="localTrab"  id="localTrab" style="width: 330px"  value="${estudante.localTrab}" ${disabled} >
																</td>
																<td width="5%">
																	<label>Profiss&atilde;o:</label>
																</td>
																<td width="35%"> 
																	<input type="text" name="profissao" id="profissao" style="width: 350px" value="${estudante.profissao}" ${disabled}  >
																</td>
																
															</tr>
														</table>
													</fieldset>
												</c:if>
											</span>
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
						<td>
							<fieldset>
								<legend>Especialidade:</legend>
								<table width="100%">
									<tr >
										<td width="5%">
											<label>Especialidade</label>
										</td>
										<td width="35%"> 
											<c:choose>
												<c:when test="${currStepEstudante != 'VISUALIZAR'}">
													<select name="especialidade" style=" width : 350px;">  
													  <c:forEach var="especialidade" items="${allEspc}">  
														<option value="${especialidade.selfId}"> ${especialidade.designacao}</option>  
													  </c:forEach>  
													</select>
												</c:when>
												<c:otherwise>
													<input type="text" name="especialidade" id="especialidade" style="width: 350px" value="${estudante.especialidade.designacao}" ${disabled}  >
												</c:otherwise>
											</c:choose>
										</td>
										<td width="5%">
											<label>Turno:</label>
										</td>
										<td width="35%">
											<c:choose>
												<c:when test="${currStepEstudante != 'VISUALIZAR'}">
													<select name="turno" id="turno" style=" width : 350px;" value="${estudante.turno}" >
														<option> </option>
														<option value="Diurno">Di&uacute;rno </option>
														<option value="Nocturno">Nocturno</option>
													</select>
												</c:when>
												<c:otherwise>
													<input type="text" name="turno" id="turno" style="width: 350px" value="${estudante.turno}" ${disabled}  >
												</c:otherwise>
											</c:choose>
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
						<td>
							<fieldset>
								<legend>Encarregado de Educa&ccedil;&atilde;o</legend>
								<table width="100%">
									<tr >
										<td width="5%" colspan="3">
											<label>Nome Enc.:</label>
										</td>
										<td width="35%"> 
											<input type="text" name="encarregadoNome" id="encarregadoNome" style="width: 350px" value="${estudante.encarregadoNome}" ${disabled} >
										</td>
										<td width="5%" 	>
											<label>Profiss&atilde;o:</label>
										</td>
										<td width="35%">
											<input type ="text" name="encarregadoProfissao"  id="encarregadoProfissao" style="width: 350px" value="${estudante.encarregadoProfissao}" ${disabled} >
										</td>
									</tr>
									
									<tr >
										<td width="5%" colspan="3">
											<label>TelfCell:</label>
										</td>
										<td width="35%"> 
											<input type="text" name="encarregadoCell" id="encarregadoCell" style="width: 350px" value="${estudante.encarregadoCell}" ${disabled}  >
										</td>
										<td>
											<label>TelfFixo:</label>
										</td>
										<td width="35%">
											<input type ="text" name="encarregadoTelf"  id="encarregadoTelf" style="width: 350px" value="${estudante.encarregadoTelf}" ${disabled}  >
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
						<td>
							<c:if test="${(currStepEstudante!='VISUALIZAR') || (currStepEstudante=='EDITAR')}">
								<fieldset>
									<table width="100%">
										<tr>
											<td align="right">
												<c:choose>
													<c:when test="${(estudante.selfId==null)|| (estudante.selfId==0)}">
														<input type="submit" value="Salvar" onclick="isTrabSelector();">
														<input type="reset" value="Limpar">
													</c:when>
													<c:otherwise>
														<input type="submit" name="action" value="Actualizar" >
														<input type="submit" name="action"  value="Cancelar">
													</c:otherwise>
												</c:choose>
												<input type="button" value="Voltar">
											</td>
										</tr>
									</table>
								</fieldset>
							</c:if>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<div align="right">
			<c:if test="${(currStepEstudante!=null) && (currStepEstudante=='VISUALIZAR')}">
				<fieldset>
					<table>
						<tr>
							<td>
								<form id="estudanteDelForm" action="/sigra/estudanteaction/remove" method="post" modelAttribute="estudante" >
									<input type="hidden" name="selfId" value="${tipopedido.selfId}"/>
									<input type="submit" value="Remover" > 
								</form>
							</td>
							<td>
								<form id="estudanteEditarForm" action="/sigra/estudanteaction/editar" method="get" modelAttribute="estudante" >
									<input type="hidden" name="selfId" value="${tipopedido.selfId}"/>
									<input type="submit" value="Alterar">
								</form>
							</td>
							<td>
								<form id="estudanteAbortarForm" action="/sigra/estudanteaction/abortar" method="get" modelAttribute="estudante" >
									<input type="submit" value="Abortar Edi&ccedil;&atilde;o">
								</form>
							</td>
							<td>
								<input type="button" onclick="window.location='/sigra/processoaction?estudanteId=${estudante.selfId}'"  value="Ir para Processo"> 
							</td>
						</tr>
					</table>
				</fieldset>
			</c:if>
		</div>
		
		<div></div>
	</fieldset>
	
	<c:import url="/rodape.jsp" /> 
</body>
</html>