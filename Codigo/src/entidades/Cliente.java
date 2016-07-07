package entidades;

public class Cliente {

	private int id;
	private String nome, documento, telefone, email, inscricaoEstadual, tipoImposto;
	private Endereco endereco;
	private boolean fisico, isentoIcms;


	public String getTipoImposto() {
		return tipoImposto;
	}


	public void setTipoImposto(String tipoImposto) {
		this.tipoImposto = tipoImposto;
	}


	public Cliente() {
		this(-1, "nome", false, "-1", "", "", new Endereco(), "-1", false);
	}


	public Cliente(int id, String nome, boolean fisico, String documento, String telefone, String email,
			Endereco endereco, String inscricaoEstadual, boolean isentoIcms) {

		this.id = id;
		this.nome = nome;
		this.fisico = fisico;
		this.documento = documento;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.inscricaoEstadual = inscricaoEstadual;
		this.isentoIcms = isentoIcms;
	}

	public Cliente(String nome, boolean fisico, String documento, String telefone, String email, Endereco endereco,
			String inscricaoEstadual, boolean isentoIcms) {		
		this.nome = nome;
		this.fisico = fisico;
		this.documento = documento;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.inscricaoEstadual = inscricaoEstadual;
		this.isentoIcms = isentoIcms;
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
		return fisico;
	}


	public void setFisico(boolean fisico) {
		this.fisico = fisico;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}


	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}


	public boolean isIsentoIcms() {
		return isentoIcms;
	}


	public void setIsentoIcms(boolean isentoIcms) {
		this.isentoIcms = isentoIcms;
	}

	@Override
	public String toString() {
		return "Documento: " + documento + ", Nome: " + nome + ", Endereco: " + endereco ;
	}

}