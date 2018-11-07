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



	function setDiferimento(){
		var diferimentoList = document.getElementsByName('radioDiferimento');
												 
		
		var i;
		
		for(i=0; i<diferimentoList.length; i++){
			
			if(diferimentoList[i].checked){
				document.getElementById('diferimento').value = diferimentoList[i].value;
				console.log("Genero é "+document.getElementById('diferimento').value);
				break;
			}
		}

	}


	

	   $(document).ready(function() {
           $("#pedidoForm").submit(function(e) {
               if(!validar()) {
                   e.preventDefault();
               }
           });             
       });


	function validar(){

		if (document.getElementById('tipoPedido').value == ''){
			alert("O campo 'Tipo de Pedido' deve ser preenchido");
			return false;
		}
		if (document.getElementById('cabecalho').value == ''){
			alert("O campo 'Cabeçalho' deve ser preenchido");
			return false;
		}	
		if (document.getElementById('texto').value == ''){
			alert("O campo 'Texto (Corpo do Pedido)' deve ser preenchido");
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
			<h4 align="center"> CADASTRO DE PEDIDO</h4>
				<div>
					<form id="pedidoForm" action="/sigra/pedidoaction/save" method="post" modelAttribute="pedido" >
						
						<input type="hidden" name="diferimento" id="diferimento" value=""/>
					
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
									<c:set var="disabled" value="${currStepPedido == 'VISUALIZAR' ? 'disabled' : ''}" />
									<fieldset>
										<table width="100%">
											<tr>
												<td>
													<c:if test="${pedido.selfId!=null && pedido.selfId>0}">
														<input type="hidden" name="selfId" id="selfId" value="${pedido.selfId}" >
													</c:if>
												</td>
											</tr>
											<tr>
												<td width="5%" al>
													<label>Tipo de Pedido:</label>
												</td>
												<td width="85%">
													<c:choose>
														<c:when test="${currStepPedido != 'VISUALIZAR'}"> 
															<select name="tipoPedido" id="tipoPedido" style=" width : 554px;">  
															<option value="">-Seleccionar- </option>
															  <c:forEach var="tipoPedido" items="${allTipopedidos}">  
																<option value="${tipoPedido.selfId}"> ${tipoPedido.designacao}</option>
															  </c:forEach>  
															</select>
														</c:when>
														<c:otherwise>
															<input type="text" name="tipoPedido" id="tipoPedido" value="${pedido.tipoPedido.designacao}" style=" width : 550px;" ${disabled} >
														</c:otherwise>
													</c:choose>	
												</td>
											</tr>
											<tr>
												<td width="5%">
													<label> Cabe&ccedil;alho:</label>
												</td>
												<td width="85%">
													<span id="refresh_01">				
														<input type="text" id="cabecalho" name="cabecalho" style=" width : 550px;" value="${pedido.cabecalho}" ${disabled}  >
													</span>
												</td>
												
											</tr>
											<tr>
												<td width="5%" >	
													<label>Texto:</label>
												</td>
												<td width="85%" >
													<span id="refresh_02">
														<textarea name="texto" id="texto" rows="5" cols="40" style=" width : 549px; height : 150px;" ${disabled} >${pedido.texto}</textarea>
													</span>
												</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
											</tr>
											<tr>
												<td width="5%">
													<label>Diferimento</label>
												</td>
												<td width="85%">
													<c:choose>
														<c:when test="${currStepPedido != 'VISUALIZAR'}"> 
															<input name="radioDiferimento" type ="radio" id="DiferimentoFavoravel"     value = "Favorável"> <label>Favor&aacute;vel </label>
															<input name="radioDiferimento" type ="radio" id="DiferimentoDesfavoravel"  value = "Desfavorável"> <label>Desfavor&aacute;vel </label>
														</c:when>
														<c:otherwise>
															<input type="text" name="diferimento" id="diferimento" style=" width : 350px;" 
																value="${(pedido.diferimento==null||pedido.diferimento=='')? 'Por Diferir':(pedido.diferimento)}" ${disabled}>
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
									<c:if test="${(currStepPedido!='VISUALIZAR') || (currStepPedido=='EDITAR')}">
										<fieldset>
											<table width="100%">
												<tr>
													<td align="right">
														<c:choose>
															<c:when test="${(pedido.selfId == null )|| (pedido.selfId==0) }">
																<input type="submit" name="action" id="action" value="Salvar" onclick="setDiferimento();">
																<input type="reset" value="Limpar" >
															</c:when>
															<c:otherwise>
																<input type="submit" name="action" id="action" value="Actualizar" onclick="setDiferimento();" >
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
					<c:if test="${(currStepPedido!=null) && (currStepPedido=='VISUALIZAR')}">
						<fieldset>
							<table>
								<tr>
									<td>
										<form id="pedidoRemoveForm" action="/sigra/pedidoaction/remove" method="post" modelAttribute="pedido" >
											<input type="hidden" name="selfId" value="${pedido.selfId}"/>
											<input type="submit" value="Remover" > 
										</form>
									</td>
									<td>
										<form id="pedidoEditarForm" action="/sigra/pedidoaction/editar" method="get" modelAttribute="pedido" >
											<input type="hidden" name="selfId" value="${pedido.selfId}"/>
											<input type="submit" value="Alterar">
										</form>
									</td>
									<td>
										<form id="pedidoAbortarForm" action="/sigra/pedidoaction/abortar" method="get" modelAttribute="pedido" >
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
														<th width="20%">TIPO PEDIDO</th>
														<th width="35%">CABE&Ccedil;ALHO</th>
														<th width="20%">DATA DE EMISS&Atilde;O</th>
														<th width="20%">DEFERIMENTO</th>
													</tr>
													<c:forEach items="${allPedidos}" var="pedido">
														<tr>
															<td height="20" valign="middle">
																<a href="/sigra/pedidoaction/selectedPedido?selfId=${pedido.selfId}" >
																	
																    
															       <img src="<c:url value="/imagens/edit_big.gif" />" width="22px" height="22px" title="Clica aqui para Detalhar!"/>
															 <!--  <img src="comuns/images/edit_big.gif" width="22px" height="22px" title="Clica aqui para Detalhar!" /> -->  
																</a>
															</td>
															<td>${pedido.tipoPedido.designacao}</td>
															<td>${pedido.cabecalho}</td>
															<td>${pedido.dataEmissao}</td>	
															<td>${(pedido.diferimento==null||pedido.diferimento=='')? 'Por Diferir': (pedido.diferimento=='Favorável'? 'Favor&aacute;vel': 'Desfavor&aacute;vel')}</td>
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
						<form id="pedidoBackHomeForm" action="/sigra/pedidoaction/home" method="get" modelAttribute="pedido" >
							<table width="100%">
								<tr>
									<td align="right">
										<input type="submit" value="Voltar" style="width : 69px; height : 30px;">
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