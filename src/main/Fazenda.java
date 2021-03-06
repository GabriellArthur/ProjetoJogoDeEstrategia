package main;

import config.Tempo;

/*
 * Custo: 100 Comida e 500 ouro
 * Fun??o: Produ??o de comida
 * Necessidade de construtores: 1
 * Tempo de constru??o: 30h
 * Capacidade: 5 alde?es
 * Produ??o por fazendeiro: 10 unidade a cada 1h + 2h para transporte at? a prefeitura
 */


public class Fazenda implements Runnable {

	Fazenda(){
	}
	
	public synchronized void criarFazenda() {
		Comandos.SwitchCriarFazenda = false;
		int fazenda = Principal.tmFazendas.getRowCount()+1;//Pega a prox posi??o na lista de fazenda
		int aldeao = Comandos.comandoAldeaoConstruirFazenda+1; //Pega o aldeao 
		Mostrar.mostrarAldeao(aldeao, "Construindo Fazenda ["+fazenda+"]");
		Mostrar.adicionarFazenda(""+fazenda, "Tempo de cria??o[30s]");
		try {
			Thread.sleep(Tempo.tempoDeCriacaoDaFazenda);
			Mostrar.mostrarFazenda(fazenda, "Disponivel");
			Comandos.comandoAldeaoParar(Comandos.comandoAldeaoConstruirFazenda);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void cultivar() {
		Comandos.SwitchCultivar = false;
		boolean continuar = true;
		while(continuar) {
			if(Comandos.Aldeoes.contains(Comandos.comandoAldeaoCultivarFazenda)) {
				int tamanho = 0;
				for (int i = 1; i <= Principal.tmAldeoes.getRowCount(); i++) {
					if(Principal.tmAldeoes.getValueAt(i-1,1)=="Cultivando") {//Pega todos que est?o cultivando
						tamanho++;
					}
				}
				try {
					int comida = Integer.parseInt(Principal.lblComida.getText());
					Mostrar.mostrarFazenda(Comandos.numeroDaFazendo+1, "Colhendo");
					Thread.sleep(Tempo.tempoDeCriacaoDaFazenda-(Comandos.evolucoesPrefeitura.getAldeao()*10));//Reduz o tempo de transporte
					comida = comida+(tamanho*(Comandos.evolucoesPrefeitura.getAldeao()*10));//Aumenta a produtividade
					Mostrar.mostrarComida(comida);
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
		if(Comandos.SwitchCriarFazenda == true) {
			this.criarFazenda();
		}
		if(Comandos.SwitchCultivar==true) {
			this.cultivar();
		}
		
	}
}
