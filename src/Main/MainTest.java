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

public class MainTest {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


//	= Abonne.abonnefrom(new File("sdq"));




	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Console console = System.console();
		System.out.println("Hello");

		List<Abonne> lesAbonnes= new ArrayList<Abonne>();

		try{
			lesAbonnes = Abonne.abonnefrom(new File("src/Data/abonne.txt"),3);
			System.out.println(lesAbonnes);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		boolean actif = true;
		Date current_date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


		while(actif){

			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.println("x																			 x");
			System.out.println("x							RESERVATION	DES VOLS							 x");
			System.out.println("x																			 x");
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");


			try {
				System.out.print("Avez vous une Abonné :");
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String verif = in.readLine();
				if (verif.toLowerCase().equals("non")) {
					System.out.println("xxxxxxxxxxxxxxxxx				CLIENT					xxxxxxxxxxxxxxxxxxxxxx\n");

					System.out.print("Saisir une date (jj/mm/aaaa) :");
					Date date;
					date = new SimpleDateFormat("dd/MM/yyyy").parse(new BufferedReader(new InputStreamReader(System.in)).readLine());
					while (date.getTime() < current_date.getTime()){
						System.out.println(ANSI_RED+"						La date saisie est déjà dépassée"+ANSI_RESET);
						System.out.print("Resaisir une date (jj/mm/aaaa) : ");
						date = new SimpleDateFormat("dd/MM/yyyy").parse(new BufferedReader(new InputStreamReader(System.in)).readLine());
					}
					System.out.println("IT'S GOOD");


				} else if((verif.toLowerCase().equals("oui"))){
					String login,mdp;
					System.out.println("xxxxxxxxxxxxxxxxx				ABONNE					xxxxxxxxxxxxxxxxxxxxxx\n");
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
							if(tentative == 3){
								tentative = 0;
								System.out.println(ANSI_RED+"					!!! Login et Mot de passe Incorrect !!! RESAISIR dans 15 sec "+ANSI_RESET);
								TimeUnit.SECONDS.sleep(15);

							}
							else{
								System.out.println(ANSI_RED+"					!!! Login et Mot de passe Incorrect !!! RESAISIR"+ANSI_RESET);
							}
						}

						System.out.println(a1.toString());



					}





				}



				actif = false;
			}
			catch (Exception ex){
				System.out.println("KO");
			}



		}
	}

}
