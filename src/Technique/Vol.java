package Technique;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Vol {

	private String reference;
	private Date dateDepart;
	private Aeroport aeroportDepart;
	private Date dateArrivee;
	private Aeroport aeroportArrivee;
	private int nbPassager;
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
	public Vol(){};


	// Méthodes liées aux getter


	public String getReference() {

		return reference;

	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public String getDateDepartformat() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String date = simpleDateFormat.format(this.dateDepart);
		return date;
	}



	public Date getDateArrivee() {
		return dateArrivee;
	}

	public String getDateArriveeformat() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String date = simpleDateFormat.format(this.dateArrivee);
		return date;
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

	public void setDateDepart(String dateDepart) throws Exception {
		Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateDepart);
		this.dateDepart = date;
	}

	public void setDateArrivee(String dateArrivee) throws Exception {
		Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateArrivee);
		this.dateArrivee = date;


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


	public void setListPassager(List<Reservation> listPassager) {
		this.listPassager = listPassager;
	}


	public String toString() {

		return "Vol : " + this.reference + ", départ de : " + this.aeroportDepart + " le : " + this.dateDepart
				+ ", arrivée a : " + this.aeroportArrivee + " le : " + this.dateArrivee;
//				+ " a bord de l'avion : " + getAvion();

	}


	public static Vol from(String text) {
		Vol vol = new Vol();
		try {
			String[] fields = text.split(",");
			vol.setReference(fields[0].strip());
			vol.setDateDepart(fields[1].strip());
			vol.setAeroportDepart(new Aeroport(fields[2].strip(),fields[3].strip(),fields[4].strip()));
			vol.setDateArrivee(fields[5].strip());
			vol.setAeroportArrivee(new Aeroport(fields[6].strip(),fields[7].strip(),fields[8].strip()));
			vol.setNbPassager(Integer.parseInt(fields[9].strip()));
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		return vol;
	}


	public static List<Vol> volsfrom(File file) throws FileNotFoundException {
		List<Vol> lesVols = new ArrayList<Vol>();
		if((file.exists() && !file.isDirectory())) {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				Vol subVol = Vol.from(scanner.nextLine());
				lesVols.add(subVol);

			}
			scanner.close();

		} else{
		try {
			file.createNewFile();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}
		return lesVols;
	}



	public String formatfile(){
		return  this.reference + ", " + this.getDateDepartformat() + ", " + this.aeroportDepart.getNom() + ", "  + this.aeroportDepart.getVille() + ", "  + this.aeroportDepart.getPays() + ", "
				+ this.getDateArriveeformat() + ", " + this.aeroportArrivee.getNom() + ", "  + this.aeroportArrivee.getVille() + ", "  + this.aeroportArrivee.getPays() + ", "
				+ this.nbPassager + "\n";
	}


	public static void saveVol(String path, List<Vol> lesVols) throws Exception{
		File file = new File(path);
		if(file.exists()){
			file.delete();
		}
		file.createNewFile();
		FileWriter filewrite = new FileWriter(path);
		for(Vol vol : lesVols){
			filewrite.write(vol.formatfile());
		}
		filewrite.close();
	}




}
