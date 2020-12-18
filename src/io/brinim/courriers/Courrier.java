package io.brinim.courriers;

public abstract class Courrier {
    private String adresseDestination;
    private String adresseExpedition;
    private int poid;

    public Courrier(String adresseDestination, String adresseExpedition, int poid) {
        this.adresseDestination = adresseDestination;
        this.adresseExpedition = adresseExpedition;
        this.poid = poid;
    }

    public abstract double calculTimbre();

    public String getAdresseDestination() {
        return adresseDestination;
    }

    public String getAdresseExpedition() {
        return adresseExpedition;
    }

    public int getPoid() {
        return poid;
    }
}
