package io.brinim.courriers.enums;

public class ProprietesColis {
    final private double taxeFixe;
    final private double taxeParKgSupp;
    final private int seuilPoid;

    public ProprietesColis(double taxeFixe, double taxeParKgSupp, int seuilPoid) {
        this.taxeFixe = taxeFixe;
        this.taxeParKgSupp = taxeParKgSupp;
        this.seuilPoid = seuilPoid;
    }

    public double getTarification(double poid) {
        if (poid > seuilPoid) {
            return taxeFixe + Math.ceil((poid - seuilPoid) / 1000) * taxeParKgSupp;
        }

        return taxeFixe;
    }
}
