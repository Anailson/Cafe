package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
import controllers.ConectarComBanco;
import entidades.Cliente;
import entidades.Endereco;
import interfaces.InterfaceCliente;

public class CadastroClienteModel  implements InterfaceCliente {
	private static String TABLE_ENDERECO = "TB_Endereco";
	private static String TABLE_RUA = "TB_Rua";
	private static String TABLE_BAIRRO = "TB_Bairro";
	private static String TABLE_CIDADE = "TB_Cidade";
	private static String TABLE_ESTADO = "TB_Estado";
	private static String ID_ENDERECO = "Id_Endereco";
	private static String ID_RUA = "Id_Rua";
	private static String ID_BAIRRO = "Id_Bairro";
	private static String ID_CIDADE = "Id_Cidade";
	private static String ID_ESTADO = "Id_Estado";
	
	//Inserir um cliente no banco
	@Override
	public boolean inserir(Cliente c) {
		ConectarComBanco banco = new ConectarComBanco();
		try{
			Connection ExConn = banco.abrirBDConn();
			Statement stmt = ExConn.createStatement();
		
			int[] numeroLinhas = verificarExistenciaCliente(c.getNome());
			PreparedStatement pstmt;
			if(numeroLinhas[0] != -1){
				JOptionPane.showMessageDialog(null, "Este cliente já existe!!!");
			}
			else {
				
				String query = "INSERT INTO cafenovohorizonte.TB_Estado (Nome) VALUES (?);";
				
				
				query = "INSERT INTO cafenovohorizonte.TB_Empresa (NomeFantasia, CPF-CNPJ, nInscricao, TipoImposto, Email, Rua, Numero, Bairro, Cidade, Estado, CEP) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
				pstmt = (PreparedStatement) ExConn.prepareStatement(query);

				pstmt.setString(1, c.getNome());
				pstmt.setString(2, String.valueOf(c.getDocumento()));
				pstmt.setString(3, String.valueOf(c.getInscricaoEstadual()));
				pstmt.setString(4, c.getTipoImposto());
				pstmt.setString(5, c.getEmail());
				Endereco endereco = c.getEndereco();
				pstmt.setString(6, endereco.getLogradouro());
				pstmt.setString(7, String.valueOf(endereco.getNumero()));
				pstmt.setString(8, endereco.getBairro());
				pstmt.setString(9, endereco.getMunicipio());
				pstmt.setString(10, endereco.getUf());
				pstmt.setString(11, String.valueOf(endereco.getCep()));
				
				pstmt.execute();
				pstmt.close();
			}

			stmt.close();
			banco.fecharBDConn();

			JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!!!");
		} catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro de Inserção!!!");
		}

