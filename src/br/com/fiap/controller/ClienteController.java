package br.com.fiap.controller;

import java.sql.Connection;

import br.com.fiap.model.bean.Cliente;
import br.com.fiap.model.dao.ClienteDAO;
import br.com.fiap.model.dao.Conexao;

public class ClienteController {

	public String insereCarro(int idCliente, String nome, String placa) {
		String resultado;

		Connection con = Conexao.abrirConexao();
		Cliente cliente = new Cliente(idCliente, nome, placa);
		ClienteDAO cdao = new ClienteDAO(con, cliente);

		resultado = cdao.inserir(cliente);
		Conexao.fecharConexao(con);
		return resultado;
	}

	public String alteraCarro(String placa, int idCliente, String nome) {
		String resultado;

		Connection con = Conexao.abrirConexao();
		Cliente cliente = new Cliente(idCliente, nome, placa);
		ClienteDAO cdao = new ClienteDAO(con, cliente);

		resultado = cdao.alterar(cliente);
		Conexao.fecharConexao(con);
		return resultado;
	}

	public String excluiCarro(int idCliente) {
		String resultado;

		Connection con = Conexao.abrirConexao();
		Cliente cliente = new Cliente();
		cliente.setIdCliente(idCliente);
		cliente.setIdCliente(0);
		ClienteDAO cdao = new ClienteDAO(con);

		resultado = cdao.excluir(cliente);
		Conexao.fecharConexao(con);
		return resultado;
	}

	public String listaCarro() {
		String resultado = "";

		Connection con = Conexao.abrirConexao();

		ClienteDAO cdao = new ClienteDAO(con);
		resultado = cdao.listarTodos();
		Conexao.fecharConexao(con);


		return (resultado != null) ? resultado : null;
	}

}
