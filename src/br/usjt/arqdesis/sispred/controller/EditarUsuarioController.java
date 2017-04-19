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

@WebServlet("/EditarUsuario.do")
public class EditarUsuarioController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String cpf = request.getParameter("cpf");
		Usuario usuario = new Usuario();
		UsuarioService userService = new UsuarioService();
		usuario = userService.consultar(cpf);
		
		request.setAttribute("atualizarUser", usuario);
		
		RequestDispatcher view = request.getRequestDispatcher("AtualizarUsuario.jsp");
		
		view.forward(request, response);
	}

}
