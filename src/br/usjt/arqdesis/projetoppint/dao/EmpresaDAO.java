package br.usjt.arqdesis.projetoppint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.usjt.arqdesis.projetoppint.model.Empresa;

public class EmpresaDAO {

	// cria uma empresa
	public int criar(Empresa empresa) {
		String sqlInsert = "INSERT INTO empresa (razaoSocial, cnpj, conjunto) VALUES (?,?,?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, empresa.getRazaoSocial());
			stm.setString(2, empresa.getCnpj());
			stm.setString(3, empresa.getConjunto());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);) {
				ResultSet rs = stm2.executeQuery();
				if (rs.next()) {
					empresa.setId(rs.getInt(1));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return empresa.getId();
	}

	// exclui uma empresa
	public void excluir(int id) {
		String sqlDelete = "DELETE from empresa WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// atualiza uma empresa
	public void atualizar(Empresa empresa) {
		String sqlUpdate = "UPDATE empresa SET razaoSocial=?, cnpj=?, conjunto=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, empresa.getRazaoSocial());
			stm.setString(2, empresa.getCnpj());
			stm.setString(3, empresa.getConjunto());
			stm.setInt(4, empresa.getId());
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// consulta uma empresa
	public Empresa consultar(int id) {
		Empresa empresa = new Empresa();
		empresa.setId(id);
		String sqlSelect = "SELECT razaoSocial, cnpj, conjunto FROM empresa WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, empresa.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					empresa.setRazaoSocial(rs.getString("razaoSocial"));
					empresa.setCnpj(rs.getString("cnpj"));
					empresa.setConjunto(rs.getString("conjunto"));
				} else {
					empresa.setId(-1);
					empresa.setRazaoSocial(null);
					empresa.setCnpj(null);
					empresa.setConjunto(null);
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return empresa;
	}
}
