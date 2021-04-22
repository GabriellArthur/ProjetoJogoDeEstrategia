package main;

import java.util.ArrayList;

import uteis.View;

public class Comandos {
	public static ArrayList<Integer> Aldeoes = new ArrayList<Integer>();
	public static void comandoAldeaoParar(int aldeao) {
		if (aldeao == -1)
			View.exibirMensagemErro("Erro", "Escolha um aldeão");
		else {
			if(Comandos.Aldeoes.contains(aldeao)) {
				for (Integer integer : Aldeoes) {
					if(integer == aldeao) {
						Aldeoes.remove(integer);
					}
				}
			}else {
				View.exibirMensagemErro("Erro", "Aldeão Livre");
			}
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
				comandoAldeaoConstruirMinaDeOuro(aldeao);
				break;
			case "Templo":
				
				break;
			case "Maravilha":
				
				break;
			}
		}
			
	}
	
	public static boolean SwitchCriarFazenda = false;
	public static int comandoAldeaoConstruirFazenda;
	public static void comandoAldeaoConstruirFazenda(int aldeao) {
		int comida = Integer.parseInt(Principal.lblComida.getText());
		int ouro = Integer.parseInt(Principal.lblOuro.getText());
		Fazenda fazenda;
		if(!Comandos.Aldeoes.contains(aldeao)) {
			if(comida>=100) {
				if(ouro>=500) {
					SwitchCriarFazenda = true;
					Aldeoes.add(aldeao);
					comandoAldeaoConstruirFazenda = aldeao;
					//
					fazenda = new Fazenda();
					Thread threadFazenda = new Thread(fazenda);
					threadFazenda.start();
					//
					Mostrar.mostrarComida(comida-100);
					Mostrar.mostrarOuro(ouro-500);
				}else {
					View.exibirMensagemErro("Erro", "Falta Ouro");
				}
			}else {
				View.exibirMensagemErro("Erro", "Falta Comida");
			}
		}else {
			View.exibirMensagemErro("Erro", "Aldeão Ocupado");
		}
	}
	
	public static boolean SwitchCriarMinaDeOuro = false;
	public static int comandoAldeaoConstruirMinaDeOuro;
	public static void comandoAldeaoConstruirMinaDeOuro(int aldeao) {
		int comida = Integer.parseInt(Principal.lblComida.getText());
		MinaDeOuro mina;
		if(!Comandos.Aldeoes.contains(aldeao)) {
			if(comida>=1000) {
					SwitchCriarMinaDeOuro = true;
					Aldeoes.add(aldeao);
					comandoAldeaoConstruirMinaDeOuro = aldeao;
					//
					mina = new MinaDeOuro();
					Thread threadMina = new Thread(mina);
					threadMina.start();
					//
					Mostrar.mostrarComida(comida-1000);
			}else {
				View.exibirMensagemErro("Erro", "Falta Comida");
			}
		}else {
			View.exibirMensagemErro("Erro", "Aldeão Ocupado");
		}
	}
	
	public static boolean SwitchCultivar = false;
	public static int numeroDaFazendo;
	public static int comandoAldeaoCultivarFazenda;
	public static void comandoAldeaoCultivar(int aldeao, int numeroFazenda) {
		if (aldeao == -1)
			View.exibirMensagemErro("Erro", "Escolha um aldeão");
		else {
			if(!Comandos.Aldeoes.contains(aldeao)) {
				SwitchCultivar = true;
				numeroDaFazendo = numeroFazenda;
				Aldeoes.add(aldeao);
				comandoAldeaoCultivarFazenda = aldeao;
				Mostrar.mostrarAldeao(aldeao+1, "Cultivando");
				//
				Fazenda fazenda;
				fazenda = new Fazenda();
				Thread threadFazenda = new Thread(fazenda);
				threadFazenda.start();
			}else {
				View.exibirMensagemErro("Erro", "Aldeão Ocupado");
			}
		}
			
	}
	
	public static boolean SwitchMinerar = false;
	public static int numeroDaMina;
	public static int comandoAldeaoMinerar;
	public static void comandoAldeaoMinerar(int aldeao, int numeroMinaOuro) {
		if(aldeao == -1) {
			View.exibirMensagemErro("Error", "Escolha um aldeão");
		}else {
			if(!Comandos.Aldeoes.contains(aldeao)) {
				SwitchMinerar = true;
				numeroDaMina = numeroMinaOuro;
				comandoAldeaoMinerar = aldeao;
				Aldeoes.add(aldeao);
				Mostrar.mostrarAldeao(aldeao+1, "Minerando");
				
				MinaDeOuro mina;
				mina = new MinaDeOuro();
				Thread threadMina = new Thread(mina);
				threadMina.start();
			}else {
				View.exibirMensagemErro("Erro", "Aldeão Ocupado");
			}
		}
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
