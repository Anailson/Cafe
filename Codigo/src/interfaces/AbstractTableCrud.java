package interfaces;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public abstract class AbstractTableCrud <E> extends AbstractTableModel{

	private static final long serialVersionUID = 1L;

	public static final String COL_DETALHES = "Detalhes"; 
	public static final String COL_EDITAR = "Editar";
	public static final String COL_EXCLUIR = "Excluir";

	public static final ImageIcon ICON_DETALHES = new ImageIcon("Imagens/icon_detalhe.png");
	public static final ImageIcon ICON_EDITAR = new ImageIcon("Imagens/icon_editar.png");
	public static final ImageIcon ICON_EXCLUIR = new ImageIcon("Imagens/icon_remover.png");
	
	private ArrayList<E> elementos;
	private String[] colunas;
	
	public AbstractTableCrud(String [] colunas, ArrayList<E> elementos) {
		
		this.colunas = colunas;
		this.elementos = elementos;
	}
	
	public static IconCellRenderer getIconCellRenderer(){
		return new IconCellRenderer();
	}	
	
	public abstract Object getCampo(E e, int coluna);
	
	public abstract void setCampo(E e, Object valor, int coluna);
	
	public int getColumnCount(){
		return colunas.length;
	}

	@Override
	public int getRowCount(){
		return this.elementos.size();
	}
	
	@Override
	public Object getValueAt(int linha, int coluna){
		
		return getCampo(elementos.get(linha), coluna);
	}
	
	@Override
	public  void setValueAt(Object valor, int linha, int coluna){
		
		setCampo(elementos.get(linha), valor, coluna);
	}
	
	@Override
	public  Class<?> getColumnClass(int coluna) {
		return Object.class;
	}
	
	@Override
	public String getColumnName(int coluna) {
		return this.colunas[coluna];		
	}
	
	@Override
	public boolean isCellEditable(int linha, int coluna){
		return false;
	}

	public E get(int linha){
		return elementos.get(linha);
	}
	
	public void salvar(E e){
		elementos.add(e);
		int indiceLinha = elementos.size() -1;
		fireTableRowsInserted(indiceLinha, indiceLinha);
	}
	
	public void salvar(ArrayList<E> e){
		elementos.addAll(e);
		int ultimoRegistro = getRowCount();
		fireTableRowsInserted(ultimoRegistro, getRowCount() - 1);
	}
	
	public E alterar (int linha, E e){
		
		elementos.set(linha, e);
		fireTableRowsUpdated(linha, linha);
		return e;
	}
	
	public E excluir (int indice){
		E e = elementos.remove(indice);
		fireTableRowsDeleted(indice, indice);
		return e;
	}
	
	public ArrayList<E> buscarTodos(){
		return elementos;
	}
	
	
	
	private static class IconCellRenderer extends DefaultTableCellRenderer  {  
		 
		private static final long serialVersionUID = 1L;

		protected void setValue(Object value){  
	  
	        if (value instanceof ImageIcon){  
	  
	            if (value != null){  
	                ImageIcon d = (ImageIcon) value;  
	                setIcon(d);  
	            }  
	              
	        } else {  
	            super.setValue(value);  
	        }     
	    }
	}	
}
