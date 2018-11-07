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

	function setMatriculaStatus(){
		var matriculaStatusList = document.getElementsByName('radioMatricula');
												 
		
		var i;
		
		for(i=0; i<matriculaStatusList.length; i++){
			
			if(matriculaStatusList[i].checked){
				document.getElementById('estadoMatricula').value = matriculaStatusList[i].value;
				console.log("Estado da Matricula é "+document.getElementById('estadoMatricula').value);
				break;
			}
		}

	}

	 $(document).ready(function() {
         $("#matriculaForm").submit(function(e) {
             if(!validar()) {
                 e.preventDefault();
             }
         });             
     });

	function validar(){
		
		if (document.getElementById('anoLectivo').value == ''){
			alert("O campo 'Ano Lectivo' deve ser preenchido");
			return false;
		}
		if (document.getElementById('estadoMatricula').value == ''){
			alert("Selecionar 'Sim' para efectuar a Matricula");
			return false;
		}	
		if (document.getElementById('tipoPaga').value == ''){
			alert("Seleccionar o 'Tipo Pagamento' correspondente");
			return false;
		}
		if (document.getElementById('numComprovativo').value == ''){
			alert("O campo 'Número de comprovativo' deve ser preenchido");
			return false;
		}	
		if (document.getElementById('dataPagamento').value == ''){
			alert("O campo 'Data de Pagamento' deve ser preenchido");
			return false;
		}	
		if (document.getElementById('valor').value == ''){
			alert("O campo 'Valor' deve ser preenchido");
			return false;
		}								 
		
		return true;
	}


	
	
	</script>
	
	</head>
<body>	
	<c:import url="/cabecalho.jsp" /> 
	
	<fieldset>
		<h4 align="center"> MATR&Iacute;CULA</h4>
		<div>
			<form id="matriculaForm" action="/sigra/matriculaaction/save" method="post" modelAttribute="matricula" >
			
			<input type="hidden" name="estadoMatricula" id="estadoMatricula" value=""/>
				
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
							<c:set var="disabled" value="${currStepMatricula == 'VISUALIZAR' ? 'disabled' : ''}" />
							<fieldset>
								<table width="100%">
									<tr>
										<td >
											<label>Nome:</label>
										</td>
										<td>
											<input type="text" name="nome" id="nome" style=" width : 350px;"  value="${estudante.nome}" disabled="disabled" >
										</td>
										<td >
											<label>Apelido:</label>
										</td>
										<td>
											<input type="text" name="apelido" id="apelido" style=" width : 350px;" value="${estudante.apelido}" disabled="disabled" >
										</td>
									</tr>
									<tr>
										<td width="15%">
											<label>Ano Lectivo:</label>
										</td>
										<td width="35%">
											<c:choose>
												<c:when test="${currStepMatricula != 'VISUALIZAR'}">
													 <select name="anoLectivo" id="anoLectivo" style=" width : 350px;">  
													  <c:forEach var="anoLectivo" items="${anosLectivo}">  
														<option value="${anoLectivo}"> ${anoLectivo}</option>  
													  </c:forEach>  
													</select>
												</c:when>
												<c:otherwise>
													<input type="text" name="anoLectivo" id="anoLectivo" style=" width : 350px;" value="${matricula.anoLectivo}" ${disabled}>
												</c:otherwise>
											</c:choose>
										</td>
										<td width="15%">
											<label>Novo Ingresso:</label>
										</td>
										<td width="35%">
											<c:choose>
												<c:when test="${currStepMatricula != 'VISUALIZAR'}">
													<input name="radioMatricula" type ="radio" id="matriculaSim" value = "Sim" ${matricula.estadoMatricula=="Sim"? 'checked' : ''} > <label>Sim </label>
													<input name="radioMatricula" type ="radio" id="matriculaNao"  value = "Não" ${matricula.estadoMatricula=="Não"? 'checked' : ''} > <label>N&atilde;o </label>
												</c:when>
												<c:otherwise>
													<input type="text" name="estadoMatricula" id="estadoMatricula" style=" width : 350px;" value="${matricula.estadoMatricula}" ${disabled}>
												</c:otherwise>
											</c:choose>	
										</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>	
									<tr>
										<td colspan="4">
											<fieldset>
												<legend>Pagamento</legend>
												<table width="100%">
													<tr>
														<td width="15%">
															<label>
																Tipo Pagamento:
															</label>
														</td>
														<td width="35%">
															<c:choose>
																<c:when test="${currStepMatricula != 'VISUALIZAR'}">
																	<select name="tipoPaga" id="tipoPaga" style=" width : 353px;">  
																	  <option value="">-Seleccionar- </option>	
																	  <c:forEach var="tipoPaga" items="${allTipoPagamento}">  
																		<option value="${tipoPaga.selfId}"> ${tipoPaga.designacao}</option>  
																	  </c:forEach>  
																	</select>
																</c:when>
																<c:otherwise>
																	<input type="text" name="designacao" id="designacao" style=" width : 350px;" value="${matricula.pagamento.tipoPagamento.designacao}" ${disabled}>
																</c:otherwise>
															</c:choose>
														</td>
														<td width="15%" >
															<label>Data Pagamento:</label>
														</td>
														<td width="35%">
															 <sb:campoData1 id="dataPagamento" name="dataPagamento" value="${matricula.pagamento.dataPagamento}" /> 
														</td>
														
													</tr>
													<tr>
														<td width="15%">
															<label>N&ordm; Comprovativo:</label>
														</td>
														<td width="35%">
															<input type="text" name="numComprovativo" id="numComprovativo" style=" width : 350px;" value="${matricula.pagamento.numComprovativo}" ${disabled} >
														</td>
														<td width="15%">
															<label>Valor (Taxa):</label>
														</td>
														<td width="35%">
															<input type="number" name="valor" id="valor" style=" width : 290px;" value="${matricula.pagamento.valor}" ${disabled} >
															<input style=" width : 52px;" value="MT" disabled="disabled" align="bottom">
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
										<td colspan="4">
											<c:if test="${(currStepMatricula!='VISUALIZAR') || (currStepMatricula=='EDITAR')}">
												<fieldset>
													<table width="100%">
														<tr>
															<td align="right">
																<c:choose>
																	<c:when test="${(matricula.selfId==null)|| (matricula.selfId==0)}">
																		<input type="submit" name="action" value="Salvar" onclick="setMatriculaStatus();">
																		<input type="reset" value="Limpar" >
																	</c:when>
																	<c:otherwise>
																		<input type="submit" name="action" value="Actualizar" onclick="setMatriculaStatus();" >
																		<input type="submit" name="action" value="Cancelar">
																	</c:otherwise>
																</c:choose>
															</td>
														</tr>
													</table>
												</fieldset>
											</c:if>
										</td>
									</tr>
								</table>
							</fieldset>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<div align="right">
			<c:if test="${(currStepMatricula!=null) && (currStepMatricula=='VISUALIZAR')}">
				<fieldset>
					<table>
						<tr>
							<td>
								<form id="matriculaDelForm" action="/sigra/matriculaaction/remove" method="post" modelAttribute="matricula" >
									<input type="hidden" name="selfId" value="${matricula.selfId}"/>
									<input type="submit" value="Remover" > 
								</form>
							</td>
							<td>
								<form id="matriculaEditarForm" action="/sigra/matriculaaction/editar" method="get" modelAttribute="matricula" >
									<input type="hidden" name="selfId" value="${matricula.selfId}"/>
									<input type="submit" value="Alterar">
								</form>
							</td>
							<td>
								<form id="matriculaAbortarEdicaoForm" action="/sigra/matriculaaction/abortaredicao" method="get" modelAttribute="matricula" >
									<input type="submit" value="Abortar Edi&ccedil;&atilde;o">
								</form>
							</td>
							<td>
								<form target="_blank" id="matriculaPrintComprovativoForm" action="/sigra/matriculaaction/printcomprovativo" method="get" modelAttribute="matricula" >
									<input type="hidden" name="selfId" value="${matricula.selfId}"/>
									<input type="submit" value="Imprimir Comprovativo">
								</form>
							</td> 
