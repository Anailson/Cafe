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

import controllers.CadastroClienteController;
import interfaces.AbstractCadastroController;
import net.miginfocom.swing.MigLayout;

public class FrameCadastroCliente extends JPanel {

	// Gambiarra do java para extender quqlquer coisa da biblioteca swing
	private static final long serialVersionUID = 1L;

	// Tipos de impostos e estados definidos como final para utilizar nos
	// JComboBox do frame
	private static final String[] IMPOSTOS = new String[] { "Simples", "- - -" };
	private static final String[] ESTADOS = new String[] { " ", "SE", "BA" };
	private static final String[] DOCUMENTO = new String[] {"CPF" , "CNPJ" };

	private JButton btCadastrar, btLimpar, btCancelar;
	private JFormattedTextField tfTelefone, tfCep, tfDocumento, tfNInscricao;
	private JTextField tfNomeFantasia, tfEmail, tfRua, tfNumero, tfBairro, tfCidade;
	private JComboBox<String> cbEstado, cbTipoImposto, cbDocumento;
	private JCheckBox chbIsentoCPMF;

	// Construtor da classe
	public FrameCadastroCliente(String titulo) {
		// Inicialização dos componentes

		btCadastrar = new JButton(FramePrincipal.BTN_CADASTRAR);
		btLimpar = new JButton(FramePrincipal.BTN_LIMPAR);
		btCancelar = new JButton(FramePrincipal.BTN_CANCELAR);

		tfNomeFantasia = new JTextField();
		tfEmail = new JTextField();
		tfRua = new JTextField();
		tfNumero = new JTextField();
		tfBairro = new JTextField();
		tfCidade = new JTextField();

		tfTelefone = new JFormattedTextField();
		tfCep = new JFormattedTextField();
		tfDocumento = new JFormattedTextField();
		tfNInscricao = new JFormattedTextField();

		cbEstado = new JComboBox<>(ESTADOS);
		cbTipoImposto = new JComboBox<>(IMPOSTOS);
		cbDocumento = new JComboBox<>(DOCUMENTO);

		chbIsentoCPMF = new JCheckBox("Isento do CPMF", false);

		configurarComponentes();
		configurarLayout(titulo);
		configurarEventos();
	}

	// Método de configuração dos componentes
	private void configurarComponentes() {

		try {
			
			FramePrincipal.mascaraTelefone(tfTelefone);
			FramePrincipal.mascaraCep(tfCep);
			FramePrincipal.mascaraDocumento(tfDocumento, cbDocumento.getSelectedItem()+ "");
			FramePrincipal.mascaraInscricao(tfNInscricao);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		tfCidade.setEnabled(false);

		this.setBackground(Color.WHITE);
	}

	// criação do layout manager de todo o frameCadastroCliente
	private void configurarLayout(String titulo) {

		this.setLayout(new MigLayout("", "[grow]", "[100px:100px][][::10px][10px:n][][grow][40px:n][::5px]"));

		JPanel pnlCliente = new JPanel();
		JPanel pnlEndereco = new JPanel();
		JPanel pnlBotoes = new JPanel();

		JLabel lbTitulo = new JLabel(titulo);
		JLabel lbNomeFantasia = new JLabel("Nome Fantasia:");
		JLabel lbEmail = new JLabel("E-mail:");
		JLabel lbTelefone = new JLabel("Telefone:");
		JLabel lbRua = new JLabel("Rua:");
		JLabel lbNumero = new JLabel("Nº:");
		JLabel lbComplemento = new JLabel("Complemento:");
		JLabel lbBairro = new JLabel("Bairro:");
		JLabel lbCidade = new JLabel("Cidade:");
		JLabel lbEstado = new JLabel("Estado:");
		JLabel lbCep = new JLabel("CEP:");
		JLabel lbNInscricao = new JLabel("Nº de Inscrição:");
		JLabel lbTipoImposto = new JLabel("Tipo de Imposto:");

		lbTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));

		this.add(lbTitulo, "cell 0 0");
		this.add(pnlCliente, "cell 0 1,grow");
		this.add(pnlEndereco, "cell 0 4,grow");
		this.add(pnlBotoes, "cell 0 6,grow");

