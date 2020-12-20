package io.brinim.courriers;

public class Colis extends Courrier {
    final private double taxeFixe = 4.3;
    final private double taxeParKgSupp = 0.3;
    final private int seuilPoid = 2000;

    public Colis(String adresseDestination, String adresseExpedition, int poid) {
        super(adresseDestination, adresseExpedition, poid);
    }

    public double calculTimbre() {
        if (getPoid() > seuilPoid) {
            return taxeFixe + Math.ceil((getPoid() - seuilPoid) / 1000.) * taxeParKgSupp;
        }

        return taxeFixe;
    }

    public String toString() {
        return String.format("Colis \nAdresse expedition: %s\n"
                + "Adresse destinataire: %s\n"
                + "Poid: %d\n Prix: %.3f\n", getAdresseExpedition(), getAdresseDestination(), getPoid(), calculTimbre());
    }
}
