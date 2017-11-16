<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<script type="text/javascript">

	function salvar() {

	tipopagamentoForm.step.value='save';

	alert("chega aki!")
	
	}
		
	</script>
	
	</head>
	<body>
		<form:form method="post" action="/tipopagamento/save" name="tipopagamentoForm"  modelAttribute="tipopagamento" > 
			<fieldset>
				<table width="100%">
					<tr>
						<td>
							<fieldset>
								<table>
									<tr>
										<td width="15%">
											<label> Designa&ccedil;&atilde;o</label>
										</td>
										<td width="85">				
											<input type="text" id="designacao" name="designacao" style=" width: 100%" value="${tipopagamento.designacao}">
										</td>
										
									</tr>
									<tr>
										<td width="15%">
											<label>Descri&ccedil;&atilde;o</label>
										</td>
										<td width="85">
											<textarea rows="5" cols="40" style="width: 100%">${tipopagamento.descricao}</textarea>
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
										<td>
											<a id="save"  href="/sigra/tipopagamento/save/" >teste</a>
											<input type="button" value="Salvar" onclick="salvar();">	
										</td>
										<td>
											<input type="button" value="Limpar" onclick="">	
										</td>
										<td>
											<input type="button" value="Cancelar" onclick="">	
										</td>
									</tr>
								</table>
							</fieldset>
						</td>
					</tr>
					<tr>
						<td>
							<fieldset>
								<legend>Lista de Tipos de Pagamentos</legend>
								<table>
									<tr>
										<th>DESIGNA&Ccedil;&Atilde;O</th>
										<th>DESCRI&Ccedil;&Atilde;O</th>
									</tr>
									<c:forEach items="${allTipoPagamentos}" var="tipo">
										<tr>
											<td>${tipo.designacao}</td>
											<td>${tipo.descricao}</td>	
										</tr>
									</c:forEach>
								</table>
							</fieldset>
						</td>
					</tr>
					<tr>
						
					</tr>
				</table>
			</fieldset>
			
		</form:form>
	</body>
</html>