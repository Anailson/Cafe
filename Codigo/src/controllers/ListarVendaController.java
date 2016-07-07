package controllers;

import javax.swing.JTable;
import javax.swing.JTextField;

import entidades.Venda;
import interfaces.AbstractListarController;
import interfaces.AbstractTableCrud;

public class ListarVendaController extends AbstractListarController<Venda> {

	public ListarVendaController(JTextField text, JTable tabela, 
			AbstractTableCrud<Venda> modelo) {
		super(text, tabela, modelo);
	}

}
