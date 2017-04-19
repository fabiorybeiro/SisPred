<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SisPred</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index.jsp">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Empresa
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="CadastrarEmpresa.jsp">Cadastrar</a></li>
          <li><a href="ConsultarEmpresa.jsp">Consultar</a></li>
          <li><a href="ListarEmpresas.do">Listar Empresas</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Usuário
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="CadastrarUsuario.jsp">Cadastrar</a></li>
          <li><a href="ConsultarUsuario.jsp">Consultar</a></li>
          <li><a href="ListarUsuario.do">Listar Usuários</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>    
    
    
<!--  
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Cadastro</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.jsp">Empresas</a>
                    </li>
                    <li><a href="ListarEmpresas.do">Listar Todos as Empresas</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
      -->  