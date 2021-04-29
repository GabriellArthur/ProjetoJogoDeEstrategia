package main;

import config.Tempo;

/*
 * Custo: 1000 Comida 
 * Função: Produção de ouro
 * Necessidade de construtores: 1
 * Tempo de construção: 40h
 * Capacidade: 5 aldeões
 * Produção por fazendeiro: 5 unidade a cada 3h + 3h para transporte até a prefeitura
 */
public class MinaDeOuro implements Runnable{
	int tempoConstrução;
	int capacidade;
	int tempoFazendeiro;
	int tempoEvolucao;
	
	MinaDeOuro(){
		this.tempoConstrução=40;
		this.capacidade=5;
		this.tempoFazendeiro=3;
	}
	
	public synchronized void criarMina() {
		Comandos.SwitchCriarMinaDeOuro = false;
		int mina = Principal.tmMinasOuro.getRowCount()+1;
		int aldeao = Comandos.comandoAldeaoConstruirMinaDeOuro+1;
		Mostrar.mostrarAldeao(aldeao, "Construindo Mina ["+mina+"]");
		Mostrar.adicionarMinaOuro(""+mina, "Tempo de criação [40s]");
		try {
			Thread.sleep(Tempo.tempoDeCriacaoDaMina);
			Mostrar.mostrarMinaOuro(mina, "Disponivel");
			Mostrar.mostrarAldeao(aldeao, "Pronto");
			
			Comandos.Aldeoes.remove(Comandos.Aldeoes.indexOf(Comandos.comandoAldeaoConstruirMinaDeOuro));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void minerar() {
		Comandos.SwitchMinerar = false;
		boolean continuar = true;
		while(continuar) {
			if(Comandos.Aldeoes.contains(Comandos.comandoAldeaoMinerar)) {
				int tamanho = 0;
				for (int i = 1; i <= Principal.tmAldeoes.getRowCount(); i++) {
					if(Principal.tmAldeoes.getValueAt(i-1,1)=="Minerando") {
						tamanho++;
					}
				}
				try {
					Mostrar.mostrarMinaOuro(Comandos.numeroDaMina+1, "Minerando");
					Thread.sleep(Tempo.tempoPadraoDeMinerar-(Comandos.evolucoesPrefeitura.getAldeao()*10));//Reduz o tempo de transporte
					int ouro = Integer.parseInt(Principal.lblOuro.getText());
					ouro = ouro+(tamanho*(Comandos.evolucoesPrefeitura.getAldeao()*10));//Aumenta a produtividade
					Mostrar.mostrarOuro(ouro);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
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
