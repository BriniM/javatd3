package io.brinim.courriers;

import java.util.ArrayList;

public class Poste {
    ArrayList<Courrier> cr = new ArrayList<>();

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
