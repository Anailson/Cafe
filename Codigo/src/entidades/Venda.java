package entidades;

import java.util.ArrayList;
import java.util.Date;

public class Venda {

	private int id;
	private Cliente cliente;
	private ArrayList<Produto> produtos;
	private Date dataCompra, dataVencimento;
	private boolean pendencia;
	
	public Venda() {
		this(-1, null, null, null, false, null);
	}

	public Venda(Cliente cliente, ArrayList<Produto> produtos, Date dataCompra, boolean pendencia, Date dataVencimento) {
		
		this(-1, cliente, produtos, dataCompra, pendencia, dataVencimento);
	}
	
	public Venda(int id, Cliente cliente, ArrayList<Produto> produtos, Date dataCompra, boolean pendencia, 
			Date dataVencimento) {
			
		this.id = id;
		this.cliente = cliente;
		this.produtos = produtos;
		this.dataCompra = dataCompra;
		this.dataVencimento = dataVencimento;
		this.pendencia = pendencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public boolean isPendencia() {
		return pendencia;
	}

	public void setPendencia(boolean pendencia) {
		this.pendencia = pendencia;
	}
	
	public float getSubtotal() {
		float subtotal = 0;
		
		for(Produto p : produtos){
			subtotal += p.getValorUnit();
		}
		
		return subtotal;
	}
	
	@Override
	public String toString() {
		
		String venda = "";
		venda += "Cod: " + id + " Cliente: " + cliente.getNome() + 
				" Subtotal: " + getSubtotal();
		return venda;
	}
}
