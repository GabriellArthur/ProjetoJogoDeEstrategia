package evolucoes;

public class EvolucoesTemplo {
	int Garfanhoto;
	int Primogenitos;
	int chuvaPedras;
	int protecaoGarfanhoto;
	int protecaoPrimogenitos;
	int protecaoChuvaPedras;
	
	public EvolucoesTemplo(){
		this.Garfanhoto=0;
		this.Primogenitos=0;
		this.chuvaPedras=0;
		this.protecaoGarfanhoto=0;
		this.protecaoPrimogenitos=0;
		this.protecaoChuvaPedras=0;
	}
	
	public void evolucaoGarfanhoto() {
		this.Garfanhoto++;
	}
	public void evolucaoPrimogenitos() {
		this.Primogenitos++;
	}
	public void evolucaoChuvaPedras() {
		this.chuvaPedras++;
	}
	public void evolucaoProtecaoGarfanhoto() {
		this.protecaoGarfanhoto++;
	}
	public void evolucaoProtecaoPrimogenitos() {
		this.protecaoPrimogenitos++;
	}
	public void evolucaoProtecaoChuvaPedras() {
		this.protecaoChuvaPedras++;
	}
}
