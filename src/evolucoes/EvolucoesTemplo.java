package evolucoes;

import java.awt.Color;

import main.Comandos;
import main.Mostrar;
import main.Principal;
import uteis.View;
//Limite de evolucao
//
public class EvolucoesTemplo {
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
	
	public void evoluir(String nome) {
		int fe = Integer.parseInt(Principal.lblOferenda.getText());
		switch (nome) {
			case "Nuvem de gafanhotos":
				if(Comandos.evolucaoTemplo.getGarfanhoto()<10) {
					if(fe>=1000) {
						fe = fe - 1000;
						Mostrar.mostrarOferendaFe(fe);
						Comandos.evolucaoTemplo.evolucaoGarfanhoto();
						Mostrar.mostrarTemplo("Nuvem de gafanhotos["+Comandos.evolucaoTemplo.getGarfanhoto()+"]", Color.RED);
					}else if(Comandos.evolucaoTemplo.getPrimogenitos()==0){
						View.exibirMensagemErro("Erro", "Não possui fé para [Nuvem de gafanhotos]");
					}else {
						View.exibirMensagemErro("Erro", "Não possui fé para [Nuvem de gafanhotos] para o level "+Comandos.evolucaoTemplo.getGarfanhoto()+1);
					}	
				}else {
					View.exibirMensagemErro("Error", "Evolução já está no maximo");
				}

				break;
			case "Morte dos primogénitos":
				if(Comandos.evolucaoTemplo.getPrimogenitos()<10) {
					if(fe>=1500) {
						fe = fe - 1500;
						Mostrar.mostrarOferendaFe(fe);
						Comandos.evolucaoTemplo.evolucaoPrimogenitos();
						Mostrar.mostrarTemplo("Morte dos primogénitos["+Comandos.evolucaoTemplo.getPrimogenitos()+"]", Color.RED);
					}else if(Comandos.evolucaoTemplo.getPrimogenitos()==0){
						View.exibirMensagemErro("Erro", "Não possui fé para [Morte dos primogénitos]");
					}else {
						View.exibirMensagemErro("Erro", "Não possui fé para [Morte dos primogénitos] para o level "+Comandos.evolucaoTemplo.getPrimogenitos()+1);
					}
				}else {
					View.exibirMensagemErro("Error", "Evolução já está no maximo");
				}
				break;
			case "Chuva de pedras":
				if(Comandos.evolucaoTemplo.getChuvaPedras()<10) {
					if(fe>=2000) {
						fe = fe - 2000;
						Mostrar.mostrarOferendaFe(fe);
						Comandos.evolucaoTemplo.evolucaoChuvaPedras();
						Mostrar.mostrarTemplo("Chuva de pedras["+Comandos.evolucaoTemplo.getChuvaPedras()+"]", Color.RED);
					}else if(Comandos.evolucaoTemplo.getChuvaPedras()==0){
						View.exibirMensagemErro("Erro", "Não possui fé para [Chuva de pedras]");
					}else {
						View.exibirMensagemErro("Erro", "Não possui fé para [Chuva de pedras] para o level "+Comandos.evolucaoTemplo.getChuvaPedras()+1);
					}
				}else {
					View.exibirMensagemErro("Error", "Evolução já está no maximo");
				}
				break;
			case "Proteção contra nuvem de gafanhotos":
				if(Comandos.evolucaoTemplo.getProtecaoGarfanhoto()<10) {
					if(fe>=5000) {
						fe = fe - 5000;
						Mostrar.mostrarOferendaFe(fe);
						Comandos.evolucaoTemplo.evolucaoProtecaoGarfanhoto();
						Mostrar.mostrarTemplo("[Proteção] Nuvem de gafanhotos["+Comandos.evolucaoTemplo.getProtecaoGarfanhoto()+"]", Color.GREEN);
					}else if(Comandos.evolucaoTemplo.getProtecaoGarfanhoto()==0){
						View.exibirMensagemErro("Erro", "Não possui fé para [Proteção contra nuvem de gafanhotos]");
					}else {
						View.exibirMensagemErro("Erro", "Não possui fé para [Proteção contra nuvem de gafanhotos] para o level "+Comandos.evolucaoTemplo.getProtecaoGarfanhoto()+1);
					}
				}else {
					View.exibirMensagemErro("Error", "Evolução já está no maximo");
				}
				break;
			case "Proteção contra morte dos primogénitos":
				if(Comandos.evolucaoTemplo.getProtecaoPrimogenitos()<10) {
					if(fe>=6000) {
						fe = fe - 6000;
						Mostrar.mostrarOferendaFe(fe);
						Comandos.evolucaoTemplo.evolucaoProtecaoPrimogenitos();
						Mostrar.mostrarTemplo("[Proteção] Morte dos primogénitos["+Comandos.evolucaoTemplo.getProtecaoPrimogenitos()+"]", Color.GREEN);
					}else  if(Comandos.evolucaoTemplo.getProtecaoPrimogenitos()==0){
						View.exibirMensagemErro("Erro", "Não possui fé para [Proteção contra morte dos primogénitos]");
					}else {
						View.exibirMensagemErro("Erro", "Não possui fé para [Proteção contra morte dos primogénitos] para o level "+Comandos.evolucaoTemplo.getProtecaoPrimogenitos()+1);
					}	
				}else {
					View.exibirMensagemErro("Error", "Evolução já está no maximo");
				}
				break;
			case "Proteção contra chuva de pedras":
				if(Comandos.evolucaoTemplo.getProtecaoChuvaPedras()<10) {
					if(fe>=7000) {
						fe = fe - 7000;
						Mostrar.mostrarOferendaFe(fe);
						Comandos.evolucaoTemplo.evolucaoProtecaoChuvaPedras();
						Mostrar.mostrarTemplo("[Proteção] Chuva de Pedras["+Comandos.evolucaoTemplo.getProtecaoChuvaPedras()+"]", Color.GREEN);
					}else if(Comandos.evolucaoTemplo.getProtecaoChuvaPedras()==0){
						View.exibirMensagemErro("Erro", "Não possui fé para [Proteção contra chuva de pedras]");
					}else {
						View.exibirMensagemErro("Erro", "Não possui fé para [Proteção contra chuva de pedras] para o level "+Comandos.evolucaoTemplo.getProtecaoChuvaPedras()+1);
					}
				}else {
					View.exibirMensagemErro("Error", "Evolução já está no maximo");
				}
				break;
		}
	}
	
}
