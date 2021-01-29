package Technique;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Avion {
    private String modele;
    private int nbSeats_FC ;
    private int nbSeats_AC ;
    private int nbSeats_EC ;
    private int  capacityMax;
    private double poidsMax;
    private Tarif tarif;

    private List<Vol> listVol;// list des vols


    public Avion(String modele, int capacity, double poid_max, Tarif tarif) {
        this.modele = modele;
        this.poidsMax = poid_max;
        this.tarif = tarif;
        this.nbSeats_AC = 6;
        this.nbSeats_AC = 12;
        this.nbSeats_AC = 24;
        this.capacityMax = this.nbSeats_FC + this.nbSeats_AC + this.nbSeats_EC;
        this.listVol = new ArrayList<Vol>();
    }
    public Avion(){
        this.nbSeats_AC = 6;
        this.nbSeats_AC = 12;
        this.nbSeats_AC = 24;
        this.capacityMax = this.nbSeats_FC + this.nbSeats_AC + this.nbSeats_EC;
        this.listVol = new ArrayList<Vol>();
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }


    public double getPoidsMax() {
        return poidsMax;
    }

    public void setPoidsMax(double poid_max) {
        this.poidsMax = poid_max;
    }

    public Tarif getTarif() {
        return tarif;
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }

    public List<Vol> getListVol() {
        return listVol;
    }

    public void setNewVol(Vol vol) {
        this.listVol.add(vol);
    }

    public int getNbSeats_FC() {
        return nbSeats_FC;
    }

    public void setNbSeats_FC(int nbSeats_FC) {
        this.nbSeats_FC = nbSeats_FC;
        this.capacityMax =  this.getCapacityMax();
    }

    public int getNbSeats_AC() {
        return nbSeats_AC;
    }

    public void setNbSeats_AC(int nbSeats_AC) {
        this.nbSeats_AC = nbSeats_AC;
        this.capacityMax =  this.getCapacityMax();
    }

    public int getNbSeats_EC() {
        return nbSeats_EC;

    }

    public void setNbSeats_EC(int nbSeats_EC) {
        this.nbSeats_EC = nbSeats_EC;
        this.capacityMax =  this.getCapacityMax();
    }

    public int getCapacityMax() {
        return this.nbSeats_FC + this.nbSeats_AC + this.nbSeats_EC;
    }


    public void setListVol(List<Vol> listVol) {
        this.listVol = listVol;
    }

    public String toString() {
        return "Avion " + this.modele + " de capacite "  + this.capacityMax + " avec un poids maximale de " + this.poidsMax;
    }





    public static Avion from(String text) {
        Avion avion = new Avion();
        String[] fields = text.split(",");

        // Avion
        avion.setModele(fields[0].strip());
        avion.setNbSeats_FC(Integer.parseInt(fields[1].strip()));
        avion.setNbSeats_AC(Integer.parseInt(fields[2].strip()));
        avion.setNbSeats_EC(Integer.parseInt(fields[3].strip()));
        avion.setPoidsMax(Double.parseDouble(fields[4].strip()));


        //Tarif
        double first_Class  = Double.parseDouble(fields[5].strip());
        int first_wight_limit  = Integer.parseInt(fields[6].strip());
        double business_Class  = Double.parseDouble(fields[7].strip());
        int business_wight_limit  = Integer.parseInt(fields[8].strip());
        double economy_Class = Double.parseDouble(fields[9].strip());
        int economy_wight_limit = Integer.parseInt(fields[10].strip());
        double perKilo = Double.parseDouble(fields[11].strip());

        Tarif tarif = new Tarif(first_Class,first_wight_limit,business_Class,business_wight_limit,economy_Class,economy_wight_limit,perKilo);
        avion.setTarif(tarif);

        return avion;
    }

    public static List<Avion> avionsfrom(File file) throws FileNotFoundException {
        List<Avion> lesAvions = new ArrayList<Avion>();
        if((file.exists() && !file.isDirectory())) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Avion subAvion = Avion.from(scanner.nextLine());
                lesAvions.add(subAvion);

            }
            scanner.close();
        }else{
            try {
                file.createNewFile();
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return lesAvions;
    }


    public String formatfile(){
        return  this.modele + ", " + this.nbSeats_FC + ", " + this.nbSeats_AC + ", "  + this.nbSeats_EC + ", "  + this.poidsMax + ", "
                + this.tarif.getFirst_Class() + ", " + this.tarif.getFirst_wight_limit() + ", "
                + this.tarif.getBusiness_Class() + ", " + this.tarif.getBusiness_wight_limit() + ", "
                + this.tarif.getEconomy_Class() + ", " + this.tarif.getEconomy_wight_limit() + ", "
                + this.tarif.getPerKilo() + "\n";
    }


    public static void saveAvion(String path, List<Avion> lesAvions) throws Exception{
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileWriter filewrite = new FileWriter(path);
        for(Avion avion : lesAvions){
            filewrite.write(avion.formatfile());
        }
        filewrite.close();
    }






}
