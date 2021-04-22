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
		Comandos.SwitchCriarFazenda = false;
		int valor = Principal.tmFazendas.getRowCount()+1;
		int aldeao = Comandos.comandoAldeaoConstruirFazenda+1;
		Mostrar.mostrarAldeao(aldeao, "Construindo");
		Mostrar.adicionarFazenda(""+valor, "Tempo de criação[30s]");
		try {
			Thread.sleep(3000);//30000
			Mostrar.mostrarFazenda(valor, "Pronto");
			Mostrar.mostrarAldeao(aldeao, "Pronto");
			
			for (Integer integer : Comandos.Aldeoes) {
				if(integer == Comandos.comandoAldeaoConstruirFazenda) {
					Comandos.Aldeoes.remove(integer);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void cultivar() {
		Comandos.SwitchCultivar = false;
		boolean continuar = true;
		while(continuar) {
			if(Comandos.Aldeoes.contains(Comandos.comandoAldeaoCultivarFazenda)) {
				try {
					Mostrar.mostrarFazenda(Comandos.numeroDaFazendo+1, "Produzindo");
					Thread.sleep(3000);
					int comida = Integer.parseInt(Principal.lblComida.getText());
					comida = comida+(Comandos.Aldeoes.size()*10);
					Mostrar.mostrarComida(comida);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				Mostrar.mostrarAldeao(Comandos.comandoAldeaoCultivarFazenda+1, "Pronto");
				Mostrar.mostrarFazenda(Comandos.numeroDaFazendo+1, "Parado");
				continuar = false;
				Thread.interrupted();	
			}
		}
		
	}
	
	@Override
	public void run() {
		if(Comandos.SwitchCriarFazenda == true) {
			this.criarFazenda();
		}
		if(Comandos.SwitchCultivar==true) {
			this.cultivar();
		}
		
	}
}
