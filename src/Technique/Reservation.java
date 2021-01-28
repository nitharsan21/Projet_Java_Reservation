package Technique;

import java.util.Date;

public class Reservation {
	
	public static final int FIRST_CLASSE = 1;
	public static final int AFFAIRE_CLASSE = 2;
	public static final int ECONOMY_CLASSE = 3;


	public static final int ETAT_CONFIRMER = 1;
	public static final int ETAT_ANNULER = -1;
	public static final int ETAT_NONVALIDER = 0;



	private int id_Reservation;
	private Date date;
	private int classe;
	private int etat;
	private double prix;
	private Abonne abonne;
	private Client client;

	public Reservation(Date date, int etat, Client client) {
		this.date = date;
		this.etat = etat;
		this.prix = prix;
		this.client = client;
	}

	public Reservation(Date date, int etat, double prix, Abonne abonne) {
		this.date = date;
		this.etat = etat;
		this.prix = prix;
		this.abonne = abonne;

	}

	public Reservation(){
	}

	public int getId_Reservation() {
		return id_Reservation;
	}

	public void setId_Reservation(int id_Reservation) {
		this.id_Reservation = id_Reservation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Abonne getAbonne() {
		return abonne;
	}

	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}









}
