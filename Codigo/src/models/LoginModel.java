package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import controllers.ConectarComBanco;

public class LoginModel {
	
	public static final int LOGIN_SUCESSO = 0;
	public static final int ERRO_AUTENTICACAO = 1;
	public static final int ERRO_LEITURA = 2;
	
	public int buscarUsuario(String login, String senha){
		
		ConectarComBanco banco = new ConectarComBanco();
		
		try{
			Connection ExConn = banco.abrirBDConn();
			Statement stmt = ExConn.createStatement();
			String query = "SELECT * FROM cafenovohorizonte.TB_Usuario WHERE login LIKE '"+login+"' AND senha LIKE '"+senha+"'";
			ResultSet rs = stmt.executeQuery(query);
			rs.first();
			
			String loginBanco = rs.getString("login");
			String senhaBanco = rs.getString("senha");
			

			if(login.equalsIgnoreCase(loginBanco) && senha.equalsIgnoreCase(senhaBanco)){
				
				stmt.close();
				banco.fecharBDConn();
				return LOGIN_SUCESSO;
				
			} else {
				return ERRO_AUTENTICACAO;
			}
		} catch (Exception e){
			e.printStackTrace();
			return ERRO_LEITURA;
		} 
	}	
}
