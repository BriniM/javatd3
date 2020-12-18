package io.brinim.courriers;

import io.brinim.courriers.enums.*;

public class Lettre extends Courrier {
    private TypeLettre typeLettre;

    public Lettre(String adresseDestination, String adresseExpedition, int poid) {
        super(adresseDestination, adresseExpedition, poid);

        // TODO: Resolve Prio & Ordinaire since both have weight lower than 20g
        // One solution would be to prompt the user for the type if it's a letter and if it's lower than 20g
        for(var tl : TypeLettre.values())
            if (tl.getTypeLettre().poidRespecte(poid))
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
