package io.brinim.courriers;

import io.brinim.courriers.enums.TypeCourrier;
import io.brinim.courriers.enums.TypeLettre;

import java.util.ArrayList;
import java.util.EnumSet;

public class Poste {
    ArrayList<Courrier> cr = new ArrayList<>();

    public void ajouterCourrier(String adresseExp, String adresseDest, int poid, TypeCourrier tc) {
        switch(tc) {
            case COLIS:
                cr.add(new Colis(adresseDest, adresseExp, poid));
                break;
            case LETTRE:
                try {
                    var typeLettre = Menu.question("type lettre", TypeLettre.class);
                    cr.add(new Lettre(adresseDest, adresseExp, poid, (TypeLettre)typeLettre));
                } catch (Exception e) { System.out.println(e.getMessage()); }
        }
    }

    public ArrayList<Courrier> getCourriers() {
        return cr;
    }

    public ArrayList<Colis> getColis() {
        ArrayList<Colis> colis = new ArrayList<>();
        for (var c : cr)
            if (c instanceof Colis)
                colis.add((Colis)c);

        return colis;
    }

    public String toString() {
        String ret = "";
        for (var o : cr)
            ret += o;
        return ret;
    }
}
