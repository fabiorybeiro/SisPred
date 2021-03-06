<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<form action="AtualizarEmpresa.do" method="post">
	<h3 class="page-header">${atualizarEmpresa.razaoSocial}</h3>
	<div class="row">
			<div class="col-md-6">
				<p><strong>ID: </strong> <input type="text" name="id"  value="${atualizarEmpresa.id}" /></p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<p><strong>Razão Social</strong></p>
				<p><input type="text" name="razaoSocial" value="${atualizarEmpresa.razaoSocial}"/></p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<p><strong>CNPJ</strong></p>
				<p><input type="text" name="cnpj" value="${atualizarEmpresa.cnpj}" /></p>
			</div>
		</div>
		<div>
			<div>
				<p><strong>Número de Conjuntos</strong></p>
				<p><input type="text" name="conjunto" required maxlength="1" value="${atualizarEmpresa.conjunto}"/></p>
			</div>
		</div>
		<div id="actions" class="row">
			<div class="col-md-12">
				<input type="submit" name="btnSalvar" value="Salvar" class="btn btn-default" /> <a href="EditarEmpresa.jsp" class="btn btn-default">Voltar</a>
            </div>
        </div>
        </form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>	
</body>
</html>