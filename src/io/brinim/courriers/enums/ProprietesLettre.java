package io.brinim.courriers.enums;

public class ProprietesLettre {
    final private double tarification;
    final private int poidMin;
    final private int poidMax;

    public ProprietesLettre(double tarification, int poidMin, int poidMax) {
        this.tarification = tarification;
        this.poidMin = poidMin;
        this.poidMax = poidMax;
    }

    public int getPoidMin() {
        return poidMin;
    }

    public int getPoidMax() {
        return poidMax;
    }

    public boolean poidRespecte(int poid) {
        return poid > poidMin && poid <= poidMax;
    }

    public double getTarification() {
        return tarification;
    }
}
