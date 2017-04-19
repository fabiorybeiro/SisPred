package br.usjt.arqdesis.sispred.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.arqdesis.sispred.model.Usuario;

public class UsuarioDAO {

	public int criar(Usuario Usuario) {
		String criarSql = "Insert into usuario(nome, sobrenome, cpf) Values(?,?,?)";
		try (Connection c = ConnectionFactory.obtemConexao(); PreparedStatement stm = c.prepareStatement(criarSql);) {
			stm.setString(1, Usuario.getNome());
			stm.setString(2, Usuario.getSobrenome());
			stm.setString(3, Usuario.getCpf());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = c.prepareStatement(sqlQuery);) {
				ResultSet rs = stm2.executeQuery();
				if (rs.next()) {
					Usuario.setId(rs.getInt(1));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Usuario.getId();

	}

	public Usuario consultar(int id) {
		Usuario Usuario = new Usuario();
		Usuario.setId(id);
		String sqlSelect = "SELECT nome, sobrenome, cpf FROM usuario WHERE id=?";
		try (Connection c = ConnectionFactory.obtemConexao(); PreparedStatement stm = c.prepareStatement(sqlSelect);) {
			stm.setInt(1, Usuario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					Usuario.setNome(rs.getString("nome"));
					Usuario.setSobrenome(rs.getString("sobrenome"));
					Usuario.setCpf(rs.getString("cpf"));
				} else {
					Usuario.setId(-1);
					Usuario.setNome(null);
					Usuario.setSobrenome(null);
					Usuario.setCpf(null);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Usuario;
	}

	public void alterar(Usuario Usuario) {
		String sqlAtualizar = "UPDATE usuario SET nome=?, sobrenome=?, cpf=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection c = ConnectionFactory.obtemConexao();
				PreparedStatement stm = c.prepareStatement(sqlAtualizar);) {
			stm.setString(1, Usuario.getNome());
			stm.setString(2, Usuario.getSobrenome());
			stm.setString(3, Usuario.getCpf());
			stm.setInt(4, Usuario.getId());
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
	
	public List<Usuario> allUsuario() {
		Usuario usuario;
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		String sqlSelect = "SELECT * FROM usuario;";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					
					usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setSobrenome(rs.getString("sobrenome"));
					usuario.setCpf(rs.getString("cpf"));
					
					lista.add(usuario);
					
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public Usuario consultar(String cpf) {
		Usuario usuario = new Usuario();
		
		String sqlSelect = "SELECT * FROM usuario WHERE cpf=?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, cpf);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setSobrenome(rs.getString("sobrenome"));
					usuario.setCpf(rs.getString("cpf"));
				} else {
					usuario.setId(-1);
					usuario.setNome(null);
					usuario.setSobrenome(null);
					usuario.setCpf(null);
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}

}
