package main;

import uteis.View;

public class Comandos {

	public static void comandoAldeaoParar(int aldeao) {
		if (aldeao == -1)
			View.exibirMensagemErro("Erro", "Escolha um aldeão");
		else
			System.out.println("comandoAldeaoParar(aldeao);");
	}

	public static void comandoAldeaoConstruir(int aldeao, String qual) {
		if (aldeao == -1)
			View.exibirMensagemErro("Erro", "Escolha um aldeão");
		else
			System.out.println("comandoAldeaoConstruir(aldeao, qual);");
	}

	public static void comandoAldeaoCultivar(int aldeao, int numeroFazenda) {
		if (aldeao == -1)
			View.exibirMensagemErro("Erro", "Escolha um aldeão");
		else
			System.out.println("comandoAldeaoCultivar(aldeao, numeroFazenda);");
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

	public static void comandoPrefeituraCriarAldeao(int value) {
		int valor = Integer.parseInt(Principal.lblComida.getText());
		if(valor>=100) {
			Mostrar.adicionarAldeao(""+value, "Tempo de criação[20h]");
			//this.mostrarAldeao(value, "fazendo nada");
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
