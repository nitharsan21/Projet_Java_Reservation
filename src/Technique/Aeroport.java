package Technique;

import java.util.*;

public class Aeroport {

	private String nom;
	private String ville;
	private String pays;

	// Données supplémentaires de la compagnie, idées d'améliorations ...
	/*
		private Map<Integer, ArrayList<Avion>> mapAvion; //map contenant l'ensemble des avions présents dans l'aéroport
	*/

	public Aeroport(String nom, String ville, String pays) {

		this.nom = nom;
		this.ville = ville;
		this.pays = pays;

		//this.mapAvion = new HashMap<Integer, ArrayList<Avion>>();

	}

	// Methodes liées aux getter

	public String getNom() {

		return nom;

	}

	public String getVille() {

		return ville;

	}

	public String getPays() {

		return pays;

	}

	/* public Map<Integer, ArrayList<Avion>> getMapAvion() {

	  		return mapAvion;

	  }

	*/

	// Methodes liées aux setter

	public void setNom(String nom) {

		this.nom = nom;

	}

	public void setVille(String ville) {

		this.ville = ville;

	}

	public void setPays(String pays) {

		this.pays = pays;

	}

	/* public void setMapAvion(Map<Integer, ArrayList<Avion>> mapAvion) {

	  		this.mapAvion = mapAvion;

	  }

	*/

	public String toString() {
		return  this.nom + "," + this.ville + " " + this.pays;
	}

}
