package main;

import java.io.IOException;
import java.util.ArrayList;

import evolucoes.EvolucoesPrefeitura;
import evolucoes.EvolucoesTemplo;
import servidor.Cliente;
import servidor.ExecutarServidor;
import uteis.View;

public class Comandos {
	public static ArrayList<Integer> Aldeoes = new ArrayList<Integer>(); //Array de Aldeões trabalhando
	public static boolean isTemplo = false;//Se tem ou não tem Templo
	public static EvolucoesTemplo evolucoesTemplo = new EvolucoesTemplo();//Evolução de Templo
	public static EvolucoesPrefeitura evolucoesPrefeitura = new EvolucoesPrefeitura();//Evolução de Prefeitura
	
	public static void comandoAldeaoParar(int aldeao) {
		if (aldeao == -1)
			View.exibirMensagemErro("Erro", "Escolha um aldeão");
		else {
			if(Comandos.Aldeoes.contains(aldeao)) {
				Aldeoes.remove(Comandos.Aldeoes.indexOf(aldeao));//Remove do Array de Aldeões trabalhando
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
					SwitchCriarFazenda = true;//Switch usado na classe, aonde ela possui mais de uma função para ser executada
					Aldeoes.add(aldeao);//Add ao array de trabalhadores
					comandoAldeaoConstruirFazenda = aldeao;//Passa como referencia o id do aldeao
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
	public static void comandoAldeaoConstruirMaravilha(int aldeao) {//Fica rodando independete do seu ouro e comida, mas só soma quando tiver ouro e comida
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
			int cultivadores=0;
			for (int i = 1; i <= Principal.tmAldeoes.getRowCount(); i++) {
				if(Principal.tmAldeoes.getValueAt(i-1,1)=="Cultivando") {
					cultivadores++;
				}
			}//Pega todos que estão cultivando no momento
			if(cultivadores < (Principal.tmFazendas.getRowCount()*(evolucoesPrefeitura.getFazenda()*5))) {//Limite inical de fazendeiros é de 5 por fazenda, caso queira mais tenha que evoluir os aldeões
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
			}else {
				View.exibirMensagemErro("Erro", "O limite de Aldeões na fazenda é de: "+evolucoesPrefeitura.getFazenda()*5+" Por fazenda");
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
			int cultivadores=0;
			for (int i = 1; i <= Principal.tmAldeoes.getRowCount(); i++) {
				if(Principal.tmAldeoes.getValueAt(i-1,1)=="Minerando") {
					cultivadores++;
				}
			}
			if(cultivadores < (Principal.tmMinasOuro.getRowCount()*(evolucoesPrefeitura.getMina()*5))) {
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
			}else {
				View.exibirMensagemErro("Erro", "O limite de Aldeões na Mina é de: "+evolucoesPrefeitura.getFazenda()*5+" Por mina");
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
		if(Principal.tmAldeoes.getValueAt(1,1)=="Evolução de aldeão") {
			View.exibirMensagemErro("ERROR", "Aldeões se encontram em evolução, indiponivel para criação");
		}else {
	
			if(valor>=100) { 
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
	public static Cliente app;
	public static void comandoCriarJogo() {
		if(!Principal.pnNomeUsuario.getText().isEmpty()) {
			if(!Principal.pnPorta.getText().isEmpty() && Principal.pnPorta.getText().length()<=5) {
				String server = "127.0.0.1";
				Mostrar.adicionarSave(Principal.pnNomeUsuario.getText(), Principal.pnCivilizacoes.getSelectedItem().toString(), server+":"+Principal.pnPorta.getText(), "Online");
				
				ExecutarServidor serv = new ExecutarServidor();
				serv.start();
				
				try {
					app = new Cliente(server,Principal.pnPorta.getText(),Principal.pnNomeUsuario.getText(),Principal.pnCivilizacoes.getSelectedItem().toString());
					app.conectar();
					app.start();
				} catch (IOException e) {
					e.printStackTrace();
				}

				
			}else {
				View.exibirMensagemErro("ERROR", "Informe a porta certa");
			}
		}else {
			View.exibirMensagemErro("ERROR", "Informe o seu nome");
		}
	}
	public static void conectarJogo(String server,String porta) {
		try {
			app = new Cliente(server,porta,Principal.pnNomeUsuario.getText(),Principal.pnCivilizacoes.getSelectedItem().toString());
			app.conectar();
			app.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
