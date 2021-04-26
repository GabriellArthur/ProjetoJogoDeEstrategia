package main;
/*
 * Custo: 100 Comida e 500 ouro
 * Função: Produção de comida
 * Necessidade de construtores: 1
 * Tempo de construção: 30h
 * Capacidade: 5 aldeões
 * Produção por fazendeiro: 10 unidade a cada 1h + 2h para transporte até a prefeitura
 */


public class Fazenda implements Runnable {
	int tempoConstrução;
	int Capacidade;
	int tempoFazendeiro;
	int tempoEvolucao;
	
	Fazenda(){
		this.tempoConstrução=30;
		this.Capacidade = 5;
		this.tempoFazendeiro=3; //3h
	}
	
	public synchronized void criarFazenda() {
		Comandos.SwitchCriarFazenda = false;
		int fazenda = Principal.tmFazendas.getRowCount()+1;
		int aldeao = Comandos.comandoAldeaoConstruirFazenda+1;
		Mostrar.mostrarAldeao(aldeao, "Construindo Mina ["+fazenda+"]");
		Mostrar.adicionarFazenda(""+fazenda, "Tempo de criação[30s]");
		try {
			Thread.sleep(3000);//30000
			Mostrar.mostrarFazenda(fazenda, "Pronto");
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
	
	private synchronized void cultivar() {
		Comandos.SwitchCultivar = false;
		boolean continuar = true;
		while(continuar) {
			if(Comandos.Aldeoes.contains(Comandos.comandoAldeaoCultivarFazenda)) {
				try {
					Mostrar.mostrarFazenda(Comandos.numeroDaFazendo+1, "Colhendo");
					Thread.sleep(3000-(Comandos.evolucoesPrefeitura.getAldeao()*10));//Reduz o tempo de transporte
					int comida = Integer.parseInt(Principal.lblComida.getText());
					comida = comida+(Comandos.Aldeoes.size()*(Comandos.evolucoesPrefeitura.getAldeao()*10));//Aumenta a produtividade
					Mostrar.mostrarComida(comida);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				Mostrar.mostrarAldeao(Comandos.comandoAldeaoCultivarFazenda+1, "Pronto");
				Mostrar.mostrarFazenda(Comandos.numeroDaFazendo+1, "Parado");
				continuar = false;
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
