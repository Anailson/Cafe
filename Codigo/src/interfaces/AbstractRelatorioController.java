package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public abstract class AbstractRelatorioController<E> {

	public final static String FILTRO = "Filtro";
	public final static String NOME = "Por nome";
	public final static String DATA = "Por data";
	
	
	public static final int FILTRAR = 0;

//	private JTable tabela;
//	private AbstractTableCrud<E> modelo;
	private JComboBox<String> cmbFiltro;
	private JTextField txtNome;
	private JLabel lblAntes, lblDepois;
	private JDateChooser dateAntes, dateDepois;
	private JButton btnFiltro;

	public AbstractRelatorioController(JTable tabela, AbstractTableCrud<E> modelo, 
			JComboBox<String> cmbFiltro, JTextField txtNome, JLabel lblAntes, JLabel lblDepois, 
			JDateChooser dateAntes, JDateChooser dateDepois, JButton btnFiltro) {

//		this.tabela = tabela;
//		this.modelo = modelo;
		this.cmbFiltro = cmbFiltro;
		this.txtNome = txtNome;
		this.lblAntes = lblAntes;
		this.lblDepois = lblDepois;
		this.dateAntes = dateAntes;
		this.dateDepois = dateDepois;
		this.btnFiltro = btnFiltro;
	}

	public ActionListener getActionListener(int id) {
		return new AddActionListener(id);
	}

	public ItemListener getItemListener(int id) {
		return new AddItemListener(id);
	}
	
	private void filtroAlterado(JComboBox<String> comboBox){
		
		String item = (String) comboBox.getSelectedItem();

		System.out.println(item);
		
		if (item.equals(FILTRO)){
			
			
			txtNome.setVisible(false);
			lblAntes.setVisible(false);
			lblDepois.setVisible(false);
			dateAntes.setVisible(false);
			dateDepois.setVisible(false);
			btnFiltro.setVisible(false);
			
		} else if (item.equals(NOME)){
			
			txtNome.setVisible(true);
			lblAntes.setVisible(false);
			lblDepois.setVisible(false);
			dateAntes.setVisible(false);
			dateDepois.setVisible(false);
			btnFiltro.setVisible(true);
			
		} else if (item.equals(DATA)){
			
			txtNome.setVisible(false);
			lblAntes.setVisible(true);
			lblDepois.setVisible(true);
			dateAntes.setVisible(true);
			dateDepois.setVisible(true);
			btnFiltro.setVisible(true);
		}		
	}

	private class AddActionListener implements ActionListener {

		private int id;

		public AddActionListener(int id) {
			this.id = id;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			switch (id) {
			case FILTRAR:
				 
				SimpleDateFormat fmt = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");  
				System.out.println(fmt.format(dateDepois.getDate()));
				break;
			}
		}
	}

	private class AddItemListener implements ItemListener {

		private int id;

		public AddItemListener(int id) {
			this.id = id;
		}

		@Override
		public void itemStateChanged(ItemEvent e) {

			switch (id) {
			case FILTRAR:

				filtroAlterado(cmbFiltro);
				break;
			}
		}
	}
}
