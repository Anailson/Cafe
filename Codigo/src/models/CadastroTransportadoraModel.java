package models;

import entidades.Transportadora;
import interfaces.InterfaceTransportadora;

public class CadastroTransportadoraModel implements InterfaceTransportadora{

	public static final String INSERT = "INSERT INTO ";
	public static final String TABLE = "cafenovohorizonte.TB_Transportadora ";
	public static final String VALUES = "VALUES (?)";
	
	public static final String DESCRICAO = "descricao";
	
	@Override
	public boolean inserir(Transportadora t) {
		
		
		return false;
	}

	@Override
	public void remover(int id) {
		
	}

	@Override
	public void pesquisar(int id) {
		
	}

	@Override
	public void alterar(Transportadora t) {
		
		
	}

}
