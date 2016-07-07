package views;

import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import controllers.ListarVendaController;
import entidades.Cliente;
import entidades.Endereco;
import entidades.Produto;
import entidades.Venda;
import interfaces.AbstractListarController;
import interfaces.AbstractTableCrud;
import net.miginfocom.swing.MigLayout;

public class FrameListarVenda extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final int CODIGO = 0;
	private static final int CLIENTE = 1;
	private static final int DATA = 2;
	private static final int SUBTOTAL = 3;
	private static final int PENDENCIA = 4;
	private static final int VENCIMENTO = 5;
	private static final int DETALHES = 6;

	private static final String[] COLUNAS = new String[] { "#", "Cliente","Data da compra", 
			"Subtotal", "Pendência", "Vencimento", AbstractTableCrud.COL_DETALHES };
	
	private JTable tblVenda;
	private TabelaCrudVenda modelTabela;
	private ArrayList<Venda> vendas;
	private JTextField tfPesquisa;
	private JLabel lbPesquisar;
	
	public FrameListarVenda(String titulo) {
		
		this.tfPesquisa = new JTextField();
		this.lbPesquisar = new JLabel(new ImageIcon(FramePrincipal.URL_IMAGENS + "/icon_pesquisar.png"));
		this.vendas = new ArrayList<>();
		this.modelTabela = new TabelaCrudVenda(COLUNAS, vendas);
		this.tblVenda = new JTable(modelTabela);
		
		configurarComponentes();
		configurarLayout(titulo);
		configurarEventos();
		configurarTabela();
	}
	
	private void configurarComponentes(){
		
		this.setBackground(Color.WHITE);
	}
	
	private void configurarLayout(String titulo){
		
		setLayout(new MigLayout("", "[300px:n][grow][5px:n]", "[100px:n][][10px:n][grow]"));
		
		JLabel lbTitulo = new JLabel(titulo);
		JScrollPane scrTabela = new JScrollPane();
//		JPanel pnlTabela = new JPanel();
		
		lbTitulo.setFont(new Font("Trebuchet Ms", Font.PLAIN, 16));
		scrTabela.setViewportView(tblVenda);
		
		add(lbTitulo, "cell 0 0");
		add(tfPesquisa, "cell 0 1,growx");
		add(lbPesquisar, "cell 1 1");
		add(scrTabela, "cell 0 3 2 1,grow");
		
		tfPesquisa.setColumns(10);
		

		
	}
	
	private void configurarEventos(){
		ListarVendaController controller = new ListarVendaController(tfPesquisa, tblVenda,
				modelTabela);

		tfPesquisa.addKeyListener(controller.getKeyListener(AbstractListarController.PESQUISAR));
		lbPesquisar.addMouseListener(controller.getMouseListener(AbstractListarController.PESQUISAR));
		tblVenda.addMouseListener(controller.getMouseListener());
	}
	
	private void configurarTabela(){
		
		tblVenda.setAutoCreateRowSorter(true);
		tblVenda.setRowHeight(35);
		
		TableColumn colunaCod = tblVenda.getColumnModel().getColumn(CODIGO);
		TableColumn colunaCli = tblVenda.getColumnModel().getColumn(CLIENTE);
		TableColumn colunaData = tblVenda.getColumnModel().getColumn(DATA);
		TableColumn colunaSub = tblVenda.getColumnModel().getColumn(SUBTOTAL);
		TableColumn colunaPend = tblVenda.getColumnModel().getColumn(PENDENCIA);
		TableColumn colunaVenc = tblVenda.getColumnModel().getColumn(VENCIMENTO);
		TableColumn colunaDet = tblVenda.getColumnModel().getColumn(DETALHES);

		colunaCod.setMaxWidth(50);
		colunaCli.setPreferredWidth(200);
		colunaData.setPreferredWidth(50);
		colunaSub.setPreferredWidth(20);
		colunaPend.setPreferredWidth(20);
		colunaVenc.setPreferredWidth(50);

		colunaDet.setMaxWidth(60);
		colunaDet.setMinWidth(35);
		colunaDet.setCellRenderer(AbstractTableCrud.getIconCellRenderer());
		
		preencherTabela();
	}
	
	private void preencherTabela(){

		ArrayList<Produto> produtos = new ArrayList<>();
		
		for (int i = 1; i <= 5; i++){
			
			//TODO: Alterar o método para buscar os clientes do banco e salvar num ArrayList();
			Produto p = new Produto(i, i * 100, "Prduto# " + i, i, "Genero# " + i, -1, -1, -1, -1, -1, -1, -1, -1, i * 10);
			produtos.add(p);
		}
		
		
		for (int i = 1; i <= 100; i++) {

			// TODO: Alterar o método para buscar os clientes do banco e salvar
			// num ArrayList();
			Cliente c = new Cliente(i, "CLIENTE #" + i, false, String.valueOf(i * 100), "Tel #" + i, "Email #" + i, new Endereco(),
					String.valueOf(i * 10), false);
			
			Venda v = new Venda(i, c, produtos, Date.from(Instant.now()), false, Date.from(Instant.now()));
			modelTabela.salvar(v);
		}
	}
	

	private class TabelaCrudVenda extends AbstractTableCrud<Venda> {

		public TabelaCrudVenda(String[] colunas, ArrayList<Venda> elementos) {
			super(colunas, elementos);
		}

		private static final long serialVersionUID = 1L;

		@Override
		public Object getCampo(Venda v, int coluna) {

			SimpleDateFormat fmt = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
			
			switch (coluna) {
			case CODIGO:

				return v.getId();
			case CLIENTE:

				return v.getCliente().getNome();
			case DATA:
				return fmt.format(v.getDataCompra());
			case SUBTOTAL:

				
				return new DecimalFormat("#.00").format(v.getSubtotal());
			case PENDENCIA:

				return (v.isPendencia() ? "Pendente" : "-");
			case VENCIMENTO:

				return fmt.format(v.getDataVencimento());
			case DETALHES:

				return AbstractTableCrud.ICON_DETALHES;
			}
			return null;
		}

		@Override
		public void setCampo(Venda v, Object valor, int coluna) {
			
			switch (coluna) {
			case CLIENTE:

				v.setCliente((Cliente) valor);
				break;
			case PENDENCIA:

				 boolean pendencia = (valor.equals("Pendente") ? true : false);
				 v.setPendencia(pendencia);
				 break;
			}
		}
		
		@Override
		public Class<?> getColumnClass(int coluna) {
			
			return (coluna == CODIGO || coluna == SUBTOTAL ? Integer.class : Object.class );
		}		
	}
}
