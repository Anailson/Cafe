package controllers;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import entidades.Cliente;
import entidades.Produto;
import interfaces.AbstractVendaController;

public class RealizarVendaVistaController extends AbstractVendaController {

	public RealizarVendaVistaController(JRadioButton rdbCodCli, JRadioButton rdbDescCli, JRadioButton rdbCodPro,
			JRadioButton rdbDescPro, JComboBox<Cliente> cmbCliente, JComboBox<Produto> cmbProduto, JSpinner spnQuant,
			JTextField tfCliente, JTextField tfProduto, JTextField tfValorUnit, JTextField tfGenero) {
		
		super(rdbCodCli, rdbDescCli, rdbCodPro, rdbDescPro, cmbCliente, cmbProduto,  spnQuant,
				tfCliente, tfProduto, tfValorUnit, tfGenero);

	}

}
