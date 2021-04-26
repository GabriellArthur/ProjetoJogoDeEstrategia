package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
//O jogo inicia com uma vila criada contendo
public class IniciarVila {
	public static void iniciarVila() {
		for (int i = 1; i <= 5; i++) {
			Mostrar.adicionarAldeao(""+i, "Pronto");
		}
		
		Mostrar.adicionarFazenda("1", "Fazenda");
		//Mostrar.mostrarFazenda(1, "Fazenda");
		
		Mostrar.adicionarMinaOuro("1", "Mina");
		//Mostrar.mostrarMinaOuro(1, "Mina");
		
		//Mostrar.mostrarComida(150);
		//Mostrar.mostrarOuro(500);
		
		//TESTE
		Mostrar.mostrarComida(500000);
		Mostrar.mostrarOuro(500000);
		
		Mostrar.mostrarOferendaFe(0);
		Mostrar.mostrarPrefeitura("Prefeitura", Color.ORANGE);
		
		Mostrar.habilitarTemplo();
		Mostrar.mostrarTemplo("Templo", Color.MAGENTA);
		
		Mostrar.habilitarMaravilha();
		Mostrar.mostrarMaravilha(0);
		
		List<String> evolucoes = new ArrayList<String>();
		evolucoes.add("NUVEM_GAFANHOTOS");
		evolucoes.add("MORTE_PRIMOGENITOS");
		evolucoes.add("CHUVA_PEDRAS"); 
		Mostrar.mostrarAtaques(evolucoes);
	}
}
