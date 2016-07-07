package controllers;

import javax.swing.JTable;
import javax.swing.JTextField;

import entidades.Fornecedor;
import interfaces.AbstractListarController;
import interfaces.AbstractTableCrud;

public class ListarFornecedorController extends AbstractListarController <Fornecedor>{
	
	public ListarFornecedorController(JTextField text, JTable tabela, AbstractTableCrud<Fornecedor> modelo) {
		super(text, tabela, modelo);
	}
}
