package main;

import java.util.ArrayList;

import evolucoes.EvolucoesPrefeitura;
import evolucoes.EvolucoesTemplo;
import uteis.View;

public class Comandos {
	public static ArrayList<Integer> Aldeoes = new ArrayList<Integer>();
	public static boolean isTemplo = false;
	public static EvolucoesTemplo evolucoesTemplo = new EvolucoesTemplo();
	public static EvolucoesPrefeitura evolucoesPrefeitura = new EvolucoesPrefeitura();
	
	public static void comandoAldeaoParar(int aldeao) {
		if (aldeao == -1)
			View.exibirMensagemErro("Erro", "Escolha um aldeão");
		else {
			if(Comandos.Aldeoes.contains(aldeao)) {
				Aldeoes.remove(Comandos.Aldeoes.indexOf(aldeao));
				Mostrar.mostrarAldeao(aldeao+1, "Pronto");
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
				comandoAldeaoConstruirTemplo(aldeao);
				break;
			case "Maravilha":
				comandoAldeaoConstruirMaravilha(aldeao);
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
	
	public static boolean SwitchCriarTemplo = false;
	public static int comandoAldeaoConstruirTemplo;
	public static void comandoAldeaoConstruirTemplo(int aldeao) {
		if(isTemplo == true) {
			View.exibirMensagemErro("Erro", "Já possui Templo");
		}else {
			int comida = Integer.parseInt(Principal.lblComida.getText());
			int ouro = Integer.parseInt(Principal.lblOuro.getText());
			Templo templo;
			if(!Comandos.Aldeoes.contains(aldeao)) {
				if(comida>=2000) {
					if(ouro>=2000) {
						SwitchCriarTemplo = true;
						Aldeoes.add(aldeao);
						comandoAldeaoConstruirTemplo = aldeao;
						//
						templo = new Templo();
						Thread threadTemplo = new Thread(templo);
						threadTemplo.start();
						//
						Mostrar.mostrarComida(comida-2000);
						Mostrar.mostrarOuro(ouro-2000);
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
	}
	
	public static int comandoAldeaoConstruirMaravilha;
	public static void comandoAldeaoConstruirMaravilha(int aldeao) {
		Aldeoes.add(aldeao);
		comandoAldeaoConstruirMaravilha = aldeao;
		Mostrar.mostrarAldeao(aldeao+1, "Construindo Maravilha");
		//
		Maravilha maravilha = new Maravilha();
		Thread threadMaravilha = new Thread(maravilha);
		threadMaravilha.start();
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
	
	public static boolean SwitchOrar = false;
	public static int comandoAldeaoOrar;
	public static  void comandoAldeaoOrar(int aldeao) {
		if (aldeao == -1) {
			View.exibirMensagemErro("Erro", "Escolha um aldeão");
		}else if(isTemplo==false) {
			View.exibirMensagemErro("Erro", "Não possui Templo");
		}else {
			if(!Comandos.Aldeoes.contains(aldeao)) {
				SwitchOrar = true;
				comandoAldeaoOrar = aldeao;
				Aldeoes.add(aldeao);
				
				Templo templo;
				templo = new Templo();
				Thread threadTemplo = new Thread(templo);
				threadTemplo.start();
			}else {
				View.exibirMensagemErro("Erro", "Aldeão Ocupado");
			}
		}
	}
	
	public static boolean SwitchSacrificar = false;
	public static int comandoAldeaoSacrificar;
	public static void comandoAldeaoSacrificar(int aldeao) {
		if (aldeao == -1) {
			View.exibirMensagemErro("Erro", "Escolha um Aldeão");
		}else if(isTemplo==false) {
			View.exibirMensagemErro("Erro", "Não possui Templo");
		}else {
			if(!Comandos.Aldeoes.contains(aldeao)) {
				SwitchSacrificar = true;
				comandoAldeaoSacrificar = aldeao;
				Aldeoes.add(aldeao);
				
				Templo templo;
				templo = new Templo();
				Thread threadTemplo = new Thread(templo);
				threadTemplo.start();
			}else {
				View.exibirMensagemErro("Erro", "Aldeão Ocupado");
			}
		}
	}

	public static void comandoPrefeituraCriarAldeao() {
		int valor = Integer.parseInt(Principal.lblComida.getText());
		Aldeao aldeao;
		if(Comandos.evolucaoPrefeitura == "Evolução de aldeão") {
			View.exibirMensagemErro("ERROR", "Aldeões se encontram em evolução, indiponivel para criação");
		}else {
	
			if(valor>=100) { // Criação do aldeão
				aldeao = new Aldeao();
				Thread threadAldeao = new Thread(aldeao);
				threadAldeao.start();
				Mostrar.mostrarComida(valor-100);
			}else {
				View.exibirMensagemErro("Erro", "Falta Comida");
			}
		}
	}

	public static String evolucaoTemplo;
	public static void comandoTemploEvoluir(String strEvolucao) {
		if(isTemplo==false) {
			View.exibirMensagemErro("Erro", "Não possui Templo");
		}else {
			evolucaoTemplo = strEvolucao;
			Thread threadEvoluir = new Thread (evolucoesTemplo);
			threadEvoluir.start();
		}
	}
	
	public static void comandoTemploLancar() { //Segunda parte
		System.out.println("comandoTemploLancar();");
	}
	
	public static String evolucaoPrefeitura;
	public static void comandoPrefeituraEvoluir(String strEvolucao) {
		Comandos.evolucaoPrefeitura = strEvolucao;
		Thread threadEvoluir = new Thread (evolucoesPrefeitura);
		threadEvoluir.start();
	}
}
