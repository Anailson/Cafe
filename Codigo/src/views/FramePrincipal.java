package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import controllers.MenuFlutuanteController;
import controllers.MenuLateralController;
import controllers.PrincipalController;
import entidades.MenuLateral;

public class FramePrincipal {

	public static final int LARGURA = 150;
	public static final int ALTURA = 50;
	public static final int GAP = 10;

	public static final String BTN_CADASTRAR = "Cadastrar";
	public static final String BTN_LIMPAR = "Limpar campos";
	public static final String BTN_CANCELAR = "Cancelar";

	public static final String URL_IMAGENS = "Imagens";
	public static final String ARQUIVO = "Arquivo";
	public static final String USUARIO = "Usuario";
	public static final String AJUDA = "Ajuda";
	public static final String ABRIR = "Abrir";
	public static final String IMPRIMIR = "Imprimir";
	public static final String SALVAR = "Salvar";
	public static final String SOBRE = "Sobre";
	public static final String HOME = "Home";
	public static final String CADASTRAR = "Cadastrar";
	public static final String LISTAR = "Listar";
	public static final String RELATORIOS = "Relatorios";
	public static final String ESTOQUE = "Estoque";
	public static final String VENDAS = "Vendas";
	public static final String CAD_CLIENTE = "Cadastrar cliente";
	public static final String CAD_TRANSPORTADORA = "Cadastrar transportadora";
	public static final String CAD_FORNECEDOR = "Cadastrar fornecedor";
	public static final String CAD_PRODUTO = "Cadastrar produto";
	public static final String LIS_CLIENTE = "Listar clientes";
	public static final String LIS_TRANSPORTADORA = "Listar transportadoras";
	public static final String LIS_FORNECEDOR = "Listar fornecedores";
	public static final String LIS_PRODUTO = "Listar produtos";
	public static final String PAGAMENTO = "Pagamento";
	public static final String RECEBIMENTO = "Recebimento";
	public static final String BALANCO = "Balanço";
	public static final String REALIZAR_VENDA = "Realizar venda";
	public static final String LISTAR_VENDAS_A_VISTA = "Listar vendas à vista";
	public static final String LISTAR_VENDAS_DUPLICATA = "Listar vendas duplicata";
	public static final String LIS_VENDAS = "Listar todas as vendas";
	public static final String SAIR = "Sair";

	private static JFrame frame;
	private JMenuBar menuBar;
	private static JScrollPane scrTelaPrincipal;
	private PanelMenuLateral pnlMenuLateral;
	private static JPanel pnlPrincipal;
	private JLabel lblHome, lblCadastrar, lblListar, lblRelatorios, lblEstoque, lblVendas, lblSair;
	private JMenuItem mItemSalvar, mItemAbrir, mItemImprimir, mItemSair, mItemSobre;

	public FramePrincipal(String s) {

		frame = new JFrame(s);

		menuBar = new JMenuBar();
		mItemAbrir = new JMenuItem(ABRIR);
		mItemSalvar = new JMenuItem(SALVAR);
		mItemImprimir = new JMenuItem(IMPRIMIR);
		mItemSair = new JMenuItem(SAIR, new ImageIcon("Imagens/icon_sair.png"));
		mItemSobre = new JMenuItem(SOBRE);

		pnlMenuLateral = new PanelMenuLateral();
		pnlPrincipal = new FrameHome();
		scrTelaPrincipal = new JScrollPane();

		lblHome = new JLabel(new ImageIcon(URL_IMAGENS + "/home.png"));
		lblCadastrar = new JLabel(new ImageIcon(URL_IMAGENS + "/cadastrar.png"));
		lblListar = new JLabel(new ImageIcon(URL_IMAGENS + "/listar.png"));
		lblRelatorios = new JLabel(new ImageIcon(URL_IMAGENS + "/relatorios.png"));
		lblEstoque = new JLabel(new ImageIcon(URL_IMAGENS + "/estoque.png"));
		lblVendas = new JLabel(new ImageIcon(URL_IMAGENS + "/vendas.png"));
		lblSair = new JLabel(new ImageIcon(URL_IMAGENS + "/sair.png"));

		iniciarLookAndFeel();
		iniciarMenu();
		iniciarMenuLateral();
		iniciarComponentes();
		iniciarEventos();
	}

