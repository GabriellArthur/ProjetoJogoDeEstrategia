package main;

import config.Tempo;

/*
Templo
Custo: comida=2.000 + ouro=2.000 (pr�-pago)
Necessidade de construtores: 1
Tempo de constru��o: 100 horas
Capacidade: ilimitados alde�es religiosos simult�neos

Fun��o 1: produ��o de oferendas de f�
Produ��o por religioso na fun��o 1: 2 unidades a cada 5 horas

Fun��o 2: sacrificar alde�o religioso
Produ��o por religioso na fun��o 2: 100 unidades de oferendas de f� imediatamente.
Observa��o: alde�o sacrificado � morto
*/
public class Templo implements Runnable{
	int tempoConstru��o; //100 horas

	Templo(){
		this.tempoConstru��o = 100;
	}
	
	@Override
	public void run() {
		if(Comandos.SwitchCriarTemplo==true) {
			this.criarTemplo();
		}
		if(Comandos.SwitchOrar==true) {
			this.orar();
		}
		if(Comandos.SwitchSacrificar==true) {
			this.sacrificar();
		}
	}
	
	public synchronized void criarTemplo() {
		Comandos.SwitchCriarTemplo = false;
		int aldeao = Comandos.comandoAldeaoConstruirTemplo+1;
		Mostrar.mostrarAldeao(aldeao, "Construindo Templo");
		try {
			Comandos.isTemplo = true;
			Thread.sleep(Tempo.tempoDeCriacaoDoTemplo);//10000
			Mostrar.mostrarOferendaFe(0);
			Mostrar.habilitarTemplo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Mostrar.mostrarAldeao(aldeao, "Pronto");
		Comandos.Aldeoes.remove(Comandos.Aldeoes.indexOf(Comandos.comandoAldeaoConstruirTemplo));
		
	}
	
	public synchronized void orar() {
		Comandos.SwitchOrar = false;
		boolean continuar = true;
		while(continuar) {
			if(Comandos.Aldeoes.contains(Comandos.comandoAldeaoOrar)) {
				try {
					Mostrar.mostrarAldeao(Comandos.comandoAldeaoOrar+1, "Orando");
					Thread.sleep(Tempo.tempoPadraoDeOrar);
					int fe = Integer.parseInt(Principal.lblOferenda.getText());
					fe = fe+(Comandos.Aldeoes.size()*2);
					Mostrar.mostrarOferendaFe(fe);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				Mostrar.mostrarAldeao(Comandos.comandoAldeaoOrar+1, "Pronto");
				continuar = false;	
			}
		}
	}
	
	public void sacrificar() {
		Comandos.SwitchSacrificar = false;
		
		int fe = Integer.parseInt(Principal.lblOferenda.getText());
		fe = fe+100;
		Mostrar.mostrarOferendaFe(fe);
		
		int aldeao = Comandos.comandoAldeaoSacrificar+1;
		Mostrar.mostrarAldeao(aldeao, "Sacrificado");
		
		for (Integer integer : Comandos.Aldeoes) {
			if(integer == Comandos.comandoAldeaoConstruirTemplo) {
				Comandos.Aldeoes.remove(integer);
			}
		}
	}
}
