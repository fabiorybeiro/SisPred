package br.usjt.arqdesis.projetoppint.service;

import br.usjt.arqdesis.projetoppint.dao.EmpresaDAO;
import br.usjt.arqdesis.projetoppint.model.Empresa;

public class EmpresaService {
	// crio um objeto dao
	EmpresaDAO dao = new EmpresaDAO();

	public EmpresaService() {
	}

	// metodo para cadastrar uma empresa
	public int criar(Empresa empresa) {
		return dao.criar(empresa);
	}

	// metodo para excluir uma empresa
	public void excluir(int id) {
		dao.excluir(id);
	}

	// metodo para atualizar dados da empresa
	public void atualizar(Empresa empresa) {
		dao.atualizar(empresa);
	}

	// metodo para consultar uma empresa
	public Empresa consultar(int id) {
		return dao.consultar(id);
	}
}
