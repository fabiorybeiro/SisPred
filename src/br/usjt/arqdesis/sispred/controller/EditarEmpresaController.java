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

@WebServlet("/EditarEmpresa.do")
public class EditarEmpresaController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String cnpj = request.getParameter("cnpj");
		Empresa empresa = new Empresa();
		EmpresaService emp = new EmpresaService();
		empresa = emp.consultar(cnpj);
		
		request.setAttribute("atualizarEmpresa", empresa);
		
		RequestDispatcher view = request.getRequestDispatcher("AtualizarEmpresa.jsp");
		
		view.forward(request, response);
	}

}
