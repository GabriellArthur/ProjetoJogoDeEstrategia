package main;

import uteis.View;

/*
Custo: 100.000 tijolos (pago tijolo a tijolo). Cada tijolo custa comida=1 + ouro=1
Função: Ganhar o jogo
Necessidade de construtores: ilimitados aldeões construtores simultâneos
Tempo de construção: Indefinido
Produção por construtor: 1 tijolo a cada 10 horas
 */
public class Maravilha implements Runnable{
	private int custo;
	
	Maravilha(){
		custo = 10000;
	}
	
	@Override
	public void run() {
		boolean continuar = true;
		while(continuar) {
			if(Comandos.Aldeoes.contains(Comandos.comandoAldeaoConstruirMaravilha)) {
				if(Integer.parseInt(Principal.lblComida.getText())>=1) {
					if(Integer.parseInt(Principal.lblOuro.getText())>=1) {
						if(Principal.tijolos != custo) {
							try {
								int comida = Integer.parseInt(Principal.lblComida.getText());
								int ouro = Integer.parseInt(Principal.lblOuro.getText());
								Mostrar.mostrarComida(comida-1);
								Mostrar.mostrarOuro(ouro-1);
								Thread.sleep(3000);
								Principal.tijolos ++;
								Mostrar.mostrarMaravilha(Principal.tijolos);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}else {
							Mostrar.mostrarAldeao(Comandos.comandoAldeaoConstruirMaravilha+1, "Pronto");
							View.exibirMensagem(Principal.lblJogador.getName()+" Venceu");
							continuar = false;
						}
					}
				}
			}else {
				Mostrar.mostrarAldeao(Comandos.comandoAldeaoConstruirMaravilha+1, "Pronto");
			}
		}
		
	}
}
