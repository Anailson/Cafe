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

import entidades.Produto;
import interfaces.AbstractTableCrud;

public class FrameEstoque extends JPanel {
	private static final long serialVersionUID = 1L;

	public static final String FILTRAR = "Filtrar";

	private static final int CODIGO = 0;
	private static final int DESCRICAO = 1;
	private static final int QUANTIDADE = 2;
	private static final int VALOR_UNIT = 3;
	private static final int VALOR_SUB = 4;

	private static final String[] COLUNAS = new String[] { "Codigo", "Descricao", "Quantidade", 
			"Valor unitário (R$)", "Subtotal (R$)" };

	private JLabel lblTitulo, lblIconPesquisa;
	private TableModelProduto tblModelProduto;
	private ArrayList<Produto> produtos;
	private JTable tblProduto;
	private JScrollPane scrTabela;
	private JTextField txtPesquisa;
	
	public FrameEstoque(String titulo) {

		this.lblTitulo = new JLabel(titulo);
		this.lblIconPesquisa = new JLabel(new ImageIcon(FramePrincipal.URL_IMAGENS + "/icon_pesquisar.png"));

		this.txtPesquisa = new JTextField();
		this.scrTabela = new JScrollPane();
		this.tblProduto = new JTable();
		this.produtos = new ArrayList<Produto>();
		this.tblModelProduto = new TableModelProduto(COLUNAS, produtos);
		
		iniciarComponentes();
		iniciarTabela();
		iniciarEventos();
	}
	
	private void iniciarComponentes(){

		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		
		scrTabela.setViewportView(tblProduto);
		tblProduto.setModel(tblModelProduto);
		
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
                .addComponent(scrTabela, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        return layout;
	}
	
	private void iniciarTabela(){
		
		tblProduto.setAutoCreateRowSorter(true);  
	    tblProduto.setRowHeight(35);
		
		TableColumn colunaDoc = tblProduto.getColumnModel().getColumn(CODIGO);
		TableColumn colunaDes = tblProduto.getColumnModel().getColumn(DESCRICAO);
		TableColumn colunaQuant = tblProduto.getColumnModel().getColumn(QUANTIDADE);
		TableColumn colunaValUni = tblProduto.getColumnModel().getColumn(VALOR_UNIT);
		TableColumn colunaValSub = tblProduto.getColumnModel().getColumn(VALOR_SUB);
		
		colunaDoc.setPreferredWidth(15);
		colunaDes.setPreferredWidth(300);
		colunaQuant.setPreferredWidth(20);
		colunaValUni.setPreferredWidth(20);
		colunaValSub.setPreferredWidth(20);
		
		preencherTabela();
	}
	
	private void preencherTabela(){
	
			for (int i = 1; i <= 10; i++){
			
			//TODO: Alterar o método para buscar os clientes do banco e salvar num ArrayList();
			Produto p = new Produto(i, i * 100, "Prduto# " + i, i, "Genero# " + i, -1, -1, -1, -1, -1, -1, -1, -1, i * 10);
			tblModelProduto.salvar(p);	
		}
	}
	
	private void iniciarEventos(){
		
//		ListarClienteController controller = new ListarClienteController(txtPesquisa, tblCliente, modeloTabelaCrud);
//		
//		txtPesquisa.addKeyListener(controller.getKeyListener(AbstractListarController.PESQUISAR));
//		lblIconPesquisa.addMouseListener(controller.getMouseListener(AbstractListarController.PESQUISAR));
//		tblCliente.addMouseListener(controller.getMouseListener());
	}
	
	

	
	private class TableModelProduto extends AbstractTableCrud<Produto>{

		private static final long serialVersionUID = 1L;

		public TableModelProduto(String[] colunas, ArrayList<Produto> elementos) {
			super(colunas, elementos);
		}

		@Override
		public Object getCampo(Produto p, int coluna) {

			switch(coluna){
			case CODIGO:
				
				return p.getCodigo();
				
			case DESCRICAO:
				
				return p.getDescricao();
				
			case QUANTIDADE:
				
				return p.getQuant();
				
			case VALOR_UNIT:
				
				return p.getValorUnit();
				
			case VALOR_SUB:
				
				return p.getValorUnit() * p.getQuant();
			}
			return null;
		}

		@Override
		public void setCampo(Produto p, Object valor, int coluna) {
			
			switch(coluna){
			case CODIGO:
				
				p.setCodigo((int) valor);
				break;
				
			case DESCRICAO:
				
				p.setDescricao((String) valor);
				break;
				
			case QUANTIDADE:
				
				p.setQuant((int) valor);
				break;
				
			case VALOR_UNIT:
				
				p.setValorUnit((float) valor);
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
				
			case QUANTIDADE:
				
				return Integer.class;
				
			case VALOR_UNIT:
				
				return Float.class;
				
			case VALOR_SUB:
				
				return Float.class;
			}
			return null;
		}
	}	
}
