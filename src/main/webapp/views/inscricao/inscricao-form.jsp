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


	function getCheckedDisciplinas(){

		var listaDiscSeleccionadas = document.getElementsByName('disc.designacao');

		var novaLista=[];

		for (var i =0; i<listaDiscSeleccionadas.length; i++){
			if(listaDiscSeleccionadas[i].checked){
				
				novaLista.push(listaDiscSeleccionadas[i].value);
			//	document.getElementsByName('disciplinas').push(disciplinas[i].value);
			}
				
		}
		console.log("Nova Lista: "+novaLista);
		document.getElementsByName('discSeleccionadas').values=novaLista;

		console.log("Disciplinas Selecioanadas: "+document.getElementsByName('discSeleccionadas').values)
	}


	 $(document).ready(function() {
         $("#inscricaoForm").submit(function(e) {
             if(!validar()) {
                 e.preventDefault();
             }
         });             
     });

	function validar(){
		
		if (document.getElementById('taxaInscricao').value == ''){
			alert("O campo 'Taxa' deve ser preenchido");
			return false;
		}
										 
		
		return true;
	}

	
	
	
	</script>
	
	</head>
<body>	
	<c:import url="/cabecalho.jsp" /> 
	
	<fieldset>
		<h4 align="center"> INSCRI&Ccedil;&Atilde;O &Agrave;S CADEIRAS (DISCIPLINAS)</h4>
		<div>
			<form id="inscricaoForm" action="/sigra/inscricaoaction/save" method="post" modelAttribute="inscricao" > 
			
		<!-- 	<input type="hidden" name="discSeleccionadas" id="discSeleccionadas" value=""/>  -->	
				
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
										<td >
											<label>Taxa:</label>
										</td>
										<td>
											<input type="text" name="taxaInscricao" id="taxaInscricao" style=" width : 350px;" value="${inscricao.taxaInscricao}"  >
										</td>
										<td>&nbsp;</td>
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
								<table width="100%">
									<tr>
										<td width="50%">
											<input type="button" value="I ANO" style=" width : 710px;">
										</td>
										<td  width="50%">
											<input type="button" value="II ANO" style=" width : 710px;">
										</td>
									</tr>
									<tr>
										<td  width="50%" >
											<input type="button" value="III ANO" style=" width : 710px;">
										</td>
										<td  width="50%">
											<input type="button" value="IV ANO" style=" width : 710px;">
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
								<table width="100%">
									<tr>	
									</tr>
									
									<tr>
										<td>
											<fieldset>
													<legend>Lista Disciplinas</legend>
												<table width="100%">
													
												<c:forEach items="${disciplinas}" var="disc" >
														<tr>
															
															<td>
																<input type="checkbox" name="disc.designacao" id="designacao" value="${disc.selfId}"> ${disc.designacao} </>
															</td>
															
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
					
					<tr>
						<td colspan="4">
							<c:if test="${(currStepMatricula!='VISUALIZAR') || (currStepMatricula=='EDITAR')}">
								<fieldset>
									<table width="100%">
										<tr>
											<td align="right">
												<c:choose>
													<c:when test="${(matricula.selfId==null)|| (matricula.selfId==0)}">
														<input type="submit" name="action" value="Salvar" >
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
						</tr>
					</table>
				</fieldset>
			</c:if>
		</div>
		
		
		
		<div>
			<fieldset>
				<form action="">
					<table width="100%">
						<tr>
							<td align="right">
								<input type="submit" value="Voltar">
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