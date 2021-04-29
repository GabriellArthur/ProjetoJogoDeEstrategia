package main;

import java.awt.Color;

import config.Tempo;
import uteis.View;

//Evolução = Dobra a produção, e reduz o tempo de transporte da produção, tempo de evolução 100horas;
public class Aldeao implements Runnable{
	private int level;
	int tempoCriacao;
	int producao;
	int tempoTransporte;
	int tempoEvolucao;
	
	Aldeao(){
		this.level = 0;
		this.tempoCriacao = 20;
		this.producao =1;
		this.tempoTransporte = 20;
		this.tempoEvolucao = 100;
	}
	
	public void upgradeAldeao() {
		if(this.level>=10) {
			View.exibirMensagemErro("ERROR", "Aldeão já está no nivel maximo!");
		}else {
			this.level ++;
			this.producao ++;
			this.tempoTransporte=this.tempoTransporte-2;
		}
	}
	
	public void criarAldeao() {
		int valor = Principal.tmAldeoes.getRowCount()+1;
		Mostrar.adicionarAldeao(""+valor, "Tempo de criação[10s]");
		try {
			Thread.sleep(Tempo.tempoDeCriacaoDoAldao);
			Mostrar.mostrarAldeao(valor, "Pronto");
			Mostrar.mostrarPrefeitura("Aldeao ["+valor+"] Criado", Color.GREEN);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.criarAldeao();
	}
	
}
