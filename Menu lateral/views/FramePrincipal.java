package views;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

import controllers.PrincipalController;

public class FramePrincipal {
	
	private static final int LARGURA = 150;
	private static final int ALTURA = 50;
	private static final int GAP = 10;
	
	public static final String ARQUIVO = "Arquivo";
	public static final String USUARIO = "Usuario";
	public static final String ABRIR = "Abrir";
	public static final String SALVAR = "Salvar";
	public static final String CLIENTE = "Cliente";
	public static final String TRANSPORTADORA = "Transportadora";
	public static final String FORNECEDOR = "Fornecedor";
	public static final String PRODUTO = "Produto";
	public static final String HOME = "Home";
	public static final String CADASTRAR = "Cadastrar";
	public static final String LISTAR = "Listar";
	public static final String RELATORIOS = "Relatorios";
	public static final String ESTOQUE = "Estoque";
	public static final String VENDAS = "Vendas";
	public static final String SAIR = "Sair";
	
	private PrincipalController controller;
	private JFrame framePrincipal;
	private JMenuBar menuBar;
	private JScrollPane scrTelaPrincipal;
	private JPanel pnlMenuLateral;
	private JButton btnHome, btnCadastrar;
	private JLabel lblListar, lblRelatorios, lblEstoque, lblVendas, 
			lblSair;
	private JMenuItem mItemSalvar, mItemAbrir, mItemSair, mItemCliente, mItemFornecedor, 
			mItemTransportadora, mItemProduto;


	public FramePrincipal(String s) {
		
		framePrincipal = new JFrame(s);
		controller = new PrincipalController(framePrincipal);
		
		menuBar = new JMenuBar();
		mItemAbrir = new JMenuItem(ABRIR);
		mItemSalvar = new JMenuItem(SALVAR);
		mItemSair = new JMenuItem(SAIR, new ImageIcon("imgs/icon_sair.png"));
		mItemCliente = new JMenuItem(CLIENTE);
		mItemFornecedor = new JMenuItem(FORNECEDOR);
		mItemTransportadora = new JMenuItem(TRANSPORTADORA);
		mItemProduto = new JMenuItem(PRODUTO);
		
		scrTelaPrincipal = new JScrollPane();
		pnlMenuLateral = new JPanel();
		
		btnHome = new JButton(new ImageIcon("imgs/home.png"));
		btnCadastrar = new JButton(new ImageIcon("imgs/cadastrar.png"));
		lblListar = new JLabel(new ImageIcon("imgs/listar.png"), SwingConstants.LEFT);
		lblRelatorios = new JLabel(new ImageIcon("imgs/relatorios.png"), SwingConstants.LEFT);
		lblEstoque = new JLabel(new ImageIcon("imgs/estoque.png"), SwingConstants.LEFT);
		lblVendas = new JLabel(new ImageIcon("imgs/vendas.png"), SwingConstants.LEFT);
		lblSair = new JLabel(new ImageIcon("imgs/sair.png"), SwingConstants.LEFT);
				
		configurarMenu();
		configurarComponentes();
		configurarEventos();
		configurarPopups();
	}

	private void configurarMenu(){

		JMenu menuArquivo = new JMenu("Arquivo");
		JMenu menUsuario = new JMenu("Usuario");

		menuArquivo.add(mItemAbrir);
		menuArquivo.add(mItemSalvar);
		menUsuario.add(mItemSair);
		
		menuBar.add(menuArquivo);
		menuBar.add(menUsuario);
	}

	private void configurarComponentes(){

		JPanel panelHome = new FrameHome(Color.GRAY).getPanel();		
		scrTelaPrincipal.setViewportView(panelHome);
        scrTelaPrincipal.setBorder(BorderFactory.createEtchedBorder());

		pnlMenuLateral.setLayout(getLayoutMenuLateral());
        pnlMenuLateral.setBorder(BorderFactory.createEtchedBorder());

		framePrincipal.setJMenuBar(menuBar);
		framePrincipal.getContentPane().setLayout(getLayoutFramePrincipal());
		framePrincipal.pack();
		framePrincipal.setMinimumSize(new Dimension(900, 600));
		framePrincipal.setSize(1000, 600);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.setLocationRelativeTo(null);
	}
	
