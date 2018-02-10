<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@	taglib tagdir="/WEB-INF/tags" prefix="sb" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	
	 <!--	 <link type="text/css" href="resources/css/estilos01.css" rel="stylesheet"/>-->
		<link href="<c:url value="/resources/css/sigraStyle.css" />" rel="stylesheet"> 
		<link type="text/css" href="resources/css/jquery-ui-1.10.1.custom.css" rel="stylesheet"> 
		 
		<script type="text/javascript" src="resources/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui-1.10.1.custom.js"></script>
		
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
		
<title>Insert title here</title>
	<script type="text/javascript">

	function selectGenero(){
		var generoList = document.getElementsByName('radioGenero');
												 
		var radioMasc = document.getElementById('generoMasc').checked;
		var radioFem  = document.getElementById('generoFem').checked;
		
		var i;
		
		for(i=0; i<generoList.length; i++){
			
			if(generoList[i].checked){
				document.getElementById('genero').value = generoList[i].value;
				break;
			}
		}
	}
	

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
		if (document.getElementById('genero').value == ''){
			alert("O campo 'Género' deve ser preenchido");
			return false;
		}								 

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

	</script>
</head>
<body>

<c:import url="/cabecalho.jsp" />
	<form action="/sigra/pessoa/save" method="post" modelAttribute="pessoa" >
	
		<input type="hidden" name="genero" id="genero" value=""/>
	
		<fieldset>
			<h4 align="center"> CADASTRO DE PESSOA</h4>
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
				<tr>
					<td>
						<table width="100%">
							<tr>
								<td>							  
									<c:set var="disabled" value="${currStepPessoa == 'VISUALIZAR' ? null : null}" />
									<fieldset>
									<legend>Identifica&ccedil;&atilde;o</legend>
										<table width="100%">
											<tr>
												<td width="5%" colspan="4">
													<label>Nome:</label>
												</td>
												<td width="35%" align="left">
													<input name="nome" id="nome"  style=" width : 350px;" value="${pessoa.nome}" ${disabled} >
												</td>
												<td width="5%">
													<label>Apelido:</label>
												</td>
												<td width="35%">
													<input name="apelido" id="apelido" style=" width : 350px;" value="${pessoa.apelido}" ${disabled}>
												</td>
											</tr>
											<tr>
												<td width="5%" colspan="4">
													<label>Data Nasc:</label>
												</td>
												<td >
											
													 <sb:campoData1 id="dataNascimento" name="dataNascimento" value="${pessoa.dataNascimento}" 	/> 
												</td>
												<td width="5%">
													<label>G&eacute;nero</label>
												</td>
												<td width="35%">
													<c:choose>
														<c:when test="${currStepPessoa != 'VISUALIZAR'}">
															<input name="radioGenero" type ="radio" id="generoMasc" value = "M"> <label>Masculino </label>
															<input name="radioGenero" type ="radio" id="generoFem"  value = "F"> <label>Feminino </label>
														</c:when>
														<c:otherwise>
															<input type="text" name="genero" id="genero" style=" width : 350px;" value="${pessoa.genero}" ${disabled}>
														</c:otherwise>
													</c:choose>
												</td>
											</tr>
											<tr>
												<td width="5%" colspan="4">
													<label>Nacionalidade:</label>
												</td>
												<td width="35%" align="left">
													<input name="nacionalidade" id="nacionalidade" style=" width : 350px;" value="${pessoa.nacionalidade}" ${disabled}>
												</td>
												<td width="5%" >
													<label>Estado Civ&iacute;l:</label>
												</td>
												<td width="35%" align="left">
													<c:choose>
														<c:when test="${currStepPessoa != 'VISUALIZAR'}">
															<select name="estadoCivil" id="estadoCivil" style=" width : 355px;" value="${pessoa.estadoCivil}">
																<option> </option>
																<option value="Solteiro(a)">Solteiro(a) </option>
																<option value="Casado(a)">Casado(a)</option>
																<option value="Divorciado(a)">Divorciado(a)</option>
																<option value="Viuvo(a)">Viuvo(a)</option>
															</select>
														</c:when>
															<c:otherwise>
																<input type="text" name="estadoCivil" id="estadoCivil" style=" width : 350px;" value="${pessoa.estadoCivil}" ${disabled}>
															</c:otherwise>
													</c:choose>
												</td>
											</tr>
											<tr>
												<td width="5%" colspan="4">
													<label>Doc Ident:</label>
												</td>
												<td width="35%" align="left">
													
															<select name="tipoDoc" style=" width : 174px;">  
															  <c:forEach var="tipoDoc" items="${allTipoDocIdent}">  
																<option value="${tipoDoc.selfId}"}> ${tipoDoc.designacao}</option>  
															  </c:forEach>  
															</select>
														
												</td>
												<td width="5%">
													<label>N&uacute;mero:</label>
												</td>
												<td width="35%">
													<input name="numero" id="numero" style=" width : 350px;" value="${pessoa.documento.numero}" ${disabled} >
												</td>
											</tr>
											<tr>
												<td width="5%" colspan="4">
													<label>Data Emiss&atilde;o:</label>
												</td>
												<td width="35%" align="left">
													<sb:campoData1 id="emissao" name="emissao" value="${pessoa.documento.emissao}" />
												</td>
												<td width="5%">
													<label>Data Validade:</label>
												</td>
												<td width="35%">
													<sb:campoData1 id="validade" name="validade" value="${pessoa.documento.validade}"/>
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
										<legend>Naturalidade</legend>
										<table width="100%">
											<tr>
												<td align="center" colspan="4">
													<input name="radionaturalidade" type ="radio" id="rural" value = "rural" > <label>Rural </label>
													<input name="radionaturalidade" type ="radio" id="urbano"  value = "urbano"> <label>Urbano </label>
												</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td width="5%" >
													<label>Prov&iacute;ncia:</label>
												</td>
												<td width="35%" align="left">
													<select name="provincia" id="provincia" items="" style=" width : 350px;" > </select>
												</td>
												<td width="5%">
													<label>Distrito:</label>
												</td>
												<td width="35%">
													<select name="distrito" id="distrito" style=" width : 350px;"> </select>
												</td>
											</tr>
											<tr>
												<td width="5%" >
													<label>Posto Admin:</label>
												</td>
												<td width="35%" align="left">
													<select name="postoAdmin" id="postoAdmin" items="" style=" width : 350px;"> </select>
												</td>
												<td width="5%">
													<label>Localidade:</label>
												</td>
												<td width="35%">
													<select name="localidade" id="localidade" style=" width : 350px;"> </select>
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
										<legend>Morada</legend>
										<table width="100%">
											<tr>
												<td width="5%">
													<label>Bairro:</label>
												</td>
												<td width="35%" align="left">
													<input name="bairro" id="bairro" style=" width : 350px;" value="${pessoa.endereco.bairro}" ${disabled}>
												</td>
												<td width="5%">
													<label>N&ordm; Quarteir&atilde;o:</label>
												</td>
												<td width="35%">
													<input name="numQuarteirao" id="numQuarteirao" style=" width : 350px;" value="${pessoa.endereco.numQuarteirao}" ${disabled}>
												</td>
											</tr>
											<tr>
												<td width="5%" >
													<label>Av/Rua:</label>
												</td>
												<td width="35%" align="left">
													<input name="nomeRuaAvenida" id="nomeRuaAvenida" style=" width : 350px;" value="${pessoa.endereco.nomeRuaAvenida}" ${disabled}>
												</td>
												<td width="5%">
													<label>N&uacute;mero:</label>
												</td>
												<td width="35%">
													<input name="numeroRuaAvenida" id="numeroRuaAvenida" style=" width : 350px;" value="${pessoa.endereco.numeroRuaAvenida}"${disabled}>
												</td>
											</tr>
												<td width="5%">
													<label>N&ordm; de Casa:</label>
												</td>
												<td width="35%">
													<input name="numeroCasa" id="numeroCasa" style=" width : 350px;" value="${pessoa.endereco.numeroCasa}" ${disabled}>
												</td>
												<td width="5%" >
													<label>Andar:</label>
												</td>
												<td width="35%" align="left">
													<input name="andar" id="andar" style=" width : 350px;" value="${pessoa.endereco.andar}" ${disabled}>
												</td>
											<tr>
											</tr>
											<tr>
												<td width="5%">
													<label>Cell:</label>
												</td>
												<td width="35%">
													<input name="telfCell" id="telfCell" style=" width : 350px;" value="${pessoa.endereco.telfCell}" ${disabled} >
												</td>
												<td width="5%" >
													<label>Telfefone (Fixo):</label>
												</td>
												<td width="35%" align="left">
													<input name="telfFixo" id="telfFixo" style=" width : 350px;" value="${pessoa.endereco.telfFixo}" ${disabled}>
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
													<input name="nomePai" id="nomePai" style=" width : 350px;" value="${pessoa.nomePai}" ${disabled}>
												</td>
												<td width="5%">
													<label>Nome da M&atilde;e:</label>
												</td>
												<td width="35%">
													<input name="nomeMae" id="nomeMae" style=" width : 350px;" value="${pessoa.nomeMae}" ${disabled}>
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
									<table width="100%">
										<tr>
											<td align="right">
												<c:choose>
													<c:when test="${(pessoa.selfId == null )|| (dept.selfId==0) }">
														<input type="submit" name="action" value="Salvar" onclick="selectGenero();">
														<input type="reset" name="limpar" id="limpar" value="Limpar">
													</c:when>
													<c:otherwise>
														<input type="submit" name="action" value="Actualizar" >
														<input type="button" value="Remover" onclick="remove(${pessoa.selfId});">
														<input type="button" value="Cancelar" onclick="cancelar();">	
													</c:otherwise>
												</c:choose>
														<input type="button" name="voltar" id="voltar" value="Voltar"> 
											</td>
										</tr>
									</table>
								</fieldset>
							</td>
						</tr>
						
					</table>
				</td>
			</tr>
				
				
			</table>
		</fieldset>
	
	</form>
	<c:import url="/rodape.jsp" /> 
</body>
</html>