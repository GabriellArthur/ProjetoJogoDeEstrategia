package main;

import java.io.IOException;

import config.Tempo;

/*
Custo: 100.000 tijolos (pago tijolo a tijolo). Cada tijolo custa comida=1 + ouro=1
Fun??o: Ganhar o jogo
Necessidade de construtores: ilimitados alde?es construtores simult?neos
Tempo de constru??o: Indefinido
Produ??o por construtor: 1 tijolo a cada 10 horas
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
			if(Comandos.Aldeoes.contains(Comandos.comandoAldeaoConstruirMaravilha)) { //Fica construindo sempre que tiver comida e ouro, caso n tenha ele n reclamar?
				if(Integer.parseInt(Principal.lblComida.getText())>=1) {
					if(Integer.parseInt(Principal.lblOuro.getText())>=1) {
						if(Principal.tijolos != custo) {
							try {
								int comida = Integer.parseInt(Principal.lblComida.getText());
								int ouro = Integer.parseInt(Principal.lblOuro.getText());
								Mostrar.mostrarComida(comida-1);
								Mostrar.mostrarOuro(ouro-1);
								Thread.sleep(Tempo.tempoDeContrucaoDeTijolosNaMaravilha);
								Principal.tijolos ++;
								if(Principal.tijolos >= 10000){
									try {
										Comandos.app.enviarMensagem(Principal.pnNomeUsuario.getText()+" Ganhouuuuuuuuuuuu......");
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
								Mostrar.mostrarMaravilha(Principal.tijolos);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}else {
							Mostrar.mostrarAldeao(Comandos.comandoAldeaoConstruirMaravilha+1, "Pronto");
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
