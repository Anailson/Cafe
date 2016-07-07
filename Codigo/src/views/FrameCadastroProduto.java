package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.CadastroProdutoController;
import interfaces.AbstractCadastroController;
import net.miginfocom.swing.MigLayout;

public class FrameCadastroProduto extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField tfCodigo, tfDescricao, tfQuant, tfEan, tfEanUnidTrib, tfExIpi, tfGenero, tfNcm, tfQntTrib,
			tfUnidCom, tfUnidTrib, tfValorUnidCom, tfValorUnidTrib;
	private JButton btCadastrar, btCancelar, btLimpar;

	public FrameCadastroProduto(String titulo) {

		tfCodigo = new JTextField();
		tfDescricao = new JTextField();
		tfQuant = new JTextField();
		tfEan = new JTextField();
		tfEanUnidTrib = new JTextField();
		tfExIpi = new JTextField();
		tfGenero = new JTextField();
		tfNcm = new JTextField();
		tfQntTrib = new JTextField();
		tfUnidCom = new JTextField();
		tfUnidTrib = new JTextField();
		tfValorUnidCom = new JTextField();
		tfValorUnidTrib = new JTextField();

		btCadastrar = new JButton(FramePrincipal.BTN_CADASTRAR);
		btLimpar = new JButton(FramePrincipal.BTN_LIMPAR);
		btCancelar = new JButton(FramePrincipal.BTN_CANCELAR);

		configurarCompomentes();
		configurarLayout(titulo);
		configurarEventos();
	}

	private void configurarCompomentes() {

		this.setBackground(Color.white);
	}

	public void configurarLayout(String titulo) {

		setLayout(new MigLayout("", "[grow]", "[100px:n][][grow][40px:n][5px:n]"));

		JPanel pnlProduto = new JPanel();
		JPanel pnlBotoes = new JPanel();
		JLabel lbTitulo = new JLabel(titulo);
		JLabel lbCodigo = new JLabel("Codigo:");
		JLabel lbDescricao = new JLabel("Descricao:");
		JLabel lbQuant = new JLabel("Quantidade:");
		JLabel lbEan = new JLabel("EAN:");
		JLabel lbEanUnidTrib = new JLabel("EAN Unid. Trib.:");
		JLabel lbExIpi = new JLabel("EX IPI:");
		JLabel lbGenero = new JLabel("Genero:");
		JLabel lbNcm = new JLabel("NCM:");
		JLabel lbQntTrib = new JLabel("Quant. Trib.:");
		JLabel lbUnidCom = new JLabel("Unid. Comp.:");
		JLabel lbUnidTrib = new JLabel("Unid. Trib.:");
		JLabel lbValorUnidCom = new JLabel("Valor Unid. Com.:");
		JLabel lbValorUnidTrib = new JLabel("Valor Unid. Trb.:");

		lbTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));

		add(lbTitulo, "cell 0 0");
		add(pnlProduto, "cell 0 1,grow");
		add(pnlBotoes, "cell 0 3,grow");

		pnlProduto.setLayout(new MigLayout("", "[5px:n][][100px:n][15px:n][][100px:n][15px:n][][100px:n][grow][5px:n]",
				"[5px:n][40px:n][40px:n][40px:n][40px:n][40px:n][5px:n]"));

		pnlProduto.add(lbDescricao, "cell 1 1,alignx trailing");
		pnlProduto.add(tfDescricao, "cell 2 1 8 1,grow");
		pnlProduto.add(lbCodigo, "cell 1 2");
		pnlProduto.add(tfCodigo, "cell 2 2,grow");
		pnlProduto.add(lbQuant, "cell 4 2");
		pnlProduto.add(tfQuant, "cell 5 2,grow");
		pnlProduto.add(lbGenero, "cell 7 2");
		pnlProduto.add(tfGenero, "cell 8 2 2 1,grow");
		pnlProduto.add(lbEan, "cell 1 3");
		pnlProduto.add(tfEan, "cell 2 3,grow");
		pnlProduto.add(lbEanUnidTrib, "cell 4 3");
		pnlProduto.add(tfEanUnidTrib, "cell 5 3,grow");
		pnlProduto.add(lbExIpi, "cell 7 3");
		pnlProduto.add(tfExIpi, "cell 8 3,grow");
		pnlProduto.add(lbNcm, "cell 1 4");
		pnlProduto.add(tfNcm, "cell 2 4,grow");
		pnlProduto.add(lbUnidCom, "cell 4 4");
		pnlProduto.add(tfUnidCom, "cell 5 4,grow");
		pnlProduto.add(lbValorUnidCom, "cell 7 4");
		pnlProduto.add(tfValorUnidCom, "cell 8 4,grow");
		pnlProduto.add(lbUnidTrib, "cell 1 5");
		pnlProduto.add(tfUnidTrib, "cell 2 5,grow");
		pnlProduto.add(lbQntTrib, "cell 4 5");
		pnlProduto.add(tfQntTrib, "cell 5 5,grow");
		pnlProduto.add(lbValorUnidTrib, "cell 7 5");
		pnlProduto.add(tfValorUnidTrib, "cell 8 5,grow");

		tfDescricao.setColumns(10);
		tfCodigo.setColumns(10);
		tfQuant.setColumns(10);
		tfGenero.setColumns(10);
		tfEan.setColumns(10);
		tfEanUnidTrib.setColumns(10);
		tfExIpi.setColumns(10);
		tfNcm.setColumns(10);
		tfUnidCom.setColumns(10);
		tfValorUnidCom.setColumns(10);
		tfUnidTrib.setColumns(10);
		tfUnidTrib.setColumns(10);
		tfValorUnidTrib.setColumns(10);

		pnlBotoes.setLayout(new MigLayout("", "[grow][][][][grow]", "[40px:n]"));
		pnlBotoes.add(btCadastrar, "cell 1 0,growy");
		pnlBotoes.add(btLimpar, "cell 2 0,growy");
		;
		pnlBotoes.add(btCancelar, "cell 3 0,growy");
	}

	private void configurarEventos() {

		CadastroProdutoController controller = new CadastroProdutoController(tfCodigo, tfDescricao, tfQuant, tfEan,
				tfEanUnidTrib, tfExIpi, tfGenero, tfNcm, tfQntTrib, tfUnidCom, tfUnidTrib, tfValorUnidCom,
				tfValorUnidTrib);

		btCadastrar.addActionListener(controller.getActionListener(AbstractCadastroController.CADASTRAR));
		btLimpar.addActionListener(controller.getActionListener(AbstractCadastroController.LIMPAR));
		btCancelar.addActionListener(controller.getActionListener(AbstractCadastroController.CANCELAR));
	}
}
