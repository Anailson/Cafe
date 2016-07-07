package entidades;

public class Fornecedor {
	
	public int id;
	public String nome;
	public boolean tipoDocumento;
	public int documento; //CPF ou CNPJ
	public int inscricaoEstadual;
	public boolean isentoIcms;
	public Endereco endereco;
	
	public Fornecedor() {
		super();
	}

	public Fornecedor(int id, String nome, boolean tipoDocumento, int documento, int inscricaoEstadual, boolean isentoIcms,
			Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.inscricaoEstadual = inscricaoEstadual;
		this.isentoIcms = isentoIcms;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isFisico() {
		return tipoDocumento;
	}

	public void setFisico(boolean fisico) {
		this.tipoDocumento = fisico;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public int getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(int inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public boolean isIsentoIcms() {
		return isentoIcms;
	}

	public void setIsentoIcms(boolean isentoIcms) {
		this.isentoIcms = isentoIcms;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {		
		return "Documento: " + documento + " Nome: " + nome + 
				" Endereco: " + endereco;
	}
}
