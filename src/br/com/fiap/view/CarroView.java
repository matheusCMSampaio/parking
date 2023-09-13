package br.com.fiap.view;

import javax.swing.JOptionPane;

import br.com.fiap.controller.CarroController;

public class CarroView {

	public static void main(String[] args) {
		String aux, escolha = "sim", placa, cor, descricao;

		int opcao;
		CarroController carro = new CarroController();

		while (escolha.equalsIgnoreCase("Sim")) {
			try {
				aux = JOptionPane.showInputDialog("1- Inserir \n2- Alterar \n3- Excluir");
				opcao = Integer.parseInt(aux);
				placa = JOptionPane.showInputDialog("Digite a placa");
				
				switch (opcao) {
				case 1:
					cor = JOptionPane.showInputDialog("Cor do carro:");
					descricao = JOptionPane.showInputDialog("Descrição: ");
					carro.insereCarro(placa, cor, descricao);
					
					break;
				case 2:
					cor = JOptionPane.showInputDialog("Cor do carro:");
					descricao = JOptionPane.showInputDialog("Descricao");
					carro.alteraCarro(placa, cor, descricao);
					break;
				case 3:
					carro.excluiCarro(placa);
					break;
				default:
					break;
				}
				JOptionPane.showMessageDialog(null, carro.listaCarro());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			escolha = JOptionPane.showInputDialog("Deseja continuar?");
		}
		JOptionPane.showMessageDialog(null, "FIMMM!");
	}

}
