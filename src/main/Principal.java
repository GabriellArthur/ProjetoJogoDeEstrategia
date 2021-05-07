package main;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

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
import javax.swing.JTextArea;
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
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.TextField;
import javax.swing.JRadioButton;

public class Principal extends JFrame {
	private static final long serialVersionUID = 1L;
	public static ArrayList<BufferedWriter>clientes;
	public static ServerSocket server;
	public static JTextPane pnPorta;
	public static JComboBox<String> pnCivilizacoes;
	public static JTextPane pnNomeUsuario;
	static String status;
	public static JTextArea texto;
	public static JTextArea textoVila;
	public static JTextField txtMsg;
	public static JTextField lbl_Ip;
	public static JButton btnIniciarJogo;
	public static JButton btnCriarJogo;
	public static JButton btnEncerrarJogo;
	public static JRadioButton rdbtnCriarJogo;
	public static JRadioButton rdbtnConectarJogo;
	public static JButton btnConectar;
	public static JButton btnDesconectar;
	public static JTabbedPane tpJogo;
	//Jogos
	static JTable tblJogos;
	public static DefaultTableModel tmJogos;
	//Aldeao
	static JTable tblAldeoes;
	public static DefaultTableModel tmAldeoes;
	static JButton btnAldeaoParar;
	static JButton btnAldeaoConstruir;
	static JButton btnAldeaoCultivar;
	static JButton btnAldeaoMinerar;
	static JButton btnAldeaoOrar;
	static JButton btnAldeaoSacrificar;
	//Fazenda
	static JComboBox<String> cbFazenda;
	public static JTable tblFazendas;
	static DefaultTableModel tmFazendas;
	//Mina de Ouro
	static JComboBox<String> cbMinaOuro;
	public static JTable tblMinasOuro;
	static DefaultTableModel tmMinasOuro;
	//Prefeitura
	static String acaoPrefeitura;
	static JTextField tfPrefeitura;
	public static int aldeao;
	public static int fazenda;
	public static int mina;
	public static JProgressBar lvlAldeao;
	public static JProgressBar lvlFazenda;
	public static JProgressBar lvlMina;
	static JLabel lblAldeao;
	static JLabel lblFazenda;
	static JLabel lblMina;
	static JProgressBar tfPrefeituraBar;
	public static JLabel lblComida;
	public static JLabel lblOuro;
	static JButton btnPrefeituraCriarAldeao;
	static JButton btnPrefeituraEvoluir;
	//Templo
		//ATK
	public static int Garfanhoto;
	public static int Primogenitos;
	public static int chuvaPedras;
	public static JProgressBar lvlGarfanhoto;
	public static JProgressBar lvlPrimogenitos;
	public static JProgressBar lvlchuvaPedras;
	static JLabel lblGarfanhoto;
	static JLabel lblPrimogenitos;
	static JLabel lblChuvaPedras;
		//Defesa
	public static int protecaoGarfanhoto;
	public static int protecaoPrimogenitos;
	public static int protecaoChuvaPedras;
	public static JProgressBar lvlprotecaoGarfanhoto;
	public static JProgressBar lvlprotecaoPrimogenitos;
	public static JProgressBar lvlprotecaoChuvaPedras;
	static JLabel lblprotecaoGarfanhoto;
	static JLabel lblprotecaoPrimogenitos;
	static JLabel lblprotecaoChuvaPedras;
	//
	static JProgressBar tfTemploBar;
	static JPanel pnTemplo;
	static JPanel pnOferenda;
	public static JLabel lblOferenda;
	static JTextField tfTemplo;
	static JComboBox<String> cbTEmploEvolucoes;
	static JButton btnTemploEvoluir;
	public static JComboBox<String> cbTemploLancamentos;
	public static JComboBox<String> cbTemploInimigo;
	static JButton btnTemploLancar;
	//Maravilha
	public static int tijolos;
	static JPanel pnMaravilha;
	static JLabel lblMaravilha;
	static JProgressBar pbMaravilha;
	private static JTextField lbl_portaConectar;
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Principal window = new Principal();
			window.setVisible(true);
		});
	}

	public Principal() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/icone.png")));
        initialize();
        Mostrar.desabilitarOpcoesEvolucao("Todos");

	}

	@SuppressWarnings("serial")
	private void initialize() {
		this.setTitle("Jogo de Estratégia em Tempo Real");
		this.setResizable(false);
		this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		this.setBounds(50, 50, 886, 862);
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
					case "Orando":
						setBackground(new Color(135, 206, 235));
						break;
					case "Evoluindo":
						setBackground(Color.GREEN);
						break;
					case "Sacrificado":
						setBackground(Color.RED);
						break;
					case "Morto":
						setBackground(Color.RED);
						break;
					case "Cultivando":
						setBackground(Color.GREEN);
						break;
					case "Minerando":
						setBackground(Color.YELLOW);
						break;
					default:
						setBackground(Color.LIGHT_GRAY); //Construindo
						break;
				}
				super.setValue(valor);
			}
		};
		
		DefaultTableCellRenderer dtcrVilaAcao = new DefaultTableCellRenderer() {
			public void setValue(Object valor) {
				String v=valor.toString();
				switch (v) {							
					case "Disponivel":
						setBackground(Color.GREEN);
						break;
					case "Colhendo":
						setBackground(Color.green);
						break;
					case "Minerando":
						setBackground(Color.YELLOW);
						break;
					case "Destruida":
						setBackground(Color.RED);
						break;
					default:
						setBackground(Color.LIGHT_GRAY); 
						break;
				}
				super.setValue(valor);
			}
		};
		
		DefaultTableCellRenderer dtcrSitaucaoJogo = new DefaultTableCellRenderer() {
			public void setValue(Object valor) {
				String v=valor.toString();
				switch (v) {							
					case "Online":
						setBackground(Color.GREEN);
						break;
					default:
						setBackground(Color.LIGHT_GRAY); 
						break;
				}
				super.setValue(valor);
			}
		};

		//*** Componentes ****************************************************
		//TELA TE INICIO
		Principal.tpJogo = new JTabbedPane(JTabbedPane.TOP);
		tpJogo.setBounds(10, 10, 850, 793);
		this.getContentPane().add(tpJogo);

		JPanel pnTP_Inicio = new JPanel();
		pnTP_Inicio.setLayout(null);
		tpJogo.addTab("Início", null, pnTP_Inicio, null);

		JPanel pnNome = new JPanel();
		pnNome.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nome", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnNome.setBounds(10, 10, 250, 51);
		pnTP_Inicio.add(pnNome);
		pnNome.setLayout(null);
		
		Principal.pnNomeUsuario = new JTextPane();
		pnNomeUsuario.setBounds(10, 21, 230, 20);
		pnNome.add(pnNomeUsuario);
		
		JPanel pnCivilizacao = new JPanel();
		pnCivilizacao.setBorder(new TitledBorder(null, "Civiliza\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnCivilizacao.setBounds(270, 10, 250, 51);
		pnTP_Inicio.add(pnCivilizacao);
		pnCivilizacao.setLayout(null);
		
		Principal.pnCivilizacoes = new JComboBox<String>();
		pnCivilizacoes.setBounds(10, 21, 230, 22);
		pnCivilizacoes.addItem("Acádia");
		pnCivilizacoes.addItem("Babilônia");
		pnCivilizacoes.addItem("Helenística");
		pnCivilizacoes.addItem("Mesopotâmica");
		pnCivilizacoes.addItem("Persa");
		pnCivilizacoes.addItem("Suméria");
		pnCivilizacao.add(pnCivilizacoes);
		
		JPanel pnCriarJogo = new JPanel();
		pnCriarJogo.setBorder(new TitledBorder(UIManager.getBorder("CheckBoxMenuItem.border"), "Criar Jogo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnCriarJogo.setToolTipText("");
		pnCriarJogo.setBounds(10, 72, 825, 274);
		pnTP_Inicio.add(pnCriarJogo);
		
		Principal.rdbtnCriarJogo = new JRadioButton("Criar Jogo");
		rdbtnCriarJogo.setSelected(true);
		rdbtnCriarJogo.setBounds(0, 0, 109, 23);
		pnCriarJogo.add(rdbtnCriarJogo);
		
		String[]colunasJogos = {"Jogador","Civilização","IP","Situação"};
		Principal.tmJogos = (
			new DefaultTableModel(null,colunasJogos) {
				public boolean isCellEditable(int row,int column) {
					return false;
				}
			}
		);
		
		Principal.tblJogos = new JTable(Principal.tmJogos);
		Principal.tblJogos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		Principal.tblJogos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Principal.tblJogos.getColumn("Situação").setCellRenderer(dtcrSitaucaoJogo);
		Principal.tblJogos.getColumnModel().getColumn(0).setResizable(false);
		Principal.tblJogos.getColumnModel().getColumn(0).setCellRenderer(dtcrCentralizado);
		Principal.tblJogos.getColumnModel().getColumn(0).setPreferredWidth(50);
		Principal.tblJogos.getColumnModel().getColumn(1).setResizable(false);
		Principal.tblJogos.getColumnModel().getColumn(1).setPreferredWidth(202);
		
		JScrollPane spJogos = new JScrollPane(Principal.tblJogos);
		spJogos.setBounds(10, 31, 805, 198);
		spJogos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnCriarJogo.add(spJogos);
		
		Principal.btnIniciarJogo = new JButton("Iniciar Jogo");
		btnIniciarJogo.setBounds(191, 240, 170, 23);
		
		Principal.btnCriarJogo = new JButton("Criar novo jogo");
		btnCriarJogo.setBounds(10, 240, 170, 23);
		
		Principal.btnEncerrarJogo = new JButton("Encerrar Jogo");
		btnEncerrarJogo.setBounds(371, 240, 170, 23);
		pnCriarJogo.setLayout(null);
		
		pnCriarJogo.add(btnIniciarJogo);
		pnCriarJogo.add(btnCriarJogo);
		pnCriarJogo.add(btnEncerrarJogo);
		//Conectar a um Jogo
		JPanel pnConectarJogo = new JPanel();
		pnConectarJogo.setBorder(new TitledBorder(UIManager.getBorder("CheckBoxMenuItem.border"), "Conectar a um Jogo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnConectarJogo.setBounds(10, 357, 825, 72);
		pnTP_Inicio.add(pnConectarJogo);
		pnConectarJogo.setLayout(null);
		
		Principal.rdbtnConectarJogo = new JRadioButton("Conectar a um Jogo");
		rdbtnConectarJogo.setBounds(0, 0, 143, 23);
		pnConectarJogo.add(rdbtnConectarJogo);
		
		JPanel pnDigitarIp = new JPanel();
		pnDigitarIp.setBorder(new TitledBorder(null, "IP do computador que criou o jogo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDigitarIp.setBounds(0, 24, 389, 44);
		pnConectarJogo.add(pnDigitarIp);
		pnDigitarIp.setLayout(null);
		
		lbl_Ip = new JTextField("127.0.0.1"); //Ip
		lbl_Ip.setBounds(2, 21, 384, 25);
		pnDigitarIp.add(lbl_Ip);
		lbl_Ip.setColumns(10);
		
		Principal.btnConectar = new JButton("Conectar");
		btnConectar.setBounds(575, 42, 115, 23);
		pnConectarJogo.add(btnConectar);
		
		Principal.btnDesconectar = new JButton("Desconectar");
		btnDesconectar.setBounds(700, 42, 115, 23);
		pnConectarJogo.add(btnDesconectar);
		
		JPanel pnPortaConectar = new JPanel();
		pnPortaConectar.setBorder(new TitledBorder(null, "Porta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnPortaConectar.setBounds(391, 24, 174, 44);
		pnConectarJogo.add(pnPortaConectar);
		pnPortaConectar.setLayout(null);
		
		lbl_portaConectar = new JTextField();
		lbl_portaConectar.setBounds(2, 21, 170, 20);
		pnPortaConectar.add(lbl_portaConectar);
		lbl_portaConectar.setColumns(10);
		//MENSAGENS
		JPanel pnChatInicio = new JPanel();
		pnChatInicio.setBorder(new TitledBorder(null, "Mensagens", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnChatInicio.setBounds(10, 440, 825, 314);
		pnTP_Inicio.add(pnChatInicio);
		pnChatInicio.setLayout(null);
		
		texto = new JTextArea(10,20);
		texto.setEditable(false);
		texto.setBackground(new Color(240,240,240));
		
		JScrollPane scroll = new JScrollPane(texto);
		texto.setLineWrap(true);
		scroll.setBounds(10, 22, 805, 247);
		
		JButton btnSend = new JButton("Enviar");
		btnSend.setToolTipText("Enviar Mensagem");
		btnSend.setBounds(736, 280, 79, 23);
		
		txtMsg = new JTextField(20);
		txtMsg.setBounds(10, 280, 716, 23);
		
		pnChatInicio.add(scroll);
		pnChatInicio.add(btnSend);
		pnChatInicio.add(txtMsg);
		//--------------------------------------------//
		JPanel pnConexaoPorta = new JPanel();
		pnConexaoPorta.setBorder(new TitledBorder(null, "Porta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnConexaoPorta.setBounds(530, 11, 198, 50);
		pnTP_Inicio.add(pnConexaoPorta);
		pnConexaoPorta.setLayout(null);
		
		Principal.pnPorta = new JTextPane();
		pnPorta.setBounds(10, 21, 178, 20);
		pnConexaoPorta.add(pnPorta);
		//VILA
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

		Principal.btnAldeaoParar = new JButton("Parar");
		Principal.btnAldeaoParar.setBounds(10, 485, 120, 21);
		pnAldeao.add(btnAldeaoParar);

		Principal.btnAldeaoConstruir = new JButton("Construir");
		Principal.btnAldeaoConstruir.setBounds(10, 510, 120, 21);
		pnAldeao.add(btnAldeaoConstruir);

		JComboBox<String> cbConstruir = new JComboBox<String>();
		cbConstruir.setBounds(140, 510, 119, 21);
		cbConstruir.addItem("Fazenda");
		cbConstruir.addItem("Mina de ouro");
		cbConstruir.addItem("Templo");
		cbConstruir.addItem("Maravilha");
		pnAldeao.add(cbConstruir);

		Principal.btnAldeaoCultivar = new JButton("Cultivar");
		Principal.btnAldeaoCultivar.setBounds(10, 535, 120, 21);
		pnAldeao.add(btnAldeaoCultivar);

		Principal.cbFazenda = new JComboBox<String>();
		cbFazenda.setBounds(140, 535, 119, 21);
		pnAldeao.add(cbFazenda);

		Principal.btnAldeaoMinerar = new JButton("Minerar");
		Principal.btnAldeaoMinerar.setBounds(10, 560, 120, 21);
		pnAldeao.add(btnAldeaoMinerar);

		Principal.cbMinaOuro = new JComboBox<String>();
		cbMinaOuro.setBounds(140, 560, 119, 21);
		pnAldeao.add(cbMinaOuro);

		Principal.btnAldeaoOrar = new JButton("Orar");
		Principal.btnAldeaoOrar.setBounds(10, 585, 120, 21);
		pnAldeao.add(btnAldeaoOrar);

		Principal.btnAldeaoSacrificar = new JButton("Sacrificar");
		Principal.btnAldeaoSacrificar.setBounds(140, 585, 120, 21);
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
		Principal.tblFazendas.getColumn("Fazenda").setCellRenderer(dtcrVilaAcao);

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
		Principal.tblMinasOuro.getColumn("Mina").setCellRenderer(dtcrVilaAcao);

		JScrollPane spMinas = new JScrollPane(Principal.tblMinasOuro);
		spMinas.setBounds(10, 20, 250, 275);
		spMinas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pnMinaOuro.add(spMinas);

		JLabel pnPrefeitura = new JLabel();
		pnPrefeitura.setLayout(null);
		pnPrefeitura.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), acaoPrefeitura, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		// level Aldeao
		Principal.lblAldeao = new JLabel();
		Principal.lblAldeao.setBounds(115, 90, 20, 20);
		Principal.lblAldeao.setIcon(new ImageIcon(Principal.class.getResource("/img/aldeao.png")));
		Principal.lblAldeao.setEnabled(true);
		pnPrefeitura.add(lblAldeao);

		Principal.lvlAldeao = new JProgressBar();
		Principal.lvlAldeao.setOrientation(SwingConstants.HORIZONTAL);
		Principal.lvlAldeao.setMaximum(10);
		Principal.lvlAldeao.setStringPainted(true);
		Principal.lvlAldeao.setBounds(136, 90, 30, 20);
		pnPrefeitura.add(lvlAldeao);
		// level Fazenda
		Principal.lblFazenda = new JLabel();
		Principal.lblFazenda.setBounds(163, 90, 20, 20);
		Principal.lblFazenda.setIcon(new ImageIcon(Principal.class.getResource("/img/fazenda.png")));
		Principal.lblFazenda.setEnabled(true);
		pnPrefeitura.add(lblFazenda);
		
		Principal.lvlFazenda = new JProgressBar();
		Principal.lvlFazenda.setOrientation(SwingConstants.HORIZONTAL);
		Principal.lvlFazenda.setMaximum(10);
		Principal.lvlFazenda.setStringPainted(true);
		Principal.lvlFazenda.setBounds(184, 90, 30, 20);
		pnPrefeitura.add(lvlFazenda);
		// level Mina
		Principal.lblMina = new JLabel();
		Principal.lblMina.setBounds(211, 90, 20, 20);
		Principal.lblMina.setIcon(new ImageIcon(Principal.class.getResource("/img/mina.png")));
		Principal.lblMina.setEnabled(true);
		pnPrefeitura.add(lblMina);
		
		Principal.lvlMina = new JProgressBar();
		Principal.lvlMina.setOrientation(SwingConstants.HORIZONTAL);
		Principal.lvlMina.setMaximum(10);
		Principal.lvlMina.setStringPainted(true);
		Principal.lvlMina.setBounds(232, 90, 30, 20);
		pnPrefeitura.add(lvlMina);
		//----//
		//Botão Cria aldeao
		Principal.btnPrefeituraCriarAldeao = new JButton("Criar aldeão");
		Principal.btnPrefeituraCriarAldeao.setBounds(10, 90, 103, 21);
		pnPrefeitura.add(btnPrefeituraCriarAldeao);

		JComboBox<String> cbPrefeituraEvolucoes = new JComboBox<String>();
		cbPrefeituraEvolucoes.setBounds(10, 115, 248, 21);
		cbPrefeituraEvolucoes.addItem("Evolução de aldeão");
		cbPrefeituraEvolucoes.addItem("Evolução de fazenda");
		cbPrefeituraEvolucoes.addItem("Evolução de mina de ouro");
		pnPrefeitura.add(cbPrefeituraEvolucoes);

		Principal.btnPrefeituraEvoluir = new JButton("Evoluir");
		btnPrefeituraEvoluir.setBounds(131, 140, 128, 21);
		pnPrefeitura.add(btnPrefeituraEvoluir);
		
		Principal.tfPrefeituraBar = new JProgressBar();
		Principal.tfPrefeituraBar.setOrientation(SwingConstants.HORIZONTAL);
		Principal.tfPrefeituraBar.setBounds(10, 140, 120, 21);
		Principal.tfPrefeituraBar.setMaximum(100);
		Principal.tfPrefeituraBar.setStringPainted(true);
		Principal.tfPrefeituraBar.setEnabled(false);
		pnPrefeitura.add(tfPrefeituraBar);
		
		//Templo
		Principal.pnTemplo = new JPanel();
		Principal.pnTemplo.setLayout(null);
		Principal.pnTemplo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Templo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Principal.pnTemplo.setBounds(570, 195, 270, 225);
		Principal.pnTemplo.setEnabled(false);
		pnTP_Vila.add(Principal.pnTemplo);
		//Oferenda de fã
		Principal.pnOferenda = new JPanel();
		((FlowLayout) Principal.pnOferenda.getLayout()).setAlignment(FlowLayout.LEFT);
		Principal.pnOferenda.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Oferendas de fã", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Principal.pnOferenda.setBounds(8, 15, 255, 45);
		Principal.pnOferenda.setEnabled(false);
		Principal.pnTemplo.add(Principal.pnOferenda);
		//Tela do Templo
		Principal.lblOferenda = new JLabel("0");
		Principal.lblOferenda.setHorizontalAlignment(SwingConstants.LEFT);
		Principal.lblOferenda.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Principal.lblOferenda.setEnabled(false);
		Principal.pnOferenda.add(Principal.lblOferenda);
		//Tipos de evolução
		Principal.cbTEmploEvolucoes = new JComboBox<String>();
		Principal.cbTEmploEvolucoes.setBounds(10, 65, 250, 20);
		Principal.cbTEmploEvolucoes.addItem("Nuvem de gafanhotos");
		Principal.cbTEmploEvolucoes.addItem("Morte dos primogénitos");
		Principal.cbTEmploEvolucoes.addItem("Chuva de pedras");
		Principal.cbTEmploEvolucoes.addItem("Proteção contra nuvem de gafanhotos");
		Principal.cbTEmploEvolucoes.addItem("Proteção contra morte dos primogénitos");
		Principal.cbTEmploEvolucoes.addItem("Proteção contra chuva de pedras");
		Principal.cbTEmploEvolucoes.setEnabled(false);
		Principal.pnTemplo.add(Principal.cbTEmploEvolucoes);
		//--------------------------------------------------------------------------------//
		//Level Nuvem de gafanhotos
		Principal.lblGarfanhoto = new JLabel();
		Principal.lblGarfanhoto.setBounds(10, 115, 20, 20);
		Principal.lblGarfanhoto.setIcon(new ImageIcon(Principal.class.getResource("/img/garfanhoto.png")));
		Principal.lblGarfanhoto.setEnabled(true);
		pnTemplo.add(lblGarfanhoto);
		Principal.lvlGarfanhoto = new JProgressBar();
		Principal.lvlGarfanhoto.setOrientation(SwingConstants.HORIZONTAL);
		Principal.lvlGarfanhoto.setMaximum(10);
		Principal.lvlGarfanhoto.setStringPainted(true);
		Principal.lvlGarfanhoto.setBounds(30, 115, 30, 20);
		pnTemplo.add(lvlGarfanhoto);
		//Level Morte dos primogénitos
		Principal.lblPrimogenitos = new JLabel();
		Principal.lblPrimogenitos.setBounds(60, 115, 20, 20);
		Principal.lblPrimogenitos.setIcon(new ImageIcon(Principal.class.getResource("/img/primogenitos.png")));
		Principal.lblPrimogenitos.setEnabled(true);
		pnTemplo.add(lblPrimogenitos);
		Principal.lvlPrimogenitos = new JProgressBar();
		Principal.lvlPrimogenitos.setOrientation(SwingConstants.HORIZONTAL);
		Principal.lvlPrimogenitos.setMaximum(10);
		Principal.lvlPrimogenitos.setStringPainted(true);
		Principal.lvlPrimogenitos.setBounds(80, 115, 30, 20);
		pnTemplo.add(lvlPrimogenitos);
		//Level Chuva de pedras
		Principal.lblChuvaPedras = new JLabel();
		Principal.lblChuvaPedras.setBounds(110, 115, 20, 20);
		Principal.lblChuvaPedras.setIcon(new ImageIcon(Principal.class.getResource("/img/pedras.png")));
		Principal.lblChuvaPedras.setEnabled(true);
		pnTemplo.add(lblChuvaPedras);
		Principal.lvlchuvaPedras = new JProgressBar();
		Principal.lvlchuvaPedras.setOrientation(SwingConstants.HORIZONTAL);
		Principal.lvlchuvaPedras.setMaximum(10);
		Principal.lvlchuvaPedras.setStringPainted(true);
		Principal.lvlchuvaPedras.setBounds(130, 115, 30, 20);
		pnTemplo.add(lvlchuvaPedras);
		//--------------------------------------------------------------------------------//
		//Level Proteção contra nuvem de gafanhotos
		Principal.lblprotecaoGarfanhoto = new JLabel();
		Principal.lblprotecaoGarfanhoto.setBounds(10, 90, 20, 20);
		Principal.lblprotecaoGarfanhoto.setIcon(new ImageIcon(Principal.class.getResource("/img/ProtecaoGarfanhotos.png")));
		Principal.lblprotecaoGarfanhoto.setEnabled(true);
		pnTemplo.add(lblprotecaoGarfanhoto);
		Principal.lvlprotecaoGarfanhoto = new JProgressBar();
		Principal.lvlprotecaoGarfanhoto.setOrientation(SwingConstants.HORIZONTAL);
		Principal.lvlprotecaoGarfanhoto.setMaximum(10);
		Principal.lvlprotecaoGarfanhoto.setStringPainted(true);
		Principal.lvlprotecaoGarfanhoto.setBounds(30, 90, 30, 20);
		pnTemplo.add(lvlprotecaoGarfanhoto);
		//Level Proteção contra morte dos primogénitos
		Principal.lblprotecaoPrimogenitos = new JLabel();
		Principal.lblprotecaoPrimogenitos.setBounds(60, 90, 20, 20);
		Principal.lblprotecaoPrimogenitos.setIcon(new ImageIcon(Principal.class.getResource("/img/ProtecaoPrimogenitos.png")));
		Principal.lblprotecaoPrimogenitos.setEnabled(true);
		pnTemplo.add(lblprotecaoPrimogenitos);
		Principal.lvlprotecaoPrimogenitos = new JProgressBar();
		Principal.lvlprotecaoPrimogenitos.setOrientation(SwingConstants.HORIZONTAL);
		Principal.lvlprotecaoPrimogenitos.setMaximum(10);
		Principal.lvlprotecaoPrimogenitos.setStringPainted(true);
		Principal.lvlprotecaoPrimogenitos.setBounds(80, 90, 30, 20);
		pnTemplo.add(lvlprotecaoPrimogenitos);
		//Level Proteção contra chuva de pedras
		Principal.lblprotecaoChuvaPedras = new JLabel();
		Principal.lblprotecaoChuvaPedras.setBounds(110, 90, 20, 20);
		Principal.lblprotecaoChuvaPedras.setIcon(new ImageIcon(Principal.class.getResource("/img/ProtecaoPedras.png")));
		Principal.lblprotecaoChuvaPedras.setEnabled(true);
		pnTemplo.add(lblprotecaoChuvaPedras);
		Principal.lvlprotecaoChuvaPedras = new JProgressBar();
		Principal.lvlprotecaoChuvaPedras.setOrientation(SwingConstants.HORIZONTAL);
		Principal.lvlprotecaoChuvaPedras.setMaximum(10);
		Principal.lvlprotecaoChuvaPedras.setStringPainted(true);
		Principal.lvlprotecaoChuvaPedras.setBounds(130, 90, 30, 20);
		pnTemplo.add(lvlprotecaoChuvaPedras);
		//--------------------------------------------------------------------------------//
		//Botão evoluir
		Principal.btnTemploEvoluir = new JButton("Evoluir");
		Principal.btnTemploEvoluir.setBounds(160, 115, 100, 20);
		Principal.btnTemploEvoluir.setEnabled(false);
		Principal.pnTemplo.add(Principal.btnTemploEvoluir);
		//Barra de processão 
		Principal.tfTemploBar = new JProgressBar();
		Principal.tfTemploBar.setOrientation(SwingConstants.HORIZONTAL);
		Principal.tfTemploBar.setBounds(160, 90, 100, 20);
		Principal.tfTemploBar.setMaximum(100);
		Principal.tfTemploBar.setStringPainted(true);
		Principal.tfTemploBar.setEnabled(false);
		pnTemplo.add(tfTemploBar);
		//SEGUNDA PARTE
		Principal.cbTemploLancamentos = new JComboBox<String>();
		Principal.cbTemploLancamentos.setBounds(10, 140, 248, 21);
		Principal.cbTemploLancamentos.setEnabled(false);
		Principal.pnTemplo.add(Principal.cbTemploLancamentos);
		//SEGUNDA PARTE
		Principal.cbTemploInimigo = new JComboBox<String>();
		Principal.cbTemploInimigo.setEnabled(false);
		Principal.cbTemploInimigo.setBounds(10, 165, 248, 21);
		Principal.pnTemplo.add(Principal.cbTemploInimigo);
		//SEGUNDA PARTE
		Principal.btnTemploLancar = new JButton("Lançar");
		Principal.btnTemploLancar.setBounds(131, 190, 128, 21);
		Principal.btnTemploLancar.setEnabled(false);
		Principal.pnTemplo.add(Principal.btnTemploLancar);
		
		//Templo
		Principal.pnMaravilha = new JPanel();
		Principal.pnMaravilha.setLayout(null);
		Principal.pnMaravilha.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Maravilha", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Principal.pnMaravilha.setBounds(570, 430, 270, 200);
		Principal.pnMaravilha.setEnabled(false);
		pnTP_Vila.add(Principal.pnMaravilha);
		
		JPanel pnChatVila = new JPanel();
		pnChatVila.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Mensagens", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnChatVila.setBounds(10, 632, 825, 122);
		pnTP_Vila.add(pnChatVila);
		pnChatVila.setLayout(null);
		
		
		JPanel pnDigitado = new JPanel();
		pnDigitado.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDigitado.setBounds(10, 88, 734, 23);
		pnChatVila.add(pnDigitado);
		pnDigitado.setLayout(null);
		
		TextField pnDigitar = new TextField();
		pnDigitar.setBounds(0, 0, 734, 29);
		pnDigitado.add(pnDigitar);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals(btnSend.getActionCommand())) {
					try {
						Comandos.app.enviarMensagem(pnDigitar.getText());
					} catch (Exception e2) {
						View.exibirMensagemErro("ERROR", e2.getMessage());
					}
					pnDigitar.setText("");
				}
			}
		});
		btnEnviar.setBounds(745, 88, 70, 23);
		pnChatVila.add(btnEnviar);
		
		textoVila = new JTextArea(2,20);
		textoVila.setLineWrap(true);
		textoVila.setEditable(false);
		textoVila.setBackground(new Color(240,240,240));
		
		
		JScrollPane scrollVila = new JScrollPane(textoVila);
		texto.setLineWrap(true);
		scrollVila.setBounds(10, 22, 805, 55);
		pnChatVila.add(scrollVila);

		Principal.lblMaravilha = new JLabel();
		Principal.lblMaravilha.setBounds(10, 20, 215, 170);
		Principal.lblMaravilha.setIcon(new ImageIcon(Principal.class.getResource("/img/maravilha.png")));
		Principal.lblMaravilha.setEnabled(false);
		Principal.pnMaravilha.add(Principal.lblMaravilha);

		Principal.pbMaravilha = new JProgressBar();
		Principal.pbMaravilha.setOrientation(SwingConstants.VERTICAL);
		Principal.pbMaravilha.setBounds(225, 20, 30, 170);
		Principal.pbMaravilha.setMaximum(10000);
		Principal.pbMaravilha.setStringPainted(true);
		Principal.pbMaravilha.setEnabled(false);
		Principal.pnMaravilha.add(pbMaravilha);

		Principal.tpJogo.setSelectedIndex(0);
		Mostrar.mostrarCriarJogo();

		//*** Eventos ********************************************************
		
		btnSend.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals(btnSend.getActionCommand())) {
					try {
						Comandos.app.enviarMensagem(Principal.txtMsg.getText());
					} catch (Exception e2) {
						View.exibirMensagemErro("ERROR", e2.getMessage());
					}
				}
			}
		});
		
		btnIniciarJogo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					Comandos.comandoIniciarVila();
					Comandos.app.enviarMensagem("/Jogar");
					for (int i = 0; i < Principal.tmJogos.getRowCount(); i++) {
						Comandos.app.enviarMensagem("/AddJogador "+Principal.tmJogos.getValueAt(i,0));
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnCriarJogo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Comandos.comandoCriarJogo();
			}
		});
		
		btnEncerrarJogo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					Comandos.app.sair();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		rdbtnCriarJogo.addActionListener(new ActionListener(){ ///////Botão de criar jogo
			public void actionPerformed(ActionEvent e) {
				Mostrar.mostrarCriarJogo();
			}
		});
		
		rdbtnConectarJogo.addActionListener(new ActionListener(){ ///////Botão de conectar jogo
			public void actionPerformed(ActionEvent e) {
				Mostrar.mostrarConectarJogo();
			}
		});
		
		btnConectar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Comandos.conectarJogo(Principal.lbl_Ip.getText(),Principal.lbl_portaConectar.getText());
			}
		});
		
		btnDesconectar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					Comandos.app.sair();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

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
				Comandos.comandoTemploLancar(Principal.cbTemploLancamentos.getSelectedItem().toString(),Principal.cbTemploInimigo.getSelectedItem().toString());
			}
		});

	}
}