		pnlCliente.setBorder(BorderFactory.createTitledBorder("Dados do cliente"));
		pnlCliente.setBackground(Color.WHITE);
		pnlCliente.setLayout(new MigLayout("",
				"[::5px][][][15px:n][][100px:n][100px:n][100px:n][15px:n][][grow][15px:n][][100px:n][::5px]",
				"[::5px][40px:n][40px:n][40px:n][::5px]"));

		pnlCliente.add(lbNomeFantasia, "cell 1 1");
		pnlCliente.add(tfNomeFantasia, "cell 2 1 12 1,grow");
		pnlCliente.add(lbEmail, "cell 1 2");
		pnlCliente.add(tfEmail, "cell 2 2 9 1,grow");
		pnlCliente.add(lbTelefone, "cell 12 2");
		pnlCliente.add(tfTelefone, "cell 13 2,grow");
		pnlCliente.add(chbIsentoCPMF, "cell 1 3 2 1");
		pnlCliente.add(lbNInscricao, "cell 4 3");
		pnlCliente.add(tfNInscricao, "cell 5 3,grow");
		pnlCliente.add(cbDocumento, "cell 6 3,alignx right,growy");
		pnlCliente.add(tfDocumento, "cell 7 3,grow");
		pnlCliente.add(lbTipoImposto, "cell 9 3,alignx right");
		pnlCliente.add(cbTipoImposto, "cell 10 3,growy");

		tfNomeFantasia.setColumns(10);
		tfEmail.setColumns(10);
		tfNInscricao.setColumns(10);

		pnlEndereco.setBorder(BorderFactory.createTitledBorder("Endereço"));
		pnlEndereco.setBackground(Color.WHITE);
		pnlEndereco.setLayout(new MigLayout("", "[5px][][][grow][15px:n][][][grow][15px:n][][100px][5px]",
				"[5px][40px:n][40px:n][40px:n][5px]"));

		pnlEndereco.add(lbRua, "cell 1 1");
		pnlEndereco.add(tfRua, "cell 2 1 6 1,grow");
		pnlEndereco.add(lbNumero, "cell 9 1");
		pnlEndereco.add(tfNumero, "cell 10 1,grow");
		pnlEndereco.add(lbComplemento, "cell 1 2");
		// pnlEndereco.add(tfComplemento, "cell 2 2 2 1,grow");
		pnlEndereco.add(lbBairro, "cell 5 2,alignx trailing");
		pnlEndereco.add(tfBairro, "cell 6 2 2 1,grow");
		pnlEndereco.add(lbCep, "cell 9 2,alignx trailing");
		pnlEndereco.add(tfCep, "cell 10 2,grow");
		pnlEndereco.add(lbCidade, "cell 1 3,alignx left");
		pnlEndereco.add(tfCidade, "cell 2 3 2 1,grow");
		pnlEndereco.add(lbEstado, "cell 5 3,alignx trailing");
		pnlEndereco.add(cbEstado, "cell 6 3,growy");

		tfRua.setColumns(10);
		// tfComplemento.setColumns(10);
		tfNumero.setColumns(10);
		tfBairro.setColumns(10);
		tfCidade.setColumns(10);

		pnlBotoes.setBackground(Color.WHITE);
		pnlBotoes.setLayout(new MigLayout("", "[grow 50][][][][grow 50]", "[40px:n]"));

		pnlBotoes.add(btCadastrar, "cell 1 0,growy");
		pnlBotoes.add(btLimpar, "cell 2 0,growy");
		pnlBotoes.add(btCancelar, "cell 3 0,growy");
	}

	// Método que cria a classe controller vinculada ao frame e adiciona as
	// ações dos botões com este controller
	private void configurarEventos() {

		CadastroClienteController controller = new CadastroClienteController(tfNomeFantasia, chbIsentoCPMF, 
				tfEmail, tfTelefone, tfRua, tfNumero, tfBairro, tfCidade, tfCep, tfDocumento, tfNInscricao, 
				cbEstado, cbTipoImposto);

		btCadastrar.addActionListener(controller.getActionListener(AbstractCadastroController.CADASTRAR));
		btLimpar.addActionListener(controller.getActionListener(AbstractCadastroController.LIMPAR));
		btCancelar.addActionListener(controller.getActionListener(AbstractCadastroController.CANCELAR));
	}

}
