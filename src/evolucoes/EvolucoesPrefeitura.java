package evolucoes;

import java.awt.Color;

import main.Comandos;
import main.Mostrar;
import main.Principal;
import uteis.View;

public class EvolucoesPrefeitura {
	int aldeao;
	int fazenda;
	int mina;
	
	public EvolucoesPrefeitura(){
		this.aldeao=1;
		this.fazenda=1;
		this.mina=1;
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
	
	public void evoluir(String nome) {
		int comida = Integer.parseInt(Principal.lblComida.getText());
		int ouro = Integer.parseInt(Principal.lblOuro.getText());
		switch (nome) {
			case "Evolução de aldeão":
				if(Comandos.evolucoesPrefeitura.getAldeao()<10) {
					if(comida>=5000) {
						if(ouro>=5000) {
							comida = comida - 5000;
							ouro = ouro - 5000;
							Mostrar.mostrarComida(comida);
							Mostrar.mostrarOuro(ouro);
							Comandos.evolucoesPrefeitura.evoluirAldeao();
							Mostrar.mostrarPrefeitura("Aldeões Evoluidos", Color.RED);
						}else {
							View.exibirMensagemErro("Error", "Falta Ouro");
						}
					}else {
						View.exibirMensagemErro("Error", "Falta Comida");
					}
				}else {
					View.exibirMensagemErro("Error", "Evolução já está no maximo");
				}
				break;
			case "Evolução de fazenda":
				if(Comandos.evolucoesPrefeitura.getFazenda()<10) {
					if(comida>=500) {
						if(ouro>=5000) {
							comida = comida - 500;
							ouro = ouro - 5000;
							Mostrar.mostrarComida(comida);
							Mostrar.mostrarOuro(ouro);
							Comandos.evolucoesPrefeitura.evoluirFazenda();
							Mostrar.mostrarPrefeitura("Fazendas Evoluidas", Color.RED);
						}else {
							View.exibirMensagemErro("Error", "Falta Ouro");
						}
					}else {
						View.exibirMensagemErro("Error", "Falta Comida");
					}
				}else {
					View.exibirMensagemErro("Error", "Evolução já está no maximo");
				}
				break;
			case "Evolução de mina de ouro":
				if(Comandos.evolucoesPrefeitura.getMina()<10) {
					if(comida>=2000) {
						if(ouro>=1000) {
							comida = comida - 2000;
							ouro = ouro - 1000;
							Mostrar.mostrarComida(comida);
							Mostrar.mostrarOuro(ouro);
							Comandos.evolucoesPrefeitura.evoluirMina();
							Mostrar.mostrarPrefeitura("Minas de Ouro Evoluidas", Color.RED);
						}else {
							View.exibirMensagemErro("Error", "Falta Ouro");
						}
					}else {
						View.exibirMensagemErro("Error", "Falta Comida");
					}
				}else {
					View.exibirMensagemErro("Error", "Evolução já está no maximo");
				}
				break;
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
	
	
}
