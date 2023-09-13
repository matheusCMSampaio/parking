package br.com.fiap.view;

import javax.swing.JOptionPane;
import br.com.fiap.controller.ClienteController;

public class ClienteView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String aux, escolha = "sim", placa, nome;

		int opcao, id;
		ClienteController cliente = new ClienteController();

		while (escolha.equalsIgnoreCase("Sim")) {
			try {
				aux = JOptionPane.showInputDialog("1- Inserir \n2- Alterar \n3- Excluir");
				opcao = Integer.parseInt(aux);
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id"));
				
				switch (opcao) {
				case 1:
					nome = JOptionPane.showInputDialog("Nome do cliente:");
					placa= JOptionPane.showInputDialog("placa do carro: ");
					
					cliente.insereCarro(id, nome, placa);
					break;
				case 2:
					nome = JOptionPane.showInputDialog("Nome do cliente:");
					placa= JOptionPane.showInputDialog("placa do carro: ");
					cliente.alteraCarro(placa, id, nome);
					break;
				case 3:
					cliente.excluiCarro(id);
					break;
				default:
					break;
				}
				JOptionPane.showMessageDialog(null, cliente.listaCarro());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			escolha = JOptionPane.showInputDialog("Deseja continuar?");
		}
		JOptionPane.showMessageDialog(null, "FIMMM!");
	}

}
