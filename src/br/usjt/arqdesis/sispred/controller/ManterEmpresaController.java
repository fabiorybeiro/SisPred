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


@WebServlet("/ManterEmpresa.do")
public class ManterEmpresaController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// cria atributos locais para receber os dados do formulario atraves do metodo getParameter
		String razaoSocial = request.getParameter("razaoSocial");
		String cnpj = request.getParameter("cnpj");
		String conj = request.getParameter("conjuntos");
		
		// cria o Javabean ou model ou TO (objeto empresa) com os dados recebidos dos formulario
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial(razaoSocial);
		empresa.setCnpj(cnpj);
		empresa.setConjunto(conj);
		
		//cria o service responsavel por todas as regras 
		EmpresaService empService = new EmpresaService();
		empService.criar(empresa);
		empService.consultar(empresa.getId());
		
		//envia o retorno para JSP
		request.setAttribute("novaEmpresa", empresa);
		
		RequestDispatcher view = request.getRequestDispatcher("cadastroIncluidoSucesso.jsp");
		view.forward(request, response);
	}
}
