<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
	
		<style>
			
				body{	background-color: #D8D8D8;
								 
					}
	
					body, 
					.menu,
					.sub-menu {
						margin: 0;
						padding: 0;
					}
					.clearfix:after{
						content: '.';
						display: block;
						clear: both;
						height: 0;
						line-height: 0;
						font-size: 0;
						visibility: hidden;
						overflow: hidden;
					}
					.menu,
					.sub-menu {
						list-style: none;
						background: #000;
					}
					.sub-menu {
						background: #444;
					}
					.menu a {
						text-decoration: none;
						display: block;
						padding: 10px;
						color: #fff;
						font-family: sans-serif;
						font-size: 14px;
						text-transform: uppercase;
						font-weight: 700;
					}
					.menu li {
						position: relative;
					}
					.menu > li {
						float: left;
					}
					.menu > li:hover {
						background: #444;
					}
					.menu li:hover > .sub-menu {
						display: block;
					}
					.sub-menu {
						display: none;
						position: absolute;
						min-width: 150px;
					}
					.sub-menu li:hover {
						background: #555;
					}
					.sub-menu .sub-menu {
						top: 0;
						left: 100%;
					}

					/* SUBMENU */
					header nav ul li > ul{ /* esse último "ul" seria o submenu */
					  display: none;
					}

					header nav ul li:hover > ul{
					   display: block;
					}
		
		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
	<!--	<link href="<c:url value="/resources/css/sigraStyle.css" />" rel="stylesheet"> -->
		<link type="text/css" href="resources/css/jquery-ui-1.10.1.custom.css" rel="stylesheet"> 
		 
		<script type="text/javascript" src="resources/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="resources/js/jquery-ui-1.10.1.custom.js"></script>
		
		<title></title>

	</head>
	<body>
		
		<div class="menu-container">
			<ul class="menu clearfix">
				<li><a href="#">Men&uacute;</a>
					<!-- Nível 1 -->
					<!-- submenu -->
					<ul class="sub-menu clearfix">
						<li><a href="#">Opera&ccedil;&otilde;oes</a>
							<!-- Nível 2 -->
							<!-- submenu do submenu -->
							<ul class="sub-menu">
								<li><a href="#">Parametriza&ccedil;&otilde;es</a>
									<!-- Nível 3 -->
									<!-- submenu do submenu do submenu -->
									<ul class="sub-menu">
										<li><a href="/sigra/deptaction">Cadastro de Departamento</a></li>
										<li><a href="/sigra/tipodocidentaction">Cadastro de Tipo de Doc. Ident</a></li>
										<li><a href="/sigra/tipopedidoaction">Cadastro de Tipo de Pedido</a></li>
										<li><a href="/sigra/tipopagamentoaction">Cadastro de Tipo de Pagamento</a></li>
										<li><a href="/sigra/tipousuarioaction">Cadastro de Tipo de Utilizador</a></li>
									</ul><!-- submenu do submenu do submenu -->
								</li>
								<li><a href="#">Pautas</a>
									<ul class="sub-menu">
										<li><a href="/sigra/pautaimport">Importar Pauta</a></li>
									</ul>
								</li>
							</ul><!-- submenu do submenu -->
						</li>
						<li><a href="#">Cursos</a>
								<ul class="sub-menu">
									<li><a href="/sigra/disciplinaaction">Cadastro de Disciplina</a></li>
									<li><a href="/sigra/especialidadeaction">Cadastro de Especialidade (Cursos)</a></li>
								</ul>
						</li>
						
						<li><a href="#">Processo</a>
							<ul class="sub-menu">
								<li><a href="#">Pesquisar Processo</a></li>
							</ul>
						</li>
						
						
						<li><a href="/sigra/deptaction">Departamento</a>
							<ul class="sub-menu">
								<li><a href="/sigra/deptaction">Cadastro de Departamento</a></li>
							</ul>
						</li>
						
						<li><a href="#">Estudante</a>
							<ul class="sub-menu">
								<li><a href="/sigra/estudante">Cadastro de Estudante</a></li>
								<li><a href="/sigra/pesquisaestudanteaction">Pesquisar Estudante</a></li>
							</ul>
						</li>
						
						<li><a href="#">Relat&oacute;rios</a>
							<ul class="sub-menu">
								<li><a  href="#">Listar Estudantes Por G&eacute;nero</a></li>
								<li><a  href="#">Listar Estudantes Por (Especialidade) Curso</a></li>
								<li><a  href="#">Listar Estudantes Por Ano de Ingresso</a></li>
								<li><a  href="#">Listar Estudantes Com Licensa de SMO</a></li>
							</ul>
						</li>
						
						<li><a href="/sigra/home/exit">Sair do Sistema</a></li>
					</ul><!-- submenu -->
				</li>
				<li><a href="#">Gest&atilde;o de Utilizadores</a>
					<ul class="sub-menu">
						<li><a href="/sigra/usuario">Criar/Remover Utilizador</a></li>
					</ul>
				</li>
				<li><a href="#">CONFIGURA&Ccedil;&Otilde;ES</a></li>
				<li><a href="#">BACK UPS</a>
					<ul class="sub-menu">
						<li><a href="#">Incrimental</a></li>
						<li><a href="#">Full Back Up</a></li>
					</ul>
				</li>
			</ul>
		</div>

	
	</body>

</html>