		return false;
	}

	
	//RemoverClienteDoBanco
	@Override
	public void remover(Cliente c) {
		ConectarComBanco banco = new ConectarComBanco();
		try{
			Connection ExConn = banco.abrirBDConn();
			Statement stmt = ExConn.createStatement();
		
			int [] possivelCliente = verificarExistenciaCliente(c.getNome());
			PreparedStatement pstmt;
			if(possivelCliente[0] != -1){
				JOptionPane.showMessageDialog(null, "Este cliente não existe!!!");
			}
			else {
				String query = "DELETE FROM cafenovohorizonte.TB_Cliente WHERE Id_Cliente = ?;";
				pstmt = (PreparedStatement) ExConn.prepareStatement(query);
				pstmt.setInt(1, possivelCliente[0]);
				
				pstmt.execute();
				
				query = "DELETE FROM cafenovohorizonte.TB_Empresa WHERE Id_Empresa = ?;";
				pstmt = (PreparedStatement) ExConn.prepareStatement(query);
				pstmt.setInt(1, possivelCliente[1]);
				
				pstmt.execute();
				
				pstmt.close();
			}

			stmt.close();
			banco.fecharBDConn();

			JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!!!");
		} catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro de remoção!!!");
		}

	}

	//Pesquisar falta fazer
	@Override
	public void pesquisar(Cliente c) {

	}
		
	//Alterar o cliente do banco
	@Override
	public void alterar(Cliente c) {
		ConectarComBanco banco = new ConectarComBanco();
		try{
			Connection ExConn = banco.abrirBDConn();
			Statement stmt = ExConn.createStatement();
		
			int [] possivelCliente = verificarExistenciaCliente(c.getNome());
			PreparedStatement pstmt;
			if(possivelCliente[0] != -1){
				JOptionPane.showMessageDialog(null, "Este cliente não existe!!!");
			}
			else {
				String query = "UPDATE cafenovohorizonte.TB_Empresa SET NomeFantasia = ?, CPF-CNPJ = ?, nInscricao = ?, TipoImposto = ?, Email = ?, Telefone = ?, Id_Endereco = ? WHERE Id_Empresa = ?;";
				pstmt = (PreparedStatement) ExConn.prepareStatement(query);
				pstmt.setString(1, c.getNome());
				pstmt.setString(2, String.valueOf(c.getDocumento()));
				pstmt.setString(3, String.valueOf(c.getInscricaoEstadual()));
				pstmt.setString(4, c.getTipoImposto());
				pstmt.setString(5, c.getEmail());
				pstmt.setString(6, c.getTelefone());
				Endereco endereco = c.getEndereco();
				int id_Estado = pesquisarEstado(endereco.getUf());
				int id_Cidade = pesquisarCidade(endereco.getMunicipio(),id_Estado);
				int id_Bairro = pesquisarBairro(endereco.getBairro(), id_Cidade);
				int id_Rua = pesquisarRua(endereco.getLogradouro(), id_Bairro, String.valueOf(endereco.getCep()));
				int id_Numero = pesquisarNumero(String.valueOf(endereco.getNumero()), id_Rua);
				pstmt.setInt(7, id_Numero);
				pstmt.setInt(8, possivelCliente[1]);
				pstmt.execute();
				
				pstmt.close();
			}

			stmt.close();
			banco.fecharBDConn();

			JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!!!");
		} catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro de remoção!!!");
		}
	}
	
	@Override
	public int[] verificarExistenciaCliente(String nome){
		int[] resul = {-1,-1};
		ConectarComBanco banco = new ConectarComBanco();
		try{
			Connection ExConn = banco.abrirBDConn();
			Statement stmt = ExConn.createStatement();
			String query = "SELECT Id_Cliente, TB_Empresa_Id_Empresa FROM cafenovohorizonte.TB_Cliente WHERE TB_Empresa_Id_Empresa = (SELECT Id_Empresa FROM cafenovohorizonte.TB_Empresa WHERE NomeFantasia LIKE '"+nome+"');";
			ResultSet rs = stmt.executeQuery(query);
			rs.last();

			int id_Cliente, id_Empresa;
			int numeroLinhas = rs.getRow();
			if(numeroLinhas > 0){
				rs.first();
				id_Cliente = rs.getInt("Id_Cliente");
				id_Empresa = rs.getInt("TB_Empresa_Id_Empresa");
				resul[0] = id_Cliente;
				resul[1] = id_Empresa;
			}
		} catch(Exception e){ }
		return resul;
	}
	
	@Override
	public int pesquisarEstado(String estado){
		return pesquisaEndereco(estado, ID_ESTADO, TABLE_ESTADO, -1, "CEP");
	}
	
	@Override
	public int pesquisarCidade(String cidade, int id_Estado){
		return pesquisaEndereco(cidade, ID_CIDADE, TABLE_CIDADE, id_Estado, "CEP");
	}
	
	@Override
	public int pesquisarRua(String rua, int id_Bairro, String CEP){
		return pesquisaEndereco(rua, ID_RUA, TABLE_RUA, id_Bairro, CEP);
	}
	
	@Override
	public int pesquisarBairro(String bairro, int id_Cidade){
		return pesquisaEndereco(bairro, ID_BAIRRO, TABLE_BAIRRO, id_Cidade, "CEP");
	}
	
	@Override
	public int pesquisarNumero(String numero, int id_Rua){
		return pesquisaEndereco(numero, ID_ENDERECO, TABLE_ENDERECO, id_Rua, "CEP");
	}

	
	private int pesquisaEndereco(String nome, String id_escolhido, String tabela, int id_pai, String CEP){
		ConectarComBanco banco = new ConectarComBanco();
		int retorno = -1;
		try{
			Connection ExConn = banco.abrirBDConn();
			Statement stmt = ExConn.createStatement();
			
			String query = "SELECT "+id_escolhido+", "+nome+" FROM cafenovohorizonte."+tabela+" WHERE Nome LIKE "+nome+";";
			ResultSet rs = stmt.executeQuery(query);
			rs.last();
			PreparedStatement pstmt = (PreparedStatement) ExConn.prepareStatement(query);
			
			int numeroLinhas = rs.getRow();
			if(numeroLinhas > 0){
				retorno = rs.getInt(id_escolhido);
			}
			else {
				switch (tabela){
				case "TB_Estado":
					query = "INSERT INTO cafenovohorizonte."+tabela+" (Nome) VALUES (?);";
					
					pstmt = (PreparedStatement) ExConn.prepareStatement(query);
					pstmt.setString(1, nome);
					break;
				case "TB_Cidade":
					query = "INSERT INTO cafenovohorizonte."+tabela+" (Nome, Id_Estado) VALUES (?, ?);";
					
					pstmt = (PreparedStatement) ExConn.prepareStatement(query);
					pstmt.setString(1, nome);
					pstmt.setInt(2, id_pai);
					break;
				case "TB_Bairro":
					query = "INSERT INTO cafenovohorizonte."+tabela+" (Nome, Id_Cidade) VALUES (?, ?);";
					
					pstmt = (PreparedStatement) ExConn.prepareStatement(query);
					pstmt.setString(1, nome);
					pstmt.setInt(2, id_pai);
					break;
				case "TB_Rua":
					query = "INSERT INTO cafenovohorizonte."+tabela+" (Nome, Id_Bairro, CEP) VALUES (?, ?, ?);";
					
					pstmt = (PreparedStatement) ExConn.prepareStatement(query);
					pstmt.setString(1, nome);
					pstmt.setInt(2, id_pai);
					pstmt.setString(3, CEP);

					break;
				case "TB_Endereco":
					query = "INSERT INTO cafenovohorizonte."+tabela+" (Numero, Id_Rua) VALUES (?, ?);";
					
					pstmt = (PreparedStatement) ExConn.prepareStatement(query);
					pstmt.setString(1, nome);
					pstmt.setInt(2, id_pai);
					break;
				}
				
				pstmt.execute();
				pstmt.close();

				query = "SELECT "+id_escolhido+" FROM cafenovohorizonte."+tabela+";";
				rs = stmt.executeQuery(query);
				rs.last();
				retorno = rs.getInt(id_escolhido);
			}
		} catch(Exception e){ }
		return retorno;
	}
}
