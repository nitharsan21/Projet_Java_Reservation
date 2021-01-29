package Technique;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class Compagnie {
    private String nomCompagnie;
    private List<Avion> listAvion;

//    private Map<Integer, ArrayList<Vol>> mapVol; // map contenant l'ensemble des vols porgrammées par la compagnie

    // Données supplémentaires de la compagnie, idées d'améliorations ...
	/*
	private ArrayList<Aeroport> listAeroport; // liste contenant l'ensemble des aéroports que dessert la compagnie
	private ArrayList<Passager> listPassager; // liste contenant l'ensemble des voyageurs de la compagnie/
	*/

    public Compagnie(String nomCompagnie) {
        this.nomCompagnie = nomCompagnie;
        this.listAvion = new ArrayList<Avion>();
    }


    public String getNomCompagnie() {

        return nomCompagnie;

    }

//    public Map<Integer, ArrayList<Vol>> getMapVol() {
//
//        return mapVol;
//
//    }
    // Méthodes liées aux setter

    public void setNomCompagnie(String nomCompagnie) {

        this.nomCompagnie = nomCompagnie;

    }

//    public void setMapVol(Map<Integer, ArrayList<Vol>> mapVol) {
//
//        this.mapVol = mapVol;
//
//    }

    public List<Avion> getListAvion() {
        return listAvion;
    }

    public void setListAvion(List<Avion> listAvion) {
        this.listAvion = listAvion;
    }

    public void creationVol(String ref, Date dateD, Date dateA, int nbPas, Aeroport aerDep, Aeroport aerAriv) {
        Vol vol = new Vol(ref, dateD, dateA, nbPas, aerDep, aerAriv);
//        this.getMapVol().get(vol.getDateDepart()).add(vol);
//        this.getMapVol().get(vol.getDateArrivee()).add(vol);
        vol.getAvion().getListVol().add(vol);
    }

    @Override
    public String toString() {
        return "Compagnie :" + this.nomCompagnie ;
    }



    public static Compagnie from(String text) {
        String[] fields = text.split(",");
        String nomCompagnie = fields[0].strip();
        return new Compagnie(nomCompagnie);
    }

    public static List<Compagnie> compagniesfrom(File file) throws FileNotFoundException {
        List<Compagnie> lesCompignies = new ArrayList<Compagnie>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            Compagnie subCompagnie = Compagnie.from(scanner.nextLine());
            lesCompignies.add(subCompagnie);

        }
        scanner.close();
        return lesCompignies;
    }

    public String formatfile(){
        return  this.nomCompagnie + "\n";
    }


    public static void saveCompagnie(String path, List<Compagnie> lesCompagnies) throws Exception{
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileWriter filewrite = new FileWriter(path);
        for(Compagnie compagnie : lesCompagnies){
            filewrite.write(compagnie.formatfile());
        }
        filewrite.close();
    }


    public static Compagnie getCompagnieFromList(List<Compagnie> lesCompagnies, String nomCompagnie){
        for(Compagnie compagnie : lesCompagnies){
            if(compagnie.nomCompagnie.toLowerCase().equals(nomCompagnie.toLowerCase())){
                return compagnie;
            }
        }
        return null;
    }

    public void AfficheAvionInCompagnie(){
        for(Avion avion : this.listAvion){
            System.out.println(avion);
        }
    }

    public Avion getAvionFromList(String modele){
        for(Avion avion : this.listAvion){
            if(avion.getModele().toLowerCase().equals(modele.toLowerCase())){
                return avion;
            }
        }
        return null;
    }


}
