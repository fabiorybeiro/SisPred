package br.usjt.arqdesis.sispred.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.sispred.model.Usuario;
import br.usjt.arqdesis.sispred.service.UsuarioService;


@WebServlet("/ManterUsuario.do")
public class ManterUsuarioController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// cria atributos locais para receber os dados do formulario atraves do metodo getParameter
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		
		// cria o Javabean ou model ou TO (objeto empresa) com os dados recebidos dos formulario
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setCpf(cpf);
		
		//cria o service responsavel por todas as regras 
		UsuarioService user = new UsuarioService();
		user.criar(usuario);
		user.consultar(usuario.getId());
		
		//envia o retorno para JSP
		request.setAttribute("user", usuario);
		
		RequestDispatcher view = request.getRequestDispatcher("cadastroIncluidoSucesso.jsp");
		view.forward(request, response);
	}
}