<!-- 							<td> -->
<%-- 								<input type="button" name="imprimirComprovativo" id="imprimirComprovativo" onclick="window.open('/sigra/matriculaaction/printcomprovativo?selfId=${matricula.selfId}' "status=yes,menubar=no,scrollbars=yes,height=480,width=640" )"  value="Imprimir Comprovativo"> --%>
<!-- 							</td> -->
						</tr>
					</table>
				</fieldset>
			</c:if>
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
												<legend>Hist&oacute;rico de Renova&ccedil;&atilde;o de Matr&iacute;culas</legend>
											<table>
												<tr align="left">
													<th width="5%" >SELECCIONAR</th>	
													<th width="30%">ANO LECTIVO</th>
													<th width="30%">MATR&Iacute;CULA</th>
													<th width="35%">DATA DE RENOVA&Ccedil;&Atilde;O</th>
												</tr>
													<c:forEach items="${allMatriculaByProcId}" var="matricula" >
													<tr>
														<td height="20" valign="middle" align="center">
															<a href="/sigra/matriculaaction/selectedMatricula?selfId=${matricula.selfId}" >
														       <img src="<c:url value="/imagens/edit_big.gif" />" width="22px" height="22px" title="Clica aqui para Detalhar!"/>
																 <!--  <img src="comuns/images/edit_big.gif" width="22px" height="22px" title="Clica aqui para Detalhar!" /> -->  
															</a>
														</td>
														<td>${matricula.anoLectivo}</td>
														<td>${matricula.estadoMatricula}</td>	
														<td>${matricula.dataExecucao}</td>	
													</tr>
												</c:forEach>
											</table>
									
										</fieldset>
									</td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>
		</div>
		
		<div>
			<fieldset>
				<form action="">
					<table width="100%">
						<tr>
							<td align="right">
								<input type="submit" value="Volar">
							</td>
						</tr>
					</table>
				</form>
			</fieldset>
		</div>
	</fieldset>
	
	<c:import url="/rodape.jsp" /> 
</body>
</html>