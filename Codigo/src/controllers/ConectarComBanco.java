package controllers;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectarComBanco {
	
	private Connection con;
		
	public Connection abrirBDConn(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/cafenovohorizonte";
			con = DriverManager.getConnection(url,"root","");
			return con;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public void fecharBDConn(){
	 	try{
			con.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
