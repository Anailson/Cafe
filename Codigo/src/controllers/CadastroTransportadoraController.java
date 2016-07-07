package controllers;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import interfaces.AbstractCadastroController;

public class CadastroTransportadoraController extends AbstractCadastroController{
	
	public static final int UF = 0; 
	public static final int DOCUMENTO = 1;
	
	private JTextField txDocumento, txMunicipio;
	private JComboBox<String> cmbTipoDocumento, cmbUf;	
	
	public CadastroTransportadoraController(JTextField txNome, JTextField txDocumento, JTextField txInscricaoEstadual,
			JTextField txLogradouro, JTextField txEmail, JTextField txTelefone, JTextField txNumero, 
			JTextField txComplemento, JTextField txBairro, JTextField txCep, JTextField txPais, JTextField txMunicipio, 
			JComboBox<String> cmbTipoDocumento, JComboBox<String> cmbUf, JCheckBox chbIsentoIcms) {
		
		super(txNome, txDocumento, txInscricaoEstadual, txLogradouro, txEmail, txTelefone, txNumero, 
				txComplemento,  txBairro, txCep, txPais, txMunicipio, cmbTipoDocumento, cmbUf, chbIsentoIcms);
		
		this.txDocumento = txDocumento;
		this.txMunicipio = txMunicipio;
		this.cmbTipoDocumento = cmbTipoDocumento;
		this.cmbUf = cmbUf;
	}
	
	public ItemListener getItemListener(int id){
		return new AddItemListener(id);
	}
	
	private void tipoDocumentoAlterado(){
		
		int index = cmbTipoDocumento.getSelectedIndex();
		
		if(index != 0){
			txDocumento.setEnabled(true);
		} else {
			txDocumento.setEnabled(false);
		}
	}
	
	private void ufAlterado(){
		
		int index = cmbUf.getSelectedIndex();
		
		if( index != 0){
			txMunicipio.setEnabled(true);
		} else {
			txMunicipio.setEnabled(false);
		}
	}
	
	private class AddItemListener implements ItemListener{

		private int id;
		
		public AddItemListener(int id) {
			this.id = id;
		}
		
		@Override
		public void itemStateChanged(ItemEvent actEvt) {
			
			switch(id){
				case UF:{
					
					ufAlterado();		
					break;
					
				} case DOCUMENTO :{
					
					tipoDocumentoAlterado();		
					break;
				}
			}	
		}		
	}

	@Override
	protected void cadastrar() {
		// TODO Auto-generated method stub
		
	}
}
