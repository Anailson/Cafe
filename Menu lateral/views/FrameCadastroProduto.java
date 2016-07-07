package views;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import controllers.CadastroProdutoController;

public class FrameCadastroProduto {


	public static final String CADASTRAR = "Cadastrar";
	public static final String LIMPAR = "Limpar";
	public static final String CANCELAR = "Cancelar";

	
	private JPanel pnlProduto;
	private JLabel lbCodigo, lbDescricao, lbEan, lbEanUnidTrib,  lbExIpi,  lbGenero, lbNcm, 
			lbQntTrib, lbUnidCom, lbUnidTrib,  lbValorUnidCom,  lbValorUnidTrib;
	private JTextField txCodigo,  txDescricao, txEan, txEanUnidTrib, txExIpi, txGenero,
			txNcm, txQntTrib, txUnidCom, txUnidTrib, txValorUnidCom, txValorUnidTrib;
	private JButton btnCadastrar, btnCancelar, btnLimpar;

	public FrameCadastroProduto() {
		
		pnlProduto = new JPanel();
		lbCodigo = new JLabel("Codigo:");
		lbDescricao = new JLabel("Descricao:");
		lbEan = new JLabel("EAN:");
		lbEanUnidTrib = new JLabel("EAN Unid. Trib.:");
		lbExIpi = new JLabel("EX IPI:");
		lbGenero = new JLabel("Genero:");
		lbNcm = new JLabel("NCM:");
		lbQntTrib = new JLabel("Quant. Trib.:");
		lbUnidCom = new JLabel("Unid. Comp.:");
		lbUnidTrib = new JLabel("Unid. Trib.:");
		lbValorUnidCom = new JLabel("Valor Unid. Com.:");
		lbValorUnidTrib = new JLabel("Valor Unid. Trb.:");
		
		txCodigo = new JTextField();
		txDescricao = new JTextField();
		txEan = new JTextField();
		txEanUnidTrib = new JTextField();
		txExIpi = new JTextField();
		txGenero = new JTextField();
		txNcm = new JTextField();
		txQntTrib = new JTextField();
		txUnidCom = new JTextField();
		txUnidTrib = new JTextField();
		txValorUnidCom = new JTextField();
		txValorUnidTrib = new JTextField();
		
		btnCadastrar = new JButton(CADASTRAR);
		btnLimpar = new JButton(LIMPAR);
		btnCancelar = new JButton(CANCELAR);
		
		configurarEventos();
		configurarCompomentes();
	}
	
	private void configurarEventos(){
		
		btnCadastrar.addActionListener(new CadastroProdutoController(CADASTRAR));
		btnLimpar.addActionListener(new CadastroProdutoController(LIMPAR));
		btnCancelar.addActionListener(new CadastroProdutoController(CANCELAR));
	}
	
	private void configurarCompomentes(){
		
		pnlProduto.setBackground(Color.white);
		pnlProduto.setLayout(getLayoutPrincipal());
	}
	
	public GroupLayout getLayoutPrincipal(){
		
		GroupLayout layout = new GroupLayout(pnlProduto);
		
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(60, 60, 60)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(lbDescricao)
								.addComponent(lbCodigo)
								.addComponent(lbEan)
								.addComponent(lbUnidCom)
								.addComponent(lbUnidTrib))
						.addGap(4, 4, 4)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(txDescricao)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
												.addComponent(txUnidCom, GroupLayout.Alignment.LEADING)
												.addComponent(txEan, GroupLayout.Alignment.LEADING)
												.addComponent(txCodigo, GroupLayout.Alignment.LEADING)
												.addComponent(txUnidTrib, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
										.addGap(60, 60, 60)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addComponent(lbEanUnidTrib)
																.addComponent(lbGenero)
																.addComponent(lbValorUnidCom)
																.addComponent(lbQntTrib))
														.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																.addComponent(txGenero)
																.addComponent(txEanUnidTrib)
																.addComponent(txValorUnidCom)
																.addComponent(txQntTrib, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
														.addGap(60, 60, 60)
														.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(lbValorUnidTrib)
																		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(txValorUnidTrib, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
																.addGroup(layout.createSequentialGroup()
																		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
																				.addComponent(lbExIpi)
																				.addComponent(lbNcm))
																		.addGap(55, 55, 55)
																		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
																				.addComponent(txExIpi, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
																				.addComponent(txNcm)))))
												.addGroup(layout.createSequentialGroup()
														.addComponent(btnCadastrar)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(60, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(60, 60, 60)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lbDescricao)
								.addComponent(txDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lbCodigo)
								.addComponent(txCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbNcm)
								.addComponent(txNcm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbGenero)
								.addComponent(txGenero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lbEan)
								.addComponent(txEan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbEanUnidTrib)
								.addComponent(txEanUnidTrib, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbExIpi)
								.addComponent(txExIpi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lbUnidCom)
								.addComponent(txUnidCom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbValorUnidCom)
								.addComponent(txValorUnidCom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lbUnidTrib)
								.addComponent(txUnidTrib, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbQntTrib)
								.addComponent(txQntTrib, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbValorUnidTrib)
								.addComponent(txValorUnidTrib, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btnCadastrar)
								.addComponent(btnLimpar)
								.addComponent(btnCancelar))
						.addGap(60, 60, 60))
				);
		return layout;
	}
	
	public JPanel getPanel() {
		return pnlProduto;
	}	
}
