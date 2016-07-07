package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Recebimento {
	private String quem, oque;
	private Date quando;
	private double quanto;
	
	public Recebimento() {
		this("", "", null, -1);
	}

	public Recebimento(String quem, String oQue, Date quando, double quanto) {

		this.quem = quem;
		this.oque = oQue;
		this.quando = quando;
		this.quanto = quanto;
	}

	public String getQuem() {
		return quem;
	}

	public void setQuem(String quem) {
		this.quem = quem;
	}

	public String getoQue() {
		return oque;
	}

	public void setoQue(String oQue) {
		this.oque = oQue;
	}
	
	public Date getQuando() {
		return quando;
	}
	
	public void setQuando(Date quando) {
		this.quando = quando;
	}

	public double getQuanto() {
		return quanto;
	}

	public void setQuanto(double quanto) {
		this.quanto = quanto;
	}
	
	@Override
	public String toString() {
		
		SimpleDateFormat fmt = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");

		return "Quem: " + quem + " O que: " + oque + 
				" Quando: " + fmt.format(quando) + " Quanto: " + quanto;
	}
}
