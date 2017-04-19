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

@WebServlet("/AtualizarEmpresa.do")
public class AtualizarEmpresaController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String razaoSocial = request.getParameter("razaoSocial");
		String cnpj = request.getParameter("cnpj");
		String conjunto = request.getParameter("conjunto");
		
		Empresa empresa = new Empresa();
		empresa.setId(id);
		empresa.setRazaoSocial(razaoSocial);
		empresa.setCnpj(cnpj);
		empresa.setConjunto(conjunto);
		
		EmpresaService emp = new EmpresaService();
		emp.atualizar(empresa);
		
		request.setAttribute("emp",empresa);
		//...envia para jsp
		RequestDispatcher view = request.getRequestDispatcher("ResultadoEmpresa.jsp");
		view.forward(request, response);
		
	}
}
