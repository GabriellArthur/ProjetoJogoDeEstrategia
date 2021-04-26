package main;

import java.awt.Color;
//O jogo inicia com uma vila criada contendo
public class IniciarVila {
	public static void iniciarVila() {
		for (int i = 1; i <= 5; i++) {
			Mostrar.adicionarAldeao(""+i, "Pronto");
		}
		
		Mostrar.adicionarFazenda("1", "Fazenda");
		
		Mostrar.adicionarMinaOuro("1", "Mina");
		
		//Mostrar.mostrarComida(150);
		//Mostrar.mostrarOuro(500);
		
		//TESTE
		Mostrar.mostrarComida(500000);
		Mostrar.mostrarOuro(500000);
		//
		
		Mostrar.mostrarPrefeitura("Prefeitura", Color.ORANGE);
		
		Mostrar.desabilitarhabilitarTemplo();
		
		Mostrar.habilitarMaravilha();
		Mostrar.mostrarMaravilha(0);
		
		//Segunda parte
		/*
		List<String> evolucoes = new ArrayList<String>();
		evolucoes.add("NUVEM_GAFANHOTOS");
		evolucoes.add("MORTE_PRIMOGENITOS");
		evolucoes.add("CHUVA_PEDRAS"); 
		Mostrar.mostrarAtaques(evolucoes);
		*/
	}
}
