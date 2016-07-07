package entidades;

public class Endereco {

	private int id;
	private String logradouro, numero, bairro, cep, uf, municipio;

	public Endereco() {
	}

	public Endereco(int id, String logradouro, String numero, String bairro, String cep, String uf, String municipio) {
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.uf = uf;
		this.municipio = municipio;
	}

	public Endereco(String logradouro, String numero, String bairro, String cep, String uf, String municipio) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.uf = uf;
		this.municipio = municipio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	@Override
	public String toString() {

		String endereco;
		endereco = "Rua: " + logradouro + ", " + numero + ".";
		endereco += "Bairro: " + bairro + ", " + municipio + " - " + uf + ".";
		endereco += "CEP: " + cep + ".";
		return endereco;
	}
}
