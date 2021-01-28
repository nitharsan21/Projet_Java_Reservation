package Technique;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Vol {
	private String reference;
	private Date dateDepart;
	private Date dateArrivee;
	private int nbPassager;
	private Aeroport aeroportDepart;
	private Aeroport aeroportArrivee;
	private List<Reservation> listPassager;
	private Avion avion;
	private double poidsTotale;


	public Vol(String reference, Date dateDepart, Date dateArrivee, int nbPassager, Aeroport aeroportDepart, Aeroport aeroportArrivee) {

		this.reference = reference;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.nbPassager = nbPassager;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
		this.listPassager = new ArrayList<Reservation>();

	}


	// Méthodes liées aux getter


	public String getReference() {

		return reference;

	}

	public Date getDateDepart() {

		return dateDepart;

	}

	public Date getDateArrivee() {

		return dateArrivee;

	}

	public int getNbPassager() {
		return nbPassager;
	}


	public Aeroport getAeroportDepart() {

		return aeroportDepart;

	}

	public Aeroport getAeroportArrivee() {

		return aeroportArrivee;

	}

	public List<Reservation> getListPassager() {

		return listPassager;

	}

	public Avion getAvion() {

		return avion;

	}

	public double poidsTotale() {

		return poidsTotale;

	}


	// Méthodes liées aux setter


	public void setReference(String reference) {

		this.reference = reference;

	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public void setDateArrivee(Date dateArrivee) {

		this.dateArrivee = dateArrivee;

	}

	public void setNbPassager(int nbPassager) {
		this.nbPassager = nbPassager;
	}


	public void setAeroportDepart(Aeroport aeroportDepart) {

		this.aeroportDepart = aeroportDepart;

	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {

		this.aeroportArrivee = aeroportArrivee;

	}

	public void setAvion(Avion avion) {

		this.avion = avion;

	}

	public void setPoidsTotale(double poidsTotale) {

		this.poidsTotale = poidsTotale;

	}


	// Méthodes liées à l'ajout des caractéristiques d'un vol

	public void ajouterAvion(Avion avion) {
		this.avion = avion;
	}

	public void ajouterPassager(Reservation reservation) {
		if(this.avion.getCapacityMax() >= this.nbPassager) {
			this.listPassager.add(reservation);
			this.nbPassager++;
		}else {
			System.out.println("la capacité est étendue à sa limite. Essayez de réserver un autre vol.");
		}
	}

	public String toString() {

		return "Vol : " + this.reference + ", départ de : " + this.aeroportDepart + " le : " + this.dateDepart
				+ ", arrivée a : " + this.aeroportArrivee + " le : " + this.dateArrivee
				+ " a bord de l'avion : " + getAvion();

	}
}
