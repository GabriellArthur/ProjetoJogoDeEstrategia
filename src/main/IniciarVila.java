package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
//O jogo inicia com uma vila criada contendo
public class IniciarVila {
	public static void iniciarVila() {
		for (int i = 0; i < 5; i++) {
			Mostrar.adicionarAldeao(""+i, "Pronto");
		}
		
		
		Mostrar.adicionarFazenda("1", "Fazenda");
		Mostrar.mostrarFazenda(1, "Fazenda");
		
		Mostrar.mostrarComida(150);
		Mostrar.mostrarOuro(100);
		
		Mostrar.adicionarMinaOuro("1", "Mina");
		Mostrar.mostrarMinaOuro(1, "Mina");
		
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
