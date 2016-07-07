package controllers;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import entidades.Recebimento;
import interfaces.AbstractRelatorioController;
import interfaces.AbstractTableCrud;

public class RelatorioRecebimentoController extends AbstractRelatorioController<Recebimento> {

	public RelatorioRecebimentoController(JTable tabela, AbstractTableCrud<Recebimento> modelo,
			JComboBox<String> cmbFiltro, JTextField txtNome, JLabel lblAntes, JLabel lblDepois, JDateChooser dateAntes,
			JDateChooser dateDepois, JButton btnFiltro) {

		super(tabela, modelo, cmbFiltro, txtNome, lblAntes, lblDepois, dateAntes, dateDepois, btnFiltro);

	}

}
