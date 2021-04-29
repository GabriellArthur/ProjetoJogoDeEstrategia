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
	public void run() {
		switch (Comandos.evolucaoPrefeitura) {
			case "Evolução de aldeão":
				this.evoluirAldeaos();
				break;
			case "Evolução de fazenda":
				this.evoluirFazendas();
				break;
			case "Evolução de mina de ouro":
				this.evoluirMinas();
				break;
		}
	}
	
	public void evoluirAldeaos() {
		int comida = Integer.parseInt(Principal.lblComida.getText());
		int ouro = Integer.parseInt(Principal.lblOuro.getText());
		if(Comandos.evolucoesPrefeitura.getAldeao()<10) {
			if(comida>=5000) {
				if(ouro>=5000) {
					//------------------------//
					comida = comida - 5000;
					ouro = ouro - 5000;
					//------------------------//
					for (int i = 1; i <= Principal.tmAldeoes.getRowCount(); i++) {
						Mostrar.mostrarAldeao(i, "Evoluindo");
					}
					Comandos.Aldeoes.clear();
					//------------------------//
					Mostrar.desabilitarOpcoesEvolucao("Todos");
					//------------------------//
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
					//------------------------//
					Mostrar.mostrarComida(comida);
					Mostrar.mostrarOuro(ouro);
					Comandos.evolucoesPrefeitura.evoluirAldeao();
					Mostrar.mostrarPrefeitura("Aldeões Evoluidos", Color.RED);
					//------------------------//
					for (int i = 1; i <= Principal.tmAldeoes.getRowCount(); i++) {
						Mostrar.mostrarAldeao(i, "Pronto");
					}
					//------------------------//
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
			View.exibirMensagemErro("Error", "Evolução já está no maximo");
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
					//------------------------// Remover aldeaos colhendo
					for (int i = 1; i <= Principal.tmAldeoes.getRowCount(); i++) {
						if(Principal.tmAldeoes.getValueAt(i-1,1)=="Cultivando") {
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
			View.exibirMensagemErro("Error", "Evolução já está no maximo");
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
					//------------------------// Remover aldeaos minerando
					for (int i = 1; i <= Principal.tmAldeoes.getRowCount(); i++) {
						if(Principal.tmAldeoes.getValueAt(i-1,1)=="Minerando") {
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
			View.exibirMensagemErro("Error", "Evolução já está no maximo");
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
