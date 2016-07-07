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

import controllers.ListarProdutoController;
import entidades.Produto;
import interfaces.AbstractListarController;
import interfaces.AbstractTableCrud;

public class FrameListarProduto extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public static final int CODIGO = 0;
	public static final int DESCRICAO = 1;
	public static final int VALOR_UNITARIO = 2;
	public static final int QUANTIDADE = 3;
	public static final int EDITAR = 4;
	public static final int EXCLUIR = 5;

	private static final String[] COLUNAS = new String[]{"Código", "Descrição", "Valor (R$)", "Quantidade", 
			AbstractTableCrud.COL_EDITAR, AbstractTableCrud.COL_EXCLUIR};
	
	private JLabel lblTitulo, lblIconPesquisa;
	private JTextField txtPesquisa;
	private JScrollPane scrTabela;
	private JTable tblCliente;
	private TabelaCrudProduto modeloTabelaCrud;
	private ArrayList<Produto> clientes;
	
	public FrameListarProduto(String titulo){
		
		this.lblTitulo = new JLabel(titulo);
		this.lblIconPesquisa = new JLabel(new ImageIcon(FramePrincipal.URL_IMAGENS + "/icon_pesquisar.png"));
		this.txtPesquisa = new JTextField();
		this.clientes = new ArrayList<Produto>();
		this.modeloTabelaCrud = new TabelaCrudProduto(COLUNAS, clientes);
		this.scrTabela = new JScrollPane();
		this.tblCliente = new JTable(modeloTabelaCrud);
		
		iniciarComponentes();
		iniciarTabela();
		iniciarEventos();
		preencherTabela();
		
	}
	
	private void iniciarComponentes(){

		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		
		scrTabela.setViewportView(tblCliente);
		
		this.setBackground(Color.WHITE);
		this.add(scrTabela, BorderLayout.CENTER);
		this.setLayout(getPanelLayout());	
	}
	
	private LayoutManager getPanelLayout(){
		
		GroupLayout layout = new GroupLayout(this);
		
		layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scrTabela, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIconPesquisa)))
                        .addGap(0, 118, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitulo)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIconPesquisa))
                .addGap(17, 17, 17)
                .addComponent(scrTabela, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
        );
        
        return layout;
	}
	
	private void iniciarTabela(){
		
		tblCliente.setAutoCreateRowSorter(true);  
	    tblCliente.setRowHeight(35);
		tblCliente.setModel(modeloTabelaCrud);
		
		TableColumn colunaCod = tblCliente.getColumnModel().getColumn(CODIGO);
		TableColumn colunaDesc = tblCliente.getColumnModel().getColumn(DESCRICAO);
		TableColumn colunaVal = tblCliente.getColumnModel().getColumn(VALOR_UNITARIO);
		TableColumn colunaQuant = tblCliente.getColumnModel().getColumn(QUANTIDADE);
		TableColumn colunaEdit = tblCliente.getColumnModel().getColumn(EDITAR);
		TableColumn colunaExcl = tblCliente.getColumnModel().getColumn(EXCLUIR);
		
		colunaCod.setPreferredWidth(20);
		colunaDesc.setPreferredWidth(300);
		colunaVal.setPreferredWidth(20);
		colunaQuant.setPreferredWidth(20);
		
		colunaEdit.setMaxWidth(50);
		colunaEdit.setMinWidth(35);
		colunaEdit.setCellRenderer(AbstractTableCrud.getIconCellRenderer());
		
		colunaExcl.setMaxWidth(50);
		colunaExcl.setMinWidth(35);
		colunaExcl.setCellRenderer(AbstractTableCrud.getIconCellRenderer());
	}
	
	private void iniciarEventos(){
		
		ListarProdutoController controller = new ListarProdutoController(txtPesquisa, tblCliente, modeloTabelaCrud);
		
		txtPesquisa.addKeyListener(controller.getKeyListener(AbstractListarController.PESQUISAR));
		lblIconPesquisa.addMouseListener(controller.getMouseListener(AbstractListarController.PESQUISAR));
		tblCliente.addMouseListener(controller.getMouseListener());
	}
	
	private void preencherTabela(){
	
		for (int i = 1; i <= 10; i++){
			
			//TODO: Alterar o método para buscar os clientes do banco e salvar num ArrayList();
			Produto p = new Produto(i, i * 100, "Prduto# " + i, i, "Genero# " + i, -1, -1, -1, -1, -1, -1, -1, -1, i * 10);
			modeloTabelaCrud.salvar(p);	
		}
	}
	
	
	private class TabelaCrudProduto extends AbstractTableCrud<Produto>{

		private static final long serialVersionUID = 1L;

		public TabelaCrudProduto(String[] colunas, ArrayList<Produto> elementos) {
			super(colunas, elementos);
		}

		@Override
		public Object getCampo(Produto p, int coluna) {
			
			
			switch(coluna){
				case CODIGO:{
					
					return p.getCodigo();
					
				} case DESCRICAO:{
					
					return p.getDescricao();
					
				} case VALOR_UNITARIO:{
					
					return p.getValorUnit();
					
				} case QUANTIDADE:{
					
					return p.getQuant();
					
				} case EDITAR:{
					
					return AbstractTableCrud.ICON_EDITAR;
					
				} case EXCLUIR:{
					
					return AbstractTableCrud.ICON_EXCLUIR;
				}
			}
			return null;
		}

		@Override
		public void setCampo(Produto p, Object valor, int coluna) {
			switch(coluna){
			case CODIGO:
				
				p.getCodigo();
				break;	
			case DESCRICAO:
				
				p.getDescricao();
				break;
			case VALOR_UNITARIO:
				
				p.getValorUnit();
				break;	
			case QUANTIDADE:
				
				p.getQuant();
				break;
			}
		}
		
		@Override
		public Class<?> getColumnClass(int coluna) {
			switch(coluna){
			case CODIGO:
				
				return Integer.class;
			case DESCRICAO:
				
				return String.class;
			case VALOR_UNITARIO:
				
				return Float.class;
			case QUANTIDADE:
				
				return Integer.class;
			}
			return super.getColumnClass(coluna);
		}
	}
}	
