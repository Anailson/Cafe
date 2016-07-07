package views;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.CadastroTransportadoraController;
import interfaces.AbstractCadastroController;
import net.miginfocom.swing.MigLayout;

public class FrameCadastroTransportadora extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private static final String[] ESTADOS = new String[] { " ", "SE", "BA" };
	private static final String[] DOCUMENTO = new String[] {"CPF" , "CNPJ" };
			
	private JTextField tfNome, tfLogradouro, tfEmail, tfNumero, tfComplemento, tfBairro, tfPais, tfMunicipio;
	private JFormattedTextField tfCep, tfTipoDocumento, tfInscricaoEstadual, tfTelefone;
	private JComboBox<String> cmbTipoDocumento, cmbUf;
	private JCheckBox chbIsentoIcms;
	private JButton btnCadastrar, btnLimpar, btnCancelar;
	

	public FrameCadastroTransportadora(String titulo) {
		
		tfNome = new JTextField();
		tfLogradouro = new JTextField();
		tfNumero = new JTextField();
		tfComplemento = new JTextField();
		tfBairro = new JTextField();
		tfPais = new JTextField();
		tfMunicipio = new JTextField();
		tfEmail = new JTextField();

		tfInscricaoEstadual = new JFormattedTextField();
		tfCep = new JFormattedTextField();
		tfTipoDocumento = new JFormattedTextField();
		tfTelefone = new JFormattedTextField();

		cmbTipoDocumento = new JComboBox<String>(DOCUMENTO);
		cmbUf = new JComboBox<String>(ESTADOS);
		
		chbIsentoIcms = new JCheckBox("Isento do ICMS:", false);
		
		btnCadastrar = new JButton(FramePrincipal.BTN_CADASTRAR);
		btnLimpar = new JButton(FramePrincipal.BTN_LIMPAR);
		btnCancelar = new JButton(FramePrincipal.BTN_CANCELAR);
		
		iniciarComponentes();
		iniciarLayout(titulo);
		iniciarEventos();
	}
	
	private void iniciarComponentes(){

		try {
			FramePrincipal.mascaraTelefone(tfTelefone);
			FramePrincipal.mascaraCep(tfCep);
			FramePrincipal.mascaraDocumento(tfTipoDocumento, cmbTipoDocumento.getSelectedItem()+ "");
			FramePrincipal.mascaraInscricao(tfInscricaoEstadual);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		tfMunicipio.setEnabled(false);
		
		this.setBackground(Color.WHITE);
	}
	
	private void iniciarLayout(String titulo){
		
		this.setLayout(new MigLayout("", "[grow]", "[100px:100px][][::10px][10px:n][][grow][40px:n][::5px]"));

		JPanel pnlTransportadora = new JPanel();
		JPanel pnlEndereco = new JPanel();
		JPanel pnlBotoes = new JPanel();

		JLabel lbTitulo = new JLabel(titulo);
		JLabel lbNome = new JLabel("Nome Fantasia:");
		JLabel lbEmail = new JLabel("E-mail:");
		JLabel lbTelefone = new JLabel("Telefone:");
		JLabel lbLogradouro = new JLabel("Rua:");
		JLabel lbNumero = new JLabel("Nº:");
		JLabel lbComplemento = new JLabel("Complemento:");
		JLabel lbBairro = new JLabel("Bairro:");
		JLabel lbMunicipio = new JLabel("Cidade:");
		JLabel lbUf = new JLabel("Estado:");
		JLabel lbCep = new JLabel("CEP:");
		JLabel lbInscricaoEstadual = new JLabel("Nº de Inscrição:");
		
		lbTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));

		this.add(lbTitulo, "cell 0 0");
		this.add(pnlTransportadora, "cell 0 1,grow");
		this.add(pnlEndereco, "cell 0 4,grow");
		this.add(pnlBotoes, "cell 0 6,grow");
		
		pnlTransportadora.setBorder(BorderFactory.createTitledBorder("Dados do transportadora"));
		pnlTransportadora.setBackground(Color.WHITE);
		pnlTransportadora.setLayout(new MigLayout("",
				"[::5px][][][15px:n][][100px:n][100px:n][100px:n][15px:n][][grow][15px:n][][100px:n][::5px]",
				"[::5px][40px:n][40px:n][40px:n][::5px]"));

		pnlTransportadora.add(lbNome, "cell 1 1");
		pnlTransportadora.add(tfNome, "cell 2 1 12 1,grow");
		pnlTransportadora.add(lbEmail, "cell 1 2");
		pnlTransportadora.add(tfEmail, "cell 2 2 9 1,grow");
		pnlTransportadora.add(lbTelefone, "cell 12 2,alignx right");
		pnlTransportadora.add(tfTelefone, "cell 13 2,grow");
		pnlTransportadora.add(chbIsentoIcms, "cell 1 3 2 1");
		pnlTransportadora.add(lbInscricaoEstadual, "cell 4 3,alignx right");
		pnlTransportadora.add(tfInscricaoEstadual, "cell 5 3,grow");
		pnlTransportadora.add(cmbTipoDocumento, "cell 6 3,alignx right,growy");
		pnlTransportadora.add(tfTipoDocumento, "cell 7 3,grow");

		tfNome.setColumns(10);
		tfEmail.setColumns(10);
		tfInscricaoEstadual.setColumns(10);
		
		pnlEndereco.setBorder(BorderFactory.createTitledBorder("Endereço"));
		pnlEndereco.setBackground(Color.WHITE);
		pnlEndereco.setLayout(new MigLayout("", "[5px][][][grow][15px:n][][][grow][15px:n][][100px][5px]",
				"[5px][40px:n][40px:n][40px:n][5px]"));

		pnlEndereco.add(lbLogradouro, "cell 1 1");
		pnlEndereco.add(tfLogradouro, "cell 2 1 6 1,grow");
		pnlEndereco.add(lbNumero, "cell 9 1");
		pnlEndereco.add(tfNumero, "cell 10 1,grow");
		pnlEndereco.add(lbComplemento, "cell 1 2");
		// pnlEndereco.add(tfComplemento, "cell 2 2 2 1,grow");
		pnlEndereco.add(lbBairro, "cell 5 2,alignx trailing");
		pnlEndereco.add(tfBairro, "cell 6 2 2 1,grow");
		pnlEndereco.add(lbCep, "cell 9 2,alignx trailing");
		pnlEndereco.add(tfCep, "cell 10 2,grow");
		pnlEndereco.add(lbMunicipio, "cell 1 3,alignx left");
		pnlEndereco.add(tfMunicipio, "cell 2 3 2 1,grow");
		pnlEndereco.add(lbUf, "cell 5 3,alignx trailing");
		pnlEndereco.add(cmbUf, "cell 6 3,growy");

		tfLogradouro.setColumns(10);
		// tfComplemento.setColumns(10);
		tfNumero.setColumns(10);
		tfBairro.setColumns(10);
		tfMunicipio.setColumns(10);

		pnlBotoes.setBackground(Color.WHITE);
		pnlBotoes.setLayout(new MigLayout("", "[grow 50][][][][grow 50]", "[40px:n]"));

		pnlBotoes.add(btnCadastrar, "cell 1 0,growy");
		pnlBotoes.add(btnLimpar, "cell 2 0,growy");
		pnlBotoes.add(btnCancelar, "cell 3 0,growy");
	}
	
	
	private void iniciarEventos(){
		
		CadastroTransportadoraController controller = new CadastroTransportadoraController(
				tfNome, tfTipoDocumento, tfInscricaoEstadual, tfLogradouro, tfEmail, tfTelefone, tfNumero, 
				tfComplemento, tfBairro, tfCep, tfPais,	tfMunicipio, 
				cmbTipoDocumento, cmbUf, chbIsentoIcms);
		
		btnCadastrar.addActionListener(controller.getActionListener(AbstractCadastroController.CADASTRAR));
		btnLimpar.addActionListener(controller.getActionListener(AbstractCadastroController.LIMPAR));
		btnCancelar.addActionListener(controller.getActionListener(AbstractCadastroController.CANCELAR));

		cmbUf.addItemListener(controller.getItemListener(CadastroTransportadoraController.UF));
		cmbTipoDocumento.addItemListener(controller.getItemListener(CadastroTransportadoraController.DOCUMENTO));
	}
}