	private static void aplicarMascara(JFormattedTextField field, MaskFormatter mask){
		mask.install(field);
	}
	
	public static void mascaraCep(JFormattedTextField field) throws ParseException {
		aplicarMascara(field, new MaskFormatter("#####-###"));
	}

	public static void mascaraTelefone(JFormattedTextField field) throws ParseException {
		aplicarMascara(field, new MaskFormatter("(##) #####-####"));
	}

	public static void mascaraInscricao(JFormattedTextField field) throws ParseException {
		aplicarMascara(field, new MaskFormatter("########-#"));
	}

	public static void mascaraDocumento(JFormattedTextField field, String documento) throws ParseException {
		
		if(documento.equals("CPF")){
			aplicarMascara(field, new MaskFormatter("###.###.###-##"));
		}else if(documento.equals("CNPJ")){
			aplicarMascara(field, new MaskFormatter("##.###.###/####-##"));
		}
	}

	public void setVisible(boolean flag) {
		frame.setVisible(flag);
	}

	public static void setPanel(JPanel panel) {
		pnlPrincipal = panel;
		scrTelaPrincipal.setViewportView(pnlPrincipal);
	}

	public static void repaint() {
		frame.repaint();
	}

	public static void alterarIcone(JLabel label, String urlIcone) {
		label.setIcon(new ImageIcon(URL_IMAGENS + urlIcone));
	}

