package br.usjt.arqdesis.projetoppint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.usjt.arqdesis.projetoppint.model.Usuarios;

public class UsuariosDAO {

	public int criar(Usuarios usuarios) {
		String criarSql = "Insert into usuario(nome, sobrenome, cpf) Values(?,?,?)";
		try (Connection c = ConnectionFactory.obtemConexao(); PreparedStatement stm = c.prepareStatement(criarSql);) {
			stm.setString(1, usuarios.getNome());
			stm.setString(2, usuarios.getSobrenome());
			stm.setString(3, usuarios.getCpf());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = c.prepareStatement(sqlQuery);) {
				ResultSet rs = stm2.executeQuery();
				if (rs.next()) {
					usuarios.setId(rs.getInt(1));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuarios.getId();

	}

	public Usuarios consultar(int id) {
		Usuarios usuarios = new Usuarios();
		usuarios.setId(id);
		String sqlSelect = "SELECT nome, sobrenome, cpf FROM usuario WHERE id=?";
		try (Connection c = ConnectionFactory.obtemConexao(); PreparedStatement stm = c.prepareStatement(sqlSelect);) {
			stm.setInt(1, usuarios.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuarios.setNome(rs.getString("nome"));
					usuarios.setSobrenome(rs.getString("sobrenome"));
					usuarios.setCpf(rs.getString("cpf"));
				} else {
					usuarios.setId(-1);
					usuarios.setNome(null);
					usuarios.setSobrenome(null);
					usuarios.setCpf(null);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public void alterar(Usuarios usuarios) {
		String sqlAtualizar = "UPDATE usuario SET nome=?, sobrenome=?, cpf=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection c = ConnectionFactory.obtemConexao();
				PreparedStatement stm = c.prepareStatement(sqlAtualizar);) {
			stm.setString(1, usuarios.getNome());
			stm.setString(2, usuarios.getSobrenome());
			stm.setString(3, usuarios.getCpf());
			stm.setInt(4, usuarios.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlExcluir = "DELETE FROM usuario WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection c = ConnectionFactory.obtemConexao(); PreparedStatement stm = c.prepareStatement(sqlExcluir);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
