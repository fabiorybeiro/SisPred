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

@WebServlet("/ConsultarUsuario.do")
public class ConsultarUsuarioController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recebe o cpf para consultar o banco
		String cpf = request.getParameter("cpf");
		// cria um usuario
		Usuario usuario = new Usuario();
		// cria um usuario service
		UsuarioService userService = new UsuarioService();
		// consulta um usuario
		usuario = userService.consultar(cpf);
		// envia para o JSP
		request.setAttribute("user", usuario);
		//...envia para jsp
		RequestDispatcher view = request.getRequestDispatcher("ResultadoUsuario.jsp");
		view.forward(request, response);
		
	}
}
