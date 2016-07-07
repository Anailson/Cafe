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

import controllers.ListarClienteController;
import entidades.Cliente;
import entidades.Endereco;
import interfaces.AbstractListarController;
import interfaces.AbstractTableCrud;

public class FrameListarCliente extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final int DOCUMENTO = 0;
	private static final int NOME = 1;
	private static final int ENDERECO = 2;
	private static final int TELEFONE = 3;
	private static final int EDITAR = 4;
	private static final int EXCLUIR = 5;

	private static final String[] COLUNAS = new String[] { "Documento", "Nome", "Endereço", "Telefone", 
			AbstractTableCrud.COL_EDITAR, AbstractTableCrud.COL_EXCLUIR};

	private JLabel lblTitulo, lblIconPesquisa;
	private JTextField txtPesquisa;
	private ArrayList<Cliente> clientes;
	private TabelaCrudCliente modeloTabelaCrud;
	private JTable tblCliente;
	private JScrollPane scrTabela;

	public FrameListarCliente(String titulo) {

		this.lblTitulo = new JLabel(titulo);
		this.lblIconPesquisa = new JLabel(new ImageIcon(FramePrincipal.URL_IMAGENS + "/icon_pesquisar.png"));
		this.txtPesquisa = new JTextField();
		this.clientes = new ArrayList<Cliente>();
		this.modeloTabelaCrud = new TabelaCrudCliente(COLUNAS, clientes);
		this.tblCliente = new JTable(modeloTabelaCrud);
		this.scrTabela = new JScrollPane();

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
		TableColumn colunaNome = tblCliente.getColumnModel().getColumn(NOME);
		TableColumn colunaEnd = tblCliente.getColumnModel().getColumn(ENDERECO);
		TableColumn colunaTel = tblCliente.getColumnModel().getColumn(TELEFONE);
		TableColumn colunaEdit = tblCliente.getColumnModel().getColumn(EDITAR);
		TableColumn colunaExcl = tblCliente.getColumnModel().getColumn(EXCLUIR);

		colunaDoc.setPreferredWidth(20);
		colunaNome.setPreferredWidth(200);
		colunaEnd.setPreferredWidth(200);
		colunaTel.setPreferredWidth(20);

		colunaEdit.setMaxWidth(50);
		colunaEdit.setMinWidth(35);
		colunaEdit.setCellRenderer(AbstractTableCrud.getIconCellRenderer());

		colunaExcl.setMaxWidth(50);
		colunaExcl.setMinWidth(35);
		colunaExcl.setCellRenderer(AbstractTableCrud.getIconCellRenderer());
	}

	private void iniciarEventos() {

		ListarClienteController controller = new ListarClienteController(txtPesquisa, tblCliente, modeloTabelaCrud);

		txtPesquisa.addKeyListener(controller.getKeyListener(AbstractListarController.PESQUISAR));
		lblIconPesquisa.addMouseListener(controller.getMouseListener(AbstractListarController.PESQUISAR));
		tblCliente.addMouseListener(controller.getMouseListener());
	}

	private void preencherTabela() {

		for (int i = 1; i <= 10; i++) {

			// TODO: Alterar o método para buscar os clientes do banco e salvar
			// num ArrayList();
			Cliente c = new Cliente(i, "CLIENTE #" + i, false, String.valueOf(i * 100), "Tel #" + i, "Email #" + i, new Endereco(),
					String.valueOf(i * 10), false);
			modeloTabelaCrud.salvar(c);
		}
	}

	private class TabelaCrudCliente extends AbstractTableCrud<Cliente> {

		private static final long serialVersionUID = 1L;

		public TabelaCrudCliente(String[] colunas, ArrayList<Cliente> elementos) {
			super(colunas, elementos);
		}

		@Override
		public Object getCampo(Cliente c, int coluna) {
			switch (coluna) {
			case DOCUMENTO:

				return c.getDocumento();
			case NOME:

				return c.getNome();
			case ENDERECO:

				return c.getEndereco();
			case TELEFONE:

				return c.getTelefone();
			case EDITAR:

				return AbstractTableCrud.ICON_EDITAR;
			case EXCLUIR:

				return AbstractTableCrud.ICON_EXCLUIR;
			}
			return null;
		}

		@Override
		public void setCampo(Cliente c, Object valor, int coluna) {
			switch (coluna) {
			case DOCUMENTO: 

				c.setDocumento((String) valor);
				break;
			case NOME: 

				c.setNome((String) valor);
				break;
			case ENDERECO: 

				c.setEndereco((Endereco) valor);
				break;
			case TELEFONE: 

				c.setTelefone((String) valor);
				break;
			}
		}
		
		@Override
		public Class<?> getColumnClass(int coluna) {
			
			switch (coluna) {
			case DOCUMENTO:

				return Integer.class;
			case NOME:

				return String.class;
			case ENDERECO:

				return String.class;
			case TELEFONE:

				return String.class;
			}
			return null;
		}
	}
}
