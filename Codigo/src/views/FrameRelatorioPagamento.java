package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import controllers.RelatorioPagamentoController;
import entidades.Pagamento;
import interfaces.AbstractRelatorioController;
import interfaces.AbstractTableCrud;

public class FrameRelatorioPagamento extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public static final String FILTRAR = "Filtrar";
	
	private static final int QUEM = 0;
	private static final int O_QUE = 1;
	private static final int QUANDO = 2;
	private static final int QUANTO = 3;

	private static final String[] COLUNAS = new String[]{"Quem", "O que", "Quando", "Quanto"};
	private static final String[] FILTRO = new String[]{AbstractRelatorioController.FILTRO, 
			AbstractRelatorioController.NOME, AbstractRelatorioController.DATA};
	
	private JPanel panelCampos;
	private JLabel lblTitulo;
	private JComboBox<String> cmbFiltro;
	private TableModelPagamento tblModelPagamento;
	private ArrayList<Pagamento> pagamentos;
	private JTable tblPagamento;
	private JScrollPane scrTabela;
	private JTextField txtNome;
	private JLabel lblAntes, lblDepois;
	private JDateChooser dateAntes, dateDepois;
	private JButton btnFiltro;
	
	public FrameRelatorioPagamento(String titulo) {

		this.panelCampos = new JPanel();
		this.lblTitulo = new JLabel(titulo);
		this.cmbFiltro = new JComboBox<String>(FILTRO);
		this.txtNome = new JTextField();
		this.lblAntes = new JLabel("Entre");
		this.lblDepois = new JLabel("e");
		this.dateAntes = new JDateChooser();
		this.dateDepois = new JDateChooser(Date.from(Instant.now()));
		this.btnFiltro = new JButton(FILTRAR);
		this.pagamentos = new ArrayList<Pagamento>();
		this.tblModelPagamento = new TableModelPagamento(COLUNAS, pagamentos);
		this.tblPagamento = new JTable(tblModelPagamento);
		this.scrTabela = new JScrollPane();
		
		iniciarComponentes();
		iniciarTabela();
		iniciarEventos();
	}
	
	private void iniciarComponentes(){
		
		txtNome.setVisible(false);
		lblAntes.setVisible(false);
		lblDepois.setVisible(false);
		dateAntes.setVisible(false);
		dateDepois.setVisible(false);
		btnFiltro.setVisible(false);
		
		dateAntes.setBackground(Color.WHITE);
		dateDepois.setBackground(Color.WHITE);
		
		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		scrTabela.setViewportView(tblPagamento);
		
		panelCampos.setLayout(getLayoutCampos());
		panelCampos.setBackground(Color.WHITE);
		
		this.setBackground(Color.WHITE);
		this.setLayout(getPanelLayout());
	}
	
	private LayoutManager getPanelLayout(){
		
		GroupLayout layout = new GroupLayout(this);
		
		layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(panelCampos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrTabela, GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitulo)
                .addGap(30, 30, 30)
                .addComponent(panelCampos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrTabela, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

		return layout;
	}
	
	private LayoutManager getLayoutCampos(){

		GroupLayout layout = new GroupLayout(panelCampos);
		
		layout.setHorizontalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cmbFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAntes)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateAntes, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDepois)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateDepois, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFiltro)
                .addGap(0, 78, Short.MAX_VALUE))
        );
		layout.setVerticalGroup(
			layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFiltro)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAntes)
                            .addComponent(lblDepois)
                            .addComponent(cmbFiltro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(dateAntes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateDepois, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        
        return layout;
	}
	
	private void iniciarTabela(){
		
		tblPagamento.setAutoCreateRowSorter(true);  
		tblPagamento.setRowHeight(35);
		
		TableColumn colunaQuem = tblPagamento.getColumnModel().getColumn(QUEM);
		TableColumn colunaOQue = tblPagamento.getColumnModel().getColumn(O_QUE);
		TableColumn colunaQuando = tblPagamento.getColumnModel().getColumn(QUANDO);
		TableColumn colunaQuanto = tblPagamento.getColumnModel().getColumn(QUANTO);
		
		colunaQuem.setPreferredWidth(250);
		colunaOQue.setPreferredWidth(250);
		colunaQuando.setPreferredWidth(50);
		colunaQuanto.setPreferredWidth(20);
		
		preencherTabela();
	}
	
	private void preencherTabela(){
		
		for (int i = 0; i < 10; i++) {
						
			Pagamento p = new Pagamento("Pagamento #" + (i + 1), "Descricao #" + (i + 1), 
					Date.from(Instant.now()), (i + 1) * 100);
			tblModelPagamento.salvar(p);
		}		
	}
	
	private void iniciarEventos(){
		RelatorioPagamentoController controller = new RelatorioPagamentoController(tblPagamento,tblModelPagamento, 
				cmbFiltro, txtNome, lblAntes, lblDepois, dateAntes, dateDepois, btnFiltro);
		
		btnFiltro.addActionListener(controller.getActionListener(AbstractRelatorioController.FILTRAR));
		cmbFiltro.addItemListener(controller.getItemListener(AbstractRelatorioController.FILTRAR));
	}
	
	private class TableModelPagamento extends AbstractTableCrud<Pagamento>{

		private static final long serialVersionUID = 1L;

		public TableModelPagamento(String[] colunas, ArrayList<Pagamento> elementos) {
			super(colunas, elementos);
		}

		@Override
		public Object getCampo(Pagamento p, int coluna) {

			
			switch(coluna){
			case QUEM:
				
				return p.getQuem();
				
			case O_QUE:
				
				return p.getoQue();
				
			case QUANDO:
				SimpleDateFormat fmt = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
				return fmt.format(p.getQuando());
				
			case QUANTO:
				
				return p.getQuanto();
			}
			return null;
		}

		@Override
		public void setCampo(Pagamento p, Object valor, int coluna) {
			
			switch(coluna){
			case QUEM:
				
				p.setQuem((String) valor);
				break;
			case O_QUE:
				
				p.setoQue((String) valor);
				break;
			case QUANDO:
				
				p.setQuando((Date) valor);
				break;
			case QUANTO:
				
				p.setQuanto((double) valor);
				break;
			}
		}

		@Override
		public Class<?> getColumnClass(int coluna) {
			
			switch(coluna){
			case QUEM:
				
				return String.class;
			case O_QUE:
				
				return String.class;
			case QUANDO:
				
				return String.class;
				
			case QUANTO:
				
				return Float.class;
			}
			return null;
		}
	}	
}
