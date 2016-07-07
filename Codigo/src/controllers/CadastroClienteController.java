package controllers;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import entidades.Cliente;
import entidades.Endereco;
import interfaces.AbstractCadastroController;
import models.CadastroClienteModel;

public class CadastroClienteController extends AbstractCadastroController {

	// Controller para cadastro de clientes
	private JTextField tfNomeFantasia, tfEmail, tfTelefone, tfRua, tfNumero, tfBairro, tfCidade, tfCep, tfCpfCnpj,
			tfNInscricao;
	private JComboBox<String> cbEstado, cbTipoImposto, cbDocumento;
	private JCheckBox chbIsentoIcms;
	CadastroClienteModel model;

	public CadastroClienteController(JTextField tfNomeFantasia, JCheckBox chbIsentoIcms, JTextField tfEmail, 
			JTextField tfTelefone, JTextField tfRua, JTextField tfNumero, JTextField tfBairro, JTextField tfCidade, JTextField tfCep,
			JTextField tfCpfCnpj, JTextField tfNInscricao, JComboBox<String> cbEstado,
			JComboBox<String> cbTipoImposto) {
		// Inicializa o construtor da classe mãe AbstractCadastroController
		super(tfNomeFantasia, tfEmail, tfTelefone, tfRua, tfNumero, tfBairro, tfCidade, tfCep, tfCpfCnpj, tfNInscricao,
				cbEstado, cbTipoImposto);
		// Pega a referência dos objetos do frame para enviá-los para o model
		this.tfNomeFantasia = tfNomeFantasia;
		this.tfEmail = tfEmail;
		this.tfTelefone = tfTelefone;
		this.tfRua = tfRua;
		this.tfNumero = tfNumero;
		this.tfBairro = tfBairro;
		this.tfCidade = tfCidade;
		this.tfCep = tfCep;
		this.tfCpfCnpj = tfCpfCnpj;
		this.tfNInscricao = tfNInscricao;
		this.cbEstado = cbEstado;
		this.cbTipoImposto = cbTipoImposto;
		this.cbDocumento = cbDocumento;
		this.chbIsentoIcms = chbIsentoIcms;
		this.model = new CadastroClienteModel();
	}

	// método cadastrar com particularidades de cliente
	@Override
	protected void cadastrar() {
		
		String uf = (String) cbEstado.getSelectedItem();
		String tipoImposto = (String) cbTipoImposto.getSelectedItem();
		boolean tipoImpostoBool;
		
		if (tipoImposto.equalsIgnoreCase("Simples")) {
			tipoImpostoBool = true;
		} else {
			tipoImpostoBool = false;
		} 
		
		Endereco endereco = new Endereco(tfRua.getText(), tfNumero.getText(), tfBairro.getText(), tfCep.getText(), 
				uf, tfCidade.getText());
		Cliente cliente = new Cliente(tfNomeFantasia.getText(), chbIsentoIcms.isSelected(), tfCpfCnpj.getText(), 
				tfTelefone.getText(), tfEmail.getText(), endereco, tfNInscricao.getText(), tipoImpostoBool);
		model.inserir(cliente);
	}
}
