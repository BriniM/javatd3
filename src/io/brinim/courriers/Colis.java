package io.brinim.courriers;

import io.brinim.courriers.enums.ProprietesColis;

public class Colis extends Courrier {
    /* Il est possible d'ajouter TypeColis si le besoin évolue */
    ProprietesColis pc;

    public Colis(String adresseDestination, String adresseExpedition, int poid) {
        super(adresseDestination, adresseExpedition, poid);
        pc = new ProprietesColis(4.3, 0.3, 2000);
    }

    public double calculTimbre() {
        return pc.getTarification(getPoid());
    }

    public String toString() {
        return String.format("Colis \nAdresse expedition: %s\n"
                + "Adresse destinataire: %s\n"
                + "Poid: %d\n Prix: %.3f\n", getAdresseExpedition(), getAdresseDestination(), getPoid(), calculTimbre());
    }
}
