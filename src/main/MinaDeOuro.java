package main;

import uteis.View;

/*
 * Custo: 1000 Comida 
 * Função: Produção de ouro
 * Necessidade de construtores: 1
 * Tempo de construção: 40h
 * Capacidade: 5 aldeões
 * Produção por fazendeiro: 5 unidade a cada 3h + 3h para transporte até a prefeitura
 */
public class MinaDeOuro implements Runnable{
	private int level;
	int tempoConstrução;
	int capacidade;
	int tempoFazendeiro;
	int tempoEvolucao;
	
	MinaDeOuro(){
		this.level=0;
		this.tempoConstrução=40;
		this.capacidade=5;
		this.tempoFazendeiro=3;
	}
	
	public void upgradeMinaDeOuro() {
		if(this.level>=10) {
			View.exibirMensagemErro("ERROR", "Mina de ouro já está no nivel maximo!");
		}else {
			this.level++;
			this.capacidade= this.capacidade*2;
			this.tempoEvolucao=100;
		}
	}
	
	public synchronized void criarMina() {
		Comandos.SwitchCriarMinaDeOuro = false;
		int mina = Principal.tmMinasOuro.getRowCount()+1;
		int aldeao = Comandos.comandoAldeaoConstruirMinaDeOuro+1;
		Mostrar.mostrarAldeao(aldeao, "Construindo Mina ["+mina+"]");
		Mostrar.adicionarMinaOuro(""+mina, "Tempo de criação [40s]");
		try {
			Thread.sleep(4000);//30000
			Mostrar.mostrarMinaOuro(mina, "Pronto");
			Mostrar.mostrarAldeao(aldeao, "Pronto");
			
			for (Integer integer : Comandos.Aldeoes) {
				if(integer == Comandos.comandoAldeaoConstruirMinaDeOuro) {
					Comandos.Aldeoes.remove(integer);
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void minerar() {
		Comandos.SwitchMinerar = false;
		boolean continuar = true;
		while(continuar) {
			if(Comandos.Aldeoes.contains(Comandos.comandoAldeaoMinerar+1)) {
				try {
					Mostrar.mostrarMinaOuro(Comandos.numeroDaMina+1, "Minerando");
					Thread.sleep(3000);
					int ouro = Integer.parseInt(Principal.lblOuro.getText());
					ouro = ouro+(Comandos.Aldeoes.size()*10);
					Mostrar.mostrarOuro(ouro);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				Mostrar.mostrarAldeao(Comandos.comandoAldeaoCultivarFazenda+1, "Pronto");
				Mostrar.mostrarMinaOuro(Comandos.numeroDaMina+1, "Parado");
				continuar = false;	
			}
		}
	}
	
	@Override
	public void run() {
		if(Comandos.SwitchMinerar==true) {
			this.minerar();
		}
		if(Comandos.SwitchCriarMinaDeOuro == true) {
			this.criarMina();
		}
	}
	
}
