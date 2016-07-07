package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import controllers.RealizarVendaVistaController;
import entidades.Cliente;
import entidades.Produto;
import interfaces.AbstractTableCrud;
import interfaces.AbstractVendaController;
import net.miginfocom.swing.MigLayout;

public class FrameRealizarVendaVista extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final String FILTRAR = "Filtrar";

	private static final int CODIGO = 0;
	private static final int DESCRICAO = 1;
	private static final int GENERO = 2;
	private static final int VALOR = 3;
	private static final int QUANTIDADE = 4;
	private static final int SUB_TOTAL = 5;

	private static final String[] COLUNAS = new String[] { "Codigo", "Descricção", "Genero", "Valor", "Quantidade",
			"Subtotal" };

	private ArrayList<Produto> produtos;
	private TableModelVendasVista modelTabela;
	private JTable tblVendas;
	private JRadioButton rdbCodCli, rdbDescCli, rdbCodPro, rdbDescPro;
	private JComboBox<Cliente> cmbCliente;
	private JComboBox<Produto> cmbProduto;
	private JSpinner spnQuant;
	private JTextField tfCliente, tfProduto, tfValorUnit, tfGenero;
	private JButton btnCancelar, btnFinalizar, btnAdicionar;

	public FrameRealizarVendaVista(String titulo) {

		this.produtos = new ArrayList<Produto>();
		this.modelTabela = new TableModelVendasVista(COLUNAS, produtos);
		this.tblVendas = new JTable(modelTabela);

		this.rdbCodCli = new JRadioButton("Codigo:");
		this.rdbDescCli = new JRadioButton("Nome:");
		this.rdbCodPro = new JRadioButton("Codigo:");
		this.rdbDescPro = new JRadioButton("Descrição:");

		this.cmbCliente = new JComboBox<Cliente>();
		this.cmbProduto = new JComboBox<Produto>();

		this.tfCliente = new JTextField();
		this.tfProduto = new JTextField();
		this.tfValorUnit = new JTextField();
		this.tfGenero = new JTextField();

		this.spnQuant = new JSpinner();

		this.btnAdicionar = new JButton("+");
		this.btnFinalizar = new JButton("Finalizar venda");
		this.btnCancelar = new JButton("Cancelar");

		iniciarComponentes();
		iniciarLayout(titulo);
		iniciarTabela();
		iniciarEventos();
	}

	private void iniciarComponentes() {

		tfCliente.setEditable(false);
		tfProduto.setEditable(false);
		tfValorUnit.setEditable(false);
		tfGenero.setEditable(false);
		
		cmbCliente.setRenderer(AbstractVendaController.getCellRenderer());
		cmbCliente.setEnabled(false);
		cmbProduto.setRenderer(AbstractVendaController.getCellRenderer());
		cmbProduto.setEnabled(false);

		this.setBackground(Color.WHITE);
	}

	private void iniciarLayout(String titulo) {

		setLayout(new MigLayout("", "[grow]", "[100px:n][][::5px][][::5px][grow][]"));

		JPanel pnlDadosGerais = new JPanel();
		JPanel pnlDetalhes = new JPanel();
		JPanel pnlBotoes = new JPanel();
		JScrollPane scrTabela = new JScrollPane();
		JLabel lbTitulo = new JLabel(titulo);
		JLabel lbCliente = new JLabel("Cliente:");
		JLabel lbProduto = new JLabel("Produto:");
		JLabel lbDadosCliente = new JLabel("Dados do cliente:");
		JLabel lbDadosProduto = new JLabel("Dados do produto:");
		JLabel lbQuant = new JLabel("Quantidade:");
		JLabel lbValorUnit = new JLabel("Valor unitário:");
		JLabel lbGenero = new JLabel("Genero:");

		ButtonGroup btGroupCli = new ButtonGroup();
		ButtonGroup btGroupPro = new ButtonGroup();

		lbTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		btGroupCli.add(rdbCodCli);
		btGroupCli.add(rdbDescCli);
		btGroupPro.add(rdbCodPro);
		btGroupPro.add(rdbDescPro);
		scrTabela.setViewportView(tblVendas);
		scrTabela.setPreferredSize(new Dimension(0, 400));

		add(lbTitulo, "cell 0 0");
		add(pnlDadosGerais, "cell 0 1,grow");
		add(pnlDetalhes, "cell 0 3,grow");
		add(scrTabela, "cell 0 5,grow");
		add(pnlBotoes, "cell 0 6,grow");

		pnlDadosGerais.setBackground(Color.WHITE);
		pnlDadosGerais.setLayout(new MigLayout("", "[][][][grow]", "[][]"));

		pnlDadosGerais.add(lbCliente, "cell 0 0");
		pnlDadosGerais.add(rdbCodCli, "cell 1 0");
		pnlDadosGerais.add(rdbDescCli, "cell 2 0");
		pnlDadosGerais.add(cmbCliente, "cell 3 0");
		pnlDadosGerais.add(lbProduto, "cell 0 1");
		pnlDadosGerais.add(rdbCodPro, "cell 1 1");
		pnlDadosGerais.add(rdbDescPro, "cell 2 1");
		pnlDadosGerais.add(cmbProduto, "cell 3 1");
		
		pnlDetalhes.setBackground(Color.WHITE);
		pnlDetalhes.setLayout(new MigLayout("", "[][60px:n][::15px][][100px:n][::15px][][100px:n][::15px][grow]", "[][][]"));
		
		pnlDetalhes.add(lbDadosCliente, "cell 0 0");
		pnlDetalhes.add(tfCliente, "cell 1 0 9 1,growx");
		pnlDetalhes.add(lbDadosProduto, "cell 0 1");
		pnlDetalhes.add(tfProduto, "cell 1 1 9 1,growx");
		pnlDetalhes.add(lbQuant, "cell 0 2");
		pnlDetalhes.add(spnQuant, "cell 1 2,growx");
		pnlDetalhes.add(lbValorUnit, "cell 3 2,alignx trailing");
		pnlDetalhes.add(tfValorUnit, "cell 4 2,growx");
		pnlDetalhes.add(lbGenero, "cell 6 2,alignx trailing");
		pnlDetalhes.add(tfGenero, "cell 7 2,growx");
		pnlDetalhes.add(btnAdicionar, "cell 9 2");
		
		tfCliente.setColumns(10);
		tfProduto.setColumns(10);
		tfValorUnit.setColumns(10);
		tfGenero.setColumns(10);
		pnlBotoes.setBackground(Color.WHITE);
		pnlBotoes.setLayout(new MigLayout("", "[grow][][][grow]", "[]"));

		pnlBotoes.add(btnFinalizar, "cell 1 0");
		pnlBotoes.add(btnCancelar, "cell 2 0");
	}

	private void iniciarTabela() {

		tblVendas.setAutoCreateRowSorter(true);
		tblVendas.setRowHeight(35);

		TableColumn colunaCod = tblVendas.getColumnModel().getColumn(CODIGO);
		TableColumn colunaDes = tblVendas.getColumnModel().getColumn(DESCRICAO);
		TableColumn colunaGen = tblVendas.getColumnModel().getColumn(GENERO);
		TableColumn colunaValUni = tblVendas.getColumnModel().getColumn(VALOR);
		TableColumn colunaQuant = tblVendas.getColumnModel().getColumn(QUANTIDADE);
		TableColumn colunaValSub = tblVendas.getColumnModel().getColumn(SUB_TOTAL);

		colunaCod.setPreferredWidth(15);
		colunaDes.setPreferredWidth(300);
		colunaGen.setPreferredWidth(20);
		colunaValUni.setPreferredWidth(20);
		colunaQuant.setPreferredWidth(20);
		colunaValSub.setPreferredWidth(20);

		preencherTabela();
	}

	private void preencherTabela() {

		for (int i = 1; i <= 10; i++) {

			// TODO: Alterar o método para buscar os clientes do banco e salvar
			// num ArrayList();
			Produto p = new Produto(i, i * 100, "Prduto# " + i, i, "Genero# " + i, -1, -1, -1, -1, -1, -1, -1, -1,
					i * 10);
			modelTabela.salvar(p);
		}
	}

	private void iniciarEventos() {

		RealizarVendaVistaController controller = new RealizarVendaVistaController(rdbCodCli, rdbDescCli, rdbCodPro,
				rdbDescPro, cmbCliente, cmbProduto, spnQuant, tfCliente, tfProduto, tfValorUnit, tfGenero);

		rdbCodCli.addItemListener(controller.getItemListener(AbstractVendaController.COD_CLI));
		rdbDescCli.addItemListener(controller.getItemListener(AbstractVendaController.DESC_CLI));
		rdbCodPro.addItemListener(controller.getItemListener(AbstractVendaController.COD_PROD));
		rdbDescPro.addItemListener(controller.getItemListener(AbstractVendaController.DESC_PROD));
		cmbCliente.addItemListener(controller.getItemListener(AbstractVendaController.CLIENTE));
		cmbProduto.addItemListener(controller.getItemListener(AbstractVendaController.PRODUTO));

		btnAdicionar.addActionListener(controller.getActionListener(AbstractVendaController.ADICIONAR));
		btnFinalizar.addActionListener(controller.getActionListener(AbstractVendaController.FINALIZAR));
		btnCancelar.addActionListener(controller.getActionListener(AbstractVendaController.CANCELAR));

	}

	private class TableModelVendasVista extends AbstractTableCrud<Produto> {

		public TableModelVendasVista(String[] colunas, ArrayList<Produto> elementos) {
			super(colunas, elementos);
		}

		private static final long serialVersionUID = 1L;

		@Override
		public Object getCampo(Produto p, int coluna) {

			switch (coluna) {
			case CODIGO:

				return p.getCodigo();
			case DESCRICAO:

				return p.getDescricao();
			case GENERO:

				return p.getGenero();
			case VALOR:

				return p.getValorUnit();
			case QUANTIDADE:

				return p.getQuant();
			case SUB_TOTAL:

				return p.getQuant() * p.getValorUnit();
			}
			return null;
		}

		@Override
		public void setCampo(Produto p, Object valor, int coluna) {

			switch (coluna) {
			case CODIGO:

				p.setCodigo((int) valor);

			case DESCRICAO:

				p.setDescricao((String) valor);

			case GENERO:

				p.setGenero((String) valor);

			case VALOR:

				p.setValorUnit((float) valor);

			case QUANTIDADE:

				p.setQuant((int) valor);
			}
		}

		@Override
		public Class<?> getColumnClass(int coluna) {
			switch (coluna) {
			case CODIGO:
				return Integer.class;

			case DESCRICAO:
				return String.class;

			case GENERO:
				return String.class;

			case VALOR:
				return Float.class;

			case QUANTIDADE:
				return Integer.class;

			case SUB_TOTAL:
				return Float.class;
			}
			return Object.class;
		}
	}

}
