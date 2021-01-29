package Technique;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Reservation {
	
	public static final int FIRST_CLASSE = 1;
	public static final int BUSINESS_CLASSE = 2;
	public static final int ECONOMY_CLASSE = 3;

	public static final int ETAT_CONFIRMER = 1;
	public static final int ETAT_ANNULER = -1;
	public static final int ETAT_NONVALIDER = 0;

	public static final String PERSONNE_ABONNE = "A";
	public static final String PERSONNE_CLIENT = "C";



	private int id_Reservation;
	private Date date;
	private int classe;
	private int etat;
	private double prix;
	private String personne;
	private Individu passager;



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

	public String getDateformat() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String date = simpleDateFormat.format(this.date);
		return date;
	}

	public void setDate(String dateres)throws Exception {
		Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateres);
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

	public void setPassager(Individu passager) {
		this.passager = passager;
	}

	public void setClasse(int classe) {
		this.classe = classe;
	}

	public String getPersonne() {
		return personne;
	}

	public void setPersonne(String personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Reservation{" +
				"id_Reservation=" + id_Reservation +
				", date=" + date +
				", classe=" + classe +
				", etat=" + etat +
				", prix=" + prix +
				", personne=" + personne +
				", passager=" + passager +
				'}';
	}

	public static Reservation from(String text) {
		Reservation res = new Reservation();
		try {
			String[] fields = text.split(",");
			res.setId_Reservation(Integer.parseInt(fields[0].strip()));
			res.setDate(fields[1].strip());
			res.setClasse(Integer.parseInt(fields[2].strip()));
			res.setEtat(Integer.parseInt(fields[3].strip()));
			res.setPrix(Double.parseDouble(fields[4].strip()));
			res.setPersonne(fields[5].strip());
			if(fields[5].strip().equals(PERSONNE_ABONNE)){
				res.setPassager(new Abonne(fields[6].strip(),fields[7].strip(),fields[8].strip(),fields[9].strip(),fields[10].strip(),Integer.parseInt(fields[11].strip()),fields[11].strip(),fields[13].strip()));
			}
			else{
				res.setPassager(new Client(fields[6].strip(),fields[7].strip(),fields[8].strip(),fields[9].strip(),fields[10].strip(),Integer.parseInt(fields[11].strip()),fields[11].strip(),fields[13].strip()));
			}

		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		return res;
	}


	public static List<Reservation> reservationfrom(File file) throws FileNotFoundException {
		List<Reservation> lesResv = new ArrayList<Reservation>();
		if((file.exists() && !file.isDirectory())) {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				Reservation subResv = Reservation.from(scanner.nextLine());
				lesResv.add(subResv);

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
		return lesResv;
	}

	public String formatfile(){
		return  this.id_Reservation + ", " + this.getDateformat() + ", " + this.classe + ", "  + this.etat + ", "  + this.prix + ", "
				+ this.personne + ", " + this.passager.getNom() + ", " + this.passager.getPrenom() + ", " + this.passager.getCode_postal() + ", " + this.passager.getAdresse() + ", "
				+ this.passager.getVille() + ", " + this.passager.getAge() + ", " + this.passager.getEmail() + ", " + this.passager.getTel() + "\n";
	}


	public static void saveReservation(String path, List<Reservation> lesResv) throws Exception{
		File file = new File(path);
		if(file.exists()){
			file.delete();
		}
		file.createNewFile();
		FileWriter filewrite = new FileWriter(path);
		for(Reservation resv : lesResv){
			filewrite.write(resv.formatfile());
		}
		filewrite.close();
	}









}
