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
		<link type="text/css" href="resources/css/jquery-ui-1.10.1.custom.css" rel="stylesheet"> 
		 
		<script type="text/javascript" src="resources/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui-1.10.1.custom.js"></script>

<title>Insert title here</title>

	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<script type="text/javascript">
	
	function selectIsTecnica(){
		var isDiscTecnicaList = document.getElementsByName('radioIsDiscTecnica');

		
		var i;
		
		for(i=0; i<isDiscTecnicaList.length; i++){
			
			if(isDiscTecnicaList[i].checked){
				document.getElementById('tecnica').value = isDiscTecnicaList[i].value;
			//	console.log("Trab é "+document.getElementById('tecnica').value);
				break;
			}
		}

		
	}
	
	
		   $(document).ready(function() {
	           $("#disciplinaForm").submit(function(e) {
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
			if (document.getElementById('codigo').value == ''){
				alert("O campo 'Código' deve ser preenchido");
				return false;
			}	
			if (document.getElementById('duracaoLectiva').value == ''){
				alert("O campo 'Duração Lectiva' deve ser preenchido");
				return false;
			}					 
			
			return true;
		}
	
	
	
	</script>	

</head>
<body>
	<c:import url="/views/menu/menu11.jsp" />
	<c:import url="/cabecalho.jsp" /> 	
	<fieldset>
		<h4 align="center"> CADASTRO DA DISCIPLINA</h4>
		<div>
			<form id="disciplinaForm" action="/sigra/disciplinaaction/save" method="post" modelAttribute="disciplina" >
			
			<input type="hidden" name="tecnica" id="tecnica" value=""/>
			
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
						<c:set var="disabled" value="${currStepDisciplina == 'VISUALIZAR' ? 'disabled' : ''}" />
						<fieldset>
							<table width="100%">
								<tr>
									<td>
										<c:if test="${disciplina.selfId!=null && disciplina.selfId>0}">
											<input type="hidden" name="selfId" value="${disciplina.selfId}"/>
										</c:if>
									</td>
								</tr>
								<tr>
									<td width="15%">
										<label> Designa&ccedil;&atilde;o:</label>
									</td>
									<td width="35%">			
										<input type="text" id="designacao" name="designacao" style=" width : 350px;" value="${disciplina.designacao}" ${disabled} >
									</td>
									<td width="15%" align="right">	
										<label>Descri&ccedil;&atilde;o:</label>
									</td>
									<td width="35%" rowspan="3">
										<textarea name="descricao" id="descricao" rows="5" cols="40" style=" width : 350px;" ${disabled} >${disciplina.descricao}</textarea>
									</td>
								</tr>
								<tr>
									<td width="15%">
										<label> C&oacute;digo:</label>
									</td>
									<td width="35%">			
										<input type="text" id="codigo" name="codigo" style=" width : 350px;" value="${disciplina.codigo}" ${disabled} >
									</td>
								</tr>
								<tr>
									<td width="15%">
										<label>Carga Hor&aacute;ria</label>
									</td>
									<td width="35%">			
										<input type="text" id="cargaHoraria" name="cargaHoraria" style=" width : 240px;" value="${disciplina.cargaHoraria}" ${disabled} >
										<input style=" width : 100px;" value="Horas/semana" disabled="disabled">
									</td>
								</tr>
								<tr>
									<td width="15%">
										<label> Dura&ccedil;&atilde;o Lectiva:</label>
									</td>
									<td width="35%">
										<c:choose>
											<c:when test="${currStepDisciplina != 'VISUALIZAR'}">
												<select name="duracaoLectiva" id="duracaoLectiva" style=" width : 355px;" value="${disciplina.duracaoLectiva}" >
													<option> </option>
													<option value="Semestral">Semestral</option>
													<option value="Anual">Anual</option>
												</select>
											</c:when>
											<c:otherwise>
												<input type="text" id="duracaoLectiva" name="duracaoLectiva" style=" width : 350px;" value="${disciplina.duracaoLectiva}" ${disabled} >
											</c:otherwise>
										</c:choose>
									</td>
									<td align="right">
										<label>T&eacute;cnica:</label>
									</td>
									<td width="35%">
										<c:choose>
											<c:when test="${currStepDisciplina != 'VISUALIZAR'}">		
												<input name="radioIsDiscTecnica" type ="radio" id="simTecnica" value = true onclick="selectIsTecnica();" >   <label><strong>Sim</strong></label>  
												<input name="radioIsDiscTecnica" type ="radio" id="naoTecnica"  value = false onclick="selectIsTecnica();" > <label><strong>N&atilde;o</strong></label>
											</c:when>
											<c:otherwise>
												<input name="tecnica" id="tecnica" value="${disciplina.tecnica? 'Sim':'Não'}" style=" width : 350px;" ${disabled}>
											</c:otherwise>
										</c:choose>	
									</td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
				<tr>
					<td> 
						<c:if test="${(currStepDisciplina!='VISUALIZAR') || (currStepDisciplina=='EDITAR')}">
							<fieldset>
								<table width="100%">
									<tr>
										<td align="right">
											<c:choose>
												<c:when test="${(disciplina.selfId==null)|| (disciplina.selfId==0)}">
													<input type="submit" name="action" value="Salvar" >
													<input type="reset" value="Limpar" > 
												</c:when>
												<c:otherwise>
													<input type="submit" name="action" value="Actualizar" >
													<input type="submit" name="action"  value="Cancelar">
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											
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
		
			
		<div>
			<c:if test="${(currStepDisciplina!=null) && (currStepDisciplina=='VISUALIZAR')}">
				<fieldset>
					<table align="right">
						<tr>
							<td>
								<form id="disciplinaDelForm" action="/sigra/disciplinaaction/remove" method="post" modelAttribute="disciplina" >
									<input type="hidden" name="selfId" value="${disciplina.selfId}"/>
									<input type="submit" value="Remover" > 
								</form>
							</td>
							<td>
								<form id="disciplinaEditarForm" action="/sigra/disciplinaaction/editar" method="get" modelAttribute="disciplina" >
									<input type="hidden" name="selfId" value="${disciplina.selfId}"/>
									<input type="submit" value="Alterar">
								</form>
							</td>
							<td>
								<form id="disciplinaEditarForm" action="/sigra/disciplinaaction/abortar" method="get" modelAttribute="disciplina" >
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
					<td>
						<fieldset>
							<table width="100%">
								<tr>
									<td>
										<fieldset>
												<legend>Lista de Disciplinas</legend>
											<table>
												<tr align="left">
													<th width="5%" >EDITAR</th>	
													<th width="25%">DESIGNA&Ccedil;&Atilde;O</th>
													<th width="25%">C&Oacute;DICO</th>
													<th width="20%">Carga Hor&aacute;ria</th>
													<th width="25%">DURA&Ccedil;&Atilde;O LECTIVA</th>
												</tr>
													<c:forEach items="${allDisciplinas}" var="disc">
														<tr>
															<td height="20" valign="middle">
																<a href="/sigra/disciplinaaction/selecteddisc?selfId=${disc.selfId}" >
																	
																    
															       <img src="<c:url value="/imagens/edit_big.gif" />" width="22px" height="22px" title="Clica aqui para Detalhar!"/>
															 <!--  <img src="comuns/images/edit_big.gif" width="22px" height="22px" title="Clica aqui para Detalhar!" /> -->  
																</a>
															</td>
															<td>${disc.designacao}</td>
															<td>${disc.codigo}</td>
															<td>${disc.cargaHoraria}</td>
															<td>${disc.duracaoLectiva}</td>	
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
			<form id="disciplinaBackHomeForm" action="/sigra/disciplinaaction/home" method="get" modelAttribute="disciplina" >
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