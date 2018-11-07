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
	
		
	
	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 	<!--<script src="http://code.jquery.com/jquery-latest.min.js"></script> -->
	
	<script type="text/javascript" >



	
	function setDefaultDeptForCancel(){

		alert("Sai Msg");
		
		document.getElementById('departamento').value = '123';
	}


	

	   $(document).ready(function() {
           $("#especialidadeForm").submit(function(e) {
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
		if (document.getElementById('numSemestresdiurno').value == ''){
			alert("O campo 'Duração da Curso no turno Diurno' deve ser preenchido");
			return false;
		}

		if (document.getElementById('numSemestresNocturno').value == ''){
			alert("O campo 'Duração da Curso no turno Nocturno' deve ser preenchido");
			return false;
		}
			
		if (document.getElementById('departamento').value == ''){



			 if (document.getElementById('action2').value == "Cancelar") {
					var fakeDeptId = '000'
					document.getElementById('departamento').value = fakeDeptId;

					console.log("Dept é "+document.getElementById('departamento').value);
					console.log("Action é "+document.getElementById('action2').value);
					return true;
			}	

			 if ((document.getElementById('action').value == "Salvar")) {
				alert("Seleccione o 'Departamento' que tutela a Especialidade (Curso)");
				console.log("Action é "+document.getElementById('action').value);
				return false;
			}	
		}	

		return true;
	}
	
		
	</script>
	
	</head>
	<body>
	<c:import url="/views/menu/menu11.jsp" />	
	<c:import url="/cabecalho.jsp" /> 	
		<fieldset>
			<h4 align="center"> CADASTRO DE ESPECIALIDADE</h4>
				<div>
					<form id="especialidadeForm" action="/sigra/especialidadeaction/save" method="post" modelAttribute="especialidade" >
						<table width="100%">
							<tr>
								<td align="center" colspan="3"> 
									<font color="blue"> 
										${statusMsg} 
									</font>
									<font color="red"> 
										${errorMsg} 
									</font>
								</td>
							</tr>	
							<tr>
							<td>&nbsp;</td>
							</tr>
							<tr>
								<td>
									<c:set var="disabled" value="${currStepEspecialidade == 'VISUALIZAR' ? 'disabled' : ''}" />
									<fieldset>
										<table width="100%">
											<tr>
												<td>
													<c:if test="${especialidade.selfId!=null && especialidade.selfId>0}">
														<input type="hidden" name="selfId" id="selfId" value="${especialidade.selfId}" >
													</c:if>
												</td>
											</tr>
											<tr>
												<td width="15%">
													<label> Designa&ccedil;&atilde;o:</label>
												</td>
												<td width="35%">
													<span id="refresh_01">				
														<input type="text" id="designacao" name="designacao" style=" width : 350px;" value="${especialidade.designacao}" ${disabled}  >
													</span>
												</td>
												<td width="15%" align="right">	
													<label>Descri&ccedil;&atilde;o:</label>
												</td>
												<td width="35%" rowspan="7">
													<span id="refresh_02">
														<textarea name="descricao" id="descricao" rows="5" cols="40" style=" width : 350px; height : 108px;" ${disabled} >${especialidade.descricao}</textarea>
													</span>
												</td>
												
											</tr>
											<tr>
												<td>
													<label>Esp.C&oacute;digo:</label>
												</td>
												<td>
													<input type="text" name="codigo" id="codigo" value="${especialidade.codigo}" style=" width : 350px;" ${disabled} >
												</td>
											</tr>
											<tr>
												<td>
													<label>Dura&ccedil;&atilde;o Diurno:</label>
												</td>
												<td>
													<input type="number" name="numSemestresdiurno" id="numSemestresdiurno" value="${especialidade.numSemestresdiurno}" 
													style=" width : 350px;" placeholder="Insira o n&ordm; de semestres do curso no turno Diuurno" ${disabled} >
												</td>
											</tr>
											<tr>
												<td>
													<label>Dura&ccedil;&atilde;o Noturno:</label>
												</td>
												<td>
													<input type="number" name="numSemestresNocturno" id="numSemestresNocturno" value="${especialidade.numSemestresNocturno}" 
													style=" width : 350px;" placeholder="Insira o n&ordm; de semestres do curso no turno Noturno" ${disabled} >
												</td>
											</tr>
											<tr>
												<td width="15%">
													<label>Departamento:</label>
												</td>
												<td>
													<c:choose>
														<c:when test="${currStepEspecialidade != 'VISUALIZAR'}"> 
															<select name="departamento" id="departamento" style=" width : 353px;">  
															<option value="">-Seleccionar- </option>
															  <c:forEach var="departamento" items="${allDepts}">  
																<option value="${departamento.selfId}"> ${departamento.designacao}</option>
															  </c:forEach>  
															</select>
														</c:when>
														<c:otherwise>
															<input type="text" name="departamento" id="departamento" value="${especialidade.departamento.designacao}" style=" width : 350px;" ${disabled} >
														</c:otherwise>
													</c:choose>	
												</td>
											</tr>
											
										</table>
									</fieldset>
								</td>
							</tr>
							<tr>
								
								<td align="right">
									<c:if test="${(currStepEspecialidade!='VISUALIZAR') || (currStepEspecialidade=='EDITAR')}">
										<fieldset>
											<table width="100%">
												<tr>
													<td align="right">
														<c:choose>
															<c:when test="${(especialidade.selfId == null )|| (especialidade.selfId==0) }">
																<input type="submit" name="action" id="action" value="Salvar" >
																<input type="reset" value="Limpar" >
															</c:when>
															<c:otherwise>
																<input type="submit" name="action" id="action" value="Actualizar" >
																<input type="submit" name="action" id="action2" value="Cancelar" >	
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
					</form>
				</div>
				
				<div align="right">
					<c:if test="${(currStepEspecialidade!=null) && (currStepEspecialidade=='VISUALIZAR')}">
						<fieldset>
							<table>
								<tr>
									<td>
										<form id="especialidadeRemoveForm" action="/sigra/especialidadeaction/remove" method="post" modelAttribute="especialidade" >
											<input type="hidden" name="selfId" value="${especialidade.selfId}"/>
											<input type="submit" value="Remover" > 
										</form>
									</td>
									<td>
										<form id="especialidadeEditarForm" action="/sigra/especialidadeaction/editar" method="get" modelAttribute="especialidade" >
											<input type="hidden" name="selfId" value="${especialidade.selfId}"/>
											<input type="submit" value="Alterar">
										</form>
									</td>
									<td>
										<form id="especialidadeAbortarForm" action="/sigra/especialidadeaction/abortar" method="get" modelAttribute="especialidade" >
											<input type="submit" value="Abortar Edi&ccedil;&atilde;o">
										</form>
									</td>
								</tr>
							</table>
						</fieldset>
					</c:if>
				</div>
					
				<div>
					<table width="100%">
						<tr>
							<td>&nbsp;
							</td>
						</tr>
					</table>
				</div>
				<div>
					<table width="100%">
						<tr>
							<td>
								<fieldset>
									<legend>Lista de Especialidade</legend>
									<table width="100%">
										<tr>
										<!-- 	<td width="15%"></td> -->
											<td width="85%">
												<table width="100%" >
													<tr align="left">
														<th width="5%" >EDITAR</th>	
														<th width="20%">DESIGNA&Ccedil;&Atilde;O</th>
														<th width="20%">N&ordm; de Semestres Diurno</th>
														<th width="20%">N&ordm; de Semestres Nocturno</th>
														<th width="35%">DEPARTAMENTO</th>
													</tr>
													<c:forEach items="${allEspecialidades}" var="espec">
														<tr>
															<td height="20" valign="middle">
																<a href="/sigra/especialidadeaction/selectedEsp?selfId=${espec.selfId}" >
																	
																    
															       <img src="<c:url value="/imagens/edit_big.gif" />" width="22px" height="22px" title="Clica aqui para Detalhar!"/>
															 <!--  <img src="comuns/images/edit_big.gif" width="22px" height="22px" title="Clica aqui para Detalhar!" /> -->  
																</a>
															</td>
															<td>${espec.designacao}</td>
															<td>${espec.numSemestresdiurno}</td>
															<td>${espec.numSemestresNocturno}</td>
															<td>${espec.departamento.designacao}</td>	
														</tr>
													</c:forEach>
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