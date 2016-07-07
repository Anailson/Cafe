package views;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.CadastroProdutoController;

public class FrameCadastroCliente {
	
	private static final String[] IMPOSTOS = new String[]{"Simples", "- - -"};
	private static final String[] ESTADOS = new String []{"SE", "BA"};
	
	public static final String CADASTRAR = "Cadastrar";
	public static final String LIMPAR = "Limpar";
	public static final String CANCELAR = "Cancelar";
	
	private JPanel panelCliente;
	private JLabel lbNomeFantasia, lbEmail, lbTelefone, lbRua, lbNumero, lbBairro,
		    	   lbCidade, lbEstado, lbCep, lbCpfCnpj, lbNInscricao, lbTipoImposto;
	private JButton btCadastrar, btLimpar, btCancelar;
	private JTextField tfNomeFantasia, tfEmail, tfTelefone, tfRua, tfNumero, tfBairro, 
					   tfCidade, tfCep, tfCpfCnpj, tfNInscricao;
	private JComboBox<String> cbEstado, cbTipoImposto;
	
	public FrameCadastroCliente(Color c) {
		
		panelCliente = new JPanel();
		
		lbNomeFantasia = new JLabel("Nome Fantasia:");
		lbEmail = new JLabel("E-mail:");
		lbTelefone = new JLabel("Telefone:");
		lbRua = new JLabel("Rua:");
		lbNumero = new JLabel("Nº:");
		lbBairro = new JLabel("Bairro:");
		lbCidade = new JLabel("Cidade:");
		lbEstado = new JLabel("Estado:");
		lbCep = new JLabel("CEP:");
		lbCpfCnpj = new JLabel("CPF/CNPJ:");
		lbNInscricao = new JLabel("Nº de Inscrição:");
		lbTipoImposto = new JLabel("Tipo de Imposto:");
		
		btCadastrar = new JButton(CADASTRAR);
		btLimpar = new JButton(LIMPAR);
		btCancelar = new JButton(CANCELAR);
		
		tfNomeFantasia = new JTextField();
		tfEmail = new JTextField();
		tfTelefone = new JTextField();
		tfRua = new JTextField();
		tfNumero = new JTextField();
		tfBairro = new JTextField();
		tfCidade = new JTextField();
		tfCep = new JTextField();
		tfCpfCnpj = new JTextField();
		tfNInscricao = new JTextField();
		
		cbEstado = new JComboBox<>(ESTADOS);
		cbTipoImposto = new JComboBox<>(IMPOSTOS);
		
		configurarComponentes(c);
		configurarEventos();
	}
	
	private void configurarComponentes(Color c){
		
		panelCliente.setLayout(null);
		panelCliente.setBackground(c);
		
		panelCliente.add(lbNomeFantasia);
		panelCliente.add(lbEmail);
		panelCliente.add(lbTelefone);
		panelCliente.add(lbRua);
		panelCliente.add(lbNumero);
		panelCliente.add(lbBairro);
		panelCliente.add(lbCidade);
		panelCliente.add(lbEstado);
		panelCliente.add(lbCep);
		panelCliente.add(lbCpfCnpj);
		panelCliente.add(lbNInscricao);
		panelCliente.add(lbTipoImposto);
		
		panelCliente.add(btCadastrar);
		panelCliente.add(btLimpar);
		panelCliente.add(btCancelar);
		
		panelCliente.add(tfNomeFantasia);
		panelCliente.add(tfEmail);
		panelCliente.add(tfTelefone);
		panelCliente.add(tfRua);
		panelCliente.add(tfNumero);
		panelCliente.add(tfBairro);
		panelCliente.add(tfCidade);
		panelCliente.add(tfCep);
		panelCliente.add(tfCpfCnpj);
		panelCliente.add(tfNInscricao);
		
		cbEstado.setSelectedItem(0);
		cbTipoImposto.setSelectedItem(0);
		
		panelCliente.add(cbEstado);
		panelCliente.add(cbTipoImposto);
		
		lbNomeFantasia.setBounds(25, 20, 100, 20);
		lbEmail.setBounds(25, 70, 60, 20);
		lbRua.setBounds(25, 120, 60, 20);
		lbBairro.setBounds(25, 170, 60, 20);
		lbCep.setBounds(470, 120, 60, 20);
		lbCpfCnpj.setBounds(25, 220, 80, 20);
		lbTelefone.setBounds(410, 70, 60, 20);
		lbNumero.setBounds(350, 120, 60, 20);
		lbCidade.setBounds(260, 170, 60, 20);
		lbEstado.setBounds(535, 170, 60, 20);
		lbNInscricao.setBounds(260, 220, 100, 20);
		lbTipoImposto.setBounds(480, 220, 100, 20);
		
		btCadastrar.setBounds(180,300,100, 30);
		btLimpar.setBounds(290,300,100, 30);
		btCancelar.setBounds(400,300,100, 30);
		
		tfNomeFantasia.setBounds(115, 18, 545, 25);
		tfEmail.setBounds(115, 68, 280, 25);
		tfTelefone.setBounds(470, 68, 190, 25);
		tfRua.setBounds(115, 118, 225, 25);
		tfNumero.setBounds(370, 118, 85, 25);
		tfCep.setBounds(500, 118, 160, 25);
		tfBairro.setBounds(115, 168, 135, 25);
		tfCidade.setBounds(310, 168, 210, 25);
		cbEstado.setBounds(585, 168, 75, 25);
		tfCpfCnpj.setBounds(115, 218, 135, 25);
		tfNInscricao.setBounds(350,218,120, 25);
		cbTipoImposto.setBounds(575, 218, 85, 25);
	}
	
	private void configurarEventos(){
		
		btCadastrar.addActionListener(new CadastroProdutoController(CADASTRAR));
		btLimpar.addActionListener(new CadastroProdutoController(LIMPAR));
		btCancelar.addActionListener(new CadastroProdutoController(CANCELAR));
	}
	
	public JPanel getPanel(){
		return panelCliente;
	}
}
