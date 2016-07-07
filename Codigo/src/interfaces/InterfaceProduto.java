package interfaces;

import entidades.Produto;

public interface InterfaceProduto {	
	public boolean inserir(Produto p);
	public void remover(int id);
	public void pesquisar(int id);
	public void alterar(Produto p);
}