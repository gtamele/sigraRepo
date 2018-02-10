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
	
	
		   $(document).ready(function() {
	           $("#tipoPagamentoForm").submit(function(e) {
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
			
			return true;
		}
	
	
	
	</script>	

</head>
<body>
	<c:import url="/cabecalho.jsp" /> 	
	<fieldset>
		<h4 align="center"> CADASTRO DE TIPOS DE PAGAMENTOS</h4>
		<div>
			<form id="tipoPagamentoForm" action="/sigra/tipopagamentoaction/save" method="post" modelAttribute="tipoPagamento" >
			
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
						<c:set var="disabled" value="${currStepTipoPagamento == 'VISUALIZAR' ? 'disabled' : ''}" />
						<fieldset>
							<table width="100%">
								<tr>
									<td>
										<c:if test="${tipoPagamento.selfId!=null && tipoPagamento.selfId>0}">
											<input type="hidden" name="selfId" value="${tipoPagamento.selfId}"/>
										</c:if>
									</td>
								</tr>
								<tr>
									<td width="5%">
										<label> Designa&ccedil;&atilde;o:</label>
									</td>
									<td width="85%">			
										<input type="text" id="designacao" name="designacao" style=" width : 583px;" value="${tipoPagamento.designacao}" ${disabled} >
									</td>
									
								</tr>
								<tr>
									<td width="5%">	
										<label>Descri&ccedil;&atilde;o:</label>
									</td>
									<td width="85%">
										<textarea name="descricao" id="descricao" rows="5" cols="40" style=" width : 583px;" ${disabled} >${tipoPagamento.descricao}</textarea>
									</td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
				<tr>
					<td> 
						<c:if test="${(currStepTipoPagamento!='VISUALIZAR') || (currStepTipoPagamento=='EDITAR')}">
							<fieldset>
								<table>
									<tr>
										<td>
											<c:choose>
												<c:when test="${(tipoPagamento.selfId==null)|| (tipoPagamento.selfId==0)}">
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
			<c:if test="${(currStepTipoPagamento!=null) && (currStepTipoPagamento=='VISUALIZAR')}">
				<fieldset>
					<table>
						<tr>
							<td>
								<form id="tipoPagamentoDelForm" action="/sigra/tipopagamentoaction/remove" method="post" modelAttribute="tipoPagamento" >
									<input type="hidden" name="selfId" value="${tipoPagamento.selfId}"/>
									<input type="submit" value="Remover" > 
								</form>
							</td>
							<td>
								<form id="tipoPagamentoEditarForm" action="/sigra/tipopagamentoaction/editar" method="get" modelAttribute="tipoPagamento" >
									<input type="hidden" name="selfId" value="${tipoPagamento.selfId}"/>
									<input type="submit" value="Alterar">
								</form>
							</td>
							<td>
								<form id="tipoPagamentoAbortarForm" action="/sigra/tipopagamentoaction/abortar" method="get" modelAttribute="tipoPagamento" >
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
												<legend>Lista de Tipo de Pedido</legend>
											<table>
												<tr align="left">
													<th width="5%" >EDITAR</th>	
													<th width="45%">DESIGNA&Ccedil;&Atilde;O</th>
													<th width="50%">DESCRI&Ccedil;&Atilde;O</th>
												</tr>
													<c:forEach items="${allTipoPagamentos}" var="tipo">
													<tr>
														<td height="20" valign="middle">
															<a href="/sigra/tipopagamentoaction/selectedtipopagamento?selfId=${tipo.selfId}" >
														       <img src="<c:url value="/imagens/edit_big.gif" />" width="22px" height="22px" title="Clica aqui para Detalhar!"/>
																 <!--  <img src="comuns/images/edit_big.gif" width="22px" height="22px" title="Clica aqui para Detalhar!" /> -->  
															</a>
														</td>
														<td>${tipo.designacao}</td>
														<td>${tipo.descricao}</td>	
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
			<form id="tipoPagamentoBackHomeForm" action="/sigra/tipopagamentoaction/home" method="get" modelAttribute="tipoPagamento" >
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