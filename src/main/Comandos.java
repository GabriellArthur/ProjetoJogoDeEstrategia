package main;

import java.util.ArrayList;

import uteis.View;

public class Comandos {

	public static void comandoAldeaoParar(int aldeao) {
		aldeao++;
		if (aldeao == -1)
			View.exibirMensagemErro("Erro", "Escolha um aldeão");
		else {
			Principal.tmAldeoes.getColumnName(aldeao);
			Mostrar.mostrarAldeao(aldeao, "Parado");
		}
			
	}

	public static void comandoAldeaoConstruir(int aldeao, String qual) {
		if (aldeao == -1)
			View.exibirMensagemErro("Erro", "Escolha um aldeão");
		else {
			switch (qual) {
			case "Fazenda":
				comandoAldeaoConstruirFazenda(aldeao);
				break;
			case "Mina de ouro":
				
				break;
			case "Templo":
				
				break;
			case "Maravilha":
				
				break;
			}
		}
			
	}
	//OK
	public static boolean SwitchCriarFazenda = false;
	public static int comandoAldeaoConstruirFazenda;
	public static void comandoAldeaoConstruirFazenda(int aldeao) {
		int comida = Integer.parseInt(Principal.lblComida.getText());
		int ouro = Integer.parseInt(Principal.lblOuro.getText());
		Fazenda fazenda;
		if(comida>=100) { // Criação do aldeão
			if(ouro>=500) {
				comandoAldeaoConstruirFazenda = aldeao;
				SwitchCriarFazenda = true;
				fazenda = new Fazenda();
				Thread threadFazenda = new Thread(fazenda);
				threadFazenda.start();
				Mostrar.mostrarComida(comida-100);
				Mostrar.mostrarOuro(ouro-500);
			}else {
				View.exibirMensagemErro("Erro", "Falta Ouro");
			}
		}else {
			View.exibirMensagemErro("Erro", "Falta Comida");
		}
	}
	
	public static boolean SwitchCultivar = false;
	public static ArrayList<Integer> Aldeoes = new ArrayList<>();
	public static int numeroDaFazendo;
	public static void comandoAldeaoCultivar(int aldeao, int numeroFazenda) {
		if (aldeao == -1)
			View.exibirMensagemErro("Erro", "Escolha um aldeão");
		else {
			if(!Comandos.Aldeoes.contains(aldeao)) {
				SwitchCultivar = true;
				numeroDaFazendo = numeroFazenda;
				Aldeoes.add(aldeao);
				Fazenda fazenda;
				fazenda = new Fazenda();
				Thread threadFazenda = new Thread(fazenda);
				threadFazenda.start();
			}else {
				View.exibirMensagemErro("Erro", "Aldeão Ocupado");
			}
		}
			
	}

	public static void comandoAldeaoMinerar(int aldeao, int numeroMinaOuro) {
		if (aldeao == -1)
			View.exibirMensagemErro("Erro", "Escolha um aldeão");
		else
			System.out.println("comandoAldeaoMinerar(aldeao, numeroMinaOuro);");
	}

	public static  void comandoAldeaoOrar(int aldeao) {
		if (aldeao == -1)
			View.exibirMensagemErro("Erro", "Escolha um aldeão");
		else
			System.out.println("comandoAldeaoOrar(aldeao);");
	}

	public static void comandoAldeaoSacrificar(int aldeao) {
		if (aldeao == -1)
			View.exibirMensagemErro("Erro", "Escolha um aldeão");
		else
			System.out.println("comandoAldeaoSacrificar(aldeao);");
	}

	public static void comandoPrefeituraCriarAldeao() {
		int valor = Integer.parseInt(Principal.lblComida.getText());
		Aldeao aldeao;
		if(valor>=100) { // Criação do aldeão
			aldeao = new Aldeao();
			Thread threadAldeao = new Thread(aldeao);
			threadAldeao.start();
			Mostrar.mostrarComida(valor-100);
		}else {
			View.exibirMensagemErro("Erro", "Falta Comida");
		}
	}

	public static void comandoPrefeituraEvoluir(String strEvolucao) {
		System.out.println("comandoPrefeituraEvoluir(strEvolucao);");
	}

	public static void comandoTemploEvoluir(String strEvolucao) {
		System.out.println("comandoTemploEvoluir(strEvolucao);");
	}
	
	public static void comandoTemploLancar() {
		System.out.println("comandoTemploLancar();");
	}

}
