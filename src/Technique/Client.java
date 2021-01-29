package Technique;

public class Client extends Individu{
	

	private int id_client;
	
	
	public Client(String nom, String prenom, String code_postal, String adresse, String ville, int age, String email,
			String tel, int id_client) {
		super(nom, prenom, code_postal, adresse, ville, age, email, tel);
		this.id_client = id_client;
	}

	public Client(String nom, String prenom, String code_postal, String adresse, String ville, int age, String email,
				  String tel){
		super(nom, prenom, code_postal, adresse, ville, age, email, tel);
	}



	public int getId_client() {
		return id_client;
	}


	public void setId_client(int id_client) {
		this.id_client = id_client;
	}


	@Override
	public String toString() { return "Client : " + this.getNom() + " " + this.getPrenom();}
	
	
	public void ShowVol(String depart, String Arriver) {

	}
	
	

}
