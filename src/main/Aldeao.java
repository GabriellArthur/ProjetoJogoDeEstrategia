package main;

import java.awt.Color;

import config.Tempo;

public class Aldeao implements Runnable{

	Aldeao(){
		
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
