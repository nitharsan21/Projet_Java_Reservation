package Technique;

import java.sql.Time;
import java.util.Date;

public class Vol {
	private int id_vol;
 	private Date date_vol;
 	private int Nb_passager;
 	private Time heure_Depart;
	private Time heure_Arrivee;
	private Avion avion;
	private double poidTotale;

	public Vol(int id_vol, Date date_vol, int nb_passager, Time heure_Depart, Time heure_Arrivee, Avion avion, double poidTotale) {
		this.id_vol = id_vol;
		this.date_vol = date_vol;
		Nb_passager = nb_passager;
		this.heure_Depart = heure_Depart;
		this.heure_Arrivee = heure_Arrivee;
		this.avion = avion;
		this.poidTotale = poidTotale;
	}


	public int getId_vol() {
		return id_vol;
	}

	public void setId_vol(int id_vol) {
		this.id_vol = id_vol;
	}

	public Date getDate_vol() {
		return date_vol;
	}

	public void setDate_vol(Date date_vol) {
		this.date_vol = date_vol;
	}

	public int getNb_passager() {
		return Nb_passager;
	}

	public void setNb_passager(int nb_passager) {
		Nb_passager = nb_passager;
	}

	public Time getHeure_Depart() {
		return heure_Depart;
	}

	public void setHeure_Depart(Time heure_Depart) {
		this.heure_Depart = heure_Depart;
	}

	public Time getHeure_Arrivee() {
		return heure_Arrivee;
	}

	public void setHeure_Arrivee(Time heure_Arrivee) {
		this.heure_Arrivee = heure_Arrivee;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public double getPoidTotale() {
		return poidTotale;
	}

	public void setPoidTotale(double poidTotale) {
		this.poidTotale = poidTotale;
	}
}
