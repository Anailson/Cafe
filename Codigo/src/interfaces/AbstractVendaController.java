package interfaces;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import entidades.Cliente;
import entidades.Produto;
import views.FrameHome;
import views.FramePrincipal;

public class AbstractVendaController {

	public static final int ADICIONAR = 0;
	public static final int FINALIZAR = 1;
	public static final int CANCELAR = 2;
	public static final int COD_CLI = 3;
	public static final int DESC_CLI = 4;
	public static final int COD_PROD = 5;
	public static final int DESC_PROD = 6;
	public static final int CLIENTE = 7;
	public static final int PRODUTO = 8;

	private static JRadioButton rdbCodCli, rdbCodProd;
	private JRadioButton rdbDescCli, rdbDescProd;
	private JComboBox<Cliente> cmbCliente;
	private JComboBox<Produto> cmbProduto;
	private JSpinner spnQuant;
	private JTextField tfCliente, tfProduto, tfValorUnit, tfGenero;

	public AbstractVendaController(JRadioButton rdbCodCli, JRadioButton rdbDescCli, JRadioButton rdbCodPro,
			JRadioButton rdbDescPro, JComboBox<Cliente> cmbCliente, JComboBox<Produto> cmbProduto, JSpinner spnQuant,
			JTextField tfCliente, JTextField tfProduto, JTextField tfValorUnit, JTextField tfGenero) {

		AbstractVendaController.rdbCodCli = rdbCodCli;
		this.rdbDescCli = rdbDescCli;
		AbstractVendaController.rdbCodProd = rdbCodPro;
		this.rdbDescProd = rdbDescPro;
		this.cmbCliente = cmbCliente;
		this.cmbProduto = cmbProduto;
		this.spnQuant = spnQuant;
		this.tfCliente = tfCliente;
		this.tfProduto = tfProduto;
		this.tfValorUnit = tfValorUnit;
		this.tfGenero = tfGenero;

		/**
		 * TODO: buscar a lista de todos os clientes e de todos os produtos do
		 * banco e adicionar num ArrayList será importante no model dos ComboBox
		 */
	}

	public ItemListener getItemListener(int id) {
		return new AddItemListener(id);
	}

	public ActionListener getActionListener(int id) {
		return new AddActionListener(id);
	}

	public static EstadosCellRenderer getCellRenderer() {
		return new EstadosCellRenderer();
	}

	private void exibirCliente(int index) {

		Cliente cliente = cmbCliente.getModel().getElementAt(index);
		tfCliente.setText(index + " " + cliente.toString());
	}

	private void exibirProduto(int index) {
		Produto produto = (Produto) cmbProduto.getModel().getSelectedItem();
		tfProduto.setText(index + " " + produto.toString());
		tfValorUnit.setText(produto.getValorUnit() + "");
		tfGenero.setText(produto.getGenero());
	}

	private void codigoCliente(boolean selecionado) {

		if (selecionado) {
			// TODO: alterar o model com o codigo dos clientes;
			ArrayList<Cliente> lista = new ArrayList<>();
			lista.add(new Cliente());
			lista.add(new Cliente());
			lista.add(new Cliente());
			lista.add(new Cliente());

			cmbCliente.setModel(new ModelComboBox<Cliente>(lista));
		}
	}

	private void descricaoCliente(boolean selecionado) {

		if (selecionado) {
			// TODO: alterar o model com o nome dos produtos;
			ArrayList<Cliente> lista = new ArrayList<>();
			lista.add(new Cliente());
			lista.add(new Cliente());
			lista.add(new Cliente());
			lista.add(new Cliente());

			cmbCliente.setModel(new ModelComboBox<Cliente>(lista));
		}
	}

	private void codigoProduto(boolean selecionado) {

		if (selecionado) {
			// TODO: alterar o model com o codigo dos produtos;
			ArrayList<Produto> lista = new ArrayList<>();
			lista.add(new Produto());
			lista.add(new Produto());
			lista.add(new Produto());
			lista.add(new Produto());

			cmbProduto.setModel(new ModelComboBox<Produto>(lista));
		}
	}

