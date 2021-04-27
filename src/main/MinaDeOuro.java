package main;


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
			Thread.sleep(4000);//30000
			Mostrar.mostrarMinaOuro(mina, "Parada");
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
				try {
					Mostrar.mostrarMinaOuro(Comandos.numeroDaMina+1, "Minerando");
					Thread.sleep(3000-(Comandos.evolucoesPrefeitura.getAldeao()*10));//Reduz o tempo de transporte
					int ouro = Integer.parseInt(Principal.lblOuro.getText());
					ouro = ouro+(Comandos.Aldeoes.size()*(Comandos.evolucoesPrefeitura.getAldeao()*10));//Aumenta a produtividade
					Mostrar.mostrarOuro(ouro);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				Mostrar.mostrarAldeao(Comandos.comandoAldeaoCultivarFazenda+1, "Pronto");
				Mostrar.mostrarMinaOuro(Comandos.numeroDaMina+1, "Parada");
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
