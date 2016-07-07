package models;

import java.sql.Connection;
import java.sql.PreparedStatement;

import controllers.ConectarComBanco;
import entidades.Produto;
import interfaces.InterfaceProduto;

public class CadastroProdutoModel implements InterfaceProduto{

	public static final String INSERT = "INSERT INTO ";
	public static final String TABLE = "cafenovohorizonte.TB_Produto ";
	public static final String VALUES = "VALUES (?)";
	
	public static final String DESCRICAO = "descricao";
	
	private ConectarComBanco banco;
	
	public CadastroProdutoModel(){
		banco = new ConectarComBanco();
	}
	
	@Override
	public boolean inserir(Produto p) {
		
		Connection exConn = banco.abrirBDConn();
		try{
			
			String sql = INSERT + TABLE + "(" + DESCRICAO + ") " + VALUES;
			
			PreparedStatement stmt = exConn.prepareStatement(sql);
			stmt.setString(1, p.getDescricao());
			
			stmt.execute();
			exConn.close();
			return true;
								
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public void remover(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pesquisar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Produto p) {
		// TODO Auto-generated method stub
		
	}
	
}
