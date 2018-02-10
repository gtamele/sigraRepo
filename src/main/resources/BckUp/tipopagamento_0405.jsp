<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script type="text/javascript" >


	
	function testFunction(){

		alert("Teste de saida 1");
	}

	function limpar (){
		
		//document.getElementById("abc").href="/sigra/tipopagamento/loadpage"
			
		alert("limpou!");
	}
	

	   $(document).ready(function() {
           $("#tipoPagamentoForm").submit(function(e) {
               if(!validar()) {
                   e.preventDefault();
               }
           });             
       });


	function salvar(tipopagamento) {
	
		if (!validar()) return;
		
		$.post("tipopagamento/save?tipopagamento="+tipopagamento);
	}

	

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

		<form method="post" action="/sigra/tipopagamento/save" name="tipopagamentoForm"  modelAttribute="tipopagamento" > 
		
		
			<fieldset>
				<table width="100%">
					<tr>
						<td>${statusMessage}</td>
					</tr>	
					<tr>
						<td>
							<fieldset>
								<table>
									<tr>
										<td width="15%">
											<label> Designa&ccedil;&atilde;o</label>
										</td>
										<td width="85">
											<span id="refresh_01">				
												<input type="text" id="designacao" name="designacao" style=" width: 100%" value="${tipopagamento.designacao}" >
											</span>
										</td>
										
									</tr>
									<tr>
										<td width="15%">
											<label>Descri&ccedil;&atilde;o</label>
										</td>
										<td width="85">
											<span id="refresh_02">
												<textarea name="descricao" id="descricao" rows="5" cols="40" style="width: 100%" >${tipopagamento.descricao}</textarea>
											</span>
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
									<!--  <a id="save"  href="/sigra/tipopagamento/save.html" onclick="testFunction()">teste</a> -->	
										</td>
										<td>
											<input type="submit" value="Salvar" >	
										</td>
										<td id="abc">
											<input type="button" value="Limpar" onclick="limpar();">	
										</td>
										<td>
											<input type="button" value="Cancelar" onclick="testFunction();">	
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
								<table width="50%">
									<tr align="left">
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
			
		</form>
	</body>
</html>