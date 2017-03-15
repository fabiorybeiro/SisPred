package br.usjt.arqdesis.projetoppint.service;

import br.usjt.arqdesis.projetoppint.dao.UsuariosDAO;
import br.usjt.arqdesis.projetoppint.model.Usuarios;

public class UsuariosService {
	
	UsuariosDAO dao = new UsuariosDAO();
	
	public UsuariosService(){}
	
	public int criar(Usuarios usuario){
		return dao.criar(usuario);
	}
	
	public Usuarios consultar(int id){
		return dao.consultar(id);
	}
	
	public void alterar(Usuarios usuario){
		dao.alterar(usuario);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
}
