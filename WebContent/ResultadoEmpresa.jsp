<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width-device, initial-scale=1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>Visualizar empresa</title>
</head>
<body>
	<div id="main" class="container">
		<h3 class="page-header">Resultado da busca</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Razão social</th>
					<th>CNPJ</th>
					<th>N. de Conjuntos</th>
					<th>Alterar</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${emp.id}</td>
					<td>${emp.razaoSocial}</td>
					<td>${emp.cnpj}</td>
					<td>${emp.conjunto}</td>
					<td>
						<form action="EditarEmpresa.do" method="post">
							<button name="cnpj" value="${emp.cnpj}">Alterar</button> 
						</form>
					</td>
					<td>
						
						<form action="ExcluirEmpresa.do" method="post">
							<button name="cnpj" onclick="funcao1()" value="${emp.cnpj}">Excluir</button> 
						</form>
					</td>
				</tr>
			</tbody>
		</table>
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="ConsultarEmpresa.jsp" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>