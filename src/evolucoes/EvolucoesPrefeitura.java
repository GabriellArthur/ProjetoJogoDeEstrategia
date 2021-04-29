package evolucoes;

import java.awt.Color;

import config.Tempo;
import main.Comandos;
import main.Mostrar;
import main.Principal;
import uteis.View;

public class EvolucoesPrefeitura implements Runnable{
	
	int aldeao;
	int fazenda;
	int mina;
	
	public EvolucoesPrefeitura(){
		this.aldeao=1;
		this.fazenda=1;
		this.mina=1;
	}
	
	@Override
	public void run() { //Uma evolu��o por vez
		switch (Comandos.evolucaoPrefeitura) {
			case "Evolu��o de alde�o":
				this.evoluirAldeaos();
				break;
			case "Evolu��o de fazenda":
				this.evoluirFazendas();
				break;
			case "Evolu��o de mina de ouro":
				this.evoluirMinas();
				break;
		}
	}
	
	public void evoluirAldeaos() { //Evolu��o de alde�o
		int comida = Integer.parseInt(Principal.lblComida.getText());//Pega as informa��es atuais de comida e ouro
		int ouro = Integer.parseInt(Principal.lblOuro.getText());
		if(Comandos.evolucoesPrefeitura.getAldeao()<10) {//Verifica se o upgrade j� n�o est� no maximo
			if(comida>=5000) {
				if(ouro>=5000) {
					//------------------------//Custo
					comida = comida - 5000;
					ouro = ouro - 5000;
					//------------------------//Mostra todos evoluindo e dar clear na lista de aldeos trabalhando
					for (int i = 1; i <= Principal.tmAldeoes.getRowCount(); i++) {
						Mostrar.mostrarAldeao(i, "Evoluindo");
					}
					Comandos.Aldeoes.clear();
					//------------------------//Desabilita op��es, alde�es est� evoluindo e indiponivel 
					Mostrar.desabilitarOpcoesEvolucao("Todos");
					//------------------------//Carregamento da barra
					int porcentagem = 0;
					while(porcentagem!=100) {
						try {
							Thread.sleep(Tempo.evoluirAldeao);
							porcentagem++;
							Mostrar.mostrarPrefeitura(porcentagem);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					//------------------------//Motra a acomida e ouro, evolui o alde�o e mostra na prefeitura que foi evoluido
					Mostrar.mostrarComida(comida);
					Mostrar.mostrarOuro(ouro);
					Comandos.evolucoesPrefeitura.evoluirAldeao();
					Mostrar.mostrarPrefeitura("Alde�es Evoluidos", Color.RED);
					//------------------------//Percorre toda a lista mudando o status para "pronto"
					for (int i = 1; i <= Principal.tmAldeoes.getRowCount(); i++) {
						Mostrar.mostrarAldeao(i, "Pronto");
					}
					//------------------------//reset's e aumanta o valor de level do alde�o
					Comandos.evolucaoPrefeitura = "";
					Mostrar.habilitarOpcoesEvolucao("Todos");
					Principal.lvlAldeao.setValue(getAldeao());
				}else {
					View.exibirMensagemErro("Error", "Falta Ouro");
				}
			}else {
				View.exibirMensagemErro("Error", "Falta Comida");
			}
		}else {
			View.exibirMensagemErro("Error", "Evolu��o j� est� no maximo");
		}
	}
	
	public void evoluirFazendas() {
		int comida = Integer.parseInt(Principal.lblComida.getText());
		int ouro = Integer.parseInt(Principal.lblOuro.getText());
		if(Comandos.evolucoesPrefeitura.getFazenda()<10) {
			if(comida>=500) {
				if(ouro>=5000) {
					comida = comida - 500;
					ouro = ouro - 5000;
					//------------------------//
					for (int i = 1; i <= Principal.tmAldeoes.getRowCount(); i++) {
						if(Principal.tmAldeoes.getValueAt(i-1,1)=="Cultivando") { //Pega todos os alde�es que est�o cultivando e para ele, j� que a fazenda vai est� evoluindo
							Mostrar.mostrarAldeao(i, "Pronto");
							Comandos.Aldeoes.remove(Comandos.Aldeoes.indexOf(i-1));
						}
					}
					for (int i = 1; i <= Principal.tblFazendas.getRowCount(); i++) {
						Mostrar.mostrarFazenda(i, "Evoluindo");
					}
					//------------------------//
					Mostrar.desabilitarOpcoesEvolucao("Fazenda");
					//------------------------//
					int porcentagem = 0;
					while(porcentagem!=100) {
						try {
							Thread.sleep(Tempo.evoluirFazenda);
							porcentagem++;
							Mostrar.mostrarPrefeitura(porcentagem);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					//------------------------//
					Mostrar.mostrarComida(comida);
					Mostrar.mostrarOuro(ouro);
					Comandos.evolucoesPrefeitura.evoluirFazenda();
					Mostrar.mostrarPrefeitura("Fazendas Evoluidas", Color.RED);
					//------------------------//
					for (int i = 1; i <= Principal.tblFazendas.getRowCount(); i++) {
						Mostrar.mostrarFazenda(i, "Disponivel");
					}
					//------------------------//
					Comandos.evolucaoPrefeitura = "";
					Mostrar.habilitarOpcoesEvolucao("Fazenda");
					Principal.lvlFazenda.setValue(getFazenda());
				}else {
					View.exibirMensagemErro("Error", "Falta Ouro");
				}
			}else {
				View.exibirMensagemErro("Error", "Falta Comida");
			}
		}else {
			View.exibirMensagemErro("Error", "Evolu��o j� est� no maximo");
		}
	}
	
	public void evoluirMinas() {
		int comida = Integer.parseInt(Principal.lblComida.getText());
		int ouro = Integer.parseInt(Principal.lblOuro.getText());
		if(Comandos.evolucoesPrefeitura.getMina()<10) {
			if(comida>=2000) {
				if(ouro>=1000) {
					comida = comida - 2000;
					ouro = ouro - 1000;
					//------------------------//
					for (int i = 1; i <= Principal.tmAldeoes.getRowCount(); i++) {
						if(Principal.tmAldeoes.getValueAt(i-1,1)=="Minerando") {//Pega todos os alde�es que est�o Minerando e para ele, j� que a Mina vai est� evoluindo
							Mostrar.mostrarAldeao(i, "Pronto");
							Comandos.Aldeoes.remove(Comandos.Aldeoes.indexOf(i-1));
						}
					}
					for (int i = 1; i <= Principal.tblMinasOuro.getRowCount(); i++) {
						Mostrar.mostrarMinaOuro(i, "Evoluindo");
					}
					//------------------------//
					Mostrar.desabilitarOpcoesEvolucao("Mina");
					//------------------------//
					int porcentagem = 0;
					while(porcentagem!=100) {
						try {
							Thread.sleep(Tempo.evoluirMina);
							porcentagem++;
							Mostrar.mostrarPrefeitura(porcentagem);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					//------------------------//
					
					Mostrar.mostrarComida(comida);
					Mostrar.mostrarOuro(ouro);
					Comandos.evolucoesPrefeitura.evoluirMina();
					Mostrar.mostrarPrefeitura("Minas de Ouro Evoluidas", Color.RED);
					//------------------------//
					for (int i = 1; i <= Principal.tblMinasOuro.getRowCount(); i++) {
						Mostrar.mostrarMinaOuro(i, "Disponivel");
					}
					//------------------------//
					Comandos.evolucaoPrefeitura = "";
					Mostrar.habilitarOpcoesEvolucao("Mina");
					Principal.lvlMina.setValue(getMina());
				}else {
					View.exibirMensagemErro("Error", "Falta Ouro");
				}
			}else {
				View.exibirMensagemErro("Error", "Falta Comida");
			}
		}else {
			View.exibirMensagemErro("Error", "Evolu��o j� est� no maximo");
		}
	}
	

	public int getAldeao() {
		return aldeao;
	}

	public int getFazenda() {
		return fazenda;
	}

	public int getMina() {
		return mina;
	}
	
	public void evoluirAldeao() {
		if(this.aldeao<=9)
			this.aldeao++;
	}
	public void evoluirFazenda() {
		if(this.fazenda<=9)
			this.fazenda++;
	}
	public void evoluirMina() {
		if(this.mina<=9)
			this.mina++;
	}


	
}
