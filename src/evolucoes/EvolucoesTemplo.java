package evolucoes;

import config.Tempo;
import main.Comandos;
import main.Mostrar;
import main.Principal;
import uteis.View;
//Limite de evolucao
//
public class EvolucoesTemplo implements Runnable{
	int Garfanhoto;
	int Primogenitos;
	int chuvaPedras;
	int protecaoGarfanhoto;
	int protecaoPrimogenitos;
	int protecaoChuvaPedras;
	
	public EvolucoesTemplo(){
		this.Garfanhoto=0;
		this.Primogenitos=0;
		this.chuvaPedras=0;
		this.protecaoGarfanhoto=0;
		this.protecaoPrimogenitos=0;
		this.protecaoChuvaPedras=0;
	}
	
	@Override
	public void run() {
		switch (Comandos.evolucaoTemplo) {
			case "Nuvem de gafanhotos":
				this.evoluirGarfanhoto();
				break;
			case "Morte dos primogénitos":
				this.evoluirPrimogenitos();
				break;
			case "Chuva de pedras":
				this.evoluirPedra();
				break;
			case "Proteção contra nuvem de gafanhotos":
				this.evoluirProtecaoGarfanhoto();
				break;
			case "Proteção contra morte dos primogénitos":
				this.evoluirProtecaoPrimogenitos();
				break;
			case "Proteção contra chuva de pedras":
				this.evoluirProtecaoPedra();
				break;
		}
		
	}
	