	private void descricaoProduto(boolean selecionado) {

		if (selecionado) {
			// TODO: alterar o model com a descricao dos produtos;
			ArrayList<Produto> lista = new ArrayList<>();
			lista.add(new Produto());
			lista.add(new Produto());
			lista.add(new Produto());
			lista.add(new Produto());

			cmbProduto.setModel(new ModelComboBox<Produto>(lista));
		}
	}

	private void adicionar() {

		Produto p = (Produto) cmbProduto.getModel().getSelectedItem();
		String descricao = p.getDescricao();
		int codigo = p.getCodigo();
		int quant = (int) spnQuant.getValue();

		JOptionPane.showConfirmDialog(null, codigo + " - " + descricao + " x" + quant, "adicionar",
				JOptionPane.WARNING_MESSAGE);
	}

	private void finalizarVenda() {

		Produto p = (Produto) cmbProduto.getModel().getSelectedItem();
		String descricao = p.getDescricao();
		int codigo = p.getCodigo();
		int quant = (int) spnQuant.getValue();
		float total = quant * p.getValorUnit();

		JOptionPane.showMessageDialog(null, codigo + " - " + descricao + " x" + quant + ". Total: " + total,
				"finalizarVenda", JOptionPane.WARNING_MESSAGE);
	}

	private void cancelar() {
		int result = JOptionPane.showConfirmDialog(null, "Você realmente deseja cancelar essa venda?", "Cancelar",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
			FramePrincipal.setPanel(new FrameHome());
		}
	}

	private class AddItemListener implements ItemListener {

		private int id;

		public AddItemListener(int id) {
			this.id = id;
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {

			switch (id) {

			case COD_CLI:

				cmbCliente.setEnabled(true);
				codigoCliente(rdbCodCli.isSelected());
				break;
			case DESC_CLI:

				cmbCliente.setEnabled(true);
				descricaoCliente(rdbDescCli.isSelected());
				break;
			case COD_PROD:

				cmbProduto.setEnabled(true);
				codigoProduto(rdbCodProd.isSelected());
				break;
			case DESC_PROD:

				cmbProduto.setEnabled(true);
				descricaoProduto(rdbDescProd.isSelected());
				break;
			case CLIENTE:
				exibirCliente(cmbCliente.getSelectedIndex());
				break;
			case PRODUTO:
				exibirProduto(cmbProduto.getSelectedIndex());
				break;
			}
		}
	}

	private class AddActionListener implements ActionListener {

		private int id;

		public AddActionListener(int id) {
			this.id = id;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {

			switch (id) {
			case ADICIONAR:

				adicionar();
				break;
			case FINALIZAR:

				finalizarVenda();
				break;
			case CANCELAR:

				cancelar();
				break;
			}
		}
	}

	private class ModelComboBox<E> extends AbstractListModel<E> implements ComboBoxModel<E> {

		private static final long serialVersionUID = 1L;

		private ArrayList<E> lista;
		private E itemAtual;

		public ModelComboBox(ArrayList<E> lista) {
			this.lista = lista;
			this.itemAtual = lista.get(0);
		}

		@Override
		public E getElementAt(int index) {
			return lista.get(index);
		}

		@Override
		public int getSize() {
			return lista.size();
		}

		@Override
		public Object getSelectedItem() {
			return itemAtual;
		}

		@SuppressWarnings("unchecked")
		@Override
		public void setSelectedItem(Object item) {
			this.itemAtual = (E) item;
		}
	}

	private static class EstadosCellRenderer extends DefaultListCellRenderer {

		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
				boolean isSelected, boolean cellHasFocus) {

			super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

			if (value instanceof Cliente) {

				Cliente c = (Cliente) value;
				if (rdbCodCli.isSelected()) {
					setText(c.getId() + "");
				} else {
					setText(c.getNome());
				}

			} else if (value instanceof Produto) {
				Produto p = (Produto) value;
				if (rdbCodProd.isSelected()) {
					setText(p.getId() + "");
				} else {
					setText(p.getDescricao());
				}
			}
			return this;
		}
	}
}
