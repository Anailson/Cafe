package interfaces;

import entidades.Transportadora;

public interface InterfaceTransportadora {

	
	public boolean inserir(Transportadora t);
	public void remover(int id);
	public void pesquisar(int id);
	public void alterar(Transportadora t	);
}
