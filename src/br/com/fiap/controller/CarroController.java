package br.com.fiap.controller;

import java.sql.Connection;

import br.com.fiap.model.bean.Carro;
import br.com.fiap.model.dao.CarroDAO;
import br.com.fiap.model.dao.Conexao;

public class CarroController {

	public String insereCarro(String placa, String cor, String descricao) {
		String resultado;

		Connection con = Conexao.abrirConexao();
		Carro carro = new Carro(placa, cor, descricao);
		CarroDAO carDao = new CarroDAO(con, carro);
		
		resultado = carDao.inserir(carro);
		Conexao.fecharConexao(con);
		return resultado;
	}
	
	public String alteraCarro(String placa, String cor, String descricao) {
		String resultado;

		Connection con = Conexao.abrirConexao();
		Carro carro = new Carro(placa, cor, descricao);
		CarroDAO carDao = new CarroDAO(con, carro);
		
		resultado = carDao.alterar(carro);
		Conexao.fecharConexao(con);
		return resultado;
	}
	public String excluiCarro(String placa) {
		String resultado;

		Connection con = Conexao.abrirConexao();
		Carro carro = new Carro();
		carro.setPlaca(placa);
		CarroDAO carDao = new CarroDAO(con);
		
		resultado = carDao.excluir(carro);
		Conexao.fecharConexao(con);
		return resultado;
	}
	public String listaCarro() {
		String resultado ="";
		
		Connection con = Conexao.abrirConexao();
		
		CarroDAO carroDao = new CarroDAO(con);
		resultado = carroDao.listarTodos();
		Conexao.fecharConexao(con);
		
//		if (resultado != null) {
//			return resultado;
//		} else {
//			return null;
//		}
		return (resultado != null)? resultado : null;
	}
}
