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
<style type="text/css">

</style>

<title>Insert title here</title>
</head>
<body>
	<c:import url="/cabecalho.jsp" />
	
	
	<form action="">
		
			<table width="100%">
				<tr>
					<td valign="top">
						<div align="left">
							<h5 align="center" >Men&uacute;</h5>
							<ul class="menu" >
								<li><a href="#">Estudante</a>
									<ul class="submenu1">
										<li><a href="#">Cadastar</a></li>
										<li><a href="#">Pesquisar</a></li>
									</ul>
								</li>
								<li><a href="#">Processo</a>
									<ul>
										<li><a href="#">Pesquisar</a></li>
									</ul>
								</li>
								<li><a href="#">Inscrição</a>
								<li><a href="#">Pediddos</a>
								<li><a href="#">Parametrização</a>
									<ul>
										<li><a href="#">Tipo Pagamento</a></li>
										<li><a href="#">Tipo Pedido </a></li>
										<li><a href="#">Tipo Usuário</a></li>
										<li><a href="#">Tipo </a></li>
									
									</ul>
								</li>
								<li><a href="#">Relatórios</a>
									<ul>
										<li><a href="#">Listar Estudades por Sexo</a></li>
										<li><a href="#">Listar Estudades por Ano Ingresso</a></li>
										<li><a href="#">Listar Estudades por Nível</a></li>
										<li><a href="#">Listar Estudades por Curso</a></li>
									</ul>
								</li>
								
							</ul>
						</div>
					</td>
					<td width="88%">
						<div>
							<table width="100%">
								<tr>
									<td>
										<fieldset>
											<table width="100%">
												<tr style=" height :450px;"></tr>
											</table>
										</fieldset>
									</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
			</table>
		
	</form> 
	<c:import url="/rodape.jsp" />
</body>
</html>