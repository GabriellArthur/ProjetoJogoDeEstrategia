package uteis;

import javax.swing.JOptionPane;

public class View {
	
	public static void exibirMensagem(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public static void exibirMensagemErro(String titulo, String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
	}

	public static String civilizacao() {
		Object[] itens = { "Acádia", "Babilônia", "Helenística", "Mesopotâmica", "Persa", "Suméria" };
		Object selectedValue = JOptionPane.showInputDialog(null, "Escolha sua civilização", "Jogador", JOptionPane.INFORMATION_MESSAGE, null,
				itens, itens[0]);
		return selectedValue.toString();
	}
	
	public static String inserirNome() {
		String retorno = JOptionPane.showInputDialog(null, "Informe seu nome", "Jogador", JOptionPane.QUESTION_MESSAGE);
		return retorno;
	}
}
