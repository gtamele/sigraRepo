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
           $("#usuarioForm").submit(function(e) {
               if(!validar()) {
                   e.preventDefault();
               }
           });             
       });

	function selectUsuarioStatus(){
		
		var statusUsuarioList = document.getElementsByName('radioUserStatus');
												 
		var radioActivo = document.getElementById('statusActivo').checked;
		var radioInactivo  = document.getElementById('statusInactivo').checked;

		if (statusUsuarioList == null) return;
		
		var i;
		
		for(i=0; i<statusUsuarioList.length; i++){
			
			if(statusUsuarioList[i].checked){
				document.getElementById('statusUsuarioActivo').value = statusUsuarioList[i].value;
				break;
			}
		}
	}
		

	function validar(){

		if (document.getElementById('nome').value == ''){
			alert("O campo 'Nome' deve ser preenchido");
			return false;
		}
		if (document.getElementById('email').value == ''){
			alert("O campo 'email' deve ser preenchido");
			return false;
		}	
		if (document.getElementById('userName').value == ''){
			alert("O campo 'Nome de Login' deve ser preenchido");
			return false;
		}

		if (document.getElementById('password').value == ''){
			alert("O campo 'PassWord' deve ser preenchido");
			return false;
		}					 

		if (document.getElementById('statusUsuarioActivo').value == ''){
			alert("O campo 'Estado de Utilizador' deve ser preenchido");
			return false;
		}	
		
		return true;
	}
		
	</script>
	
	</head>
	<body>
	<c:import url="/views/menu/menu11.jsp" /> 	
	<c:import url="/cabecalho.jsp" /> 	
	
		<form id="usuarioForm" action="/sigra/usuario/save" method="post" modelAttribute="usuario" >
		
		<input type="hidden" name="statusUsuarioActivo" id="statusUsuarioActivo" value=""/>
		
			<fieldset>
				
				<h4 align="center"> CADASTRO DE UTILIZADOR</h4>
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
											<c:if test="${usuario.selfId!=null && usuario.selfId>0}">
												<input  name="selfId" id="selfId" value="${usuario.selfId}" hidden="true">
											</c:if>
										</td>
									</tr>
									<tr>
										<td width="10%">
											<label>Nome:</label>
										</td>
										<td width="35%">
											<span id="refresh_01">				
												<input type="text" id="nome" name="nome" style=" width : 350px;" value="${usuario.nome}"  >
											</span>
										</td>
										<td width="10%">
											<label>E-mail:</label>
										</td>
										<td width="35%">
											<input type="text" name="email" id="email" value="${usuario.email}" style=" width : 350px;"  >
										</td>
									
									</tr>
									
									<tr>
										<td width="10%">
											<label>Nome de Login:</label>
										</td>
										<td width="35%">
											<input type="text" name="userName" id="userName" value="${usuario.userName}" style=" width : 350px;" } >
										</td>
										<td>
											<label>PassWord:</label>
										</td>
										<td>
											<input type="password" name="password" id="password" value="${usuario.password}" style=" width : 350px;" >
										</td>
									</tr>
									
									<tr>
										<td width="10%">
											<label>Tipo Utilizador:</label>
										</td>
										<td width="35%">
										<!-- <c:choose>
												<c:when test="${currStepEspecialidade != 'VISUALIZAR'}">  -->	
													<select name="tipoUsuario" id="tipoUsuario" style=" width : 354px;" >  
													  <c:forEach var="tipoUsuario" items="${allTipoUsuario}">  
														<option value="${tipoUsuario.selfId}"}> ${tipoUsuario.designacao}</option>
													  </c:forEach>  
													</select>
										<!-- 		</c:when>
												<c:otherwise>
													<input type="text" name="departamento" id="departamento" value="${usuario.departamento.designacao}" style=" width : 350px;" } >
												</c:otherwise>
											</c:choose>	 -->
										</td>
										<td>
											<label>PassWord Confirma&ccedil;&atilde;o:</label>
										</td>
										<td>
											<input type="password" name="passwordConfirmacao" id="passwordConfirmacao" value="${usuario.passwordConfirmacao}" style=" width : 350px;" >
										</td>
										
									</tr>
									<tr>
										<td>
											<label>Estado de Utilizador:</label>
										</td>
										<td>
											<input name="radioUserStatus" type ="radio" id="statusActivo" value = true> <label>Activo </label>
											<input name="radioUserStatus" type ="radio" id="statusInactivo"  value = false> <label>Inactivo </label>
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
												<c:when test="${(usuario.selfId == null )|| (usuario.selfId==0) }">
													<input type="submit" name="action" value="Salvar" onclick="selectUsuarioStatus();">
													<input type="reset" value="Limpar" >
												</c:when>
												<c:otherwise>
												<!-- <input type="button" id="Actualizar" value="Actualizar" onclick="actualizar(${usuario});" >	 -->	
													
													<input type="button" value="Remover" onclick="remove(${usuario.selfId});">
													<input type="button" value="Cancelar" onclick="cancelar();">	
													<input type="button" value="Editar" onclick="editar();">
													<input type="submit" name="action" value="Actualizar" >
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
													<th width="20%">UTILIZADOR</th>
													<th width="20%">TIPO UTILIZADOR</th>
													<th width="20%">ACTIVO</th>
													<th width="25%">E-MAIL</th>
												</tr>
												<c:forEach items="${allUsuarios}" var="user">
													<tr>
														<td height="20" valign="middle">
															<a href="/sigra/usuario/selectedUsuario?selfId=${user.selfId}" >
																
															    
														       <img src="<c:url value="/imagens/edit_big.gif" />" width="22px" height="22px" title="Clica aqui para Detalhar!"/>
														 <!--  <img src="comuns/images/edit_big.gif" width="22px" height="22px" title="Clica aqui para Detalhar!" /> -->  
															</a>
														</td>
														<td>${user.userName}</td>
														<td>${user.tipoUsuario.designacao}</td>
														<td>${user.statusUsuarioActivo==true? 'Sim': 'N&atilde;o'}</td>
														<td>${user.email}</td>
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