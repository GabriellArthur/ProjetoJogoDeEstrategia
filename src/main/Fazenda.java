package main;
/*
 * Custo: 100 Comida e 500 ouro
 * Função: Produção de comida
 * Necessidade de construtores: 1
 * Tempo de construção: 30h
 * Capacidade: 5 aldeões
 * Produção por fazendeiro: 10 unidade a cada 1h + 2h para transporte até a prefeitura
 */

import uteis.View;

public class Fazenda implements Runnable {
	private int level;
	int tempoConstrução;
	int Capacidade;
	int tempoFazendeiro;
	int tempoEvolucao;
	
	Fazenda(){
		this.level=0;
		this.tempoConstrução=30;
		this.Capacidade = 5;
		this.tempoFazendeiro=3; //3h
	}
	
	public void upgradeFazenda() {
		if(this.level>=10) {
			View.exibirMensagemErro("ERROR", "Fazenda já está no nivel maximo!");
		}else {
			this.level ++;
			this.Capacidade = this.Capacidade *2;
			this.tempoEvolucao=100;
		}
	}
	
	public void criarFazenda() {
		int valor = Principal.tmFazendas.getRowCount()+1;
		Mostrar.mostrarAldeao(Comandos.comandoAldeaoConstruirFazenda+1, "construindo");
		Mostrar.adicionarFazenda(""+valor, "Tempo de criação[30s]");
		try {
			Thread.sleep(30000);
			Mostrar.mostrarFazenda(valor, "Pronto");
			Mostrar.mostrarAldeao(Comandos.comandoAldeaoConstruirFazenda+1, "Pronto");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void cultivar() {
		Comandos.SwitchCultivar = false;
		while(true) {
			if(Comandos.Aldeoes.isEmpty()) {
				Mostrar.mostrarFazenda(Comandos.numeroDaFazendo+1, "Parado");
			}else {
				for (Integer aldeaos : Comandos.Aldeoes) {
					Mostrar.mostrarAldeao(aldeaos+1, "Cultivando");
				}
				Mostrar.mostrarFazenda(Comandos.numeroDaFazendo+1, "Produzindo["+Comandos.Aldeoes.size()+"]");
				try {
					Thread.sleep(3000);
					int comida = Integer.parseInt(Principal.lblComida.getText());
					comida = comida+(Comandos.Aldeoes.size()*10);
					Mostrar.mostrarComida(comida);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	@Override
	public void run() {
		if(Comandos.SwitchCriarFazenda == true) {
			this.criarFazenda();
			Comandos.SwitchCriarFazenda = false;
		}
		if(Comandos.SwitchCultivar==true) {
			this.cultivar();
		}
		
	}
}
