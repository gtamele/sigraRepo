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

	function selectGenero(){
		var generoList = document.getElementsByName('radioGenero');
												 
		var radioMasc = document.getElementById('generoMasc').checked;
		var radioFem  = document.getElementById('generoFem').checked;
		
		var i;
		
		for(i=0; i<generoList.length; i++){
			
			if(generoList[i].checked){
				document.getElementById('genero').value = generoList[i].value;
				console.log("Genero é "+document.getElementById('genero').value);
				break;
			}
		}

	}

	 $(document).ready(function() {
         $("#pessoaForm").submit(function(e) {
             if(!validar()) {
                 e.preventDefault();
             }
         });             
     });

	function validar(){

		if (document.getElementById('nome').value == ''){
			alert("O campo 'Nome' deve ser preenchido");
			return false;
		}
		if (document.getElementById('apelido').value == ''){
			alert("O campo 'Apelido' deve ser preenchido");
			return false;
		}	
		if (document.getElementById('dataNascimento').value == ''){
			alert("O campo 'Data de Nascimento' deve ser preenchido");
			return false;
		}
	/**	if (document.getElementById('genero').value == ''){
			alert("O campo 'Género' deve ser preenchido");
			return false;
		}								 
	**/
		if (document.getElementById('nacionalidade').value == ''){
			alert("O campo 'Nacionalidade' deve ser preenchido");
			return false;
		}
		if (document.getElementById('estadoCivil').value == ''){
			alert("O campo 'Estado Civil' deve ser preenchido");
			return false;
		}	
			
		return true;
	}


	function showTrab(){

		$('#isTrab').removeClass('hidden')

	}

	function hideTrab(){

		$('#isTrab').addClass('hidden')

	}


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

	</script>
