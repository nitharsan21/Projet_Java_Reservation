package Technique;

public abstract class Individu {
	private String nom;
	private String prenom;
	private String code_postal;
	private String adresse;
	private String ville;
	private int age;
	private String email;
	private String tel;
	
	public Individu(String nom, String prenom, String code_postal, String adresse, String ville, int age, String email,
			String tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.code_postal = code_postal;
		this.adresse = adresse;
		this.ville = ville;
		this.age = age;
		this.email = email;
		this.tel = tel;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "Individu [nom=" + nom + ", prenom=" + prenom + ", code_postal=" + code_postal + ", adresse=" + adresse
				+ ", ville=" + ville + ", age=" + age + ", email=" + email + ", tel=" + tel + "]";
	}
	

}
