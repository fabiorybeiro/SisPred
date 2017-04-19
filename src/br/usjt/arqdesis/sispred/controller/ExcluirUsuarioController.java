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

@WebServlet("/ExcluirUsuario.do")
public class ExcluirUsuarioController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recebe o cnpj para consultar o banco
		String cpf = request.getParameter("cpf");
		// cria um usuario
		Usuario usuario = new Usuario();
		// cria um usuario service
		UsuarioService userService = new UsuarioService();
		// consulta e instancia um usuario
		usuario = userService.consultar(cpf);
		// envia para o JSP
		request.setAttribute("user",usuario);
		// acao para exclusao da empresa
		userService.excluir(usuario.getId());
		//...envia para jsp
		RequestDispatcher view = request.getRequestDispatcher("cadastroExcluidoSucesso.jsp");
		view.forward(request, response);
		
	}
}
