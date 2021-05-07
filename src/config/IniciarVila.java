package config;

import java.awt.Color;
import java.util.ArrayList;

import main.Mostrar;
//O jogo inicia com uma vila criada contendo
public class IniciarVila {
	public static int indexPartida;
	public static void iniciarVila() {
		//-------------------------------------//
		for (int i = 1; i <= 5; i++) {
			Mostrar.adicionarAldeao(""+i, "Pronto"); //5 alde�es
		}
		Mostrar.adicionarFazenda("1", "Disponivel"); //1 Fazenda
		Mostrar.adicionarMinaOuro("1", "Disponivel");//1 Mina
		Mostrar.mostrarComida(15000);//150 Comida
		Mostrar.mostrarOuro(50000);//500 Ouro
		Mostrar.mostrarPrefeitura("Prefeitura", Color.ORANGE);
		Mostrar.desabilitarhabilitarTemplo();//Habilitado assim que � construido e inicia com 0 de f�
		Mostrar.habilitarMaravilha();// 0 maravilha
		
		ArrayList<String> evolucoes = new ArrayList<String>();
		evolucoes.add("NUVEM_GAFANHOTOS");
		evolucoes.add("MORTE_PRIMOGENITOS");
		evolucoes.add("CHUVA_PEDRAS"); 
		Mostrar.mostrarAtaques(evolucoes);
		
		Mostrar.habilitarOpcoesEvolucao("Todos");
	}
	
}
