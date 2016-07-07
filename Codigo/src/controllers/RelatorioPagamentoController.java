package controllers;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import entidades.Pagamento;
import interfaces.AbstractRelatorioController;
import interfaces.AbstractTableCrud;

public class RelatorioPagamentoController extends AbstractRelatorioController<Pagamento> {

	public RelatorioPagamentoController(JTable tabela, AbstractTableCrud<Pagamento> modelo, 
			JComboBox<String> cmbFiltro, JTextField txtNome, JLabel lblAntes, JLabel lblDepois, JDateChooser dateAntes, 
			JDateChooser dateDepois, JButton btnFiltro) {
		super(tabela, modelo, cmbFiltro, txtNome, lblAntes, lblDepois, dateAntes, dateDepois, btnFiltro);

	}
}
