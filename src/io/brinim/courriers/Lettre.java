package io.brinim.courriers;

import io.brinim.courriers.enums.*;

public class Lettre extends Courrier {
    private TypeLettre typeLettre;

    public Lettre(String adresseDestination, String adresseExpedition, int poid, TypeLettre tl) {
        super(adresseDestination, adresseExpedition, poid);

        typeLettre = tl;
    }

    public double calculTimbre() {
        return typeLettre.getTypeLettre().getTarification();
    }

    public String toString() {
        return String.format("Lettre \nAdresse expedition: %s\n"
                + "Adresse destinataire: %s\n"
                + "Type: %s\n"
                + "Poid: %d\n Prix: %.3f\n",getAdresseExpedition(), getAdresseDestination(), typeLettre, getPoid(), calculTimbre());
    }
}
