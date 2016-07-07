package interfaces;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public abstract class AbstractListarController<E> {

	public static final int PESQUISAR = 0;

	private JTable tabela;
	private AbstractTableCrud<E> modelo;
	private JTextField text;

	public AbstractListarController(JTextField text, JTable tabela, AbstractTableCrud<E> modelo) {
		super();
		this.tabela = tabela;
		this.modelo = modelo;
		this.text = text;
	}

	public KeyListener getKeyListener(int id) {
		return new AddKeyListener(id);
	}

	public MouseListener getMouseListener() {
		return new AddMouseListener();
	}

	public MouseListener getMouseListener(int id) {
		return new AddMouseListener(id);
	}

	private void resetarTextField(JTextField text) {
		text.setText("");
	}

	public ArrayList<E> pesquisar(JTextField text, JTable tabela, AbstractTableCrud<E> modelo) {

		resetarTextField(text);

		JOptionPane.showMessageDialog(null, "Pesquisar selecionado", "Pesquisar", JOptionPane.ERROR_MESSAGE);

		return null;
	}

	public void detalhes(E e) {
		JOptionPane.showMessageDialog(null, e.toString(), "Detalhes", JOptionPane.WARNING_MESSAGE);
	}

	public void editar(E e) {
		JOptionPane.showMessageDialog(null, e.toString(), "Editar", JOptionPane.WARNING_MESSAGE);
	}

	public void excluir(E e) {

		JOptionPane.showMessageDialog(null, e.toString(), "Excluir", JOptionPane.ERROR_MESSAGE);
	}

	private class AddKeyListener implements KeyListener {

		private int id;

		public AddKeyListener(int id) {
			this.id = id;
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (id == PESQUISAR && e.getKeyCode() == KeyEvent.VK_ENTER) {
				pesquisar(text, tabela, modelo);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
	}

	private class AddMouseListener implements MouseListener {

		private int id;

		public AddMouseListener() {
			this.id = -1;
		}

		public AddMouseListener(int id) {
			this.id = id;
		}

		@Override
		public void mouseClicked(MouseEvent event) {
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {

			switch (id) {

			case -1: {

				int linha = tabela.getSelectedRow();
				int coluna = tabela.getSelectedColumn();
				String nomeColuna = tabela.getColumnName(coluna);

				E e = modelo.get(linha);

				switch (nomeColuna) {
				case AbstractTableCrud.COL_DETALHES:
					detalhes(e);
					break;
				case AbstractTableCrud.COL_EDITAR:
					editar(e);
					break;
				case AbstractTableCrud.COL_EXCLUIR:
					excluir(e);
					break;

				}
				break;

			}
			default: {

				switch (id) {

				case PESQUISAR: {
					pesquisar(text, tabela, modelo);
					break;
				}
				}
			}
			}
		}
	}
}
