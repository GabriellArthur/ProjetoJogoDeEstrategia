package main;

import java.awt.Color;
//O jogo inicia com uma vila criada contendo
public class IniciarVila {
	public static void iniciarVila() {
		for (int i = 1; i <= 5; i++) {
			Mostrar.adicionarAldeao(""+i, "Pronto");
		}
		
		Mostrar.adicionarFazenda("1", "Disponivel");
		
		Mostrar.adicionarMinaOuro("1", "Disponivel");
		
		Mostrar.mostrarComida(15000);
		Mostrar.mostrarOuro(50000);
		
		
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
