package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.TableColumn;

import controllers.ListarFornecedorController;
import entidades.Endereco;
import entidades.Fornecedor;
import interfaces.AbstractListarController;
import interfaces.AbstractTableCrud;

public class FrameListarFornecedor extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final int DOCUMENTO = 0;
	public static final int INSCRICAO_ESTADUAL = 1;
	public static final int NOME = 2;
	public static final int ENDERECO = 3;
	public static final int EDITAR = 4;
	public static final int EXCLUIR = 5;

	private static final String[] COLUNAS = new String[] { "Documento", "Ins Estadual","Nome", 
			"Endereço", AbstractTableCrud.COL_EDITAR, AbstractTableCrud.COL_EXCLUIR };

	private JLabel lblTitulo, lblIconPesquisa;
	private JTextField txtPesquisa;
	private JScrollPane scrTabela;
	private JTable tblCliente;
	private TabelaCrudFornecedor modeloTabelaCrud;
	private ArrayList<Fornecedor> clientes;

	public FrameListarFornecedor(String titulo) {

		this.lblTitulo = new JLabel(titulo);
		this.lblIconPesquisa = new JLabel(new ImageIcon(FramePrincipal.URL_IMAGENS + "/icon_pesquisar.png"));
		this.txtPesquisa = new JTextField();
		this.scrTabela = new JScrollPane();
		this.clientes = new ArrayList<Fornecedor>();
		this.modeloTabelaCrud = new TabelaCrudFornecedor(COLUNAS, clientes);
		this.tblCliente = new JTable(modeloTabelaCrud);

		iniciarComponentes();
		iniciarTabela();
		iniciarEventos();
		preencherTabela();
	}

	private void iniciarComponentes() {

		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));

		scrTabela.setViewportView(tblCliente);

		this.setBackground(Color.WHITE);
		this.add(scrTabela, BorderLayout.CENTER);
		this.setLayout(getPanelLayout());
	}

	private LayoutManager getPanelLayout() {

		GroupLayout layout = new GroupLayout(this);

		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(scrTabela, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(lblTitulo)
										.addGroup(layout.createSequentialGroup()
												.addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, 250,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(lblIconPesquisa)))
								.addGap(0, 118, Short.MAX_VALUE)))
				.addContainerGap()));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(30, 30, 30).addComponent(lblTitulo).addGap(30, 30, 30)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblIconPesquisa))
								.addGap(17, 17, 17)
								.addComponent(scrTabela, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)));

		return layout;
	}

	private void iniciarTabela() {

		tblCliente.setAutoCreateRowSorter(true);
		tblCliente.setRowHeight(35);

		TableColumn colunaDoc = tblCliente.getColumnModel().getColumn(DOCUMENTO);
		TableColumn colunaInscEst = tblCliente.getColumnModel().getColumn(INSCRICAO_ESTADUAL);
		TableColumn colunaNome = tblCliente.getColumnModel().getColumn(NOME);
		TableColumn colunaEnd = tblCliente.getColumnModel().getColumn(ENDERECO);
		TableColumn colunaEdit = tblCliente.getColumnModel().getColumn(EDITAR);
		TableColumn colunaExcl = tblCliente.getColumnModel().getColumn(EXCLUIR);

		colunaDoc.setPreferredWidth(20);
		colunaInscEst.setPreferredWidth(20);
		colunaNome.setPreferredWidth(200);
		colunaEnd.setPreferredWidth(200);

		colunaEdit.setMaxWidth(50);
		colunaEdit.setMinWidth(35);
		colunaEdit.setCellRenderer(AbstractTableCrud.getIconCellRenderer());

		colunaExcl.setMaxWidth(50);
		colunaExcl.setMinWidth(35);
		colunaExcl.setCellRenderer(AbstractTableCrud.getIconCellRenderer());
	}

	private void iniciarEventos() {

		ListarFornecedorController controller = new ListarFornecedorController(txtPesquisa, tblCliente,
				modeloTabelaCrud);

		txtPesquisa.addKeyListener(controller.getKeyListener(AbstractListarController.PESQUISAR));
		lblIconPesquisa.addMouseListener(controller.getMouseListener(AbstractListarController.PESQUISAR));
		tblCliente.addMouseListener(controller.getMouseListener());
	}

	private void preencherTabela() {

		for (int i = 1; i <= 10; i++) {

			// TODO: Alterar o método para buscar os clientes do banco e salvar
			// num ArrayList();
			Fornecedor f = new Fornecedor(i, "FORNECEDOR #" + i, false, i * 10, i * 100, false, new Endereco());
			modeloTabelaCrud.salvar(f);
		}
	}

	private class TabelaCrudFornecedor extends AbstractTableCrud<Fornecedor> {

		private static final long serialVersionUID = 1L;

		public TabelaCrudFornecedor(String[] colunas, ArrayList<Fornecedor> elementos) {
			super(colunas, elementos);
		}

		@Override
		public Object getCampo(Fornecedor t, int coluna) {
			switch (coluna) {
			case DOCUMENTO:

				return t.getDocumento();
			case INSCRICAO_ESTADUAL:

				return t.getInscricaoEstadual();
			case NOME:

				return t.getNome();
			case ENDERECO:

				return t.getEndereco();
			case EDITAR:

				return AbstractTableCrud.ICON_EDITAR;
			case EXCLUIR:

				return AbstractTableCrud.ICON_EXCLUIR;
			}
			return null;
		}

		@Override
		public void setCampo(Fornecedor c, Object valor, int coluna) {
			switch (coluna) {
			case DOCUMENTO: 

				c.setDocumento((int) valor);
				break;
			case INSCRICAO_ESTADUAL: 

				c.setInscricaoEstadual((int) valor);
				break;
			case NOME: 

				c.setNome((String) valor);
				break;
			case ENDERECO:

				c.setEndereco((Endereco) valor);
				break;
			}
		}

		@Override
		public Class<?> getColumnClass(int coluna) {

			switch (coluna) {
			case DOCUMENTO:

				return Integer.class;
			case INSCRICAO_ESTADUAL:

				return Integer.class;
			case NOME:

				return String.class;
			case ENDERECO:

				return String.class;
			}
			return null;
		}
	}
}
