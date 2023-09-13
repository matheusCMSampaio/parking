package br.com.fiap.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.fiap.model.bean.Cliente;

public class ClienteDAO implements IDAO {
	private Connection con;
	private Cliente cliente;

	public ClienteDAO(Connection con, Cliente cliente) {
		this.con = con;
		this.cliente = cliente;
	}

	public ClienteDAO(Connection con) {
		this.con = con;
	}

	public Connection getCon() {
		return con;
	}

	public String inserir(Object obj) {
		cliente = (Cliente) obj;
		String sql = "insert into cliente(idcliente, nomeCliente, placa) values(?,?,?)";

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNomeCliente());
			ps.setString(3, cliente.getPlaca());

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
		cliente = (Cliente) obj;
		String sql = "update cliente set nomeCliente = ?, placa = ? where idCliente = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(3, cliente.getIdCliente());
			ps.setString(1, cliente.getNomeCliente());
			ps.setString(2, cliente.getPlaca());
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
		cliente = (Cliente) obj;
		String sql = "delete from cliente where idcliente = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getIdCliente());
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
		String sql = "select * from cliente";
		String listaCliente = "Lista dos Clientes\n\n";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					listaCliente += "Id:" + rs.getString(1) + "\nNome: " + rs.getString(2) + "\nPlaca:"
							+ rs.getString(3) + "\n\n";

				}
				return listaCliente;
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		}

	}

}