</head>
<body>
<c:import url="/views/menu/menu11.jsp" /> 
<c:import url="/cabecalho.jsp" />
	
	
		
		
	
		<fieldset>
			<h4 align="center"> CADASTRO DE ESTUDANTE</h4>
			
			<div>
				<form id="pessoaForm" action="/sigra/estudante/save" method="post" modelAttribute="estudante" >
				
				<input type="hidden" name="genero" id="genero" value=""/>
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
							<td>
								<table width="100%">
									<tr>
										<td>							  
											<c:set var="disabled" value="${currStepEstudante == 'VISUALIZAR' ? 'disabled' : ''}" />
											<fieldset>
											<legend>Identifica&ccedil;&atilde;o</legend>
												<table width="100%">
													<tr>
														<td width="5%" colspan="4">
															<label>Nome:</label>
														</td>
														<td width="35%" align="left">
															<input name="nome" id="nome"  style=" width : 350px;" value="${estudante.nome}" ${disabled} >
														</td>
														<td width="5%">
															<label>Apelido:</label>
														</td>
														<td width="35%">
															<input name="apelido" id="apelido" style=" width : 350px;" value="${estudante.apelido}" ${disabled}>
														</td>
													</tr>
													<tr>
														<td width="5%" colspan="4">
															<label>Data Nasc:</label>
														</td>
														<td >
													
															 <sb:campoData1 id="dataNascimento" name="dataNascimento" value="${estudante.dataNascimento}" 	/> 
														</td>
														<td width="5%">
															<label>G&eacute;nero</label>
														</td>
														<td width="35%">
															<c:choose>
																<c:when test="${currStepEstudante != 'VISUALIZAR'}">
																	<input name="radioGenero" type ="radio" id="generoMasc" value = "M"> <label>Masculino </label>
																	<input name="radioGenero" type ="radio" id="generoFem"  value = "F"> <label>Feminino </label>
																</c:when>
																<c:otherwise>
																	<input type="text" name="genero" id="genero" style=" width : 350px;" value="${estudante.genero}" ${disabled}>
																</c:otherwise>
															</c:choose>
														</td>
													</tr>
													<tr>
														<td width="5%" colspan="4">
															<label>Nacionalidade:</label>
														</td>
														<td width="35%" align="left">
															<input name="nacionalidade" id="nacionalidade" style=" width : 350px;" value="${estudante.nacionalidade}" ${disabled}>
														</td>
														<td width="5%" >
															<label>Estado Civ&iacute;l:</label>
														</td>
														<td width="35%" align="left">
															<c:choose>
																<c:when test="${currStepEstudante != 'VISUALIZAR'}">
																	<select name="estadoCivil" id="estadoCivil" style=" width : 355px;" value="${estudante.estadoCivil}">
																		<option> </option>
																		<option value="Solteiro(a)">Solteiro(a) </option>
																		<option value="Casado(a)">Casado(a)</option>
																		<option value="Divorciado(a)">Divorciado(a)</option>
																		<option value="Viuvo(a)">Viuvo(a)</option>
																	</select>
																</c:when>
																	<c:otherwise>
																		<input type="text" name="estadoCivil" id="estadoCivil" style=" width : 350px;" value="${estudante.estadoCivil}" ${disabled}>
																	</c:otherwise>
															</c:choose>
														</td>
													</tr>
													<tr>
														<td width="5%" colspan="4">
															<label>Doc Ident:</label>
														</td>
														<td width="35%" align="left">
															<c:choose>
																<c:when test="${currStepEstudante != 'VISUALIZAR'}">
																	<select name="tipoDoc" style=" width : 174px;">  
																	  <c:forEach var="tipoDoc" items="${allTipoDocIdent}">  
																		<option value="${tipoDoc.selfId}"> ${tipoDoc.designacao}</option>  
																	  </c:forEach>  
																	</select>
																</c:when>
																<c:otherwise>
																	<input type="text" name="tipoDoc" id="tipoDoc" style=" width : 350px;" value="${tipoDoc.designacao}" ${disabled}>
																</c:otherwise>
															</c:choose>
																
														</td>
														<td width="5%">
															<label>N&uacute;mero:</label>
														</td>
														<td width="35%">
															<input name="numero" id="numero" style=" width : 350px;" value="${estudante.documento.numero}" ${disabled} >
														</td>
													</tr>
													<tr>
														<td width="5%" colspan="4">
															<label>Data Emiss&atilde;o:</label>
														</td>
														<td width="35%" align="left">
															<sb:campoData1 id="emissao" name="emissao" value="${estudante.documento.emissao}" />
														</td>
														<td width="5%">
															<label>Data Validade:</label>
														</td>
														<td width="35%">
															<sb:campoData1 id="validade" name="validade" value="${estudante.documento.validade}"/>
														</td>
													</tr>
												</table>
											</fieldset>
										</td>
									</tr>
									<tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%">
									<tr>
										<td>
											<fieldset>
												<legend>Naturalidade</legend>
												<table width="100%">
												
													<tr>
														<td width="5%" >
															<label>Prov&iacute;ncia:</label>
														</td >
														<td width="35%" align="left" >
															<c:choose>
																<c:when test="${currStepEstudante != 'VISUALIZAR'}">
																	<select name="naturalidade" id="naturalidade" style=" width : 355px;" value="${estudante.naturalidade}"> 
																		<option> </option>
																		<option value="Maputo-Cidade">Maputo-Cidade </option>
																		<option value="Maputo-Provincia">Maputo Prov&iacute;ncia </option>
																		<option value="Gaza">Gaza </option>
																		<option value="Inhambane ">Inhambane </option>
																		<option value="Manica">Manica </option>
																		<option value="Sofala">Sofala</option>
																		<option value="Tete">Tete</option>
																		<option value="Zambezia">Zamb&eacute;zia </option>
																		<option value="Nampula">Nampula </option>
																		<option value="Cabo Delgado">Cabo Delgado </option>
																		<option value="Niassa">Niassa</option>
																	</select>
																</c:when>
																<c:otherwise>
																	<input type="text" name="naturalidade" id="naturalidade" style=" width : 350px;" value="${estudante.naturalidade}" ${disabled}>
																</c:otherwise>
															</c:choose>
														</td>
														<td width="5%" ></td>
														<td width="35%" align="left" ></td>
													</tr>
													
												</table>
											</fieldset>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%">
									<tr>
										<td>
											<fieldset>
												<legend>Morada</legend>
												<table width="100%">
													<tr>
														<td width="5%">
															<label>Bairro:</label>
														</td>
														<td width="35%" align="left">
															<input name="bairro" id="bairro" style=" width : 350px;" value="${estudante.endereco.bairro}" ${disabled}>
														</td>
														<td width="5%">
															<label>N&ordm; Quarteir&atilde;o:</label>
														</td>
														<td width="35%">
															<input type="number" name="numQuarteirao" id="numQuarteirao" style=" width : 350px;" value="${estudante.endereco.numQuarteirao}" ${disabled}>
														</td>
													</tr>
													<tr>
														<td width="5%" >
															<label>Av/Rua:</label>
														</td>
														<td width="35%" align="left">
															<input name="nomeRuaAvenida" id="nomeRuaAvenida" style=" width : 350px;" value="${estudante.endereco.nomeRuaAvenida}" ${disabled}>
														</td>
														<td width="5%">
															<label>N&uacute;mero:</label>
														</td>
														<td width="35%">
															<input type="number" name="numeroRuaAvenida" id="numeroRuaAvenida" style=" width : 350px;" value="${estudante.endereco.numeroRuaAvenida}"${disabled}>
														</td>
													</tr>
													<tr>
														<td width="5%">
															<label>N&ordm; de Casa:</label>
														</td>
														<td width="35%">
															<input type="number" name="numeroCasa" id="numeroCasa" style=" width : 350px;" value="${estudante.endereco.numeroCasa}" ${disabled}>
														</td>
														<td width="5%" >
															<label>Andar:</label>
														</td>
														<td width="35%" align="left">
															<input type="number" name="andar" id="andar" style=" width : 310px;" value="${estudante.endereco.andar}" ${disabled}>
															<input style=" width : 32px;" value="&ordm;" disabled="disabled" align="bottom">
														</td>
													</tr>
												</table>
											</fieldset>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%">
									<tr>
										<td>
											<fieldset>
												<legend>Contacto</legend>
												<table width="100%">
													<tr>
														<td width="5%">
															<label>Cell:</label>
														</td>
														<td width="35%">
															<input type="number" name="telfCell" id="telfCell" style=" width : 350px;" value="${estudante.contacto.telfCell}" ${disabled}>
														</td>
														<td width="5%">
															<label>Telfefone (Fixo):</label>
														</td>
														<td width="35%" align="left">
															<input name="telfFixo" id="telfFixo" style=" width : 350px;" value="${estudante.contacto.telfFixo}" ${disabled}>
														</td>
													</tr>
													<tr>
														<td width="5%" >
															<label>Email:</label>
														</td>
														<td width="35%" align="left">
															<input name="email" id="email" style=" width : 350px;" value="${estudante.contacto.email}" ${disabled}>
														</td>
														<td width="5%">
															<label>Fax:</label>
														</td>
														<td width="35%">
															<input type="number" name="fax" id="fax" style=" width : 350px;" value="${estudante.contacto.fax}"${disabled}>
														</td>
													</tr>
													
												</table>
											</fieldset>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%">
									<tr>
										<td>
											<fieldset>
												<legend>Filia&ccedil;&atilde;o</legend>
												<table width="100%">
													<tr>
														<td width="5%" colspan="4">
															<label>Nome do Pai:</label>
														</td>
														<td width="35%" align="left">
															<input name="nomePai" id="nomePai" style=" width : 350px;" value="${estudante.nomePai}" ${disabled}>
														</td>
														<td width="5%">
															<label>Nome da M&atilde;e:</label>
														</td>
														<td width="35%">
															<input name="nomeMae" id="nomeMae" style=" width : 350px;" value="${estudante.nomeMae}" ${disabled}>
														</td>
													</tr>
													
												</table>
											</fieldset>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>
								<fieldset>
									<legend>Dados Acad&eacute;micos</legend>
									<table width="100%">
										
										<tr>
											<td width="5%">
												<label>Estudante Trabalhador:</label>
											</td>
											<td width="35%" align="left">
												<input type ="radio" name="radioIsTrab"  id="trabSim" value = true  ${estudante.trabalhador==true? 'checked' : ''} onclick="showTrab();"  > <label>Sim </label>
												<input type ="radio" name="radioIsTrab"  id="trabNao"  value = false ${estudante.trabalhador==false? 'checked' : ''} onclick="hideTrab();" > <label>N&atilde;o </label> 
											</td> 
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
																		<input type ="text" name="localTrab"  id="localTrab" style="width: 350px"  value="${estudante.localTrab}" ${disabled} >
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
										<tr>
											<td>&nbsp;</td>
										</tr>
										<tr>
											<td colspan="4">
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
																		<input type="text" name="especialidade" id="especialidade" style="width: 350px" value="${especialidade.designacao}" ${disabled}  >
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
											<td colspan="4">
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
																<label>Cell:</label>
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
									</table>
								</fieldset>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%">
									<tr>
										<td>
											<c:if test="${(currStepEstudante!='VISUALIZAR') || (currStepEstudante=='EDITAR')}">
												<fieldset>
													<table width="100%">
														<tr>
															<td align="right">
																<c:choose>
																	<c:when test="${(estudante.selfId == null )|| (estudante.selfId==0) }">
																		<input type="submit" name="action" value="Salvar" onclick="selectGenero();isTrabSelector();">
																		<input type="reset" name="limpar" id="limpar" value="Limpar">
																	</c:when>
																	<c:otherwise>
																		<input type="submit" name="action" value="Actualizar" >
																		<input type="button" value="Cancelar" onclick="cancelar();">	
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
										<form id="estudanteRemoveForm" action="/sigra/estudante/remove" method="post" modelAttribute="estudante" >
											<input type="hidden" name="selfId" value="${estudante.selfId}"/>
											<input type="submit" value="Remover" > 
										</form>
									</td>
									<td>
										<form id="estudanteEditarForm" action="/sigra/estudante/editar" method="get" modelAttribute="estudante" >
											<input type="hidden" name="selfId" value="${especialidade.selfId}"/>
											<input type="submit" value="Editar">
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
				<div>
					<form id="tipoPedidoBackHomeForm" action="/sigra/estudante/home" method="get" modelAttribute="tipopedido" >
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