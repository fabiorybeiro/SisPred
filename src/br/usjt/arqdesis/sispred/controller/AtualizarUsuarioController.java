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

@WebServlet("/AtualizarUsuario.do")
public class AtualizarUsuarioController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setCpf(cpf);
		
		UsuarioService userService = new UsuarioService();
		userService.alterar(usuario);
		
		request.setAttribute("user",usuario);
		//...envia para jsp
		RequestDispatcher view = request.getRequestDispatcher("ResultadoUsuario.jsp");
		view.forward(request, response);
		
	}
}
