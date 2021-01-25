package Technique;

public class Ville {
	private String pay;
	private String ville;
	
	
	public Ville(String pay, String ville) {
		super();
		this.pay = pay;
		this.ville = ville;
	}
	
	public String getPay() {
		return pay;
	}
	

	public void setPay(String pay) {
		this.pay = pay;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	@Override
	public String toString() {
		return "Ville [pay=" + pay + ", ville=" + ville + "]";
	}

}
