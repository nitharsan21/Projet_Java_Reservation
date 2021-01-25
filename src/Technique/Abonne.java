package Technique;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Abonne extends Individu{
	
	private int id_abonne;
	private String login;
	private String mdp;
	private int nb_points;
	
	
	public Abonne(String nom, String prenom, String code_postal, String adresse, String ville, int age, String email,
			String tel, int id_abonne, String login, String mdp, int nb_points) {
		super(nom, prenom, code_postal, adresse, ville, age, email, tel);
		this.id_abonne = id_abonne;
		this.login = login;
		this.mdp = mdp;
		this.nb_points = nb_points;
	}


	public int getId_abonne() {
		return id_abonne;
	}


	public void setId_abonne(int id_abonne) {
		this.id_abonne = id_abonne;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public int getNb_points() {
		return nb_points;
	}


	public void setNb_points(int nb_points) {
		this.nb_points = nb_points;
	}


	@Override
	public String toString() {
		return "Abonne : " + this.getNom() + " " + this.getPrenom();
	}

	public static Abonne from(String text) {

		String[] fields = text.split(",");

		String nom = fields[0].strip();
		String prenom = fields[1].strip();
		String code_postal = fields[2].strip();
		String adresse = fields[3].strip();
		String ville = fields[4].strip();
		int age = Integer.parseInt(fields[5].strip());
		String email = fields[6].strip();
		String tel = fields[7].strip();
		int id_abonne = Integer.parseInt(fields[8].strip());
		String login = fields[9].strip();
		String mdp = fields[10].strip();
		int nb_points = Integer.parseInt(fields[11].strip());
		return new Abonne(nom,prenom,code_postal,adresse,ville,age,email,tel,id_abonne,login,mdp,nb_points);
	}
	
	

	public static List<Abonne> abonnefrom(File file, int nbLine) throws FileNotFoundException {
		List<Abonne> lesAbonne = new ArrayList<Abonne>();
		Scanner scanner = new Scanner(file);
		for(int i = 0; i < nbLine;i++) {
			Abonne subAbonne = Abonne.from(scanner.nextLine());
				lesAbonne.add(subAbonne);

		}
		scanner.close();
		return lesAbonne;
	}
	
	
	

}
