package controllers;

import javax.swing.JTable;
import javax.swing.JTextField;

import entidades.Transportadora;
import interfaces.AbstractListarController;
import interfaces.AbstractTableCrud;

public class ListarTransportadoraController extends AbstractListarController <Transportadora>{
	
	public ListarTransportadoraController(JTextField text, JTable tabela, AbstractTableCrud<Transportadora> modelo) {
		super(text, tabela, modelo);
	}
}
