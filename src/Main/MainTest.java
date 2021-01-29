package Main;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;


import Technique.*;
import jdk.dynalink.beans.StaticClass;

public class MainTest {

	public static List<Abonne> lesAbonnes= new ArrayList<Abonne>();
	public static List<Compagnie> lesCompagnie =  new ArrayList<Compagnie>();

	public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	public static Date current_date = new Date();

	public static final String PATH_ABONNE = "src/Data/abonne.txt";
	public static final String PATH_COMPAGNIE = "src/Data/compagnie.txt";



	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";




	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Console console = System.console();

		initialisationProjet();
		saveProjet();
/*
		while(true){
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("x																			 x");
			System.out.println("x" + ANSI_BLUE + "				Bienvenue dans la GESTION DES RÉSERVATIONS					 " + ANSI_RESET +"x");
			System.out.println("x																			 x");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

			System.out.println("\n\nxxxxxxxxxxxxxxxxx			SELECTION D'UN ACTION				xxxxxxxxxxxxxx\n");
			System.out.println(" GESTION DE VOL : 1");
			System.out.println(" RESERVATION : 2 ");
			System.out.println(" Quitter : quit");

			try {
				System.out.print("\nAction : ");
				String action = new BufferedReader(new InputStreamReader(System.in)).readLine();

				switch(action){
					case "1":
						gestionVol(true);
						break;
					case "2":
						reservationVol(true);
						break;
					case "quit":
						System.exit(0);
						break;
					default:
						System.out.println(ANSI_RED + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ACTION INCONNUE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +ANSI_RESET );
						break;

				}

			}catch (Exception ex){
				System.out.println(ex.getMessage());
			}

		}*/


	}//main


	public static void initialisationProjet(){

		try{
			System.out.println("les abonnées");
			lesAbonnes = Abonne.abonnefrom(new File(PATH_ABONNE));
			for(Abonne a : lesAbonnes){
				System.out.println(a);
			}

			System.out.println("\nLa liste des compagnies aériennes");
			lesCompagnie = Compagnie.compagniesfrom(new File(PATH_COMPAGNIE));


			for(Compagnie compagnie : lesCompagnie){
				List<Avion> lesAvions = new ArrayList<Avion>();
				lesAvions = Avion.avionsfrom(new File("src/Data/Avion/"+compagnie.getNomCompagnie()+"_Avions.txt"));
				lesCompagnie.get(lesCompagnie.indexOf(compagnie)).setListAvion(lesAvions);
			}

			for(Compagnie compagnie : lesCompagnie){
				for(Avion avion : lesCompagnie.get(lesCompagnie.indexOf(compagnie)).getListAvion()) {
					List<Vol> lesVols = new ArrayList<Vol>();
					lesVols = Vol.volsfrom(new File("src/Data/Avion/Vol/"+compagnie.getNomCompagnie()+"_"+avion.getModele() +"_Vols.txt"));
					avion.setListVol(lesVols);
				}
			}

			for(Compagnie c : lesCompagnie){
				for(Avion a : c.getListAvion()) {
					for(Vol v : a.getListVol()) {
						List<Reservation> lesResv = new ArrayList<Reservation>();
						lesResv = Reservation.reservationfrom(new File("src/Data/Avion/Vol/Reservation/"+c.getNomCompagnie()+"_"+a.getModele() +"_"+v.getReference()+"_Reservations.txt"));
						v.setListPassager(lesResv);
					}
				}
			}

//			for(Compagnie c : lesCompagnie){
//				System.out.println(c);
//				for(Avion a : c.getListAvion()) {
//					System.out.println(a);
//					System.out.println(a.getTarif().toString());
//					for(Vol v : a.getListVol()) {
//						System.out.println(v.toString());
//						for(Reservation r : v.getListPassager()) {
//							System.out.println(r.toString());
//
//
//						}
//					}
//				}
//			}

		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}//initialisationProjet

	public static void saveProjet(){

		try {
			Abonne.saveAbonne(PATH_ABONNE, lesAbonnes);





			for (Compagnie c : lesCompagnie) {
				System.out.println(c);
				for (Avion a : c.getListAvion()) {
					System.out.println(a);
					System.out.println(a.getTarif().toString());
					for (Vol v : a.getListVol()) {
						System.out.println(v.toString());
						for (Reservation r : v.getListPassager()) {
							System.out.println(r.toString());


						}
					}
				}
			}


		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}

	}//saveProjet





























	public static void gestionVol(boolean actif){
		while(actif){
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("x																			 x");
			System.out.println("x" + ANSI_PURPLE + "							GESTION DES VOLS							 " + ANSI_RESET+ "x");
			System.out.println("x																			 x");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

			try{


			}catch(Exception ex){

			}
		}

	}//gestionVol

	public static void reservationVol(boolean actif){

		while(actif){

			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("x																			 x");
			System.out.println("x" + ANSI_GREEN + "							RESERVATION	DES VOLS							 " + ANSI_RESET+ "x");
			System.out.println("x																			 x");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");


			try {
				System.out.print("Avez-vous un Abonné (oui/non):");
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String verif = in.readLine();
				if (verif.toLowerCase().equals("non")) {
					System.out.println("\nxxxxxxxxxxxxxxxxx				CLIENT					xxxxxxxxxxxxxxxxxxxxxx\n");

					System.out.print("Saisir une date (jj/mm/aaaa) :");

					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(new BufferedReader(new InputStreamReader(System.in)).readLine());
					while (date.getTime() < current_date.getTime()){
						System.out.println(ANSI_RED+"						La date saisie est déjà dépassée"+ANSI_RESET);
						System.out.print("Resaisir une date (jj/mm/aaaa) : ");
						date = new SimpleDateFormat("dd/MM/yyyy").parse(new BufferedReader(new InputStreamReader(System.in)).readLine());
					}
					System.out.println("IT'S GOOD");


				} else if((verif.toLowerCase().equals("oui"))){
					String login,mdp;
					System.out.println("\nxxxxxxxxxxxxxxxxx				ABONNE					xxxxxxxxxxxxxxxxxxxxxx\n");
					Abonne a1 = null;
					int tentative = 0;

					while (a1 == null) {
						System.out.print(" Login :");
						login = new BufferedReader(new InputStreamReader(System.in)).readLine();
						System.out.print(" Mdp :");
						mdp = new BufferedReader(new InputStreamReader(System.in)).readLine();


						for (Abonne abonne : lesAbonnes) {
							if (abonne.getLogin().equals(login) && abonne.getMdp().equals(mdp)) {
								a1 = abonne;
							}
						}
						if(a1 == null){
							tentative++;
							if(tentative%3 == 0){
								tentative = 0;
								System.out.println(ANSI_RED+"					!!! Login et Mot de passe Incorrect !!! RESAISIR dans 15 sec "+ANSI_RESET);
								TimeUnit.SECONDS.sleep(15);
							}
							else{
								System.out.println(ANSI_RED+"					!!! Login et Mot de passe Incorrect !!! RESAISIR"+ANSI_RESET);
							}
							if(tentative == 7){
								System.exit(0);
							}
						}
						System.out.println(a1.toString());

//						date = new SimpleDateFormat("dd/MM/yyyy").parse(new BufferedReader(new InputStreamReader(System.in)).readLine());
//						while (date.getTime() < current_date.getTime()){
//							System.out.println(ANSI_RED+"						La date saisie est déjà dépassée"+ANSI_RESET);
//							System.out.print("Resaisir une date (jj/mm/aaaa) : ");
//							date = new SimpleDateFormat("dd/MM/yyyy").parse(new BufferedReader(new InputStreamReader(System.in)).readLine());
//						}
						boolean actionabonne = true;

						while(actionabonne) {

							System.out.println("\n\nxxxxxxxxxxxxxxxxx			SELECTION D'UN ACTION				xxxxxxxxxxxxxxxxxxxxxx\n");
							System.out.println(" Faire une Reservation : 1");
							System.out.println(" afficher Points : 2 ");
							System.out.println(" Resilier Compte : 3");
							System.out.println(" Quitter : quit");

							System.out.println("\nAction : ");
							String action = new BufferedReader(new InputStreamReader(System.in)).readLine();

							if(action.equals("1")){
								System.out.println("\n\nxxxxxxxxxxxxxxxxx				RESERVATION			xxxxxxxxxxxxxxxxxxxxxx\n");
								System.out.print(" Ville de depart :");
								String ville_depart = new BufferedReader(new InputStreamReader(System.in)).readLine();
								System.out.print(" Ville de arrivée :");
								String ville_arrivée = new BufferedReader(new InputStreamReader(System.in)).readLine();


								//When find vol select reserver.
								//
								//
								//
								//
								//

							}

						}

					}
				}
				actif = false;
			}
			catch (Exception ex){
				System.out.println("KO");
			}
		}
	}//reservationVol


}
