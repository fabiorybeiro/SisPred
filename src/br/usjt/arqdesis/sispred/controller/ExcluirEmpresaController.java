package br.usjt.arqdesis.sispred.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.sispred.model.Empresa;
import br.usjt.arqdesis.sispred.service.EmpresaService;

@WebServlet("/ExcluirEmpresa.do")
public class ExcluirEmpresaController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recebe o cnpj para consultar o banco
		String cnpj = request.getParameter("cnpj");
		// cria uma empresa
		Empresa empresa = new Empresa();
		// cria uma empresa service
		EmpresaService emp = new EmpresaService();
		// consulta e instancia uma empresa
		empresa = emp.consultar(cnpj);
		// envia para o JSP
		request.setAttribute("novaEmpresa",empresa);
		// acao para exclusao da empresa
		emp.excluir(empresa.getId());
		//...envia para jsp
		RequestDispatcher view = request.getRequestDispatcher("cadastroExcluidoSucesso.jsp");
		view.forward(request, response);
		
	}
}
