package entidades;

public class Produto {	
	private int id;
	private int codigo;
	private String descricao;
	private int quant;
	private String genero;
	private int ncm;
	private int ean;
	private int eanUnidTrib;
	private int exIpi;
	private int unidCom;
	private float valorUnidCom;
	private int unidTrib;
	private int quantUnidTrib;
	private float valorUnit;
	
	public Produto() { 
		this(-1, -1, "des", -1, "gen", -1, -1, -1, -1, -1, -1, -1, -1, -1);
	}
	
	public Produto(int id, int codigo, String descricao, int quant, String genero, 
			int ncm, int ean, int eanUnidTrib, int exIpi, int unidCom, float valorUnidCom, 
			int unidTrib, int quantUnidTrib, float valorUnit) {
		
		super();
		
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.quant = quant;
		this.genero = genero;
		this.ncm = ncm;
		this.ean = ean;
		this.eanUnidTrib = eanUnidTrib;
		this.exIpi = exIpi;
		this.unidCom = unidCom;
		this.valorUnidCom = valorUnidCom;
		this.unidTrib = unidTrib;
		this.quantUnidTrib = quantUnidTrib;
		this.valorUnit = valorUnit;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getNcm() {
		return ncm;
	}

	public void setNcm(int ncm) {
		this.ncm = ncm;
	}

	public int getEan() {
		return ean;
	}

	public void setEan(int ean) {
		this.ean = ean;
	}

	public int getEanUnidTrib() {
		return eanUnidTrib;
	}

	public void setEanUnidTrib(int eanUnidTrib) {
		this.eanUnidTrib = eanUnidTrib;
	}

	public int getExIpi() {
		return exIpi;
	}

	public void setExIpi(int exIpi) {
		this.exIpi = exIpi;
	}

	public int getUnidCom() {
		return unidCom;
	}

	public void setUnidCom(int unidCom) {
		this.unidCom = unidCom;
	}

	public float getValorUnidCom() {
		return valorUnidCom;
	}

	public void setValorUnidCom(float valorUnidCom) {
		this.valorUnidCom = valorUnidCom;
	}

	public int getUnidTrib() {
		return unidTrib;
	}

	public void setUnidTrib(int unidTrib) {
		this.unidTrib = unidTrib;
	}

	public int getQuantUnidTrib() {
		return quantUnidTrib;
	}

	public void setQuantUnidTrib(int quantUnidTrib) {
		this.quantUnidTrib = quantUnidTrib;
	}

	public float getValorUnit() {
		return valorUnit;
	}

	public void setValorUnit(float valorUnit) {
		this.valorUnit = valorUnit;
	}
	
	@Override
	public String toString() {
		return "Codigo: " + codigo + " Descricao: " +descricao +
				" Valor: " + valorUnit + " Quantidade: " + quant;
	}	
}
