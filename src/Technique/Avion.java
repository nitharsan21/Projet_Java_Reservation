package Technique;

public class Avion {
    private String Modele;
    private int  capacity;
    private double poid_max;
    private Tarif tarif;


    public Avion(String modele, int capacity, double poid_max, Tarif tarif) {
        Modele = modele;
        this.capacity = capacity;
        this.poid_max = poid_max;
        this.tarif = tarif;
    }

    public String getModele() {
        return Modele;
    }

    public void setModele(String modele) {
        Modele = modele;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPoid_max() {
        return poid_max;
    }

    public void setPoid_max(double poid_max) {
        this.poid_max = poid_max;
    }

    public Tarif getTarif() {
        return tarif;
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }


}
