<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visualizar Usuário</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Lista de usuários cadastrados</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Sobrenome</th>
					<th>CPF</th>
					<th>Alterar</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<c:forEach var="user" items="${lista}">
				<tr>
					<td>${user.id}</td>
					<td>${user.nome}</td>
					<td>${user.sobrenome}</td>
					<td>${user.cpf}</td>
					<td>
						<form action="EditarUsuario.do" method="post">
							<button name="cpf" value="${user.cpf}">Alterar</button> 
						</form>
					</td>
					<td>
						
						<form action="ExcluirUsuario.do" method="post">
							<button name="cpf" value="${user.cpf}">Excluir</button> 
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>

		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="index.jsp" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>