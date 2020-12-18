package io.brinim.courriers.enums;

public class ProprietesColis {
    final private double taxeFixe;
    final private double taxeParKgSupp;

    public ProprietesColis(double taxeFixe, double taxeParKgSupp) {
        this.taxeFixe = taxeFixe;
        this.taxeParKgSupp = taxeParKgSupp;
    }

    public double getTarification(double poid) {
        return taxeFixe + Math.ceil((poid - 2000)/ 1000) * taxeParKgSupp;
    }
}
