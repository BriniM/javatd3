package io.brinim.courriers;

import io.brinim.courriers.enums.*;

public class Lettre extends Courrier {
    private TypeLettre typeLettre;

    public Lettre(String adresseDestination, String adresseExpedition, int poid, TypeLettre tl) throws Exception {
        super(adresseDestination, adresseExpedition, poid);
        typeLettre = tl;

        var propLettre = tl.getTypeLettre();
        if (! propLettre.poidRespecte(poid))
            throw new Exception(String.format("Le poid doit étre supérieur ou égale a[%d et inférieur a %d.",
                    propLettre.getPoidMin(), propLettre.getPoidMax()));
    }

    public double calculTimbre() {
        return typeLettre.getTypeLettre().getTarification();
    }

    public String toString() {
        return String.format("Lettre \nAdresse expedition: %s\n"
                + "Adresse destinataire: %s\n"
                + "Type: %s\n"
                + "Poid: %d\n Prix: %.3f\n",
                getAdresseExpedition(), getAdresseDestination(), typeLettre, getPoid(), calculTimbre());
    }
}
