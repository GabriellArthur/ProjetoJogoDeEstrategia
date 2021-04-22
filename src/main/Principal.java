package main;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import uteis.View;

import java.awt.Toolkit;

public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblJogador;
	static JTable tblAldeoes;
	public static DefaultTableModel tmAldeoes;
	static JComboBox<String> cbFazenda;
	static JComboBox<String> cbMinaOuro;
	static JTable tblFazendas;
	static DefaultTableModel tmFazendas;
	static JTable tblMinasOuro;
	static DefaultTableModel tmMinasOuro;
	static JLabel lblComida;
	static JLabel lblOuro;
	static JTextField tfPrefeitura;
	static JPanel pnTemplo;
	static JPanel pnOferenda;
	static JLabel lblOferenda;
	static JTextField tfTemplo;
	static JComboBox<String> cbTEmploEvolucoes;
	static JButton btnTemploEvoluir;
	static JComboBox<String> cbTemploLancamentos;
	static JComboBox<String> cbTemploInimigo;
	static JButton btnTemploLancar;
	static JPanel pnMaravilha;
	static JLabel lblMaravilha;
	static JProgressBar pbMaravilha;
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Principal window = new Principal();
			window.setVisible(true);
		});
	}

	public Principal() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/icone.png")));
        initialize();
        IniciarVila.iniciarVila();
		try {
			//String nome = View.inserirNome();
			//String civilizacao = View.civilizacao();
	        //Principal.lblJogador.setText(nome +" - "+ civilizacao);
			this.lblJogador.setText("A" +" - "+ "TEST");
		} catch (Exception e) {
			View.exibirMensagem(e.getMessage());
		}
		

	}

	@SuppressWarnings("serial")
	private void initialize() {
		this.setTitle("Jogo de Estratégia em Tempo Real");
		this.setResizable(false);
		this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		this.setBounds(50, 50, 886, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		//*** Configuracoes **************************************************

		DefaultTableCellRenderer dtcrCentralizado = new DefaultTableCellRenderer();
		dtcrCentralizado.setHorizontalAlignment(SwingConstants.CENTER);

		DefaultTableCellRenderer dtcrAldeaoAcao = new DefaultTableCellRenderer() {
			public void setValue(Object valor) {
				String v=valor.toString();
				switch (v) {							//Status do Aldeao e sua respetiva cor
					case "Pronto":
						setBackground(Color.WHITE);
						break;
					case "orando":
						setBackground(new Color(135, 206, 235));
						break;
					case "sacrificado":
						setBackground(Color.RED);
						break;
					case "Cultivando":
						setBackground(Color.GREEN);
						break;
					case "Minerando":
						setBackground(Color.YELLOW);
						break;
					case "Construindo":
						setBackground(Color.LIGHT_GRAY);
						break;
					default:
						setBackground(Color.BLACK);
						break;
				}
				super.setValue(valor);
			}
		};

		//*** Componentes ****************************************************

		JTabbedPane tpJogo = new JTabbedPane(JTabbedPane.TOP);
		tpJogo.setBounds(10, 10, 850, 665);
		this.getContentPane().add(tpJogo);

		JPanel pnTP_Inicio = new JPanel();
		pnTP_Inicio.setLayout(null);
		tpJogo.addTab("Início", null, pnTP_Inicio, null);

		JPanel pnJogador = new JPanel();
		pnJogador.setBorder(new TitledBorder(null, "Jogador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnJogador.setBounds(10, 10, 250, 51);
		pnTP_Inicio.add(pnJogador);

		lblJogador = new JLabel("Jogador");
		lblJogador.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnJogador.add(lblJogador);

		JPanel pnTP_Vila = new JPanel();
		pnTP_Vila.setLayout(null);
		tpJogo.addTab("Vila", null, pnTP_Vila, null);

		JPanel pnAldeao = new JPanel();
		pnAldeao.setLayout(null);
		pnAldeao.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Alde\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnAldeao.setBounds(10, 10, 270, 620);
		pnTP_Vila.add(pnAldeao);

		String[] colunasAldeoes = {"nó", "Ação"};
		Principal.tmAldeoes = (
			new DefaultTableModel(null, colunasAldeoes){
				public boolean isCellEditable(int row, int column){
					return false;
				}
			}
		);

		Principal.tblAldeoes = new JTable(Principal.tmAldeoes);
		Principal.tblAldeoes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Principal.tblAldeoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Principal.tblAldeoes.getColumn("Ação").setCellRenderer(dtcrAldeaoAcao);
		Principal.tblAldeoes.getColumnModel().getColumn(0).setResizable(false);
		Principal.tblAldeoes.getColumnModel().getColumn(0).setCellRenderer(dtcrCentralizado);
		Principal.tblAldeoes.getColumnModel().getColumn(0).setPreferredWidth(30);
		Principal.tblAldeoes.getColumnModel().getColumn(1).setResizable(false);
		Principal.tblAldeoes.getColumnModel().getColumn(1).setPreferredWidth(202);

		JScrollPane spAldeoes = new JScrollPane(Principal.tblAldeoes);
		spAldeoes.setBounds(10, 20, 250, 460);
		spAldeoes.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnAldeao.add(spAldeoes);

		JButton btnAldeaoParar = new JButton("Parar");
		btnAldeaoParar.setBounds(10, 485, 120, 21);
		pnAldeao.add(btnAldeaoParar);

		JButton btnAldeaoConstruir = new JButton("Construir");
		btnAldeaoConstruir.setBounds(10, 510, 120, 21);
		pnAldeao.add(btnAldeaoConstruir);

		JComboBox<String> cbConstruir = new JComboBox<String>();
		cbConstruir.setBounds(140, 510, 119, 21);
		cbConstruir.addItem("Fazenda");
		cbConstruir.addItem("Mina de ouro");
		cbConstruir.addItem("Templo");
		cbConstruir.addItem("Maravilha");
		pnAldeao.add(cbConstruir);

		JButton btnAldeaoCultivar = new JButton("Cultivar");
		btnAldeaoCultivar.setBounds(10, 535, 120, 21);
		pnAldeao.add(btnAldeaoCultivar);

		Principal.cbFazenda = new JComboBox<String>();
		cbFazenda.setBounds(140, 535, 119, 21);
		pnAldeao.add(cbFazenda);

		JButton btnAldeaoMinerar = new JButton("Minerar");
		btnAldeaoMinerar.setBounds(10, 560, 120, 21);
		pnAldeao.add(btnAldeaoMinerar);

		Principal.cbMinaOuro = new JComboBox<String>();
		cbMinaOuro.setBounds(140, 560, 119, 21);
		pnAldeao.add(cbMinaOuro);

		JButton btnAldeaoOrar = new JButton("Orar");
		btnAldeaoOrar.setBounds(10, 585, 120, 21);
		pnAldeao.add(btnAldeaoOrar);

		JButton btnAldeaoSacrificar = new JButton("Sacrificar");
		btnAldeaoSacrificar.setBounds(140, 585, 120, 21);
		pnAldeao.add(btnAldeaoSacrificar);

		JPanel pnFazenda = new JPanel();
		pnFazenda.setLayout(null);
		pnFazenda.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Fazendas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnFazenda.setBounds(290, 10, 270, 305);
		pnTP_Vila.add(pnFazenda);

		String[] colunasFazendas = {"nó", "Fazenda"};
		Principal.tmFazendas = (new DefaultTableModel(null, colunasFazendas){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		});

		Principal.tblFazendas = new JTable(Principal.tmFazendas);
		Principal.tblFazendas.setRowSelectionAllowed(false);
		Principal.tblFazendas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Principal.tblFazendas.getColumnModel().getColumn(0).setResizable(false);
		Principal.tblFazendas.getColumnModel().getColumn(0).setCellRenderer(dtcrCentralizado);
		Principal.tblFazendas.getColumnModel().getColumn(0).setPreferredWidth(30);
		Principal.tblFazendas.getColumnModel().getColumn(1).setResizable(false);
		Principal.tblFazendas.getColumnModel().getColumn(1).setPreferredWidth(202);

		JScrollPane spFazendas = new JScrollPane(Principal.tblFazendas);
		spFazendas.setBounds(10, 20, 250, 275);
		spFazendas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnFazenda.add(spFazendas);

		JPanel pnMinaOuro = new JPanel();
		pnMinaOuro.setLayout(null);
		pnMinaOuro.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Minas de ouro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnMinaOuro.setBounds(290, 325, 270, 305);
		pnTP_Vila.add(pnMinaOuro);

		String[] colunasMinas = {"nó", "Mina"};
		Principal.tmMinasOuro = (new DefaultTableModel(null, colunasMinas){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		});		

		Principal.tblMinasOuro = new JTable(Principal.tmMinasOuro);
		Principal.tblMinasOuro.setRowSelectionAllowed(false);
		Principal.tblMinasOuro.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		Principal.tblMinasOuro.getColumnModel().getColumn(0).setResizable(false);
		Principal.tblMinasOuro.getColumnModel().getColumn(0).setCellRenderer(dtcrCentralizado);
		Principal.tblMinasOuro.getColumnModel().getColumn(0).setPreferredWidth(30);
		Principal.tblMinasOuro.getColumnModel().getColumn(1).setResizable(false);
		Principal.tblMinasOuro.getColumnModel().getColumn(1).setPreferredWidth(202);

		JScrollPane spMinas = new JScrollPane(Principal.tblMinasOuro);
		spMinas.setBounds(10, 20, 250, 275);
		spMinas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnMinaOuro.add(spMinas);

		JPanel pnPrefeitura = new JPanel();
		pnPrefeitura.setLayout(null);
		pnPrefeitura.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Prefeitura", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnPrefeitura.setBounds(570, 10, 270, 175);
		pnTP_Vila.add(pnPrefeitura);

		JPanel pnComida = new JPanel();
		((FlowLayout) pnComida.getLayout()).setAlignment(FlowLayout.LEFT);
		pnComida.setBorder(new TitledBorder(null, "Comida", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnComida.setBounds(8, 15, 127, 45);
		pnPrefeitura.add(pnComida);

		Principal.lblComida = new JLabel("0");
		Principal.lblComida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnComida.add(Principal.lblComida);

		JPanel pnOuro = new JPanel();
		((FlowLayout) pnOuro.getLayout()).setAlignment(FlowLayout.LEFT);
		pnOuro.setBorder(new TitledBorder(null, "Ouro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnOuro.setBounds(135, 15, 128, 45);
		pnPrefeitura.add(pnOuro);

		Principal.lblOuro = new JLabel("0");
		Principal.lblOuro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnOuro.add(Principal.lblOuro);

		Principal.tfPrefeitura = new JTextField();
		tfPrefeitura.setBounds(10, 65, 250, 20);
		Principal.tfPrefeitura.setEditable(false);
		pnPrefeitura.add(tfPrefeitura);

		JButton btnPrefeituraCriarAldeao = new JButton("Criar aldeão");
		btnPrefeituraCriarAldeao.setBounds(10, 90, 128, 21);
		pnPrefeitura.add(btnPrefeituraCriarAldeao);

		JComboBox<String> cbPrefeituraEvolucoes = new JComboBox<String>();
		cbPrefeituraEvolucoes.setBounds(10, 115, 248, 21);
		cbPrefeituraEvolucoes.addItem("Evolução de aldeão");
		cbPrefeituraEvolucoes.addItem("Evolução de fazenda");
		cbPrefeituraEvolucoes.addItem("Evolução de mina de ouro");
		pnPrefeitura.add(cbPrefeituraEvolucoes);

		JButton btnPrefeituraEvoluir = new JButton("Evoluir");
		btnPrefeituraEvoluir.setBounds(131, 140, 128, 21);
		pnPrefeitura.add(btnPrefeituraEvoluir);

		Principal.pnTemplo = new JPanel();
		Principal.pnTemplo.setLayout(null);
		Principal.pnTemplo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Templo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Principal.pnTemplo.setBounds(570, 195, 270, 225);
		Principal.pnTemplo.setEnabled(false);
		pnTP_Vila.add(Principal.pnTemplo);

		Principal.pnOferenda = new JPanel();
		((FlowLayout) Principal.pnOferenda.getLayout()).setAlignment(FlowLayout.LEFT);
		Principal.pnOferenda.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Oferendas de fã", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Principal.pnOferenda.setBounds(8, 15, 255, 45);
		Principal.pnOferenda.setEnabled(false);
		Principal.pnTemplo.add(Principal.pnOferenda);

		Principal.lblOferenda = new JLabel("0");
		Principal.lblOferenda.setHorizontalAlignment(SwingConstants.LEFT);
		Principal.lblOferenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Principal.lblOferenda.setEnabled(false);
		Principal.pnOferenda.add(Principal.lblOferenda);

		Principal.tfTemplo = new JTextField();
		Principal.tfTemplo.setEditable(false);
		Principal.tfTemplo.setBounds(10, 65, 250, 20);
		Principal.pnTemplo.add(Principal.tfTemplo);

		Principal.cbTEmploEvolucoes = new JComboBox<String>();
		Principal.cbTEmploEvolucoes.setBounds(10, 90, 248, 21);
		Principal.cbTEmploEvolucoes.addItem("Nuvem de gafanhotos");
		Principal.cbTEmploEvolucoes.addItem("Morte dos primogénitos");
		Principal.cbTEmploEvolucoes.addItem("Chuva de pedras");
		Principal.cbTEmploEvolucoes.addItem("Proteção contra nuvem de gafanhotos");
		Principal.cbTEmploEvolucoes.addItem("Proteção contra morte dos primogénitos");
		Principal.cbTEmploEvolucoes.addItem("Proteção contra chuva de pedras");
		Principal.cbTEmploEvolucoes.setEnabled(false);
		Principal.pnTemplo.add(Principal.cbTEmploEvolucoes);

		Principal.btnTemploEvoluir = new JButton("Evoluir");
		Principal.btnTemploEvoluir.setBounds(131, 115, 128, 21);
		Principal.btnTemploEvoluir.setEnabled(false);
		Principal.pnTemplo.add(Principal.btnTemploEvoluir);

		Principal.cbTemploLancamentos = new JComboBox<String>();
		Principal.cbTemploLancamentos.setBounds(10, 140, 248, 21);
		Principal.cbTemploLancamentos.setEnabled(false);
		Principal.pnTemplo.add(Principal.cbTemploLancamentos);

		Principal.cbTemploInimigo = new JComboBox<String>();
		Principal.cbTemploInimigo.setEnabled(false);
		Principal.cbTemploInimigo.setBounds(10, 165, 248, 21);
		Principal.pnTemplo.add(Principal.cbTemploInimigo);

		Principal.btnTemploLancar = new JButton("Lançar");
		Principal.btnTemploLancar.setBounds(131, 190, 128, 21);
		Principal.btnTemploLancar.setEnabled(false);
		Principal.pnTemplo.add(Principal.btnTemploLancar);

		Principal.pnMaravilha = new JPanel();
		Principal.pnMaravilha.setLayout(null);
		Principal.pnMaravilha.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Maravilha", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Principal.pnMaravilha.setBounds(570, 430, 270, 200);
		Principal.pnMaravilha.setEnabled(false);
		pnTP_Vila.add(Principal.pnMaravilha);

		Principal.lblMaravilha = new JLabel();
		Principal.lblMaravilha.setBounds(10, 20, 215, 170);
		Principal.lblMaravilha.setIcon(new ImageIcon(Principal.class.getResource("/img/maravilha.png")));
		Principal.lblMaravilha.setEnabled(false);
		Principal.pnMaravilha.add(Principal.lblMaravilha);

		Principal.pbMaravilha = new JProgressBar();
		Principal.pbMaravilha.setOrientation(SwingConstants.VERTICAL);
		Principal.pbMaravilha.setBounds(225, 20, 30, 170);
		Principal.pbMaravilha.setMaximum(100000);
		Principal.pbMaravilha.setStringPainted(true);
		Principal.pbMaravilha.setEnabled(false);
		Principal.pnMaravilha.add(pbMaravilha);

		tpJogo.setSelectedIndex(1);

		//*** Eventos ********************************************************

		btnAldeaoParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comandos.comandoAldeaoParar(tblAldeoes.getSelectedRow());
			}
		});

		btnAldeaoConstruir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comandos.comandoAldeaoConstruir(tblAldeoes.getSelectedRow(), cbConstruir.getSelectedItem().toString());
			}
		});

		btnAldeaoCultivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comandos.comandoAldeaoCultivar(tblAldeoes.getSelectedRow(), cbFazenda.getSelectedIndex());
			}
		});

		btnAldeaoMinerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comandos.comandoAldeaoMinerar(tblAldeoes.getSelectedRow(), cbMinaOuro.getSelectedIndex());
			}
		});

		btnAldeaoOrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comandos.comandoAldeaoOrar(tblAldeoes.getSelectedRow());
			}
		});

		btnAldeaoSacrificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comandos.comandoAldeaoSacrificar(tblAldeoes.getSelectedRow());
			}
		});

		btnPrefeituraCriarAldeao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comandos.comandoPrefeituraCriarAldeao();				
			}
		});

		btnPrefeituraEvoluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comandos.comandoPrefeituraEvoluir(cbPrefeituraEvolucoes.getSelectedItem().toString());
			}
		});

		btnTemploEvoluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comandos.comandoTemploEvoluir(cbTEmploEvolucoes.getSelectedItem().toString());
			}
		});

		btnTemploLancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comandos.comandoTemploLancar();
			}
		});

	}

	
}