	public void evoluirGarfanhoto() {
		int fe = Integer.parseInt(Principal.lblOferenda.getText());
		if(Comandos.evolucoesTemplo.getGarfanhoto()<10) {
			if(fe>=1000) {
				fe = fe - 1000;
				Mostrar.desabilitarOpcaoEvoluir();//Desabilita o "evoluir"
				//------------------------//
				int porcentagem = 0;
				while(porcentagem!=100) {//Bar
					try {
						Thread.sleep(Tempo.evoluirGarfanhoto);
						porcentagem++;
						Mostrar.mostrarEvolucao(porcentagem);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//------------------------//
				Mostrar.mostrarOferendaFe(fe);
				Comandos.evolucoesTemplo.evolucaoGarfanhoto();//Evolui
				Mostrar.habilitarOpcaoEvoluir();
				Comandos.evolucaoTemplo = "";
				Principal.lvlGarfanhoto.setValue(getGarfanhoto());//Passa o level
			}else if(Comandos.evolucoesTemplo.getPrimogenitos()==0){
				View.exibirMensagemErro("Erro", "Não possui fé para [Nuvem de gafanhotos]");
			}else {
				View.exibirMensagemErro("Erro", "Não possui fé para [Nuvem de gafanhotos] para o level "+Comandos.evolucoesTemplo.getGarfanhoto()+1);
			}	
		}else {
			View.exibirMensagemErro("Error", "Evolução já está no maximo");
		}
	}
	public void evoluirPrimogenitos() {
		int fe = Integer.parseInt(Principal.lblOferenda.getText());
		if(Comandos.evolucoesTemplo.getPrimogenitos()<10) {
			if(fe>=1500) {
				fe = fe - 1500;
				Mostrar.desabilitarOpcaoEvoluir();
				//------------------------/
				int porcentagem = 0;
				while(porcentagem!=100) {
					try {
						Thread.sleep(Tempo.evoluirPrimogenitos);
						porcentagem++;
						Mostrar.mostrarEvolucao(porcentagem);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//------------------------//
				Mostrar.mostrarOferendaFe(fe);
				Comandos.evolucoesTemplo.evolucaoPrimogenitos();
				Mostrar.habilitarOpcaoEvoluir();
				Comandos.evolucaoTemplo = "";
				Principal.lvlPrimogenitos.setValue(getPrimogenitos());
			}else if(Comandos.evolucoesTemplo.getPrimogenitos()==0){
				View.exibirMensagemErro("Erro", "Não possui fé para [Morte dos primogénitos]");
			}else {
				View.exibirMensagemErro("Erro", "Não possui fé para [Morte dos primogénitos] para o level "+Comandos.evolucoesTemplo.getPrimogenitos()+1);
			}	
		}else {
			View.exibirMensagemErro("Error", "Evolução já está no maximo");
		}
	}
	public void evoluirPedra() {
		int fe = Integer.parseInt(Principal.lblOferenda.getText());
		if(Comandos.evolucoesTemplo.getChuvaPedras()<10) {
			if(fe>=2000) {
				fe = fe - 2000;
				Mostrar.desabilitarOpcaoEvoluir();
				//------------------------//
				int porcentagem = 0;
				while(porcentagem!=100) {
					try {
						Thread.sleep(Tempo.evoluirPedra);
						porcentagem++;
						Mostrar.mostrarEvolucao(porcentagem);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//------------------------//
				Mostrar.mostrarOferendaFe(fe);
				Comandos.evolucoesTemplo.evolucaoChuvaPedras();
				Mostrar.habilitarOpcaoEvoluir();
				Comandos.evolucaoTemplo = "";
				Principal.lvlchuvaPedras.setValue(getChuvaPedras());
			}else if(Comandos.evolucoesTemplo.getChuvaPedras()==0){
				View.exibirMensagemErro("Erro", "Não possui fé para [Chuva de pedras]");
			}else {
				View.exibirMensagemErro("Erro", "Não possui fé para [Chuva de pedras] para o level "+Comandos.evolucoesTemplo.getChuvaPedras()+1);
			}	
		}else {
			View.exibirMensagemErro("Error", "Evolução já está no maximo");
		}
	}
	public void evoluirProtecaoGarfanhoto() {
		int fe = Integer.parseInt(Principal.lblOferenda.getText());
		if(Comandos.evolucoesTemplo.getProtecaoGarfanhoto()<10) {
			if(fe>=5000) {
				fe = fe - 5000;
				Mostrar.desabilitarOpcaoEvoluir();
				//------------------------//
				int porcentagem = 0;
				while(porcentagem!=100) {
					try {
						Thread.sleep(Tempo.evoluirProtecaoGarfanhoto);
						porcentagem++;
						Mostrar.mostrarEvolucao(porcentagem);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//------------------------//
				Mostrar.mostrarOferendaFe(fe);
				Comandos.evolucoesTemplo.evolucaoProtecaoGarfanhoto();
				Mostrar.habilitarOpcaoEvoluir();
				Comandos.evolucaoTemplo = "";
				Principal.lvlprotecaoGarfanhoto.setValue(getProtecaoGarfanhoto());
			}else if(Comandos.evolucoesTemplo.getProtecaoGarfanhoto()==0){
				View.exibirMensagemErro("Erro", "Não possui fé para [Proteção contra nuvem de gafanhotos]");
			}else {
				View.exibirMensagemErro("Erro", "Não possui fé para [Proteção contra nuvem de gafanhotos] para o level "+Comandos.evolucoesTemplo.getProtecaoGarfanhoto()+1);
			}	
		}else {
			View.exibirMensagemErro("Error", "Evolução já está no maximo");
		}
		
	}
	public void evoluirProtecaoPrimogenitos() {
		int fe = Integer.parseInt(Principal.lblOferenda.getText());
		if(Comandos.evolucoesTemplo.getProtecaoPrimogenitos()<10) {
			if(fe>=6000) {
				fe = fe - 6000;
				Mostrar.desabilitarOpcaoEvoluir();
				//------------------------//
				int porcentagem = 0;
				while(porcentagem!=100) {
					try {
						Thread.sleep(Tempo.evoluirProtecaoPrimogenitos);
						porcentagem++;
						Mostrar.mostrarEvolucao(porcentagem);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//------------------------//
				Mostrar.mostrarOferendaFe(fe);
				Comandos.evolucoesTemplo.evolucaoProtecaoPrimogenitos();
				Mostrar.habilitarOpcaoEvoluir();
				Comandos.evolucaoTemplo = "";
				Principal.lvlprotecaoPrimogenitos.setValue(getProtecaoPrimogenitos());
			}else if(Comandos.evolucoesTemplo.getProtecaoPrimogenitos()==0){
				View.exibirMensagemErro("Erro", "Não possui fé para [Morte dos primogénitos]");
			}else {
				View.exibirMensagemErro("Erro", "Não possui fé para [Morte dos primogénitos] para o level "+Comandos.evolucoesTemplo.getProtecaoPrimogenitos()+1);
			}	
		}else {
			View.exibirMensagemErro("Error", "Evolução já está no maximo");
		}
		
	}
	public void evoluirProtecaoPedra() {
		int fe = Integer.parseInt(Principal.lblOferenda.getText());
		if(Comandos.evolucoesTemplo.getProtecaoChuvaPedras()<10) {
			if(fe>=7000) {
				fe = fe - 7000;
				Mostrar.desabilitarOpcaoEvoluir();
				//------------------------//
				int porcentagem = 0;
				while(porcentagem!=100) {
					try {
						Thread.sleep(Tempo.evoluirProtecaoPedra);
						porcentagem++;
						Mostrar.mostrarEvolucao(porcentagem);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//------------------------//
				Mostrar.mostrarOferendaFe(fe);
				Comandos.evolucoesTemplo.evolucaoProtecaoChuvaPedras();
				Mostrar.habilitarOpcaoEvoluir();
				Comandos.evolucaoTemplo = "";
				Principal.lvlprotecaoChuvaPedras.setValue(getProtecaoChuvaPedras());
			}else if(Comandos.evolucoesTemplo.getProtecaoChuvaPedras()==0){
				View.exibirMensagemErro("Erro", "Não possui fé para [Morte dos primogénitos]");
			}else {
				View.exibirMensagemErro("Erro", "Não possui fé para [Morte dos primogénitos] para o level "+Comandos.evolucoesTemplo.getProtecaoChuvaPedras()+1);
			}	
		}else {
			View.exibirMensagemErro("Error", "Evolução já está no maximo");
		}
		
	}
	//---------------------------//
	public void evolucaoGarfanhoto() {
		if(this.Garfanhoto<=9)
			this.Garfanhoto++;
	}
	public void evolucaoPrimogenitos() {
		if(this.Primogenitos<=9)
			this.Primogenitos++;
	}
	public void evolucaoChuvaPedras() {
		if(this.chuvaPedras<=9)
			this.chuvaPedras++;
	}
	public void evolucaoProtecaoGarfanhoto() {
		if(this.protecaoGarfanhoto<=9)
			this.protecaoGarfanhoto++;
	}
	public void evolucaoProtecaoPrimogenitos() {
		if(this.protecaoPrimogenitos<=9)
			this.protecaoPrimogenitos++;
	}
	public void evolucaoProtecaoChuvaPedras() {
		if(this.protecaoChuvaPedras<=9)
			this.protecaoChuvaPedras++;
	}

	public int getGarfanhoto() {
		return Garfanhoto;
	}

	public int getPrimogenitos() {
		return Primogenitos;
	}

	public int getChuvaPedras() {
		return chuvaPedras;
	}

	public int getProtecaoGarfanhoto() {
		return protecaoGarfanhoto;
	}

	public int getProtecaoPrimogenitos() {
		return protecaoPrimogenitos;
	}

	public int getProtecaoChuvaPedras() {
		return protecaoChuvaPedras;
	}
	
	
}
