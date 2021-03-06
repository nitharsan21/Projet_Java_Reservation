package Technique;

public class Tarif {


    private double first_Class;
    private int first_wight_limit;
    private double business_Class;
    private int business_wight_limit;
    private double economy_Class;
    private int economy_wight_limit;
    private double perKilo;

    public Tarif(double first_Class, int first_wight_limit, double business_Class, int business_wight_limit, double economy_Class, int economy_wight_limit, double perKilo) {
        this.first_Class = first_Class;
        this.first_wight_limit = first_wight_limit;
        this.business_Class = business_Class;
        this.business_wight_limit = business_wight_limit;
        this.economy_Class = economy_Class;
        this.economy_wight_limit = economy_wight_limit;
        this.perKilo = perKilo;
    }

    public Tarif(){};


    public double getFirst_Class() {
        return first_Class;
    }

    public void setFirst_Class(double first_Class) {
        this.first_Class = first_Class;
    }

    public int getFirst_wight_limit() {
        return first_wight_limit;
    }

    public void setFirst_wight_limit(int first_wight_limit) {
        this.first_wight_limit = first_wight_limit;
    }

    public double getBusiness_Class() {
        return business_Class;
    }

    public void setBusiness_Class(double business_Class) {
        this.business_Class = business_Class;
    }

    public int getBusiness_wight_limit() {
        return business_wight_limit;
    }

    public void setBusiness_wight_limit(int business_wight_limit) {
        this.business_wight_limit = business_wight_limit;
    }

    public double getEconomy_Class() {
        return economy_Class;
    }

    public void setEconomy_Class(double economy_Class) {
        this.economy_Class = economy_Class;
    }

    public int getEconomy_wight_limit() {
        return economy_wight_limit;
    }

    public void setEconomy_wight_limit(int economy_wight_limit) {
        this.economy_wight_limit = economy_wight_limit;
    }

    public double getPerKilo() {
        return perKilo;
    }

    public void setPerKilo(double perKilo) {
        this.perKilo = perKilo;
    }

    public double getTarif(int classe, double poid){
        switch (classe){
            case 1:
                if(poid > this.first_wight_limit) {
                    return (this.perKilo * (poid - this.first_wight_limit))+ this.first_Class;
                }else {
                    return this.first_Class;
                }
            case 2:
                if(poid > this.business_wight_limit) {
                    return (this.perKilo * (poid - this.business_wight_limit))+ this.business_Class;
                }else {
                    return this.business_Class;
                }
            case 3:
                if(poid > this.economy_wight_limit) {
                    return (this.perKilo * (poid - this.economy_wight_limit))+ this.economy_Class;
                }else {
                    return this.economy_Class;
                }
            default:
                if(poid > this.economy_wight_limit) {
                    return (this.perKilo * (poid - this.economy_wight_limit))+ this.economy_Class;
                }else {
                    return this.economy_Class;
                }

        }
    }

    public double calculTarif(int classe,double poid){
        double total;
        return this.getTarif(classe, poid);
    }


    @Override
    public String toString() {
        return "Tarif{" +
                "first_Class=" + first_Class +
                ", first_wight_limit=" + first_wight_limit +
                ", business_Class=" + business_Class +
                ", business_wight_limit=" + business_wight_limit +
                ", economy_Class=" + economy_Class +
                ", economy_wight_limit=" + economy_wight_limit +
                ", perKilo=" + perKilo +
                '}';
    }
}
