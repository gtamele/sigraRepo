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



	
	function remove(selfId){
	
		$.get("remove",{'selfId':selfId});
	}

	function cancelar(){
		
		$.get("cancelar");
	}


	function editar(){

		$.get("editar");

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
		
		return true;
	}
		
	</script>
	
	</head>
	<body>
		
	<c:import url="/cabecalho.jsp" /> 	
	
		<form id="especialidadeForm" action="/sigra/especialidade/save" method="post" modelAttribute="especialidade" >
		
			<fieldset>
				
				<h4 align="center"> CADASTRO DE ESPECIALIDADE</h4>
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
							
							<fieldset>
								<table>
									<tr>
										<td>
											<c:if test="${especialidade.selfId!=null && especialidade.selfId>0}">
												<input  name="selfId" id="selfId" value="${especialidade.selfId}" hidden="true">
											</c:if>
										</td>
									</tr>
									<tr>
										<td width="15%">
											<label> Designa&ccedil;&atilde;o:</label>
										</td>
										<td width="35%">
											<span id="refresh_01">				
												<input type="text" id="designacao" name="designacao" style=" width : 350px;" value="${especialidade.designacao}"  >
											</span>
										</td>
										<td width="15%" align="right">	
											<label>Descri&ccedil;&atilde;o:</label>
										</td>
										<td width="35%" rowspan="7">
											<span id="refresh_02">
												<textarea name="descricao" id="descricao" rows="5" cols="40" style=" width : 350px; height : 108px;"  >${especialidade.descricao}</textarea>
											</span>
										</td>
										
									</tr>
									<tr>
										<td>
											<label>Esp.C&oacute;digo:</label>
										</td>
										<td>
											<input type="text" name="codigo" id="codigo" value="${especialidade.codigo}" style=" width : 350px;" } >
										</td>
									</tr>
									<tr>
										<td>
											<label>Dura&ccedil;&atilde;o Diurno:</label>
										</td>
										<td>
											<input type="text" name="numSemestresdiurno" id="numSemestresdiurno" value="${especialidade.numSemestresdiurno}" 
											style=" width : 350px;" placeholder="Insira o n&ordm; de semestres do curso no turno Diuurno" >
										</td>
									</tr>
									<tr>
										<td>
											<label>Dura&ccedil;&atilde;o Noturno:</label>
										</td>
										<td>
											<input type="text" name="numSemestresNocturno" id="numSemestresNocturno" value="${especialidade.numSemestresNocturno}" 
											style=" width : 350px;" placeholder="Insira o n&ordm; de semestres do curso no turno Noturno" >
										</td>
									</tr>
									<tr>
										<td width="15%">
											<label>Departamento:</label>
										</td>
										<td>
										<!-- <c:choose>
												<c:when test="${currStepEspecialidade != 'VISUALIZAR'}">  -->	
													<select name="departamento" id="departamento" style=" width : 354px;" >  
													  <c:forEach var="departamento" items="${allDepts}">  
														<option value="${departamento.selfId}"}> ${departamento.designacao}</option>
													  </c:forEach>  
													</select>
										<!-- 		</c:when>
												<c:otherwise>
													<input type="text" name="departamento" id="departamento" value="${especialidade.departamento.designacao}" style=" width : 350px;" } >
												</c:otherwise>
											</c:choose>	 -->
										</td>
									</tr>
									
								</table>
							</fieldset>
						</td>
					</tr>
					<tr>
						
						<td>
							<fieldset>
								<table>
									<tr>
									
										<td align="right">
											<c:choose>
												<c:when test="${(especialidade.selfId == null )|| (especialidade.selfId==0) }">
													<input type="submit" name="action" value="Salvar" >
													<input type="reset" value="Limpar" >
												</c:when>
												<c:otherwise>
												<!-- <input type="button" id="Actualizar" value="Actualizar" onclick="actualizar(${especialidade});" >	 -->	
													
													<input type="submit" name="action" value="Actualizar" >
													<input type="button" value="Remover" onclick="remove(${especialidade.selfId});">
													<input type="button" value="Cancelar" onclick="cancelar();">	
												</c:otherwise>
											</c:choose>
													
										</td>
										<td >
											<c:if test="${currStepEspecialidade == 'EDITAR' }">
												
											 </c:if>
										</td>
										<td>
												
										</td>
									</tr>
								</table>
							</fieldset>
						</td>
					</tr>
					<tr>
						<td>&nbsp;
						</td>
					</tr>
					<tr>
						<td>
							<fieldset>
								<legend>Lista de Especialidade</legend>
								<table width="100%">
									<tr>
									<!-- 	<td width="15%"></td> -->
										<td width="85%">
											<table >
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
															<a href="/sigra/especialidade/selectedEsp?selfId=${espec.selfId}" >
																
															    
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
					<tr>
						<td align="right">
							<input type="button" name="voltar" id="voltar" value="Voltar"> 
						</td>
					</tr>
				</table>
			</fieldset>
			
		</form>
		<c:import url="/rodape.jsp" /> 
	</body>
</html>