	private void iniciarLookAndFeel() {
		try { // Exceção para utilizar ou não o tema Ninbus do java
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void iniciarMenu() {

		JMenu menuArquivo = new JMenu(ARQUIVO);
		JMenu menuUsuario = new JMenu(USUARIO);
		JMenu menuAjuda = new JMenu(AJUDA);

		menuArquivo.add(mItemAbrir);
		menuArquivo.add(mItemSalvar);
		menuArquivo.add(mItemImprimir);
		menuUsuario.add(mItemSair);
		menuAjuda.add(mItemSobre);

		menuBar.add(menuArquivo);
		menuBar.add(menuUsuario);
		menuBar.add(menuAjuda);

		frame.setJMenuBar(menuBar);
	}

	private void iniciarMenuLateral() {

		MenuLateral home = new MenuLateral(HOME, lblHome);
		MenuLateral cadastrar = new MenuLateral(CADASTRAR, lblCadastrar);
		MenuLateral listar = new MenuLateral(LISTAR, lblListar);
		MenuLateral relatorios = new MenuLateral(RELATORIOS, lblRelatorios);
		MenuLateral estoque = new MenuLateral(ESTOQUE, lblEstoque);
		MenuLateral vendas = new MenuLateral(VENDAS, lblVendas);
		MenuLateral sair = new MenuLateral(SAIR, lblSair);

		cadastrar.addMenuFlutuante(CAD_CLIENTE, new JLabel(new ImageIcon(URL_IMAGENS + "/cliente.png")));
		cadastrar.addMenuFlutuante(CAD_FORNECEDOR, new JLabel(new ImageIcon(URL_IMAGENS + "/fornecedor.png")));
		cadastrar.addMenuFlutuante(CAD_TRANSPORTADORA, new JLabel(new ImageIcon(URL_IMAGENS + "/transportadora.png")));
		cadastrar.addMenuFlutuante(CAD_PRODUTO, new JLabel(new ImageIcon(URL_IMAGENS + "/produto.png")));

		listar.addMenuFlutuante(LIS_CLIENTE, new JLabel(new ImageIcon(URL_IMAGENS + "/cliente.png")));
		listar.addMenuFlutuante(LIS_FORNECEDOR, new JLabel(new ImageIcon(URL_IMAGENS + "/fornecedor.png")));
		listar.addMenuFlutuante(LIS_TRANSPORTADORA, new JLabel(new ImageIcon(URL_IMAGENS + "/transportadora.png")));
		listar.addMenuFlutuante(LIS_PRODUTO, new JLabel(new ImageIcon(URL_IMAGENS + "/produto.png")));
		listar.addMenuFlutuante(LIS_VENDAS, new JLabel(new ImageIcon(URL_IMAGENS + "/lis_vendas.png")));

		relatorios.addMenuFlutuante(PAGAMENTO, new JLabel(new ImageIcon(URL_IMAGENS + "/pagamento.png")));
		relatorios.addMenuFlutuante(RECEBIMENTO, new JLabel(new ImageIcon(URL_IMAGENS + "/recebimento.png")));
		relatorios.addMenuFlutuante(BALANCO, new JLabel(new ImageIcon(URL_IMAGENS + "/balanco.png")));

		// vendas.addMenuFlutuante(REALIZAR_VENDA, new JLabel(new
		// ImageIcon(URL_IMAGENS + "/realizar_venda.png")));
		vendas.addMenuFlutuante(LISTAR_VENDAS_A_VISTA, new JLabel(new ImageIcon(URL_IMAGENS + "/listar_a_vista.png")));
		vendas.addMenuFlutuante(LISTAR_VENDAS_DUPLICATA,
				new JLabel(new ImageIcon(URL_IMAGENS + "/listar_duplicata.png")));

		// pnlMenuLateral.setPosicaoRelativa(Configs.ACIMA);
		// pnlMenuLateral.setOrientacao(Configs.HORIZONTAL);
		pnlMenuLateral.addMenuLateral(home);
		pnlMenuLateral.addMenuLateral(cadastrar);
		pnlMenuLateral.addMenuLateral(listar);
		pnlMenuLateral.addMenuLateral(relatorios);
		pnlMenuLateral.addMenuLateral(estoque);
		pnlMenuLateral.addMenuLateral(vendas);
		pnlMenuLateral.addMenuLateral(sair);

		pnlMenuLateral.setLarguraMenu(150);
		pnlMenuLateral.setAlturaMenu(40);
		pnlMenuLateral.addMenuLateralListener(new MenuLateralController(frame));
		pnlMenuLateral.addMenuFlutuanteListener(new MenuFlutuanteController(frame));

		pnlMenuLateral.gerarMenus();
	}

	private void iniciarComponentes() {

		scrTelaPrincipal.setViewportView(pnlPrincipal);
		scrTelaPrincipal.setBorder(BorderFactory.createEtchedBorder());

		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(FramePrincipal.URL_IMAGENS + "/CafeIcone.png"));
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(getLayoutFrame());
		frame.pack();
		frame.setMinimumSize(new Dimension(900, 600));
		frame.setSize(1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

	}

	private GroupLayout getLayoutFrame() {

		GroupLayout layout = new GroupLayout(frame.getContentPane());

		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(pnlMenuLateral.getPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(GAP).addComponent(scrTelaPrincipal).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(scrTelaPrincipal, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
								.addComponent(pnlMenuLateral.getPanel(), GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));

		return layout;
	}

	private void iniciarEventos() {

		PrincipalController controller = new PrincipalController(frame);

		frame.addWindowListener(controller.getWindowListener());
		//
		// //Itens da barra de menus prinicipal
		mItemAbrir.addActionListener(controller.getAcitonListener(ABRIR));
		mItemSalvar.addActionListener(controller.getAcitonListener(SALVAR));
		mItemImprimir.addActionListener(controller.getAcitonListener(IMPRIMIR));
		mItemSair.addActionListener(controller.getAcitonListener(SAIR));
		mItemSobre.addActionListener(controller.getAcitonListener(SOBRE));
	}
}
