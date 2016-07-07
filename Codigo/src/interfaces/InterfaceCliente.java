package interfaces;

import entidades.Cliente;

public interface InterfaceCliente {
	
	public boolean inserir(Cliente c);
	public void remover(Cliente c);
	public void pesquisar(Cliente c);
	public void alterar(Cliente c);
	int[] verificarExistenciaCliente(String nome);
	int pesquisarEstado(String estado);
	int pesquisarCidade(String cidade, int id_Estado);
	int pesquisarRua(String rua, int id_Bairro, String CEP);
	int pesquisarBairro(String bairro, int id_Cidade);
	int pesquisarNumero(String numero, int id_Rua);
	//adicionar os metodos de retornar
}

