package main;

import java.awt.Color;
import java.util.List;

public class Mostrar {
	//Adicionar
	public static void adicionarSave(String name,String civilizacao,String ip,String status) {
		String[] linha = {name, civilizacao,ip,status};
		Principal.tmJogos.addRow(linha);
	}
	
	public static void adicionarAldeao(String numero, String acao) {
		String[] linha = {numero, acao};
		Principal.tmAldeoes.addRow(linha);
	}


	public static void adicionarFazenda(String numero, String aldeoes) {
		String[] linha = {numero, aldeoes};
		Principal.tmFazendas.addRow(linha);
		Principal.cbFazenda.addItem(numero);
	}
	
	public static void adicionarMinaOuro(String numero, String aldeoes) {
		String[] linha = {numero, aldeoes};
		Principal.tmMinasOuro.addRow(linha);
		Principal.cbMinaOuro.addItem(numero);
	}
	//Mostrar
	
	public static void mostrarCriarJogo() {
		Principal.pnPorta.setEnabled(true);
		Principal.tblJogos.setEnabled(true);
		Principal.btnIniciarJogo.setEnabled(true);	
		if(Comandos.app == null) {
			Principal.btnCriarJogo.setEnabled(true);
		}else {
			Principal.btnCriarJogo.setEnabled(false);
		}
		Principal.btnEncerrarJogo.setEnabled(true);
		Principal.rdbtnConectarJogo.setSelected(false);
		Principal.btnConectar.setEnabled(false);
		Principal.btnDesconectar.setEnabled(false);
		
	}
	
	public static void mostrarConectarJogo() {
		Principal.pnPorta.setEnabled(false);
		Principal.tblJogos.setEnabled(false);
		Principal.btnIniciarJogo.setEnabled(false);
		Principal.btnCriarJogo.setEnabled(false);
		Principal.btnEncerrarJogo.setEnabled(false);
		Principal.rdbtnCriarJogo.setSelected(false);
		Principal.btnConectar.setEnabled(true);
		Principal.btnDesconectar.setEnabled(true);
	}
	
	public static void mostrarAldeao(int aldeao, String acao) {
		Principal.tblAldeoes.setValueAt(acao, aldeao-1, 1);
		
	}
	
	public static void mostrarFazenda(int fazenda, String aldeoes) {
		Principal.tblFazendas.setValueAt(aldeoes, fazenda-1, 1);
	}

	public static void mostrarComida(int qtd) {
		Principal.lblComida.setText(Integer.toString(qtd));
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
	
	public static void desabilitarOpcaoEvoluir() {
		Principal.btnTemploEvoluir.setEnabled(false);
	}
	public static void habilitarOpcaoEvoluir() {
		Principal.btnTemploEvoluir.setEnabled(true);
	}
	
	public static void desabilitarOpcoesEvolucao(String tipo) {
		switch (tipo) {
		case "Todos":
			Principal.btnPrefeituraCriarAldeao.setEnabled(false);
			Principal.btnAldeaoParar.setEnabled(false);
			Principal.btnAldeaoConstruir.setEnabled(false);
			Principal.btnAldeaoCultivar.setEnabled(false);
			Principal.btnAldeaoMinerar.setEnabled(false);
			Principal.btnAldeaoOrar.setEnabled(false);
			Principal.btnAldeaoSacrificar.setEnabled(false);	
			Principal.btnPrefeituraEvoluir.setEnabled(false);
			break;
		case "Fazenda":
			Principal.btnAldeaoCultivar.setEnabled(false);
			Principal.btnPrefeituraEvoluir.setEnabled(false);
			break;
		case "Mina":
			Principal.btnAldeaoMinerar.setEnabled(false);
			Principal.btnPrefeituraEvoluir.setEnabled(false);
			break;
		}
	}
	
	public static void habilitarOpcoesEvolucao(String tipo) {
		switch (tipo) {
		case "Todos":
			Principal.btnPrefeituraCriarAldeao.setEnabled(true);
			Principal.btnAldeaoParar.setEnabled(true);
			Principal.btnAldeaoConstruir.setEnabled(true);
			Principal.btnAldeaoCultivar.setEnabled(true);
			Principal.btnAldeaoMinerar.setEnabled(true);
			Principal.btnAldeaoOrar.setEnabled(true);
			Principal.btnAldeaoSacrificar.setEnabled(true);	
			Principal.btnPrefeituraEvoluir.setEnabled(true);
			break;
		case "Fazenda":
			Principal.btnAldeaoCultivar.setEnabled(true);
			Principal.btnPrefeituraEvoluir.setEnabled(true);
			break;
		case "Mina":
			Principal.btnAldeaoMinerar.setEnabled(true);
			Principal.btnPrefeituraEvoluir.setEnabled(true);
			break;
		}
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
	
	public static void mostrarPrefeitura(int quantidade) {
		Principal.tfPrefeituraBar.setValue(quantidade);
	}
	
	public static void mostrarEvolucao(int quantidade) {
		Principal.tfTemploBar.setValue(quantidade);
	}

	public static void mostrarAtaques(List<String> evolucoes) {
		Principal.cbTemploLancamentos.setEnabled(true);
		Principal.cbTemploInimigo.setEnabled(true);
		Principal.btnTemploLancar.setEnabled(true);
		Principal.cbTemploLancamentos.removeAllItems();
		for (String evolucao : evolucoes) {
			switch (evolucao) {
			case "NUVEM_GAFANHOTOS":	Principal.cbTemploLancamentos.addItem("Nuvem de gafanhotos");	break;
			case "MORTE_PRIMOGENITOS":	Principal.cbTemploLancamentos.addItem("Morte dos primogênitos");	break;
			case "CHUVA_PEDRAS": 		Principal.cbTemploLancamentos.addItem("Chuva de pedras");
			}
		}
	}

}
