package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.model.bean.Carro;

public class CarroDAO implements IDAO {

	private Connection con;
	private Carro carro;

	public CarroDAO(Connection con, Carro carro) {
		this.con = con;
		this.carro = carro;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public String inserir(Object obj) {
		carro = (Carro) obj;
		String sql = "insert into carro(placa, cor, descricao) values(?,?,?)";

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getPlaca());
			ps.setString(2, carro.getCor());
			ps.setString(3, carro.getDescricao());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(Object obj) {
		carro = (Carro) obj;
		String sql = "update carro set cor = ?, descricao = ? where placa = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(3, carro.getPlaca());
			ps.setString(1, carro.getCor());
			ps.setString(2, carro.getDescricao());
			if (ps.executeUpdate() > 0) {
				return "Alterado com sucerro";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}

	public String excluir(Object obj) {
		carro = (Carro) obj;
		String sql = "delete from carro where placa = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getPlaca());
			if (ps.executeUpdate() > 0) {
				return "Excluido com sucesso";
			} else {
				return "Erro ao excluir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