	private GroupLayout getLayoutFramePrincipal(){

		GroupLayout layout = new GroupLayout(framePrincipal.getContentPane());
		
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(pnlMenuLateral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(scrTelaPrincipal)
						.addContainerGap()
				)
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(scrTelaPrincipal, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
								.addComponent(pnlMenuLateral, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()
				)
		);

		return layout;
	}
	
	private LayoutManager getLayoutMenuLateral(){

		GroupLayout layout = new GroupLayout(pnlMenuLateral);
		
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addGap(GAP)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                		.addComponent(btnHome, GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE)
	        				.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE)
	        				.addComponent(lblListar, GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE)
	        				.addComponent(lblRelatorios, GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE)
	        				.addComponent(lblEstoque, GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE)
	        				.addComponent(lblVendas, GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE)
	        				.addComponent(lblSair, GroupLayout.DEFAULT_SIZE, LARGURA, Short.MAX_VALUE))
	                .addGap(GAP)
                )
        );
				
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP)
						.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP)
						.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP)
						.addComponent(lblListar, GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP)
						.addComponent(lblRelatorios, GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP)
						.addComponent(lblEstoque, GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP)
						.addComponent(lblVendas, GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGap(GAP)
						.addComponent(lblSair, GroupLayout.PREFERRED_SIZE, ALTURA, GroupLayout.PREFERRED_SIZE)
				)
		);

		return layout;
	}
	
	private void configurarPopups(){
		
		JPopupMenu popupCadastrar = new JPopupMenu();
		JPopupMenu popupListar= new JPopupMenu();
		JPopupMenu popupRelatorios = new JPopupMenu();
		JPopupMenu popupEstoque = new JPopupMenu();
		JPopupMenu popupVendas = new JPopupMenu();
		
		popupCadastrar.add(mItemCliente);
		popupCadastrar.add(mItemFornecedor);
		popupCadastrar.add(mItemTransportadora);
		popupCadastrar.add(mItemProduto);
				
		btnCadastrar.setComponentPopupMenu(popupCadastrar);
		lblListar.setComponentPopupMenu(popupListar);
		lblRelatorios.setComponentPopupMenu(popupRelatorios);
		lblEstoque.setComponentPopupMenu(popupEstoque);
		lblVendas.setComponentPopupMenu(popupVendas);
		
	}

	private void configurarEventos(){
		
		framePrincipal.addWindowListener(controller.getWindowListener());
		
		//Itens da barra de menus prinicipal
		mItemSalvar.addActionListener(controller.getAcitonListener(SALVAR));
		mItemAbrir.addActionListener(controller.getAcitonListener(ABRIR));
		mItemSair.addActionListener(controller.getAcitonListener(SAIR));
		
		//Itens dos popups
		mItemCliente.addActionListener(controller.getAcitonListener(CLIENTE));
		mItemFornecedor.addActionListener(controller.getAcitonListener(FORNECEDOR));
		mItemTransportadora.addActionListener(controller.getAcitonListener(TRANSPORTADORA));
		mItemProduto.addActionListener(controller.getAcitonListener(PRODUTO));
		
		//Itens no menu lateral
		btnHome.addMouseListener(controller.getMouseListener(HOME));
		btnCadastrar.addMouseListener(controller.getMouseListener(CADASTRAR));
		lblListar.addMouseListener(controller.getMouseListener(LISTAR));
		lblRelatorios.addMouseListener(controller.getMouseListener(RELATORIOS));
		lblEstoque.addMouseListener(controller.getMouseListener(ESTOQUE));
		lblVendas.addMouseListener(controller.getMouseListener(VENDAS));
		lblSair.addMouseListener(controller.getMouseListener(SAIR));
	}
	
	public void setVisible(boolean flag){
		framePrincipal.setVisible(flag);
	}
	
}
