package controllers;

import javax.swing.JTextField;

import interfaces.AbstractCadastroController;

public class CadastroProdutoController extends AbstractCadastroController{
	
	public CadastroProdutoController (JTextField txCodigo, JTextField txDescricao, JTextField txQuant, 
			JTextField txEan, JTextField txEanUnidTrib, JTextField txExIpi, JTextField txGenero,
			JTextField txNcm, JTextField txQntTrib, JTextField txUnidCom, JTextField txUnidTrib, 
			JTextField txValorUnidCom, JTextField txValorUnidTrib) {
		
		super(txCodigo,  txDescricao, txQuant, txEan, txEanUnidTrib, txExIpi, txGenero, txNcm, 
				txQntTrib, txUnidCom, txUnidTrib, txValorUnidCom, txValorUnidTrib);
	}

	@Override
	protected void cadastrar() {
		// TODO Auto-generated method stub
		
	}	
}
