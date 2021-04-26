package main;

import java.awt.Color;
import java.util.List;

public class Mostrar {


	public static void adicionarAldeao(String numero, String acao) {
		String[] linha = {numero, acao};
		Principal.tmAldeoes.addRow(linha);
	}

	public static void mostrarAldeao(int aldeao, String acao) {
		Principal.tblAldeoes.setValueAt(acao, aldeao-1, 1);
	}

	public static void adicionarFazenda(String numero, String aldeoes) {
		String[] linha = {numero, aldeoes};
		Principal.tmFazendas.addRow(linha);
		Principal.cbFazenda.addItem(numero);
	}

	public static void mostrarFazenda(int fazenda, String aldeoes) {
		Principal.tblFazendas.setValueAt(aldeoes, fazenda-1, 1);
	}

	public static void mostrarComida(int qtd) {
		Principal.lblComida.setText(Integer.toString(qtd));
	}

	public static void adicionarMinaOuro(String numero, String aldeoes) {
		String[] linha = {numero, aldeoes};
		Principal.tmMinasOuro.addRow(linha);
		Principal.cbMinaOuro.addItem(numero);
	}

	public static void mostrarMinaOuro(int minaOuro, String aldeoes) {
		Principal.tblMinasOuro.setValueAt(aldeoes, minaOuro-1, 1);
	}

	public static void mostrarOuro(int qtd) {
		Principal.lblOuro.setText(Integer.toString(qtd));
	}

	public static void mostrarOferendaFe(int qtd) {
		Principal.lblOferenda.setText(Integer.toString(qtd));
	}

	public static void mostrarPrefeitura(String acao, Color cor) {
		Principal.tfPrefeitura.setText(acao);
		Principal.tfPrefeitura.setBackground(cor);
	}

	public static void desabilitarhabilitarTemplo() {
			Principal.pnTemplo.setEnabled(false);
			Principal.pnOferenda.setEnabled(false);
			Principal.lblOferenda.setEnabled(false);
			Principal.cbTEmploEvolucoes.setEnabled(false);
			Principal.btnTemploEvoluir.setEnabled(false);	
	}
	
	public static void habilitarTemplo() {
			Principal.pnTemplo.setEnabled(true);
			Principal.pnOferenda.setEnabled(true);
			Principal.lblOferenda.setEnabled(true);
			Principal.cbTEmploEvolucoes.setEnabled(true);
			Principal.btnTemploEvoluir.setEnabled(true);
	}

	public static void habilitarMaravilha() {
		Principal.pnMaravilha.setEnabled(true);
		Principal.lblMaravilha.setEnabled(true);
		Principal.pbMaravilha.setEnabled(true);
	}

	public static void mostrarMaravilha(int tijolos) {
		Principal.pbMaravilha.setValue(tijolos);
	}

	public static void mostrarAtaques(List<String> evolucoes) {
		Principal.cbTemploLancamentos.setEnabled(true);
		Principal.cbTemploInimigo.setEnabled(true);
		Principal.btnTemploLancar.setEnabled(true);
		Principal.cbTemploLancamentos.removeAllItems();
		for (String evolucao : evolucoes) {
			switch (evolucao) {
			case "NUVEM_GAFANHOTOS":	Principal.cbTemploLancamentos.addItem("Nuvem de gafanhotos");	break;
			case "MORTE_PRIMOGENITOS":	Principal.cbTemploLancamentos.addItem("Morte dos primog�nitos");	break;
			case "CHUVA_PEDRAS": 		Principal.cbTemploLancamentos.addItem("Chuva de pedras");
			}
		}
	}

	public static void mostrarTemplo(String acao, Color cor) {
		Principal.tfTemplo.setText(acao);
		Principal.tfTemplo.setBackground(cor);
	}
}
