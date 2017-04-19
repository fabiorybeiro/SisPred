package br.usjt.arqdesis.sispred.service;

import java.util.List;

import br.usjt.arqdesis.sispred.dao.UsuarioDAO;
import br.usjt.arqdesis.sispred.model.Usuario;

public class UsuarioService {
	
	UsuarioDAO dao = new UsuarioDAO();
	
	public UsuarioService(){}
	
	public int criar(Usuario usuario){
		return dao.criar(usuario);
	}
	
	public Usuario consultar(int id){
		return dao.consultar(id);
	}
	
	public void alterar(Usuario usuario){
		dao.alterar(usuario);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}

	public List<Usuario> allUsuario() {
		return dao.allUsuario();
	}

	public Usuario consultar(String cpf) {
		return dao.consultar(cpf);
	}
}
